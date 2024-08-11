package com.paulusmaulus.raytracer2d.core;

import javax.swing.JFrame;

import com.paulusmaulus.raytracer2d.utils.interfaces.Action;

public final class Game extends JFrame implements Runnable {

    private Renderer renderer;

    private AudioPlayer audioPlayer = new AudioPlayer();
    private GameLoop mainLoop = new GameLoop();
    private PhysicsEngine physicsEngine = new PhysicsEngine();
    private ResourceManager resourceManager = new ResourceManager();
    private SceneManager sceneManager = new SceneManager();
    private UISystem uiSystem = new UISystem();

    public Game() {
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public AudioPlayer getAudioPlayer() {
        return audioPlayer;
    }

    public GameLoop getMainLoop() {
        return mainLoop;
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

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    public Renderer getRenderer() {
        return renderer;
    }

    @Override
    public void repaint() {
        getRenderer().render(getGraphics(), getSceneManager().getCurrentScene());
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
