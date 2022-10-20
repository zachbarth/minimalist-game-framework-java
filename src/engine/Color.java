package engine;

public class Color {
    
    protected final java.awt.Color color;

    public Color(int r, int g, int b) {
        this(r, g, b, 0xFF);
    }

    public Color(int r, int g, int b, int a) {
        this.color = new java.awt.Color(r, g, b, a);
    }

    public int getR() { return color.getRed(); }
    public int getG() { return color.getGreen(); }
    public int getB() { return color.getBlue(); }
    public int getA() { return color.getAlpha(); }

    /**
     * @param scale The scale factor to apply to the original alpha, between 0 and 1.
     * @return A copy of this color with a scaled alpha value.
     */
    public Color withAlpha(float scale) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), (int)Engine.clamp(color.getAlpha() * scale, 0, 255));
    }

    public static final Color TRANSPARENT = new Color(0x00, 0x00, 0x00, 0x00);
    public static final Color ALICEBLUE = new Color(0xF0, 0xF8, 0xFF);
    public static final Color ANTIQUE_WHITE = new Color(0xFA, 0xEB, 0xD7);
    public static final Color AQUA = new Color(0x00, 0xFF, 0xFF);
    public static final Color AQUAMARINE = new Color(0x7F, 0xFF, 0xD4);
    public static final Color AZURE = new Color(0xF0, 0xFF, 0xFF);
    public static final Color BEIGE = new Color(0xF5, 0xF5, 0xDC);
    public static final Color BISQUE = new Color(0xFF, 0xE4, 0xC4);
    public static final Color BLACK = new Color(0x00, 0x00, 0x00);
    public static final Color BLANCHED_ALMOND = new Color(0xFF, 0xEB, 0xCD);
    public static final Color BLUE = new Color(0x00, 0x00, 0xFF);
    public static final Color BLUE_VIOLET = new Color(0x8A, 0x2B, 0xE2);
    public static final Color BROWN = new Color(0xA5, 0x2A, 0x2A);
    public static final Color BURLY_WOOD = new Color(0xDE, 0xB8, 0x87);
    public static final Color CADET_BLUE = new Color(0x5F, 0x9E, 0xA0);
    public static final Color CHARTREUSE = new Color(0x7F, 0xFF, 0x00);
    public static final Color CHOCOLATE = new Color(0xD2, 0x69, 0x1E);
    public static final Color CORAL = new Color(0xFF, 0x7F, 0x50);
    public static final Color CORNFLOWER_BLUE = new Color(0x64, 0x95, 0xED);
    public static final Color CORNSILK = new Color(0xFF, 0xF8, 0xDC);
    public static final Color CRIMSON = new Color(0xDC, 0x14, 0x3C);
    public static final Color CYAN = new Color(0x00, 0xFF, 0xFF);
    public static final Color DARK_BLUE = new Color(0x00, 0x00, 0x8B);
    public static final Color DARK_CYAN = new Color(0x00, 0x8B, 0x8B);
    public static final Color DARK_GOLDENROD = new Color(0xB8, 0x86, 0x0B);
    public static final Color DARK_GRAY = new Color(0xA9, 0xA9, 0xA9);
    public static final Color DARK_GREEN = new Color(0x00, 0x64, 0x00);
    public static final Color DARK_KHAKI = new Color(0xBD, 0xB7, 0x6B);
    public static final Color DARK_MAGENTA = new Color(0x8B, 0x00, 0x8B);
    public static final Color DARK_OLIVE_GREEN = new Color(0x55, 0x6B, 0x2F);
    public static final Color DARK_ORANGE = new Color(0xFF, 0x8C, 0x00);
    public static final Color DARK_ORCHID = new Color(0x99, 0x32, 0xCC);
    public static final Color DARK_RED = new Color(0x8B, 0x00, 0x00);
    public static final Color DARK_SALMON = new Color(0xE9, 0x96, 0x7A);
    public static final Color DARK_SEA_GREEN = new Color(0x8F, 0xBC, 0x8F);
    public static final Color DARK_SLATE_BLUE = new Color(0x48, 0x3D, 0x8B);
    public static final Color DARK_SLATE_GRAY = new Color(0x2F, 0x4F, 0x4F);
    public static final Color DARK_TURQUOISE = new Color(0x00, 0xCE, 0xD1);
    public static final Color DARK_VIOLET = new Color(0x94, 0x00, 0xD3);
    public static final Color DEEP_PINK = new Color(0xFF, 0x14, 0x93);
    public static final Color DEEP_SKY_BLUE = new Color(0x00, 0xBF, 0xFF);
    public static final Color DIM_GRAY = new Color(0x69, 0x69, 0x69);
    public static final Color DODGER_BLUE = new Color(0x1E, 0x90, 0xFF);
    public static final Color FIREBRICK = new Color(0xB2, 0x22, 0x22);
    public static final Color FLORAL_WHITE = new Color(0xFF, 0xFA, 0xF0);
    public static final Color FOREST_GREEN = new Color(0x22, 0x8B, 0x22);
    public static final Color FUCHSIA = new Color(0xFF, 0x00, 0xFF);
    public static final Color GAINSBORO = new Color(0xDC, 0xDC, 0xDC);
    public static final Color GHOST_WHITE = new Color(0xF8, 0xF8, 0xFF);
    public static final Color GOLD = new Color(0xFF, 0xD7, 0x00);
    public static final Color GOLDENROD = new Color(0xDA, 0xA5, 0x20);
    public static final Color GRAY = new Color(0x80, 0x80, 0x80);
    public static final Color GREEN = new Color(0x00, 0x80, 0x00);
    public static final Color GREEN_YELLOW = new Color(0xAD, 0xFF, 0x2F);
    public static final Color HONEYDEW = new Color(0xF0, 0xFF, 0xF0);
    public static final Color HOT_PINK = new Color(0xFF, 0x69, 0xB4);
    public static final Color INDIAN_RED = new Color(0xCD, 0x5C, 0x5C);
    public static final Color INDIGO = new Color(0x4B, 0x00, 0x82);
    public static final Color IVORY = new Color(0xFF, 0xFF, 0xF0);
    public static final Color KHAKI = new Color(0xF0, 0xE6, 0x8C);
    public static final Color LAVENDER = new Color(0xE6, 0xE6, 0xFA);
    public static final Color LAVENDER_BLUSH = new Color(0xFF, 0xF0, 0xF5);
    public static final Color LAWN_GREEN = new Color(0x7C, 0xFC, 0x00);
    public static final Color LEMON_CHIFFON = new Color(0xFF, 0xFA, 0xCD);
    public static final Color LIGHT_BLUE = new Color(0xAD, 0xD8, 0xE6);
    public static final Color LIGHT_CORAL = new Color(0xF0, 0x80, 0x80);
    public static final Color LIGHT_CYAN = new Color(0xE0, 0xFF, 0xFF);
    public static final Color LIGHT_GOLDENROD_YELLOW = new Color(0xFA, 0xFA, 0xD2);
    public static final Color LIGHT_GRAY = new Color(0xD3, 0xD3, 0xD3);
    public static final Color LIGHT_GREEN = new Color(0x90, 0xEE, 0x90);
    public static final Color LIGHT_PINK = new Color(0xFF, 0xB6, 0xC1);
    public static final Color LIGHT_SALMON = new Color(0xFF, 0xA0, 0x7A);
    public static final Color LIGHT_SEA_GREEN = new Color(0x20, 0xB2, 0xAA);
    public static final Color LIGHT_SKYBLUE = new Color(0x87, 0xCE, 0xFA);
    public static final Color LIGHT_SLATE_GRAY = new Color(0x77, 0x88, 0x99);
    public static final Color LIGHT_STEEL_BLUE = new Color(0xB0, 0xC4, 0xDE);
    public static final Color LIGHT_YELLOW = new Color(0xFF, 0xFF, 0xE0);
    public static final Color LIME = new Color(0x00, 0xFF, 0x00);
    public static final Color LIME_GREEN = new Color(0x32, 0xCD, 0x32);
    public static final Color LINEN = new Color(0xFA, 0xF0, 0xE6);
    public static final Color MAGENTA = new Color(0xFF, 0x00, 0xFF);
    public static final Color MAROON = new Color(0x80, 0x00, 0x00);
    public static final Color MEDIUM_AQUAMARINE = new Color(0x66, 0xCD, 0xAA);
    public static final Color MEDIUM_BLUE = new Color(0x00, 0x00, 0xCD);
    public static final Color MEDIUM_ORCHID = new Color(0xBA, 0x55, 0xD3);
    public static final Color MEDIUM_PURPLE = new Color(0x93, 0x70, 0xDB);
    public static final Color MEDIUM_SEA_GREEN = new Color(0x3C, 0xB3, 0x71);
    public static final Color MEDIUM_SLATE_BLUE = new Color(0x7B, 0x68, 0xEE);
    public static final Color MEDIUM_SPRING_GREEN = new Color(0x00, 0xFA, 0x9A);
    public static final Color MEDIUM_TURQUOISE = new Color(0x48, 0xD1, 0xCC);
    public static final Color MEDIUM_VIOLET_RED = new Color(0xC7, 0x15, 0x85);
    public static final Color MIDNIGHT_BLUE = new Color(0x19, 0x19, 0x70);
    public static final Color MINT_CREAM = new Color(0xF5, 0xFF, 0xFA);
    public static final Color MISTY_ROSE = new Color(0xFF, 0xE4, 0xE1);
    public static final Color MOCCASIN = new Color(0xFF, 0xE4, 0xB5);
    public static final Color NAVAJO_WHITE = new Color(0xFF, 0xDE, 0xAD);
    public static final Color NAVY = new Color(0x00, 0x00, 0x80);
    public static final Color OLD_LACE = new Color(0xFD, 0xF5, 0xE6);
    public static final Color OLIVE = new Color(0x80, 0x80, 0x00);
    public static final Color OLIVE_DRAB = new Color(0x6B, 0x8E, 0x23);
    public static final Color ORANGE = new Color(0xFF, 0xA5, 0x00);
    public static final Color ORANGE_RED = new Color(0xFF, 0x45, 0x00);
    public static final Color ORCHID = new Color(0xDA, 0x70, 0xD6);
    public static final Color PALE_GOLDENROD = new Color(0xEE, 0xE8, 0xAA);
    public static final Color PALE_GREEN = new Color(0x98, 0xFB, 0x98);
    public static final Color PALE_TURQUOISE = new Color(0xAF, 0xEE, 0xEE);
    public static final Color PALE_VIOLET_RED = new Color(0xDB, 0x70, 0x93);
    public static final Color PAPAYA_WHIP = new Color(0xFF, 0xEF, 0xD5);
    public static final Color PEACH_PUFF = new Color(0xFF, 0xDA, 0xB9);
    public static final Color PERU = new Color(0xCD, 0x85, 0x3F);
    public static final Color PINK = new Color(0xFF, 0xC0, 0xCB);
    public static final Color PLUM = new Color(0xDD, 0xA0, 0xDD);
    public static final Color POWDER_BLUE = new Color(0xB0, 0xE0, 0xE6);
    public static final Color PURPLE = new Color(0x80, 0x00, 0x80);
    public static final Color RED = new Color(0xFF, 0x00, 0x00);
    public static final Color ROSY_BROWN = new Color(0xBC, 0x8F, 0x8F);
    public static final Color ROYAL_BLUE = new Color(0x41, 0x69, 0xE1);
    public static final Color SADDLE_BROWN = new Color(0x8B, 0x45, 0x13);
    public static final Color SALMON = new Color(0xFA, 0x80, 0x72);
    public static final Color SANDY_BROWN = new Color(0xF4, 0xA4, 0x60);
    public static final Color SEA_GREEN = new Color(0x2E, 0x8B, 0x57);
    public static final Color SEA_SHELL = new Color(0xFF, 0xF5, 0xEE);
    public static final Color SIENNA = new Color(0xA0, 0x52, 0x2D);
    public static final Color SILVER = new Color(0xC0, 0xC0, 0xC0);
    public static final Color SKY_BLUE = new Color(0x87, 0xCE, 0xEB);
    public static final Color SLATE_BLUE = new Color(0x6A, 0x5A, 0xCD);
    public static final Color SLATE_GRAY = new Color(0x70, 0x80, 0x90);
    public static final Color SNOW = new Color(0xFF, 0xFA, 0xFA);
    public static final Color SPRING_GREEN = new Color(0x00, 0xFF, 0x7F);
    public static final Color STEEL_BLUE = new Color(0x46, 0x82, 0xB4);
    public static final Color TAN = new Color(0xD2, 0xB4, 0x8C);
    public static final Color TEAL = new Color(0x00, 0x80, 0x80);
    public static final Color THISTLE = new Color(0xD8, 0xBF, 0xD8);
    public static final Color TOMATO = new Color(0xFF, 0x63, 0x47);
    public static final Color TURQUOISE = new Color(0x40, 0xE0, 0xD0);
    public static final Color VIOLET = new Color(0xEE, 0x82, 0xEE);
    public static final Color WHEAT = new Color(0xF5, 0xDE, 0xB3);
    public static final Color WHITE = new Color(0xFF, 0xFF, 0xFF);
    public static final Color WHITE_SMOKE = new Color(0xF5, 0xF5, 0xF5);
    public static final Color YELLOW = new Color(0xFF, 0xFF, 0x00);
    public static final Color YELLOW_GREEN = new Color(0x9A, 0xCD, 0x32);

}
