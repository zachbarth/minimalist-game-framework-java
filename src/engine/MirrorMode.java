package engine;

public enum MirrorMode {
    /**
     * Do not mirror the texture.
     */
    NONE,

    /**
     * Mirror the texture horizontally.
     */
    HORIZONTAL,

    /**
     * Mirror the texture vertically.
     */
    VERTICAL,

    /**
     * Mirror the texture horizontally and vertically. Equivalent to rotating it 180 degrees.
     */
    BOTH,
}
