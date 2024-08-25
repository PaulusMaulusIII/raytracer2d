package raytracer2d.utils.ray_tracing;

import java.util.ArrayList;
import java.util.List;

import raytracer2d.utils.core.Intersectable;
import raytracer2d.utils.math.Vector;

public class Ray {
    Vector origin;
    Vector direction;

    public List<RayHit> cast(List<Intersectable> intersectables) {
        List<RayHit> hits = new ArrayList<>();
        for (Intersectable intersectable : intersectables) {
            RayHit intersection = intersectable.getIntersection(this);
            if (intersection != null)
                hits.add(intersection);
        }
        return hits;
    }
}
