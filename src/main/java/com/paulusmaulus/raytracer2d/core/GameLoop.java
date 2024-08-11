package com.paulusmaulus.raytracer2d.core;

import java.util.List;

import com.paulusmaulus.raytracer2d.utils.other.Action;

public class GameLoop {
    List<Action> actions;

    public void add(Action... actions) {
        if (this.actions != null)
            this.actions.addAll(List.of(actions));
        throw new NullPointerException();
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
