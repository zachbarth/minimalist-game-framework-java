package engine;

import java.awt.*;

public class Texture {
    
    public final Image image;
    public final int width, height;
    public final Vector2 size;

    public Texture(Image image) {
        this.image = image;
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
        this.size = new Vector2(width, height);
    }

}
