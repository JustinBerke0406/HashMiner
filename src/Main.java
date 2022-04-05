import app.game.Game;
import app.window.Window;

public class Main {
    public static void main(String[] args) throws Exception {
        Window window = new Window(1000, true);

        Game g = new Game(window);
        g.load();

        window.toggleWindow();
    }
}
