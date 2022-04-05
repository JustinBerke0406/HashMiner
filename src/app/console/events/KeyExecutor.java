package app.console.events;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyExecutor implements KeyListener {
    private ArrayList<Reciever> recievers = new ArrayList<>();

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        for (Reciever r : recievers) r.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    private void addReciever(Reciever reciever) {
        recievers.add(reciever);
    }

    public static abstract class Reciever {
        public abstract void keyPressed(KeyEvent e);

        public void addKeyListener(KeyExecutor k) {
            k.addReciever(this);
        }
    }
}
