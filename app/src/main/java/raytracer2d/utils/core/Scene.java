package raytracer2d.utils.core;

import java.util.LinkedList;
import java.util.List;

import raytracer2d.utils.rendering.RenderLayer;

public class Scene {
    public final String name;

    private List<GameObject> gameObjects = new LinkedList<>();
    private List<Collidable> collidables = new LinkedList<>();
    private List<Intersectable> intersectables = new LinkedList<>();
    private List<PhysicsAffected> physicsAffecteds = new LinkedList<>();
    private List<RenderLayer> renderLayers = new LinkedList<>();
    private RenderLayer background;

    public Scene(String name) {
        super();
        this.name = name;
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

    public List<RenderLayer> getRenderLayers() {
        return renderLayers;
    }

    public void setRenderables(List<RenderLayer> renderLayers) {
        this.renderLayers = renderLayers;
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

    public void add(RenderLayer... renderLayers) {
        if (this.renderLayers != null) {
            this.renderLayers.addAll(List.of(renderLayers));
            for (RenderLayer renderLayer : renderLayers) {
                if (renderLayer.isBackground() && background == null) {
                    background = renderLayer;
                } else {
                    for (Renderable renderable : renderLayer.getRenderables())
                        if (renderable instanceof Intersectable)
                            add((Intersectable) renderable);
                }
            }

        } else
            throw new NullPointerException();
    }

    public RenderLayer getBackground() {
        return background;
    }
}
