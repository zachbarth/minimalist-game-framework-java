package engine;

import game.Game;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;

import javax.sound.sampled.AudioFormat;
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
		bufferGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		bufferGraphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		windowImage = new BufferedImage(bufferWidth, bufferHeight, BufferedImage.TYPE_INT_ARGB);
		windowGraphics = windowImage.createGraphics();

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

	private static String getAssetPath(String path) {
        return Paths.get("assets", path).toAbsolutePath().toString();
    }

	/**
	 * Loads a texture from the "assets" directory. Supports the following formats: ??????
	 * @param path The path to the texture file, relative to the "assets" directory.
	 * @return A texture object.
	 */
    public static Texture loadTexture(String path) {
		ImageIcon icon = new ImageIcon(getAssetPath(path));
		if (icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
			throw new Error("Failed to load texture.");
		}

		return new Texture(icon.getImage());
    }

	/**
	 * Loads a resizable texture from the Assets directory. Supports the following formats: ??????
	 * See the documentation for an explanation of what these parameters _actually_ mean.
	 * @param path The path to the texture file, relative to the "assets" directory.
	 * @param leftOffset The resize offset from the left of the texture (in pixels).
	 * @param rightOffset The resize offset from the right of the texture (in pixels).
	 * @param topOffset The resize offset from the top of the texture (in pixels).
	 * @param bottomOffset The resize offset from the bottom of the texture (in pixels).
	 * @return A resizable texture object.
	 */
    public static ResizableTexture loadResizableTexture(String path, int leftOffset, int rightOffset, int topOffset, int bottomOffset) {
		ImageIcon icon = new ImageIcon(getAssetPath(path));
		if (icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
			throw new Error("Failed to load texture.");
		}

		// Convert the relative offsets (from the edges) into absolute offsets (from the origin):
		Image image = icon.getImage();
		int width = image.getWidth(null);
		int height = image.getHeight(null);
        rightOffset = width - rightOffset - 1;
        bottomOffset = height - bottomOffset - 1;

        if (leftOffset < 0 || rightOffset >= width || topOffset < 0 || bottomOffset >= height || leftOffset > rightOffset || topOffset > bottomOffset) {
            throw new Error("Invalid offset parameter.");
        }

        return new ResizableTexture(image, leftOffset, rightOffset, topOffset, bottomOffset);
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
		drawTexture(texture, position, null, 0, null, MirrorMode.NONE, null, InterpolationMode.LINEAR);
	}

	/**
	 * Draws a texture.
	 * @param texture The texture to draw.
	 * @param position The position where the texture will be drawn.
	 * @param size The destination size of the texture. If null, the original texture size will be used.
	 * @param rotation The amount the texture will be rotated clockwise (in degrees). If zero, the texture will not be rotated.
	 * @param pivot The offset from position to the pivot that the texture will be rotated about. If null, the center of the destination bounds will be used.
	 * @param mirror The mirroring to apply to the texture. If you are unsure what to put here, use TextureMirror.NONE as a default value.
	 * @param source The source bounds of the texture to draw. If null, the entire texture will be drawn.
	 * @param interpolationMode The interpolation mode to use when drawing the texture. If you are unsure what to put here, use TextureScaleMode.LINEAR as a default value.
	 */
	public static void drawTexture(Texture texture, Vector2 position, Vector2 size, float rotation, Vector2 pivot, MirrorMode mirror, Bounds2 source, InterpolationMode interpolationMode) {
		int dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2;
		if (source != null) {
            // Use the specified source coordinates:
            sx1 = (int)source.position.x;
            sy1 = (int)source.position.y;
            sx2 = sx1 + (int)source.size.x;
            sy2 = sy1 + (int)source.size.y;
            dx1 = (int)position.x;
            dy1 = (int)position.y;
            dx2 = dx1 + sx2 - sx1;
            dy2 = dy1 + sy2 - sy1;
        } else {
            // Use the full texture as the source:
            sx1 = 0;
            sy1 = 0;
            sx2 = sx1 + texture.width;
            sy2 = sy1 + texture.height;
            dx1 = (int)position.x;
            dy1 = (int)position.y;
            dx2 = dx1 + texture.width;
            dy2 = dy1 + texture.height;
        }

		// Apply the size override, if specified:
        if (size != null) {
            dx2 = dx1 + (int)size.x;
            dy2 = dy1 + (int)size.y;
        }

		// Set the pivot to the center of the image, if unspecified:
		Vector2 center = new Vector2((dx2 - dx1) / 2, (dy2 - dy1) / 2);
        if (pivot == null) {
			pivot = center;
        }
		
		// Set the interpolation mode:
		bufferGraphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
			(interpolationMode == InterpolationMode.LINEAR) ? RenderingHints.VALUE_INTERPOLATION_BILINEAR : RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);

		// Start building the transform relative to the draw position:
		AffineTransform transform = new AffineTransform();
		transform.translate(dx1, dy1);

		// Rotate around the pivot:
		transform.translate(pivot.x, pivot.y);
		transform.rotate(Math.toRadians(rotation));
		transform.translate(-pivot.x, -pivot.y);

		// Mirror around the center, regardless of the pivot:
		if (mirror != MirrorMode.NONE) {
			transform.translate(center.x, center.y);
			if (mirror == MirrorMode.HORIZONTAL || mirror == MirrorMode.BOTH) {
				transform.scale(-1, 1);
			}
			if (mirror == MirrorMode.VERTICAL || mirror == MirrorMode.BOTH) {
				transform.scale(1, -1);
			}
			transform.translate(-center.x, -center.y);
		}

		// Finish building the transform:
		transform.translate(-dx1, -dy1);

		// Draw the image:
		AffineTransform oldTransform = bufferGraphics.getTransform();
		bufferGraphics.setTransform(transform);
		bufferGraphics.drawImage(texture.image, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, null);
		bufferGraphics.setTransform(oldTransform);
	}

	/**
	 * Draws a resizable texture.
	 * See the documentation for an explanation of how resizable textures work.
	 * @param texture The resizable texture to draw.
	 * @param bounds The bounds that the texture should be resized to.
	 */
    public static void drawResizableTexture(ResizableTexture texture, Bounds2 bounds) {
        int bxmin = texture.leftOffset;
        int bxmax = texture.rightOffset;
        int bymin = texture.topOffset;
        int bymax = texture.bottomOffset;
        int txmax = texture.width;
        int tymax = texture.height;
        int px = (int)bounds.position.x;
        int py = (int)bounds.position.y;
        
        // Don't let the overall size be so small that segment 9 has a negative size in either dimension:
        int sx = Math.max((int)bounds.size.x, txmax - bxmax + bxmin);
        int sy = Math.max((int)bounds.size.y, tymax - bymax + bymin);

        // Draw each of the nine segments:
		bufferGraphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        drawResizableTextureSegment(texture, 0, 0, bxmin, bymin, px, py, bxmin, bymin);
        drawResizableTextureSegment(texture, bxmax, 0, txmax - bxmax, bymin, px + sx - (txmax - bxmax), py, txmax - bxmax, bymin);
        drawResizableTextureSegment(texture, 0, bymax, bxmin, tymax - bymax, px, py + sy - (tymax - bymax), bxmin, tymax - bymax);
        drawResizableTextureSegment(texture, bxmax, bymax, txmax - bxmax, tymax - bymax, px + sx - (txmax - bxmax), py + sy - (tymax - bymax), txmax - bxmax, tymax - bymax);
        drawResizableTextureSegment(texture, bxmin, 0, bxmax - bxmin, bymin, px + bxmin, py, sx - bxmin - (txmax - bxmax), bymin);
        drawResizableTextureSegment(texture, 0, bymin, bxmin, bymax - bymin, px, py + bymin, bxmin, sy - bymin - (tymax - bymax));
        drawResizableTextureSegment(texture, bxmax, bymin, txmax - bxmax, bymax - bymin, px + sx - (txmax - bxmax), py + bymin, txmax - bxmax, sy - bymin - (tymax - bymax));
        drawResizableTextureSegment(texture, bxmin, bymax, bxmax - bxmin, tymax - bymax, px + bxmin, py + sy - (tymax - bymax), sx - bxmin - (txmax - bxmax), tymax - bymax);
        drawResizableTextureSegment(texture, bxmin, bymin, bxmax - bxmin, bymax - bymin, px + bxmin, py + bymin, sx - bxmin - (txmax - bxmax), sy - bymin - (tymax - bymax));
    }

	private static void drawResizableTextureSegment(ResizableTexture texture, int subtextureX, int subtextureY, int subtextureW, int subtextureH, int destX, int destY, int destW, int destH) {
        if (subtextureW > 0 && subtextureH > 0) {
			bufferGraphics.drawImage(texture.image, destX, destY, destX + destW, destY + destH, subtextureX, subtextureY, subtextureX + subtextureW, subtextureY + subtextureH, null);
        }
    }

}
