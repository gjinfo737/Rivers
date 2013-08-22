package com.rivers;

import java.util.ArrayList;
import java.util.List;

public class WaterPath {

	private final WaterPoint startPoint;
	private List<WaterPoint> points;

	public WaterPath(WaterPoint startPoint) {
		this.startPoint = startPoint;
		points = new ArrayList<WaterPoint>();
		points.add(startPoint);

	}

	void step() {
		points.add(currentPoint().nextPoint());
	}

	private WaterPoint currentPoint() {
		return points.get(points.size() - 1);
	}

	public List<WaterPoint> getPoints() {
		return points;
	}
}
