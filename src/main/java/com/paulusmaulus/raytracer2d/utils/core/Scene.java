package com.paulusmaulus.raytracer2d.utils.core;

import java.util.List;

import com.paulusmaulus.raytracer2d.interactables.Interactable;
import com.paulusmaulus.raytracer2d.utils.res.Audio;
import com.paulusmaulus.raytracer2d.utils.res.Texture;

public class Scene {
    public final String name;

    private Texture background;
    private List<Audio> audios;
    private List<Interactable> interactables;

    public Scene(String name) {
        super();
        this.name = name;
    }

    public List<Audio> getAudios() {
        return audios;
    }

    public void setAudios(List<Audio> audios) {
        this.audios = audios;
    }

    public void addAudio(Audio... audios) {
        this.audios.addAll(List.of(audios));
    }

    public Audio getAudio(String name) {
        for (Audio audio : audios)
            if (audio.name.equals(name))
                return audio;
        throw new java.lang.IndexOutOfBoundsException();
    }

    public Texture getBackground() {
        return background;
    }

    public void setBackground(Texture background) {
        this.background = background;
    }

    public List<Interactable> getInteractables() {
        return interactables;
    }

    public void setInteractables(List<Interactable> interactables) {
        this.interactables = interactables;
    }

    public void addInteractable(Interactable... interactables) {
        this.interactables.addAll(List.of(interactables));
    }

    public Interactable getInteractable(String name) {
        for (Interactable interactable : interactables)
            if (interactable.name.equals(name))
                return interactable;
        throw new java.lang.IndexOutOfBoundsException();
    }
}
