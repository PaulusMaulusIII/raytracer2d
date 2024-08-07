package com.paulusmaulus.raytracer2d.utils.ray_tracing;

import java.util.ArrayList;
import java.util.List;

import com.paulusmaulus.raytracer2d.interactables.Interactable;
import com.paulusmaulus.raytracer2d.utils.math.Vector;

public class Ray {
    Vector origin;
    Vector direction;

    public List<RayHit> cast(List<Interactable> interactables) {
        List<RayHit> hits = new ArrayList<>();
        for (Interactable interactable : interactables) {
            RayHit intersection = interactable.getIntersection(this);
            if (intersection != null)
                hits.add(intersection);
        }
        return hits;
    }
}
