package com.paulusmaulus.raytracer2d.utils.core;

import com.paulusmaulus.raytracer2d.utils.ray_tracing.Ray;
import com.paulusmaulus.raytracer2d.utils.ray_tracing.RayHit;

public interface Intersectable {
    public RayHit getIntersection(Ray ray);
}
