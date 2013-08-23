package com.rivers;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WaterPath {

	private int maxSpawns;
	private int numberOfSpawns;
	private List<WaterPoint> points;
	private Random random;
	private List<WaterPath> spawns;
	private int chanceToSpawn = 5;
	private int iterations;
	private List<AffectorPoint> affectorPoints;
	private final int width;
	private final int height;

	public WaterPath(WaterPoint startPoint, int maxSpawns, int numberOfSpawns, int iterations, int width, int height) {
		this.width = width;
		this.height = height;
		this.affectorPoints = AffectorPoint.createAffectors(width, height, AffectorPoint.AFFECTOR_DENSITY);
		this.maxSpawns = maxSpawns;
		this.numberOfSpawns = numberOfSpawns;
		this.iterations = iterations;
		points = new ArrayList<WaterPoint>();
		points.add(startPoint);
		random = new Random();
		spawns = new ArrayList<WaterPath>();
		iterate();

	}

	private void iterate() {
		for (int i = 0; i < iterations; i++) {
			step();
		}
	}

	public void step() {
		if (random.nextInt(100) > 100 - chanceToSpawn) {
			if (numberOfSpawns <= maxSpawns) {
				chanceToSpawn *= 2;
				chanceToSpawn = chanceToSpawn > 100 ? 100 : chanceToSpawn;
				this.numberOfSpawns++;
				System.err.println("spawn " + numberOfSpawns);
				spawns.add(new WaterPath(new WaterPoint(currentPoint()), maxSpawns - 1, numberOfSpawns, (int) (iterations / 2f), width, height));
			}
		}
		points.add(currentPoint().nextPoint(affectorPoints));
	}

	private WaterPoint currentPoint() {
		return points.get(points.size() - 1);
	}

	public List<WaterPoint> getPoints() {
		return points;
	}

	public void drawPoints(Graphics2D g) {
		for (AffectorPoint ap : affectorPoints) {
			ap.draw(g);
		}
		for (WaterPoint p : points) {
			p.draw(g);
		}
		for (WaterPath spawn : spawns) {
			spawn.drawPoints(g);
		}
	}
}
