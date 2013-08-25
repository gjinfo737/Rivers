package com.rivers;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpreadWalker {
	private static final Color[] COLORS = new Color[] { Color.BLUE };
	private static final int SPAWN_MAX_DIRECTION_CHANGE = 10;
	private double stepSize = .01;
	private double x;
	private double y;
	private Color color;
	private Random random;
	private List<Double[]> drops;

	public SpreadWalker(double width, double height, int numberOfIterations, long seed, Color color) {
		random = new Random(seed);
		this.color = color;
		x = random.nextDouble() * width;
		y = random.nextDouble() * height;
		drops = new ArrayList<Double[]>();
		iterate(numberOfIterations);
	}

	public void draw(Graphics2D g) {
		g.setColor(color);
		for (Double[] d : drops) {
			g.fillOval(d[0].intValue(), d[1].intValue(), 2, 2);
		}
	}

	private void iterate(int number) {
		for (int i = 0; i < number; i++) {
			drops.add(new Double[] { x, y });
			step();
		}
	}

	private void step() {
		double dx = random.nextDouble();
		double dy = random.nextDouble();
		dx = random.nextBoolean() ? dx : -dx;
		dy = random.nextBoolean() ? dy : -dy;
		x += dx;
		y += dy;
	}

}
