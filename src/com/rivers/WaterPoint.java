package com.rivers;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;
import java.util.Random;

public class WaterPoint {

	private static final Color[] COLORS = new Color[] { Color.WHITE, Color.BLACK, Color.MAGENTA, Color.CYAN, Color.BLUE, Color.DARK_GRAY, Color.RED, Color.GREEN };
	private static final int SPAWN_MAX_DIRECTION_CHANGE = 10;
	private double stepSize = 3;
	private double x;
	private double y;
	private double directionDegrees;
	private Color color;
	private static Random random = new Random();

	public WaterPoint(double x, double y, double directionDegrees) {
		this(x, y, directionDegrees, COLORS[random.nextInt(COLORS.length)]);
	}

	public WaterPoint(double x, double y, double directionDegrees, Color color) {
		this.x = x;
		this.y = y;
		this.directionDegrees = directionDegrees;
		this.color = color;
	}

	public WaterPoint(WaterPoint currentPoint) {
		this(currentPoint.x, currentPoint.y, random.nextBoolean() ? currentPoint.directionDegrees + random.nextInt(SPAWN_MAX_DIRECTION_CHANGE) : currentPoint.directionDegrees
				- random.nextInt(SPAWN_MAX_DIRECTION_CHANGE));
	}

	public WaterPoint nextPoint(List<AffectorPoint> affectorPoints) {
		return new WaterPoint(nextX(affectorPoints), nextY(affectorPoints), nextDirection(), color);
	}

	private double nextX(List<AffectorPoint> affectorPoints) {
		double dx = cosStep() + x;
		for (AffectorPoint affectorPoint : affectorPoints) {
			dx = affectorPoint.affectX(dx);
		}
		return dx;
	}

	private double nextY(List<AffectorPoint> affectorPoints) {
		double dy = sinStep() + y;
		for (AffectorPoint affectorPoint : affectorPoints) {
			dy = affectorPoint.affectY(dy);
		}
		return dy;
	}

	private double nextDirection() {
		return random.nextBoolean() ? directionDegrees + 1 : directionDegrees - 1;
	}

	private double cosStep() {
		int quadrant = getQuadrant();
		double radians = radiansForQuadrantOne(quadrant);
		return stepSize * Math.cos(radians) * signChangeForX(quadrant);
	}

	private double sinStep() {
		int quadrant = getQuadrant();
		double radians = radiansForQuadrantOne(quadrant);
		return stepSize * Math.sin(radians) * signChangeForY(quadrant);
	}

	private int signChangeForX(int quadrant) {
		switch (quadrant) {
		case 2:
		case 3:
			return -1;
		case 1:
		case 4:
		default:
			return 1;
		}
	}

	private int signChangeForY(int quadrant) {
		switch (quadrant) {
		case 3:
		case 4:
			return 1;
		case 1:
		case 2:
		default:
			return -1;
		}
	}

	private double radiansForQuadrantOne(int currentQuadrant) {
		switch (currentQuadrant) {
		case 2:
			return radians(directionDegrees - 90);
		case 3:
			return radians(directionDegrees - 180);
		case 4:
			return radians(directionDegrees - 270);
		case 1:
		default:
			return radians(directionDegrees);
		}
	}

	private double radians(double deg) {
		return Math.PI * (deg / 180);
	}

	private int getQuadrant() {
		if (directionDegrees >= 360) {
			directionDegrees = directionDegrees % 360;
		}
		if (directionDegrees >= 0 && directionDegrees <= 90) {
			return 1;
		} else if (directionDegrees > 90 && directionDegrees <= 180) {
			return 2;
		} else if (directionDegrees > 180 && directionDegrees <= 270) {
			return 3;
		}
		return 4;
	}

	public void draw(Graphics2D g) {
		g.setColor(color);
		g.drawOval((int) x, (int) y, 2, 2);

	}
}
