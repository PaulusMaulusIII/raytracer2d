package raytracer2d.utils.res;

import java.awt.Graphics2D;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import raytracer2d.utils.core.Renderable;
import raytracer2d.utils.math.Vector;
import raytracer2d.utils.rendering.Color;
import raytracer2d.utils.rendering.RenderLayer;

public class TileMap extends Resource implements Renderable {

    private final Texture texture;
    public final int tileSize;
    public final int width;
    public final int height;

    private int[][] tileNumbers = new int[1][1];
    private Map<Integer, Tile> tiles = new HashMap<>();
    private Color[][] colors = new Color[1][1];
    private int mapHeight = 0;
    private int mapWidth = 0;
    private RenderLayer renderLayer;

    public TileMap(String pathname, String name, Texture texture, int tileSize) {
        super(pathname, name);
        this.texture = texture;
        this.tileSize = tileSize;
        parseMap();
        fillTiles();
        this.width = mapWidth * tileSize;
        this.height = mapHeight * tileSize;
        System.out.println(width + ", " + height);
        this.colors = new Color[height][width];
        drawTexture();
    }

    private void parseMap() {
        try (Scanner scanner = new Scanner(this)) {
            ArrayList<ArrayList<Integer>> mapList = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                try (Scanner lineScanner = new Scanner(line)) {
                    ArrayList<Integer> mapSubList = new ArrayList<>();
                    mapWidth = 0;
                    while (lineScanner.hasNextInt()) {
                        mapSubList.add(lineScanner.nextInt());
                        mapWidth++;
                    }
                    mapList.add(mapSubList);
                    mapHeight++;
                }
            }
            tileNumbers = new int[mapHeight][mapWidth];
            for (int mapY = 0; mapY < mapHeight; mapY++) {
                for (int mapX = 0; mapX < mapWidth; mapX++) {
                    tileNumbers[mapY][mapX] = mapList.get(mapY).get(mapX);
                }
            }
            for (int[] tileNumbers : tileNumbers) {
                System.out.println(Arrays.toString(tileNumbers));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void fillTiles() {
        int index = 0;
        for (int y = 0; y < texture.height; y += tileSize) {
            for (int x = 0; x < texture.width; x += tileSize) {
                Color[][] tilePixels = new Color[tileSize][tileSize];
                for (int yRel = y; yRel < y + tileSize; yRel++) {
                    for (int xRel = x; xRel < x + tileSize; xRel++) {
                        tilePixels[yRel - y][xRel - x] = texture.getColor(xRel, yRel);
                    }
                }
                tiles.put(index, new Tile(index, tileSize, tilePixels));
                index++;
            }
        }
    }

    private void drawTexture() {
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                int tileIndex = tileNumbers[y][x];
                Tile tile = tiles.get(tileIndex);
                if (tile != null) {
                    for (int yRel = 0; yRel < tileSize; yRel++) {
                        for (int xRel = 0; xRel < tileSize; xRel++) {
                            colors[y * tileSize + yRel][x * tileSize + xRel] = tile.pixels()[yRel][xRel];
                        }
                    }
                }
            }
        }
    }

    private Color getColor(int x, int y) {
        try {
            if (colors[y][x] == null) {
                return null;
            }
            return colors[y][x];
        } catch (Exception e) {
            return Color.RED;
        }
    }

    public void draw(Graphics2D buffer, int minX, int minY, int maxX, int maxY) {
        for (int x = minX; x < maxX; x++) {
            for (int y = minY; y < maxY; y++) {
                if (getColor(x, y) != null) {
                    buffer.setColor(getColor(x, y).toAWT());
                    buffer.fillRect(x, y, 1, 1);
                }
            }
        }
    }

    record Tile(int index, int size, Color[][] pixels) {
    }

    @Override
    public Color getColor(Vector pos) {
        return getColor((int) pos.x, (int) pos.y);
    }

    @Override
    public void setPos(Vector pos) {
    }

    @Override
    public boolean visible(Vector pos) {
        return true;
    }

    @Override
    public Vector getPos() {
        return new Vector(0, 0);
    }

    @Override
    public void setRenderLayer(RenderLayer renderLayer) {
        this.renderLayer = renderLayer;
    }

    @Override
    public RenderLayer getRenderLayer() {
        return renderLayer;
    }

}
