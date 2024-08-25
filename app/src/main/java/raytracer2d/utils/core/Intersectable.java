package raytracer2d.utils.core;

import raytracer2d.utils.ray_tracing.Ray;
import raytracer2d.utils.ray_tracing.RayHit;

public interface Intersectable {
    public RayHit getIntersection(Ray ray);
}
