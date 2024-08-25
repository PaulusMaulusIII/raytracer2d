package raytracer2d.utils.core;

import raytracer2d.utils.math.Vector;
import raytracer2d.utils.rendering.Color;
import raytracer2d.utils.rendering.RenderLayer;

public interface Renderable {

    public Color getColor(Vector pos);

    public void setPos(Vector pos);

    public Vector getPos();

    public RenderLayer getRenderLayer();
}
