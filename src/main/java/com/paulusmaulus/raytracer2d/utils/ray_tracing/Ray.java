package com.paulusmaulus.raytracer2d.utils.ray_tracing;

import java.util.ArrayList;
import java.util.List;

import com.paulusmaulus.raytracer2d.utils.math.Vector;
import com.paulusmaulus.raytracer2d.utils.rendering.Renderable;

public class Ray {
    Vector origin;
    Vector direction;

    public List<RayHit> cast(List<Renderable> renderables) {
        List<RayHit> hits = new ArrayList<>();
        for (Renderable renderable : renderables) {
            RayHit intersection = renderable.getIntersection(this);
            if (intersection != null)
                hits.add(intersection);
        }
        return hits;
    }
}
