package engine;

import game.Game;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.nio.file.Paths;

public final class Engine {

	// Don't let the Engine class be instantiated:
	private Engine() { }

	// Game loop variables:
	private static JFrame windowFrame;
	private static JLabel windowLabel;
	private static BufferedImage bufferImage, windowImage;
	private static Graphics2D bufferGraphics, windowGraphics;
	private static int bufferWidth, bufferHeight;
	private static int windowFrameWidth, windowFrameHeight;
	private static int windowFrameInitialWidth, windowFrameInitialHeight;
	private static float timeDelta;
	private static Game game;

	// ======================================================================================
    // Game loop
    // ======================================================================================

	public static void main(String[] args) {
		start();
		run();
	}

	private static void start() {
		// Create our render targets:
		bufferWidth = (int) Game.RESOLUTION.x;
		bufferHeight = (int) Game.RESOLUTION.y;
		bufferImage = new BufferedImage(bufferWidth, bufferHeight, BufferedImage.TYPE_INT_ARGB);
		bufferGraphics = bufferImage.createGraphics();
		windowImage = new BufferedImage(bufferWidth, bufferHeight, BufferedImage.TYPE_INT_ARGB);
		windowGraphics = windowImage.createGraphics();

		// Configure render settings:
		RenderingHints hints = new RenderingHints(null);
		hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		bufferGraphics.addRenderingHints(hints);

		// Create a window using Swing:
		windowFrame = new JFrame();
		windowLabel = new JLabel(new ImageIcon(windowImage));
		windowFrame.setContentPane(windowLabel);
		windowFrame.setFocusTraversalKeysEnabled(false);
		windowFrame.setResizable(true);
		windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowFrame.setTitle(Game.TITLE);
		windowFrame.pack();
		windowFrame.requestFocusInWindow();
		windowFrame.setVisible(true);
		windowFrameWidth = windowFrame.getWidth();
		windowFrameHeight = windowFrame.getHeight();
		windowFrameInitialWidth = windowFrameWidth;
		windowFrameInitialHeight = windowFrameHeight;

		// Instantiate the game object:
		game = new Game();
	}

	private static void run() {
		long lastFrameStart = System.nanoTime();
		while (true) {
			// Measure the time elapsed between one frame and the next:
			long frameStart = System.nanoTime();
			timeDelta = (frameStart - lastFrameStart) / 1000000000f;
			lastFrameStart = frameStart;

			// // Process pre-update engine logic:
			// pollEvents();

			// Clear and start drawing into the render target:
			bufferGraphics.setColor(Color.BLACK);
			bufferGraphics.fillRect(0, 0, bufferWidth, bufferHeight);

			// Update game logic:
			game.update();

			// Resize the window image when the window frame is resized:
			if (windowFrame.getWidth() != windowFrameWidth || windowFrame.getHeight() != windowFrameHeight) {
				int resizedWidth = bufferWidth + windowFrame.getWidth() - windowFrameInitialWidth;
				int resizedHeight = bufferHeight + windowFrame.getHeight() - windowFrameInitialHeight;
				windowImage = new BufferedImage(resizedWidth, resizedHeight, BufferedImage.TYPE_INT_ARGB);
				windowGraphics = windowImage.createGraphics();
				windowLabel.setIcon(new ImageIcon(windowImage));
				windowFrameWidth = windowFrame.getWidth();
				windowFrameHeight = windowFrame.getHeight();
			}

			// Figure out how to scale our render target to fill the window:
			int windowImageWidth = windowImage.getWidth();
			int windowImageHeight = windowImage.getHeight();
			float renderTargetScale = ((float)windowImageWidth / windowImageHeight > (float)bufferWidth / bufferHeight)
				? (float)windowImageHeight / bufferHeight
				: (float)windowImageWidth / bufferWidth;

			// Copy the render target to the screen:
			windowGraphics.setColor(Color.BLACK);
			windowGraphics.fillRect(0, 0, windowImageWidth, windowImageHeight);
			Vector2 renderTargetSize = new Vector2(bufferWidth, bufferHeight).mul(renderTargetScale);
			Vector2 renderTargetPos = new Vector2(windowImageWidth, windowImageHeight).sub(renderTargetSize).mul(0.5f);
			windowGraphics.drawImage(bufferImage, (int)renderTargetPos.x, (int)renderTargetPos.y, (int)renderTargetSize.x, (int)renderTargetSize.y, null);
			windowFrame.repaint();

			// Wait until the next frame:
			try {
				long frameLength = (System.nanoTime() - frameStart) / 1000000;
				Thread.sleep(Math.max(0, 17 - frameLength));
			}
			catch (InterruptedException e) {
			}
		}
	}

	public static float timeDelta() {
		return timeDelta;
	}

	// ======================================================================================
    // Content loading
    // ======================================================================================

	private static String getAssetPath(String path)
    {
        return Paths.get("assets", path).toAbsolutePath().toString();
    }

	/**
	 * Loads a texture from the "assets" directory. Supports the following formats: ??????
	 * @param path The path to the texture file, relative to the "assets" directory.
	 * @return A texture object.
	 */
    public static Texture loadTexture(String path)
    {
		ImageIcon icon = new ImageIcon(getAssetPath(path));
		if (icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
			throw new Error("Failed to load texture.");
		}

		return new Texture(icon.getImage());
    }

	// ======================================================================================
    // Primitive drawing
    // ======================================================================================

	/**
	 * Draws a line.
	 * @param start The start of the line.
	 * @param end The end of the line.
	 * @param color The color of the line.
	 */
    public static void drawLine(Vector2 start, Vector2 end, Color color) {
		bufferGraphics.setColor(color);
		bufferGraphics.drawLine((int)start.x, (int)start.y, (int)end.x, (int)end.y);
    }

	/**
	 * Draws a rectangle.
	 * @param bounds The bounds of the rectangle.
	 * @param color The color of the rectangle.
	 * @param filled Whether or not the rectangle should be filled.
	 */
    public static void drawRect(Bounds2 bounds, Color color, boolean filled) {
		bufferGraphics.setColor(color);
		if (filled) {
			bufferGraphics.fillRect((int)bounds.position.x, (int)bounds.position.y, (int)bounds.size.x, (int)bounds.size.y);
		} else {
			bufferGraphics.drawRect((int)bounds.position.x, (int)bounds.position.y, (int)bounds.size.x, (int)bounds.size.y);
		}
    }

	/**
	 * Draws a circle.
	 * @param center The center of the circle.
	 * @param radius The radius of the circle.
	 * @param color The color of the circle.
	 * @param filled Whether or not the circle should be filled.
	 */
    public static void drawCircle(Vector2 center, float radius, Color color, boolean filled) {
		bufferGraphics.setColor(color);
		if (filled) {
			bufferGraphics.fillOval((int)(center.x - radius), (int)(center.y - radius), (int)(radius * 2), (int)(radius * 2));
		} else {
			bufferGraphics.drawOval((int)(center.x - radius), (int)(center.y - radius), (int)(radius * 2), (int)(radius * 2));
		}
    }

	// ======================================================================================
    // Texture drawing
    // ======================================================================================

	/**
	 * Draws a texture.
	 * @param texture The texture to draw.
	 * @param position The position where the texture will be drawn.
	 */
	public static void drawTexture(Texture texture, Vector2 position) {
		drawTexture(texture, position, null, null, 0, null, TextureMirror.NONE, null, TextureScaleMode.LINEAR);
	}

	/**
	 * Draws a texture.
	 * @param texture The texture to draw.
	 * @param position The position where the texture will be drawn.
	 * @param color The color to multiply with the colors of the texture. If null, the colors of the texture will be unchanged.
	 * @param size The destination size of the texture. If null, the original texture size will be used.
	 * @param rotation The amount the texture will be rotated clockwise (in degrees). If zero, the texture will not be rotated.
	 * @param pivot The offset from position to the pivot that the texture will be rotated about. If null, the center of the destination bounds will be used.
	 * @param mirror The mirroring to apply to the texture. If you are unsure what to put here, use TextureMirror.NONE as a default value.
	 * @param source The source bounds of the texture to draw. If null, the entire texture will be drawn.
	 * @param scaleMode The scale mode to use when drawing the texture. If you are unsure what to put here, use TextureScaleMode.LINEAR as a default value.
	 */
	public static void drawTexture(Texture texture, Vector2 position, Color color, Vector2 size, float rotation, Vector2 pivot, TextureMirror mirror, Bounds2 source, TextureScaleMode scaleMode) {
		bufferGraphics.drawImage(texture.image, (int)position.x, (int)position.y, null);
	}

}
