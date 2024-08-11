package com.paulusmaulus.raytracer2d.core;

import javax.swing.JFrame;

import com.paulusmaulus.raytracer2d.utils.core.Scene;
import com.paulusmaulus.raytracer2d.utils.interfaces.Action;

public final class Game extends JFrame implements Runnable {

    private Scene currentScene;

    private AudioPlayer audioPlayer = new AudioPlayer();
    private GameLoop mainLoop = new GameLoop();
    private InputHandler inputHandler = new InputHandler();
    private PhysicsEngine physicsEngine = new PhysicsEngine();
    private ResourceManager resourceManager = new ResourceManager();
    private SceneManager sceneManager = new SceneManager();
    private UISystem uiSystem = new UISystem();

    public Game() {
        super();
    }

    public AudioPlayer getAudioPlayer() {
        return audioPlayer;
    }

    public GameLoop getMainLoop() {
        return mainLoop;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public PhysicsEngine getPhysicsEngine() {
        return physicsEngine;
    }

    public ResourceManager getResourceManager() {
        return resourceManager;
    }

    public SceneManager getSceneManager() {
        return sceneManager;
    }

    public UISystem getUISystem() {
        return uiSystem;
    }

    @Override
    public void repaint() {
        Renderer.render(getGraphics(), currentScene);
    }

    @Override
    public void run() {
        while (true) {
            for (Action action : getMainLoop().getActions()) {
                action.run();
            }
        }
    }
}
