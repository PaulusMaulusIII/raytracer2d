package com.paulusmaulus.raytracer2d.utils.core;

import com.paulusmaulus.raytracer2d.utils.math.Vector;
import com.paulusmaulus.raytracer2d.utils.rendering.Color;
import com.paulusmaulus.raytracer2d.utils.rendering.RenderLayer;

public interface Renderable {

    public Color getColor(Vector pos);

    public Vector getPos();

    public RenderLayer getRenderLayer();
}
