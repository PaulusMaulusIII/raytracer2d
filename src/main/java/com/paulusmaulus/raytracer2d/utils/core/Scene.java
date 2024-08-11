package com.paulusmaulus.raytracer2d.utils.core;

import java.util.LinkedList;
import java.util.List;

import com.paulusmaulus.raytracer2d.utils.res.Audio;
import com.paulusmaulus.raytracer2d.utils.res.Texture;

public class Scene {
    public final String name;

    private Texture background;
    private List<Audio> audios = new LinkedList<>();;
    private List<GameObject> gameObjects = new LinkedList<>();;
    private List<Collidable> collidables = new LinkedList<>();;
    private List<Intersectable> intersectables = new LinkedList<>();;
    private List<PhysicsAffected> physicsAffecteds = new LinkedList<>();;
    private List<Renderable> renderables = new LinkedList<>();;

    public Scene(String name) {
        super();
        this.name = name;
    }

    public void addAudio(Audio... audios) {
        if (this.audios != null)
            this.audios.addAll(List.of(audios));
        else
            throw new NullPointerException();
    }

    public void add(GameObject gameObject) {
        if (this.gameObjects == null)
            throw new NullPointerException();
        this.gameObjects.add(gameObject);
        if (gameObject instanceof PhysicsAffected) {
            if (gameObject instanceof Collidable)
                add(((Collidable) gameObject));
            add(((PhysicsAffected) gameObject));
        }
        if (gameObject instanceof Renderable)
            add(((Renderable) gameObject));
        if (gameObject instanceof Intersectable)
            add(((Intersectable) gameObject));
    }

    private void add(Collidable... collidables) {
        if (this.collidables != null)
            this.collidables.addAll(List.of(collidables));
        else
            throw new NullPointerException();
    }

    private void add(Intersectable... intersectables) {
        if (this.intersectables != null)
            this.intersectables.addAll(List.of(intersectables));
        else
            throw new NullPointerException();
    }

    private void add(PhysicsAffected... physicsAffecteds) {
        if (this.physicsAffecteds != null)
            this.physicsAffecteds.addAll(List.of(physicsAffecteds));
        else
            throw new NullPointerException();
    }

    private void add(Renderable... renderables) {
        if (this.renderables != null)
            this.renderables.addAll(List.of(renderables));
        else
            throw new NullPointerException();
    }

    public List<Audio> getAudios() {
        return audios;
    }

    public void setAudios(List<Audio> audios) {
        this.audios = audios;
    }

    public Audio getAudio(String name) {
        for (Audio audio : audios)
            if (audio.name.equals(name))
                return audio;
        throw new java.lang.IndexOutOfBoundsException();
    }

    public Texture getBackground() {
        return background;
    }

    public void setBackground(Texture background) {
        this.background = background;
    }

    public List<Collidable> getCollidables() {
        return collidables;
    }

    public void setCollidables(List<Collidable> collidables) {
        this.collidables = collidables;
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public List<Intersectable> getIntersectables() {
        return intersectables;
    }

    public void setIntersectables(List<Intersectable> intersectables) {
        this.intersectables = intersectables;
    }

    public List<PhysicsAffected> getPhysicsAffecteds() {
        return physicsAffecteds;
    }

    public void setPhysicsAffecteds(List<PhysicsAffected> physicsAffecteds) {
        this.physicsAffecteds = physicsAffecteds;
    }

    public List<Renderable> getRenderables() {
        return renderables;
    }

    public void setRenderables(List<Renderable> renderables) {
        this.renderables = renderables;
    }
}
