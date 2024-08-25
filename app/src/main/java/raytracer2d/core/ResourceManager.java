package raytracer2d.core;

import java.util.LinkedList;
import java.util.List;

import raytracer2d.utils.res.Audio;

public class ResourceManager {
    private List<Audio> audios = new LinkedList<>();

    public void addAudio(Audio... audios) {
        if (this.audios != null)
            this.audios.addAll(List.of(audios));
        else
            throw new NullPointerException();
    }

    public List<Audio> getAudios() {
        return audios;
    }

    public void setAudios(List<Audio> audios) {
        this.audios = audios;
    }

    public Audio getAudio(String name) {
        for (Audio audio : audios)
            if (audio.name.equals(name))
                return audio;
        throw new java.lang.IndexOutOfBoundsException();
    }
}
