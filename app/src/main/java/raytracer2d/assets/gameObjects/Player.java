package raytracer2d.assets.gameObjects;

import java.awt.Graphics2D;

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

    Color color = Color.BLACK;

    public Player(Vector anchor, Game game) {
        super("Player", anchor, game);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor(Vector pos) {
        return color;
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

    @Override
    public boolean visible(Vector pos) {
        return true;
    }

    @Override
    public void draw(Graphics2D gfx) {
        if (visible(anchor)) {
            gfx.setColor(getColor(anchor).toAWT());
            gfx.fillOval((int) getPos().x - 25, (int) getPos().y - 25, 50, 50);
        }
    }

}
