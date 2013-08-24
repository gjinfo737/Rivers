package com.rivers;

import java.awt.image.BufferedImage;

public class Main {

	public static final long SEED = 1098080;

	public static void main(String[] args) {
		int iterations = 100000;
		WaterPoint startPoint1 = new WaterPoint(400, 0, 270 - 45);
		WaterPoint startPoint2 = new WaterPoint(0, 0, 270 + 45);
		WaterPoint startPoint3 = new WaterPoint(200, 400, 90);
		int maxSpawns = 1;
		WaterPath wp1 = new WaterPath(startPoint1, maxSpawns, 0, iterations,
				500, 500);
		WaterPath wp2 = new WaterPath(startPoint2, maxSpawns, 0, iterations,
				500, 500);
		WaterPath wp3 = new WaterPath(startPoint3, maxSpawns, 0, iterations,
				500, 500);
		BufferedImage bufferedImage = new BufferedImage(500, 500,
				BufferedImage.TYPE_4BYTE_ABGR);

		wp1.drawPoints(bufferedImage.createGraphics());
		wp2.drawPoints(bufferedImage.createGraphics());
		wp3.drawPoints(bufferedImage.createGraphics());
		new Window().setIcon(bufferedImage);
	}
}
