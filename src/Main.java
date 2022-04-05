import app.console.TableEditor;
import app.game.Game;
import app.window.Window;

public class Main {
    public static void main(String[] args) throws Exception {
        Window window = new Window(1000, true);

        TableEditor w = new TableEditor(window.getTextDisplay());
        w.drawPerimeter(true, "#", 0, 0, 8, 20, 42, 25);

        Game g = new Game(window);
        g.load();

        window.toggleWindow();
    }
}
