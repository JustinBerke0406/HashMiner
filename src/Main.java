import app.console.TableEditor;
import app.game.Game;
import app.math.PerlinNoise;
import app.window.Window;

public class Main {
    public static void main(String[] args) throws Exception {
        Window window = new Window(1000, true);

        PerlinNoise pn = new PerlinNoise(422);

        TableEditor w = new TableEditor(window.getTextDisplay());
        w.applyFunctionToAll((x, y) -> {
            if (pn.noise(x+0.01f, y+0.01f, 0f) > 0.01) {
                w.setText(y, x, "#");
                System.out.println(pn.noise(x+0.01f, y+0.01f, 0f));
            }
        });

        Game g = new Game(window);
        g.load();

        window.toggleWindow();
    }
}
