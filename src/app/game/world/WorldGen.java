package app.game.world;

import app.console.TableEditor;
import app.math.PerlinNoise;

public class WorldGen {
    private final int WORLD_START_HEIGHT = 15;
    private final float NOISE_COEF = 1f;
    
    private int seed;
    private PerlinNoise pn;
    private TableEditor editor;

    public WorldGen(int seed, TableEditor editor) {
        this.seed = seed;
        this.editor = editor;

        pn = new PerlinNoise(this.seed);
    }

    public void generate() {
        int diff = 0;
        for (int i = 0; i < editor.getColumns(); i++) {
            diff = (int) Math.floor(20*pn.noise(i / (NOISE_COEF * editor.getColumns()), (WORLD_START_HEIGHT+diff) / (NOISE_COEF * editor.getRows()), 0f)) / 2;

            editor.drawLine(i, WORLD_START_HEIGHT+diff, i, editor.getRows()-1, "#");
        }
    }
}
