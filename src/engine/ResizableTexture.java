package engine;

import java.awt.*;

public class ResizableTexture {
    
    public final Image image;
    public final int width, height;
    public final int leftOffset, rightOffset, topOffset, bottomOffset;

    public ResizableTexture(Image image, int leftOffset, int rightOffset, int topOffset, int bottomOffset) {
        this.image = image;
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
        this.leftOffset = leftOffset;
        this.rightOffset = rightOffset;
        this.topOffset = topOffset;
        this.bottomOffset = bottomOffset;
    }

}
