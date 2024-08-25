package raytracer2d.utils.interfaces;

import java.util.List;

public interface Rule {
    public boolean applies();

    public List<Modification> getModifications();
}
