package engine;

public enum MouseButton {

    /** Constant for the left mouse button. */
    LEFT(1),
    
    /** Constant for the middle mouse button. */
    MIDDLE(2),

    /** Constant for the right mouse button. */
    RIGHT(3),

    /** Constant for the back mouse button. */
    BACK(4);

    private final int value;

    MouseButton(int value) {
        this.value = value;
    }

    public int getValue() { 
        return value; 
    }

}
