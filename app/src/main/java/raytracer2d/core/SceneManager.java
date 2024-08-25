package raytracer2d.core;

import java.util.LinkedList;
import java.util.List;

import raytracer2d.utils.core.Scene;

public class SceneManager {

    List<Scene> scenes = new LinkedList<>();
    int currentScene;

    public void setCurrentScene(Scene scene) {
        if (!scenes.contains(scene))
            scenes.add(scene);
        currentScene = scenes.indexOf(scene);
    }

    public Scene getCurrentScene() {
        return scenes.get(currentScene);
    }

    public void add(Scene... scenes) {
        if (this.scenes != null)
            this.scenes.addAll(List.of(scenes));
        else
            throw new NullPointerException();
    }

    public List<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(List<Scene> scenes) {
        this.scenes = scenes;
    }
}
