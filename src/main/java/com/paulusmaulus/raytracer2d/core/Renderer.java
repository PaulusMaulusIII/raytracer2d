package com.paulusmaulus.raytracer2d.core;

import java.awt.Graphics;

import com.paulusmaulus.raytracer2d.utils.core.Scene;

public abstract class Renderer {
    public abstract void render(Graphics gfx, Scene scene);
}
