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

	public static List<AffectorPoint> createAffectors(int width, int height, double density) {
		Random random = new Random();
		List<AffectorPoint> created = new ArrayList<AffectorPoint>();
		int count = random.nextInt((int) ((width * height) * density));
		for (int i = 0; i < count; i++) {
			created.add(new AffectorPoint(random.nextDouble() * width, random.nextDouble() * height, random.nextDouble()));
		}

		return created;
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.ORANGE);
		int size = (int) (100 * affection);
		g.drawOval((int) x, (int) y, size, size);
		g.fillOval((int) x, (int) y, size, size);
	}
}
