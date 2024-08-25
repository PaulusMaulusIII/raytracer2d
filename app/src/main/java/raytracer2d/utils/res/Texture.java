package raytracer2d.utils.res;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import raytracer2d.utils.rendering.Color;

public class Texture extends Resource {

    public final int width;
    public final int height;
    private final Color[][] pixels;

    public Texture(String pathname, String name) {
        super(pathname, name);
        BufferedImage image = null;
        try {
            image = ImageIO.read(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (image != null) {
            this.width = image.getWidth();
            this.height = image.getHeight();
            pixels = new Color[height][width];
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    pixels[y][x] = Color.fromInt(image.getRGB(x, y));
                }
            }
        } else {
            throw new Error("Encountered Error loading Texture");
        }
    }

    public Color getColor(int x, int y) {
        return pixels[y][x];
    }
}
