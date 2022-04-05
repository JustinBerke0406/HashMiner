package app.window;

import javax.swing.*;
import javax.swing.border.Border;

import app.console.events.KeyExecutor;

import java.awt.*;
import java.awt.event.*;

public class Window extends JPanel {
    private JFrame frame;

    private int width;
    private int height;

    public final String title = "HashMiner";

    private boolean resizable;
    private boolean shown = false;

    private Graphics graphics;

    private JTable textDisplay;

    private KeyExecutor keyExecutor;

    /**
     * Creates a new Window object.
     * <br>
     * <br>
     * <i>*Defaults gridWidth and gridHeight to the actual window size</i>
     * <br>
     * <br>
     * 
     * @param width     Width of the screen in pixels
     * @param height    Height of the screen in pixels
     * @param title     Window name
     * @param resizable If the window can be resized
     * 
     * 
     */
    public Window(int width, boolean resizable) {
        this.frame = new JFrame(title);
        this.width = width;
        this.height = 901;
        this.resizable = resizable;

        setup();
    }

    /**
     * Toggles the visibility of the window.
     */
    public void toggleWindow() {
        this.frame.setVisible(this.shown = !this.shown);
        this.graphics = this.frame.getGraphics();
    }

    private void setup() {
        this.frame.setSize(this.width, this.height);
        // revalidate();
        // this.frame.getContentPane().add(this);
        this.frame.setDefaultCloseOperation(3);
        this.frame.setResizable(this.resizable);
        this.frame.setLayout(new GridBagLayout());

        frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                width = componentEvent.getComponent().getWidth();
                height = componentEvent.getComponent().getHeight();
            }
        });

        // setupTextDisplay();
        setupTextGrid();
        // setupTextField();

        // this.frame.pack();
    }

    private void setupTextDisplay() {
        GridBagConstraints c = new GridBagConstraints();

        JLabel display = new JLabel("test");
        display.setVerticalAlignment(SwingConstants.TOP);

        Border border = BorderFactory.createMatteBorder(2, 0, 2, 0, Color.BLACK);
        display.setBorder(border);

        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(0, 0, 20, 0);
        c.ipady = 60;
        c.anchor = GridBagConstraints.NORTH;
        c.weighty = 0.8;
        c.gridx = 0;
        c.gridy = 0;

        this.frame.add(display, c);
    }

    private void setupTextGrid() {
        GridBagConstraints c = new GridBagConstraints();

        textDisplay = new JTable(50, 50);
        textDisplay.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        textDisplay.setShowGrid(false);
        textDisplay.setFocusable(false);
        textDisplay.removeMouseListener(textDisplay.getMouseListeners()[1]);
        textDisplay.removeMouseMotionListener(textDisplay.getMouseMotionListeners()[1]);

        Border border = BorderFactory.createMatteBorder(2, 0, 2, 0, Color.BLACK);
        textDisplay.setBorder(border);

        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(0, 0, 20, 0);
        // c.ipady = 60;
        c.anchor = GridBagConstraints.NORTH;
        c.weighty = 0.8;
        c.gridx = 0;
        c.gridy = 0;

        keyExecutor = new KeyExecutor();

        this.frame.addKeyListener(keyExecutor);
        this.frame.add(textDisplay, c);
    }

    private void setupTextField() {
        GridBagConstraints c = new GridBagConstraints();

        JTextField input = new JTextField();
        // input.setPreferredSize(new Dimension(width, 10));
        // input.setBounds((int) (width * (1-textBoxOffset)/2), height - 10, (int)
        // (width * textBoxOffset), 10);

        JLabel inputLabel = new JLabel("Input:");

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.ipadx = 0;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 1;

        this.frame.add(inputLabel, c);

        c = new GridBagConstraints();

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        input.setBorder(border);

        c.fill = GridBagConstraints.BOTH;
        c.ipady = 0;
        c.ipadx = 0;
        c.insets = new Insets(0, 0, 5, 0);
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 2;

        this.frame.add(input, c);
    }

    public JTable getTextDisplay() {
        return textDisplay;
    }

    public KeyExecutor getKeyExecutor() {
        return keyExecutor;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isResizable() {
        return this.resizable;
    }

    public void setResizable(boolean resizable) {
        this.resizable = resizable;
    }

    public boolean isShown() {
        return this.shown;
    }

    public void setShown(boolean shown) {
        this.shown = shown;
    }

    public Graphics getGraphics() {
        return this.graphics;
    }

    public void setGraphics(Graphics g) {
        this.graphics = g;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
}
