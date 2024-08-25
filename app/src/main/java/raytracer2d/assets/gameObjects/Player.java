package raytracer2d.assets.gameObjects;

import raytracer2d.core.Game;
import raytracer2d.utils.core.Collidable;
import raytracer2d.utils.core.GameObject;
import raytracer2d.utils.core.Intersectable;
import raytracer2d.utils.core.Renderable;
import raytracer2d.utils.math.Vector;
import raytracer2d.utils.ray_tracing.Ray;
import raytracer2d.utils.ray_tracing.RayHit;
import raytracer2d.utils.rendering.Color;
import raytracer2d.utils.rendering.RenderLayer;

public class Player extends GameObject implements Renderable, Collidable, Intersectable {

    public Player(Vector anchor, Game game) {
        super("Player", anchor, game);
    }

    @Override
    public Color getColor(Vector pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getColor'");
    }

    @Override
    public Vector getPos() {
        return anchor;
    }

    @Override
    public RenderLayer getRenderLayer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRenderLayer'");
    }

    @Override
    public RayHit getIntersection(Ray ray) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIntersection'");
    }

    @Override
    public void setPos(Vector pos) {
        this.anchor = pos;
    }

}
