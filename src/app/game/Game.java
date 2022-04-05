package app.game;

import app.console.TableEditor;
import app.console.events.KeyExecutor;
import app.game.player.Player;
import app.game.world.WorldGen;
import app.window.Window;

public class Game {
    private TableEditor editor;
    private KeyExecutor keyExecutor;

    public Game(Window w) {
        editor = new TableEditor(w.getTextDisplay());
        keyExecutor = w.getKeyExecutor();

        new WorldGen(74, editor).generate();
    }

    public void load() {
        loadPlayer();
    }

    private void loadPlayer() {
        new Player(editor, keyExecutor);
    }
}
