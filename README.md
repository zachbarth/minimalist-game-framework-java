# Minimalist Game Framework for Java #

This is a minimalist game framework in the style of the "game engine" we use at [Zachtronics](http://www.zachtronics.com). It is a thin layer over Swing that encourages you to modify and extend the framework to suit your needs and preferences. There is also a [C# version](https://github.com/zachbarth/minimalist-game-framework) of this framework.

# Getting Started #

1. Clone the repo.
2. Add your assets (images, fonts, sounds, and music) to the "assets" folder.
3. Start writing your game in the `Game` class.

All functions and properties listed below are members of the static `Engine` class. For example, if you wanted to draw a line, you could call `Engine.drawLine()` from anywhere in your code. Documentation for function arguments and enum values can be found in the code itself.

# Example #

![Simple Game Example](docs/example-game.gif)

```Java
package game;

import engine.*;

public class Game {

    public static final String WINDOW_TITLE = "Minimalist Game Framework";
    public static final int WINDOW_SCALE = 3;
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
```

Art Source: _[https://o-lobster.itch.io/simple-dungeon-crawler-16x16-pixel-pack](https://o-lobster.itch.io/simple-dungeon-crawler-16x16-pixel-pack)_

# Core #

float **`getTimeDelta`**()

* Returns the amount of time (in seconds) since the last frame.

# Content #

Texture **`loadTexture`**(String path)

* Loads a texture from the "assets" directory. 
* Supports the following formats: PNG, GIF, JPEG.

ResizableTexture **`loadResizableTexture`**(String path, int leftOffset, int rightOffset, int topOffset, int bottomOffset)

* Loads a resizable texture from the "assets" directory. 
* Supports the following formats: PNG, GIF, JPEG.
* See below for an explanation of how resizable textures work.

Font **`loadFont`**(String path, int pointSize)

* Loads a font from the "assets" directory for a single text size.
* Supports the following formats: TTF, OTF.

Sound **`loadSound`**(String path)

* Loads a sound file from the "assets" directory. 
* Supports the following formats: WAV.

# Graphics #

void **`drawLine`**(Vector2 start, Vector2 end, Color color)

* Draws a line.

void **`drawRect`**(Bounds2 bounds, Color color, boolean filled)

* Draws a rectangle.

void **`drawCircle`**(Vector2 center, float radius, Color color, boolean filled)

* Draws a circle.

void **`drawTexture`**(Texture texture, Vector2 position)
void **`drawTexture`**(Texture texture, Vector2 position, Vector2 size, float rotation, Vector2 pivot, MirrorMode mirror, Bounds2 source, InterpolationMode interpolationMode)

* Draws a texture.
* Look at the code for more information about the function arguments. Most of them are optional.

void **`drawResizableTexture`**(ResizableTexture texture, Bounds2 bounds)

* Draws a resizable texture.
* See below for an explanation of how resizable textures work.

Bounds2 **`drawString`**(String text, Vector2 position, Color color, Font font)
Bounds2 **`drawString`**(String text, Vector2 position, Color color, Font font, TextAlignment alignment, float rotation, boolean measureOnly)

* Draws a text string.
* Returns the bounds of the drawn text. The bounds of rotated text will not be correct.

# Keyboard Input #

boolean **`getKeyDown`**(Key key)

* Returns true if a key was pressed down this frame.

boolean **`getKeyHeld`**(Key key)

* Returns true if a key was held during this frame.

boolean **`getKeyUp`**(Key key)

* Returns true if a key was released this frame.

string **`getTypedText`**()

* Returns the textual representation of the keys that were pressed this frame.

# Mouse Input #

Vector2 **`getMousePosition`**()

* Returns the current position of the mouse cursor (in pixels).

float **`getMouseScroll`**()

* Returns the amount the mouse wheel has been scrolled this frame (in scroll units).

boolean **`getMouseButtonDown`**(MouseButton button)

* Returns true if a mouse button was pressed down this frame.

boolean **`getMouseButtonHeld`**(MouseButton button)

* Returns true if a mouse button was held during this frame.

boolean **`getMouseButtonUp`**(MouseButton button)

* Returns true if a mouse button was released this frame.

# Audio #

SoundInstance **`playSound`**(Sound sound, boolean repeat)

* Plays a sound.
* Returns an instance handle that can be passed to stopSound() to stop playback of the sound.

void **`stopSound`**(SoundInstance instance)

* Stops a playing sound.

# Utility Classes #

class **`Vector2`**

* A simple 2D vector class that supports basic vector math operations that is used in many API functions.

class **`Bounds2`**

* A simple axis-aligned 2D bounding rectangle that is used in a few API functions.

class **`Color`**

* A data structure representing a 32-bit RGBA color that is used in many API functions. 
* The class also contains static members for all of the built-in .NET colors, e.g. `Color.CORNFLOWER_BLUE` and others.

# Appendix 1: Screen Resolution #

To keep things simple, the resolution of the game is fixed and specified at the top of the `Game` class. 

If you hit Alt+Enter while the game is running it will toggle between windowed and fullscreen.
* When running windowed the window will be the same size as the specified resolution. 
* When running fullscreen the game will scale up to fit your screen and automatically letterbox if the aspect ratios do not match (so that the contents are not distorted).

# Appendix 2: Resizable Textures #

Most of the asset types supported should be fairly obvious, but the framework also supports something ambiguously called a "resizable texture". Sometimes also called "nine-patches" or "border textures", these are textures that are divided into nine areas (specified at load time as numerical offsets from the edges) so that they can be drawn at different sizes without distorting the edges. The following example creates a resizable texture of a button and then draws it four times with different sizes:

```Java
ResizableTexture button = Engine.loadResizableTexture("button.png", 20, 20, 20, 40);
Engine.drawResizableTexture(button, new Bounds2(10, 40, 50, 80));
Engine.drawResizableTexture(button, new Bounds2(70, 20, 100, 60));
Engine.drawResizableTexture(button, new Bounds2(180, 10, 70, 100));
Engine.drawResizableTexture(button, new Bounds2(260, 30, 120, 90));
```

![Resizable Textures Example](docs/resizable-textures.png)
