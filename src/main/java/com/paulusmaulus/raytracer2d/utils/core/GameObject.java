package com.paulusmaulus.raytracer2d.utils.core;

import com.paulusmaulus.raytracer2d.core.Game;
import com.paulusmaulus.raytracer2d.utils.math.Vector;

public abstract class GameObject {
    public final String name;
    public Vector anchor;
    public Game game;

    public GameObject(String name, Vector anchor, Game game) {
        this.name = name;
        this.anchor = anchor;
        this.game = game;
    }

}
