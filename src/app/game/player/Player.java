package app.game.player;

import java.awt.event.KeyEvent;

import app.console.TableEditor;
import app.console.events.KeyExecutor;
import app.console.events.KeyExecutor.Reciever;

public class Player extends Reciever {
    private Controller controller;
    private TableEditor editor;

    public Player(TableEditor e, KeyExecutor keyExecutor) {
        editor = e;

        controller = new Controller(editor);

        addKeyListener(keyExecutor);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        controller.inputKey(e.getKeyCode());
    }   
}
