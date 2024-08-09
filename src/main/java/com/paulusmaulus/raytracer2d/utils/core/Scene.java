package com.paulusmaulus.raytracer2d.utils.core;

import java.util.List;

import com.paulusmaulus.raytracer2d.interactables.Interactable;
import com.paulusmaulus.raytracer2d.utils.rendering.Renderable;
import com.paulusmaulus.raytracer2d.utils.res.Audio;
import com.paulusmaulus.raytracer2d.utils.res.Texture;

public class Scene {
    public final String name;

    private Texture background;
    private List<Audio> audios;
    private List<Interactable> interactables;
    private List<Renderable> renderables;

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

    public List<Renderable> getRenderables() {
        return renderables;
    }

    public void setRenderables(List<Renderable> renderables) {
        this.renderables = renderables;
    }

    public void addRenderable(Renderable... renderables) {
        this.renderables.addAll(List.of(renderables));
    }
}
