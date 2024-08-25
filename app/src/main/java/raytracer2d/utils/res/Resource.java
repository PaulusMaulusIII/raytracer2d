package raytracer2d.utils.res;

import java.io.File;

public abstract class Resource extends File {

    public final String name;

    public Resource(String pathname, String name) {
        super(pathname);
        this.name = name;
    }

}
