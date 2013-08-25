package com.rivers;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Main {

	private static final Color DARK_GREEN = new Color(49, 92, 45);
	private static final Color BROWN = new Color(227, 175, 86);
	private static final int NUM_ITERATIONS_WATER = 1500000;
	private static final int NUM_ITERATIONS_TREES = 1500;
	public static final int SIZE = 1000;
	public static final long SEED = 106801211;

	public static void main(String[] args) {

		BufferedImage bufferedImage = new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g = bufferedImage.createGraphics();
		g.setColor(BROWN);
		g.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());

		Random random = new Random(SEED);
		for (int i = 0; i < 1000; i++) {
			new SpreadWalker(SIZE, SIZE, NUM_ITERATIONS_TREES, random.nextLong(), DARK_GREEN).draw(g);
		}
		for (int i = 0; i < 2; i++) {
			new SpreadWalker(SIZE, SIZE, NUM_ITERATIONS_WATER, random.nextLong(), Color.BLUE).draw(g);
		}
		new Window().setIcon(bufferedImage);
	}

	private static void path() {
		int iterations = 100000;
		WaterPoint startPoint1 = new WaterPoint(400, 0, 270 - 45);
		WaterPoint startPoint2 = new WaterPoint(0, 0, 270 + 45);
		WaterPoint startPoint3 = new WaterPoint(200, 400, 90);
		int maxSpawns = 1;
		WaterPath wp1 = new WaterPath(startPoint1, maxSpawns, 0, iterations, 500, 500);
		WaterPath wp2 = new WaterPath(startPoint2, maxSpawns, 0, iterations, 500, 500);
		WaterPath wp3 = new WaterPath(startPoint3, maxSpawns, 0, iterations, 500, 500);
		BufferedImage bufferedImage = new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_4BYTE_ABGR);

		wp1.drawPoints(bufferedImage.createGraphics());
		wp2.drawPoints(bufferedImage.createGraphics());
		wp3.drawPoints(bufferedImage.createGraphics());
		new Window().setIcon(bufferedImage);
	}
}
