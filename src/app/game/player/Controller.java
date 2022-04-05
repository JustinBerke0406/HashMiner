package app.game.player;

import app.console.TableEditor;

public class Controller {
    private TableEditor editor;

    private int x;
    private int y;

    private String onTile;

    public Controller(TableEditor e) {
        editor = e;
        
        onTile = editor.getValue(0, 0);
        editor.setText(0, 0, "0");
    }

    public void inputKey(int key) {
        switch (key) {
            case 37:
                move(-1, 0);
                break;
            case 38:
                move(0, -1);
                break;
            case 39:
                move(1, 0);
                break;
            case 40:
                move(0, 1);
                break;
            default:
        }
    }

    public void move(int xn, int yn) {
        editor.setText(y, x, onTile);
        onTile = editor.getValue(y+yn, x+xn);
        editor.setText(y+yn, x+xn, "0");
        x += xn;
        y += yn;
    }
}
