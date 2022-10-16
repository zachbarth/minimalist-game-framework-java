package engine;

public enum InterpolationMode {
    /**
     * Use a linear scale mode that interpolates between pixels for a smooth but blurry image.
     */
    LINEAR,

    /**
     * Use a nearest neighbor scale mode that interpolates between pixels for a sharp but pixelated image.
     */
    NEAREST,
}
