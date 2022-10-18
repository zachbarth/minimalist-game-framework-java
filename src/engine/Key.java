package engine;

public enum Key {
    
    /** Constant for the ENTER virtual key. */
    ENTER('\n'),

    /** Constant for the BACK_SPACE virtual key. */
    BACK_SPACE('\b'),

    /** Constant for the TAB virtual key. */
    TAB('\t'),

    /** Constant for the CANCEL virtual key. */
    CANCEL(0x03),

    /** Constant for the CLEAR virtual key. */
    CLEAR(0x0C),

    /** Constant for the SHIFT virtual key. */
    SHIFT(0x10),

    /** Constant for the CONTROL virtual key. */
    CONTROL(0x11),

    /** Constant for the ALT virtual key. */
    ALT(0x12),

    /** Constant for the PAUSE virtual key. */
    PAUSE(0x13),

    /** Constant for the CAPS_LOCK virtual key. */
    CAPS_LOCK(0x14),

    /** Constant for the ESCAPE virtual key. */
    ESCAPE(0x1B),

    /** Constant for the SPACE virtual key. */
    SPACE(0x20),

    /** Constant for the PAGE_UP virtual key. */
    PAGE_UP(0x21),

    /** Constant for the PAGE_DOWN virtual key. */
    PAGE_DOWN(0x22),

    /** Constant for the END virtual key. */
    END(0x23),

    /** Constant for the HOME virtual key. */
    HOME(0x24),

    /** Constant for the non-numpad <b>left</b> arrow key. */
    LEFT(0x25),

    /** Constant for the non-numpad <b>up</b> arrow key. */
    UP(0x26),

    /** Constant for the non-numpad <b>right</b> arrow key. */
    RIGHT(0x27),

    /** Constant for the non-numpad <b>down</b> arrow key. */
    DOWN(0x28),

    /** Constant for the comma key, "," */
    COMMA(0x2C),

    /** Constant for the minus key, "-" */
    MINUS(0x2D),

    /** Constant for the period key, "." */
    PERIOD(0x2E),

    /** Constant for the forward slash key, "/" */
    SLASH(0x2F),

    /** 0 thru 9 are the same as ASCII '0' thru '9' (0x30 - 0x39) */

    /** Constant for the "0" key. */
    NR_0(0x30),

    /** Constant for the "1" key. */
    NR_1(0x31),

    /** Constant for the "2" key. */
    NR_2(0x32),

    /** Constant for the "3" key. */
    NR_3(0x33),

    /** Constant for the "4" key. */
    NR_4(0x34),

    /** Constant for the "5" key. */
    NR_5(0x35),

    /** Constant for the "6" key. */
    NR_6(0x36),

    /** Constant for the "7" key. */
    NR_7(0x37),

    /** Constant for the "8" key. */
    NR_8(0x38),

    /** Constant for the "9" key. */
    NR_9(0x39),

    /** Constant for the semicolon key, ";" */
    SEMICOLON(0x3B),

    /** Constant for the equals key, "=" */
    EQUALS(0x3D),

    /** A thru Z are the same as ASCII 'A' thru 'Z' (0x41 - 0x5A) */

    /** Constant for the "A" key. */
    A(0x41),

    /** Constant for the "B" key. */
    B(0x42),

    /** Constant for the "C" key. */
    C(0x43),

    /** Constant for the "D" key. */
    D(0x44),

    /** Constant for the "E" key. */
    E(0x45),

    /** Constant for the "F" key. */
    F(0x46),

    /** Constant for the "G" key. */
    G(0x47),

    /** Constant for the "H" key. */
    H(0x48),

    /** Constant for the "I" key. */
    I(0x49),

    /** Constant for the "J" key. */
    J(0x4A),

    /** Constant for the "K" key. */
    K(0x4B),

    /** Constant for the "L" key. */
    L(0x4C),

    /** Constant for the "M" key. */
    M(0x4D),

    /** Constant for the "N" key. */
    N(0x4E),

    /** Constant for the "O" key. */
    O(0x4F),

    /** Constant for the "P" key. */
    P(0x50),

    /** Constant for the "Q" key. */
    Q(0x51),

    /** Constant for the "R" key. */
    R(0x52),

    /** Constant for the "S" key. */
    S(0x53),

    /** Constant for the "T" key. */
    T(0x54),

    /** Constant for the "U" key. */
    U(0x55),

    /** Constant for the "V" key. */
    V(0x56),

    /** Constant for the "W" key. */
    W(0x57),

    /** Constant for the "X" key. */
    X(0x58),

    /** Constant for the "Y" key. */
    Y(0x59),

    /** Constant for the "Z" key. */
    Z(0x5A),

    /** Constant for the open bracket key, "[" */
    OPEN_BRACKET(0x5B),

    /** Constant for the back slash key, "\" */
    BACK_SLASH(0x5C),

    /** Constant for the close bracket key, "]" */
    CLOSE_BRACKET(0x5D),

    /** Constant for the number pad "0" key. */
    NP_0(0x60),

    /** Constant for the number pad "1" key. */
    NP_1(0x61),

    /** Constant for the number pad "2" key. */
    NP_2(0x62),

    /** Constant for the number pad "3" key. */
    NP_3(0x63),

    /** Constant for the number pad "4" key. */
    NP_4(0x64),

    /** Constant for the number pad "5" key. */
    NP_5(0x65),

    /** Constant for the number pad "6" key. */
    NP_6(0x66),

    /** Constant for the number pad "7" key. */
    NP_7(0x67),

    /** Constant for the number pad "8" key. */
    NP_8(0x68),

    /** Constant for the number pad "9" key. */
    NP_9(0x69),

    /** Constant for the number pad multiply key. */
    MULTIPLY(0x6A),

    /** Constant for the number pad add key. */
    ADD(0x6B),

    /** Constant for the number pad separator key. */
    SEPARATOR(0x6C),

    /** Constant for the number pad subtract key. */
    SUBTRACT(0x6D),

    /** Constant for the number pad decimal point key. */
    DECIMAL(0x6E),

    /** Constant for the number pad divide key. */
    DIVIDE(0x6F),

    /** Constant for the delete key. */
    DELETE(0x7F),

    /** Constant for the NUM_LOCK key. */
    NUM_LOCK(0x90),

    /** Constant for the SCROLL_LOCK key. */
    SCROLL_LOCK(0x91),

    /** Constant for the F1 function key. */
    F1(0x70),

    /** Constant for the F2 function key. */
    F2(0x71),

    /** Constant for the F3 function key. */
    F3(0x72),

    /** Constant for the F4 function key. */
    F4(0x73),

    /** Constant for the F5 function key. */
    F5(0x74),

    /** Constant for the F6 function key. */
    F6(0x75),

    /** Constant for the F7 function key. */
    F7(0x76),

    /** Constant for the F8 function key. */
    F8(0x77),

    /** Constant for the F9 function key. */
    F9(0x78),

    /** Constant for the F10 function key. */
    F10(0x79),

    /** Constant for the F11 function key. */
    F11(0x7A),

    /** Constant for the F12 function key. */
    F12(0x7B),

    /**  Constant for the PRINTSCREEN key. */
    PRINTSCREEN(0x9A),

    /**  Constant for the INSERT key. */
    INSERT(0x9B),

    /**  Constant for the HELP key. */
    HELP(0x9C),

    /**  Constant for the META key. */
    META(0x9D),

    /**  Constant for the BACK_QUOTE  key. */
    BACK_QUOTE(0xC0),

    /**  Constant for the QUOTE key. */
    QUOTE(0xDE),

    /** Constant for the numeric keypad <b>up</b> arrow key. */
    KP_UP(0xE0),

    /** Constant for the numeric keypad <b>down</b> arrow key. */
    KP_DOWN(0xE1),

    /** Constant for the numeric keypad <b>left</b> arrow key. */
    KP_LEFT(0xE2),

    /** Constant for the numeric keypad <b>right</b> arrow key. */
    KP_RIGHT(0xE3),

    /**
     * This value is used to indicate that the keyCode is unknown.
     * KEY_TYPED events do not have a keyCode value; this value
     * is used instead.
     */
    UNDEFINED(0x00);

    private final int value;

    Key(int value) {
        this.value = value;
    }

    public int getValue() { 
        return value; 
    }
    
}
