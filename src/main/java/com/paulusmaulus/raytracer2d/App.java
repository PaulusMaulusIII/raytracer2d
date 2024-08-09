package com.paulusmaulus.raytracer2d;

import java.awt.Graphics;

import javax.swing.JFrame;

import com.paulusmaulus.raytracer2d.utils.res.Texture;
import com.paulusmaulus.raytracer2d.utils.res.TileMap;

/**
 * Hello world!
 *
 */
public final class App extends JFrame implements Runnable {

    public App() {
        super();
    }

    /*
     * public static void main(String[] args) {
     * App app = new App();
     * 
     * app.setSize(720, 720);
     * app.setTitle("2D Ray-Tracing game engine");
     * app.setVisible(true);
     * app.run();
     * }
     */

    TileMap tileMap = null;

    public static void main(String[] args) {
        App app = new App();

        app.tileMap = new TileMap(
                "src\\main\\java\\com\\paulusmaulus\\raytracer2d\\assets\\maps\\example.map",
                "Example",
                new Texture(
                        "src\\main\\java\\com\\paulusmaulus\\raytracer2d\\assets\\textures\\example.png",
                        "Test"),
                128);

        app.setSize(app.tileMap.width, app.tileMap.height);
        app.setTitle("TileMap Test");
        app.setVisible(true);
        app.run();
    }

    @Override
    public void repaint() {
        Graphics gfx = getGraphics();
        for (int x = 0; x < tileMap.width; x++) {
            for (int y = 0; y < tileMap.height; y++) {
                gfx.setColor(tileMap.getColor(x, y).toAWT());
                gfx.drawRect(x, y, 1, 1);
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            repaint();
        }
    }
}
