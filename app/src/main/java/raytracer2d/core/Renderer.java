package raytracer2d.core;

import java.awt.Graphics;

import raytracer2d.utils.core.Scene;

public abstract class Renderer {
    public abstract void render(Graphics gfx, Scene scene);
}
