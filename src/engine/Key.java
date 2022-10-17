package engine;

public final class Key {
    
    // Don't let the Key class be instantiated:
    private Key() { }

    /** Constant for the ENTER virtual key. */
    public static final int ENTER = '\n';

    /** Constant for the BACK_SPACE virtual key. */
    public static final int BACK_SPACE = '\b';

    /** Constant for the TAB virtual key. */
    public static final int TAB = '\t';

    /** Constant for the CANCEL virtual key. */
    public static final int CANCEL = 0x03;

    /** Constant for the CLEAR virtual key. */
    public static final int CLEAR = 0x0C;

    /** Constant for the SHIFT virtual key. */
    public static final int SHIFT = 0x10;

    /** Constant for the CONTROL virtual key. */
    public static final int CONTROL = 0x11;

    /** Constant for the ALT virtual key. */
    public static final int ALT = 0x12;

    /** Constant for the PAUSE virtual key. */
    public static final int PAUSE = 0x13;

    /** Constant for the CAPS_LOCK virtual key. */
    public static final int CAPS_LOCK = 0x14;

    /** Constant for the ESCAPE virtual key. */
    public static final int ESCAPE = 0x1B;

    /** Constant for the SPACE virtual key. */
    public static final int SPACE = 0x20;

    /** Constant for the PAGE_UP virtual key. */
    public static final int PAGE_UP = 0x21;

    /** Constant for the PAGE_DOWN virtual key. */
    public static final int PAGE_DOWN = 0x22;

    /** Constant for the END virtual key. */
    public static final int END = 0x23;

    /** Constant for the HOME virtual key. */
    public static final int HOME = 0x24;

    /**
     * Constant for the non-numpad <b>left</b> arrow key.
     * @see #KP_LEFT
     */
    public static final int LEFT = 0x25;

    /**
     * Constant for the non-numpad <b>up</b> arrow key.
     * @see #KP_UP
     */
    public static final int UP = 0x26;

    /**
     * Constant for the non-numpad <b>right</b> arrow key.
     * @see #KP_RIGHT
     */
    public static final int RIGHT = 0x27;

    /**
     * Constant for the non-numpad <b>down</b> arrow key.
     * @see #KP_DOWN
     */
    public static final int DOWN = 0x28;

    /**
     * Constant for the comma key, ","
     */
    public static final int COMMA = 0x2C;

    /**
     * Constant for the minus key, "-"
     * @since 1.2
     */
    public static final int MINUS = 0x2D;

    /**
     * Constant for the period key, "."
     */
    public static final int PERIOD = 0x2E;

    /**
     * Constant for the forward slash key, "/"
     */
    public static final int SLASH = 0x2F;

    /** 0 thru 9 are the same as ASCII '0' thru '9' (0x30 - 0x39) */

    /** Constant for the "0" key. */
    public static final int NR_0 = 0x30;

    /** Constant for the "1" key. */
    public static final int NR_1 = 0x31;

    /** Constant for the "2" key. */
    public static final int NR_2 = 0x32;

    /** Constant for the "3" key. */
    public static final int NR_3 = 0x33;

    /** Constant for the "4" key. */
    public static final int NR_4 = 0x34;

    /** Constant for the "5" key. */
    public static final int NR_5 = 0x35;

    /** Constant for the "6" key. */
    public static final int NR_6 = 0x36;

    /** Constant for the "7" key. */
    public static final int NR_7 = 0x37;

    /** Constant for the "8" key. */
    public static final int NR_8 = 0x38;

    /** Constant for the "9" key. */
    public static final int NR_9 = 0x39;

    /**
     * Constant for the semicolon key, ";"
     */
    public static final int SEMICOLON = 0x3B;

    /**
     * Constant for the equals key, " 
     */
    public static final int EQUALS = 0x3D;

    /** A thru Z are the same as ASCII 'A' thru 'Z' (0x41 - 0x5A) */

    /** Constant for the "A" key. */
    public static final int A = 0x41;

    /** Constant for the "B" key. */
    public static final int B = 0x42;

    /** Constant for the "C" key. */
    public static final int C = 0x43;

    /** Constant for the "D" key. */
    public static final int D = 0x44;

    /** Constant for the "E" key. */
    public static final int E = 0x45;

    /** Constant for the "F" key. */
    public static final int F = 0x46;

    /** Constant for the "G" key. */
    public static final int G = 0x47;

    /** Constant for the "H" key. */
    public static final int H = 0x48;

    /** Constant for the "I" key. */
    public static final int I = 0x49;

    /** Constant for the "J" key. */
    public static final int J = 0x4A;

    /** Constant for the "K" key. */
    public static final int K = 0x4B;

    /** Constant for the "L" key. */
    public static final int L = 0x4C;

    /** Constant for the "M" key. */
    public static final int M = 0x4D;

    /** Constant for the "N" key. */
    public static final int N = 0x4E;

    /** Constant for the "O" key. */
    public static final int O = 0x4F;

    /** Constant for the "P" key. */
    public static final int P = 0x50;

    /** Constant for the "Q" key. */
    public static final int Q = 0x51;

    /** Constant for the "R" key. */
    public static final int R = 0x52;

    /** Constant for the "S" key. */
    public static final int S = 0x53;

    /** Constant for the "T" key. */
    public static final int T = 0x54;

    /** Constant for the "U" key. */
    public static final int U = 0x55;

    /** Constant for the "V" key. */
    public static final int V = 0x56;

    /** Constant for the "W" key. */
    public static final int W = 0x57;

    /** Constant for the "X" key. */
    public static final int X = 0x58;

    /** Constant for the "Y" key. */
    public static final int Y = 0x59;

    /** Constant for the "Z" key. */
    public static final int Z = 0x5A;

    /**
     * Constant for the open bracket key, "["
     */
    public static final int OPEN_BRACKET = 0x5B;

    /**
     * Constant for the back slash key, "\"
     */
    public static final int BACK_SLASH = 0x5C;

    /**
     * Constant for the close bracket key, "]"
     */
    public static final int CLOSE_BRACKET = 0x5D;

    /** Constant for the number pad "0" key. */
    public static final int NP_0 = 0x60;

    /** Constant for the number pad "1" key. */
    public static final int NP_1 = 0x61;

    /** Constant for the number pad "2" key. */
    public static final int NP_2 = 0x62;

    /** Constant for the number pad "3" key. */
    public static final int NP_3 = 0x63;

    /** Constant for the number pad "4" key. */
    public static final int NP_4 = 0x64;

    /** Constant for the number pad "5" key. */
    public static final int NP_5 = 0x65;

    /** Constant for the number pad "6" key. */
    public static final int NP_6 = 0x66;

    /** Constant for the number pad "7" key. */
    public static final int NP_7 = 0x67;

    /** Constant for the number pad "8" key. */
    public static final int NP_8 = 0x68;

    /** Constant for the number pad "9" key. */
    public static final int NP_9 = 0x69;

    /** Constant for the number pad multiply key. */
    public static final int MULTIPLY = 0x6A;

    /** Constant for the number pad add key. */
    public static final int ADD = 0x6B;

    /** Constant for the number pad separator key. */
    public static final int SEPARATOR = 0x6C;

    /** Constant for the number pad subtract key. */
    public static final int SUBTRACT = 0x6D;

    /** Constant for the number pad decimal point key. */
    public static final int DECIMAL = 0x6E;

    /** Constant for the number pad divide key. */
    public static final int DIVIDE = 0x6F;

    /** Constant for the delete key. */
    public static final int DELETE = 0x7F; /* ASCII DEL */

    /** Constant for the NUM_LOCK key. */
    public static final int NUM_LOCK = 0x90;

    /** Constant for the SCROLL_LOCK key. */
    public static final int SCROLL_LOCK = 0x91;

    /** Constant for the F1 function key. */
    public static final int F1 = 0x70;

    /** Constant for the F2 function key. */
    public static final int F2 = 0x71;

    /** Constant for the F3 function key. */
    public static final int F3 = 0x72;

    /** Constant for the F4 function key. */
    public static final int F4 = 0x73;

    /** Constant for the F5 function key. */
    public static final int F5 = 0x74;

    /** Constant for the F6 function key. */
    public static final int F6 = 0x75;

    /** Constant for the F7 function key. */
    public static final int F7 = 0x76;

    /** Constant for the F8 function key. */
    public static final int F8 = 0x77;

    /** Constant for the F9 function key. */
    public static final int F9 = 0x78;

    /** Constant for the F10 function key. */
    public static final int F10 = 0x79;

    /** Constant for the F11 function key. */
    public static final int F11 = 0x7A;

    /** Constant for the F12 function key. */
    public static final int F12 = 0x7B;

    /**  Constant for the PRINTSCREEN key. */
    public static final int PRINTSCREEN = 0x9A;

    /**  Constant for the INSERT key. */
    public static final int INSERT = 0x9B;

    /**  Constant for the HELP key. */
    public static final int HELP = 0x9C;

    /**  Constant for the META key. */
    public static final int META = 0x9D;

    /**  Constant for the BACK_QUOTE  key. */
    public static final int BACK_QUOTE = 0xC0;

    /**  Constant for the QUOTE key. */
    public static final int QUOTE = 0xDE;

    /** Constant for the numeric keypad <b>up</b> arrow key. */
    public static final int KP_UP = 0xE0;

    /** Constant for the numeric keypad <b>down</b> arrow key. */
    public static final int KP_DOWN = 0xE1;

    /** Constant for the numeric keypad <b>left</b> arrow key. */
    public static final int KP_LEFT = 0xE2;

    /** Constant for the numeric keypad <b>right</b> arrow key. */
    public static final int KP_RIGHT = 0xE3;

    /**
     * This value is used to indicate that the keyCode is unknown.
     * KEY_TYPED events do not have a keyCode value; this value
     * is used instead.
     */
    public static final int UNDEFINED = 0x0;
    
}
