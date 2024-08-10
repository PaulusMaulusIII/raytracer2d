package com.paulusmaulus.raytracer2d.utils.core;

import com.paulusmaulus.raytracer2d.utils.math.Vector;

public abstract class Interactable {
    public final String name;
    public Vector anchor;

    public Interactable(String name, Vector anchor) {
        this.name = name;
        this.anchor = anchor;
    }

}
