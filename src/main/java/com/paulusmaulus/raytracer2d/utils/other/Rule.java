package com.paulusmaulus.raytracer2d.utils.other;

import java.util.List;

public interface Rule {
    public boolean applies();

    public List<Modification> getModifications();
}
