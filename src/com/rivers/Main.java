package com.rivers;

import java.awt.image.BufferedImage;

public class Main {
	public static void main(String[] args) {
		WaterPoint startPoint = new WaterPoint(0, 0, 270 + 45);
		WaterPath wp = new WaterPath(startPoint);
		for (int i = 0; i < 1000; i++) {
			wp.step();
		}

		BufferedImage bufferedImage = new BufferedImage(500, 500,
				BufferedImage.TYPE_4BYTE_ABGR);
		for (WaterPoint p : wp.getPoints()) {
			p.draw(bufferedImage.createGraphics());
		}
		// try {
		// // retrieve image
		// File outputfile = new File("E:\\saved24343.png");
		// ImageIO.write(bufferedImage, "png", outputfile);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		new Window().setIcon(bufferedImage);
	}
}
