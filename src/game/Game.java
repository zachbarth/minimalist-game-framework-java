package game;

import engine.*;

public class Game {

	public static final String TITLE = "Minimalist Game Framework";
	public static final Vector2 RESOLUTION = new Vector2(128, 128);

	// Define some constants controlling animation speed:
    static final float FRAMERATE = 10;
    static final float WALKSPEED = 50;

    // Load some textures when the game starts:
    Texture texKnight = Engine.loadTexture("knight.png");
    Texture texBackground = Engine.loadTexture("background.png");

    // Keep track of the knight's state:
    Vector2 knightPosition = RESOLUTION.div(2);
    boolean knightFaceLeft = false;
    float knightFrameIndex = 0;

    public Game() {
    }

    public void update() {
        // Draw the background:
        Engine.drawTexture(texBackground, Vector2.zero);
        
        // Use the keyboard to control the knight:
		Vector2 moveOffset = Vector2.zero;
		if (Engine.getKeyHeld(Key.LEFT)) {
	        moveOffset = moveOffset.add(new Vector2(-1, 0));
	        knightFaceLeft = true;
	    }
		if (Engine.getKeyHeld(Key.RIGHT)) {
		    moveOffset = moveOffset.add(new Vector2(1, 0));
		    knightFaceLeft = false;
		}
		if (Engine.getKeyHeld(Key.UP)) {
		    moveOffset = moveOffset.add(new Vector2(0, -1));
		}
		if (Engine.getKeyHeld(Key.DOWN)) {
		    moveOffset = moveOffset.add(new Vector2(0, 1));
		}
		knightPosition = knightPosition.add(moveOffset.mul(WALKSPEED * Engine.getTimeDelta()));
        
        // Advance through the knight's 6-frame animation and select the current frame:
        knightFrameIndex = (knightFrameIndex + FRAMERATE * Engine.getTimeDelta()) % 6.0f;
        boolean knightIdle = moveOffset.length() == 0;
        Bounds2 knightFrameBounds = new Bounds2(((int)knightFrameIndex) * 16, knightIdle ? 0 : 16, 16, 16);

        // Draw the knight:
        Vector2 knightDrawPos = knightPosition.add(new Vector2(-8, -8));
        MirrorMode knightMirror = knightFaceLeft ? MirrorMode.HORIZONTAL : MirrorMode.NONE;
		Engine.drawTexture(texKnight, knightDrawPos, null, 0, null, knightMirror, knightFrameBounds, InterpolationMode.LINEAR);
    }

}
