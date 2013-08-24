package com.rivers;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AffectorPoint {
	public static final double AFFECTOR_DENSITY = .00002;

	private double x;
	private double y;
	private double affection;

	public AffectorPoint(double x, double y, double affection) {
		this.x = x;
		this.y = y;
		this.affection = affection;
	}

	public static List<AffectorPoint> createAffectors(int width, int height,
			double density) {
		Random random = new Random(Main.SEED);
		List<AffectorPoint> created = new ArrayList<AffectorPoint>();
		int count = random.nextInt((int) ((width * height) * density));
		for (int i = 0; i < count; i++) {
			created.add(new AffectorPoint(random.nextDouble() * width, random
					.nextDouble() * height, nextAffection(random)));
		}

		return created;
	}

	private static double nextAffection(Random random) {
		return 5 + random.nextDouble() * 5;
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.ORANGE);
		int size = (int) (1 * affection);
		System.out.println(x + ", " + y + "draw affection: " + size);
		g.drawOval((int) x, (int) y, size, size);
		g.fillOval((int) x, (int) y, size, size);
	}

	public double affectX(double dx) {
		double distance = Math.abs(dx - x);
		if (x < dx)
			dx -= affection / distance;
		else if (x > dx)
			dx += affection / distance;
		return dx;
	}

	public double affectY(double dy) {
		double distance = Math.abs(dy - y);
		if (y < dy)
			dy -= affection / distance;
		else if (y > dy)
			dy += affection / distance;
		return dy;
	}
}
