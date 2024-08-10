package com.paulusmaulus.raytracer2d.UI;

import java.util.List;

public abstract class UI {
    List<UIElement> elements;

    public UI() {
        super();
    }

    public void add(UIElement... elements) {
        if (this.elements != null)
            this.elements.addAll(List.of(elements));
        throw new NullPointerException();
    }

    public List<UIElement> getElements() {
        return elements;
    }

    public void setElements(List<UIElement> elements) {
        this.elements = elements;
    }
}
