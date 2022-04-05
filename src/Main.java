import app.console.TableEditor;
import app.game.Game;
import app.math.PerlinNoise;
import app.window.Window;

public class Main {
    public static void main(String[] args) throws Exception {
        Window window = new Window(1000, true);

        PerlinNoise pn = new PerlinNoise(44);

        TableEditor w = new TableEditor(window.getTextDisplay());
        w.applyFunctionToAll((x, y) -> {
            if (pn.noise(x / (1f * w.getColumns()), y / (1f * w.getRows()), 0f) > -100) {
                w.setText(y, x, "#");
                System.out.println(pn.noise(x / (1f * w.getColumns()), y / (1f * w.getRows()), 0f));
            }
        }).clear();

        Game g = new Game(window);
        g.load();

        window.toggleWindow();
    }
}
