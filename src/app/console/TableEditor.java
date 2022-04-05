package app.console;

import java.util.function.BiConsumer;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TableEditor {
    private TableModel table;
    private JTable jtable;

    private int columns;
    private int rows;

    public TableEditor(JTable table) {
        this.table = table.getModel();
        this.jtable = table;

        this.columns = this.table.getColumnCount();
        this.rows = this.table.getRowCount();
    }

    public TableEditor setText(int r, int c, String text) {
        table.setValueAt(text, r, c);

        return this;
    }

    public TableEditor fillRow(int r, String text) {
        for (int i = 0; i < columns; i++)
            setText(r, i, text);

        return this;
    }

    public TableEditor fillColumn(int c, String text) {
        for (int i = 0; i < rows; i++)
            setText(i, c, text);

        return this;
    }

    public TableEditor drawRectangle(int x1, int y1, int x2, int y2, String text, boolean fill) {
        int temp;
        
        if (x1 > x2) {
            temp = x1;
            x1 = x2;
            x2 = temp;
        }

        if (y1 > y2) {
            temp = y1;
            y1 = y2;
            y2 = temp;
        }
        
        if (fill)
            for (int x = x1; x <= x2; x++)
                for (int y = y1; y <= y2; y++)
                    setText(y, x, text);
        else {
            for (int x = x1; x <= x2; x++) {
                setText(y1, x, text);
                setText(y2, x, text);
            }

            for (int y = y1+1; y <= y2-1; y++) {
                setText(y, x1, text);
                setText(y, x2, text);
            }
        }

        return this;
    }

    public TableEditor drawLine(int x1, int y1, int x2, int y2, String text) {
        int yDist = Math.abs(y2-y1);
        int xDist = Math.abs(x2-x1);

        if (xDist >= yDist) {
            double slope = (double) (y2-y1)/(x2-x1);
            double cur = y1-slope;

            int xStart = Math.min(x1, x2);

            for (int i = 0; i < xDist+1; i++) {
                setText((int)Math.round((cur+slope)), i+xStart, text);

                cur += slope;
            }
        }
        else {
            double slope = (double) (x2-x1)/(y2-y1);
            double cur = x1-slope;

            int yStart = Math.min(y1, y2);

            for (int i = 0; i < yDist+1; i++) {
                setText(i+yStart, (int)Math.round((cur+slope)), text);

                cur += slope;
            }
        }

        return this;
    }

    public TableEditor drawPerimeter(boolean connectEndpoints, String text, int... coords) {
        if (coords.length % 2 != 0) return this;

        for (int i = 0; i < coords.length-2; i += 2)
            drawLine(coords[i], coords[i+1], coords[i+2], coords[i+3], text);

        if (connectEndpoints) {
            drawLine(coords[0], coords[1], coords[coords.length-2], coords[coords.length-1], text);
        }

        return this;
    }

    public TableEditor applyFunctionToAll(BiConsumer<Integer, Integer> func) {
        for (int x = 0; x < columns; x++)
            for (int y = 0; y < rows; y++)
                func.accept(x, y);
        
        return this;
    }

    public String getValue(int r, int c) {
        return (String) table.getValueAt(r, c);
    }

    public TableEditor clear() {
        DefaultTableModel def = new DefaultTableModel(rows, columns);

        jtable.setModel(def);
        table = def;

        return this;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
