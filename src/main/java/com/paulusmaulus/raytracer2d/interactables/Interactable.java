package com.paulusmaulus.raytracer2d.interactables;

import com.paulusmaulus.raytracer2d.utils.ray_tracing.Ray;
import com.paulusmaulus.raytracer2d.utils.ray_tracing.RayHit;

public abstract class Interactable {
    public final String name;

    public Interactable(int id, String name) {
        this.name = name;
    }

    public abstract RayHit getIntersection(Ray ray);
}
