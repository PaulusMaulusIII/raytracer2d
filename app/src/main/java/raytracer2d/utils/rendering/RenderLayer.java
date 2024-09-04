package raytracer2d.utils.rendering;

import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;

import raytracer2d.utils.core.Renderable;

public class RenderLayer {
    List<Renderable> renderables;
    int depth;
    boolean background = false;

    public RenderLayer(int depth) {
        super();
        renderables = new LinkedList<>();
        this.depth = depth;
    }

    public void add(Renderable... renderables) {
        if (this.renderables != null) {
            this.renderables.addAll(List.of(renderables));
            for (Renderable renderable : renderables) {
                renderable.setRenderLayer(this);
            }
        } else
            throw new NullPointerException();
    }

    public List<Renderable> getRenderables() {
        return renderables;
    }

    public void draw(Graphics2D buffer, int minX, int minY, int maxX, int maxY) {
        if (renderables == null || renderables.isEmpty())
            return;
        for (Renderable renderable : renderables)
            renderable.draw(buffer, minX, minY, maxX, maxY);
    }

    public void setBackground(boolean background) {
        this.background = background;
    }

    public boolean isBackground() {
        return background;
    }
}
