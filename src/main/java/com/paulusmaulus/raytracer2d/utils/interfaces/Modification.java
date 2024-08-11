package com.paulusmaulus.raytracer2d.utils.interfaces;

import com.paulusmaulus.raytracer2d.utils.core.PhysicsAffected;

public interface Modification {
    public void run(PhysicsAffected physicsAffected);
}