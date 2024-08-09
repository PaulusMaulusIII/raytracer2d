package com.paulusmaulus.raytracer2d.utils.res;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.paulusmaulus.raytracer2d.utils.rendering.Color;

public class TileMap extends Resource {

    private final Texture texture;
    public final int tileSize;
    public final int width;
    public final int height;

    private int[][] tileNumbers = new int[1][1];
    private Set<Tile> tiles = new HashSet<>();
    private Color[][] colors = new Color[1][1];

    public TileMap(String pathname, String name, Texture texture, int tileSize) {
        super(pathname, name);
        this.texture = texture;
        this.tileSize = tileSize;
        this.width = tileSize * (int) (texture.width / tileSize);
        this.height = tileSize * (int) (texture.height / tileSize);
        this.colors = new Color[height][width];
        this.tileNumbers = new int[height / tileSize][width / tileSize];
        if (texture.width < width || texture.height < height)
            throw new Error("Texture dimension mismatch");
        parseMap();
        fillTiles();
        drawTexture();
    }

    public void parseMap() {
        try (Scanner scanner = new Scanner(this)) {
            int x = 0;
            int y = 0;

            while (scanner.hasNextInt()) {
                tileNumbers[y][x] = scanner.nextInt();
                x++;
                if (x >= tileNumbers[0].length) {
                    x = 0;
                    y++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void fillTiles() {
        int index = 0;
        for (int y = 0; y < height; y += tileSize) {
            for (int x = 0; x < width; x += tileSize) {
                Color[][] tilePixels = new Color[tileSize][tileSize];
                for (int yRel = y; yRel < y + tileSize; yRel++) {
                    for (int xRel = x; xRel < x + tileSize; xRel++) {
                        tilePixels[yRel - y][xRel - x] = texture.getColor(xRel, yRel);
                    }
                }
                tiles.add(new Tile(index, tileSize, tilePixels));
                index++;
            }
        }
    }

    public void drawTexture() {
        for (int y = 0; y < height; y += tileSize) {
            for (int x = 0; x < width; x += tileSize) {
                for (Tile tile : tiles) {
                    if (tile.index == tileNumbers[y / tileSize][x / tileSize]) {
                        for (int yRel = y; yRel < y + tileSize; yRel++) {
                            for (int xRel = x; xRel < x + tileSize; xRel++) {
                                colors[yRel][xRel] = tile.pixels[yRel - y][xRel - x];
                            }
                        }
                    }
                }
            }
        }
    }

    public Color getColor(int x, int y) {
        if (colors[y][x] == null) {
            return Color.RED;
        }
        return colors[y][x];
    }

    record Tile(int index, int size, Color[][] pixels) {
    }
}
