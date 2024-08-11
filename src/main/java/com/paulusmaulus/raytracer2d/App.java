package com.paulusmaulus.raytracer2d;

import javax.swing.JFrame;

import com.paulusmaulus.raytracer2d.assets.gameObjects.Player;
import com.paulusmaulus.raytracer2d.core.GameLoop;
import com.paulusmaulus.raytracer2d.core.InputHandler;
import com.paulusmaulus.raytracer2d.core.Renderer;
import com.paulusmaulus.raytracer2d.utils.core.Scene;
import com.paulusmaulus.raytracer2d.utils.math.Vector;

public final class App extends JFrame implements Runnable {

    GameLoop mainLoop;
    Scene currentScene;

    public App() {
        super();
    }

    public static void main(String[] args) {

        App app = new App();
        app.setSize(720, 720);
        app.setTitle("2D Ray-Tracing game engine");
        app.setVisible(true);

        Player player = new Player(new Vector(0, 0));

        InputHandler inputHandler = new InputHandler();

        Scene scene = new Scene("Test");
        scene.add(player);
        app.setCurrentScene(scene);

        GameLoop mainLoop = new GameLoop();
        mainLoop.add(() -> {

        });
        app.setMainLoop(mainLoop);

        app.run();
    }

    public void setMainLoop(GameLoop mainLoop) {
        this.mainLoop = mainLoop;
    }

    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }

    @Override
    public void repaint() {
        Renderer.render(getGraphics(), currentScene);
    }

    @Override
    public void run() {
        while (true) {

        }
    }
}
