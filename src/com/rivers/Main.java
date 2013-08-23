package com.rivers;

import java.awt.image.BufferedImage;

public class Main {
	public static void main(String[] args) {
		WaterPath wp1 = new WaterPath(new WaterPoint(400, 0, 270 - 45), 4, 0,
				1000);
		WaterPath wp2 = new WaterPath(new WaterPoint(0, 0, 270 + 45), 4, 0, 500);
		WaterPath wp3 = new WaterPath(new WaterPoint(200, 400, 90), 4, 0, 10000);
		BufferedImage bufferedImage = new BufferedImage(500, 500,
				BufferedImage.TYPE_4BYTE_ABGR);

		wp1.drawPoints(bufferedImage.createGraphics());
		wp2.drawPoints(bufferedImage.createGraphics());
		wp3.drawPoints(bufferedImage.createGraphics());
		new Window().setIcon(bufferedImage);
	}
}
