package com.paulusmaulus.raytracer2d.utils.rendering;

import com.paulusmaulus.raytracer2d.utils.math.Vector;
import com.paulusmaulus.raytracer2d.utils.ray_tracing.Ray;
import com.paulusmaulus.raytracer2d.utils.ray_tracing.RayHit;

public interface Renderable {
    public RayHit getIntersection(Ray ray);

    public Color getColor(Vector pos);
}
