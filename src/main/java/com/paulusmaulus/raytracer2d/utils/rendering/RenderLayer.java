package com.paulusmaulus.raytracer2d.utils.rendering;

import java.util.LinkedList;
import java.util.List;

import com.paulusmaulus.raytracer2d.utils.core.Renderable;

public class RenderLayer {
    List<Renderable> renderables;
    int depth;

    public RenderLayer(int depth) {
        super();
        renderables = new LinkedList<>();
        this.depth = depth;
    }

    public void add(Renderable... renderables) {
        if (this.renderables != null)
            this.renderables.addAll(List.of(renderables));
        else
            throw new NullPointerException();
    }

    public List<Renderable> getRenderables() {
        return renderables;
    }
}
