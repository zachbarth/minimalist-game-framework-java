package engine;

import game.Game;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public final class Engine {

	// Don't let the Engine class be instantiated.
	private Engine() { }

	private static JFrame windowFrame;
	private static JLabel windowLabel;
	private static BufferedImage bufferImage, windowImage;
	private static Graphics2D bufferGraphics, windowGraphics;
	private static int bufferWidth, bufferHeight;
	private static int windowFrameWidth, windowFrameHeight;
	private static int windowFrameInitialWidth, windowFrameInitialHeight;
	private static float timeDelta;
	private static Game game;

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

}
