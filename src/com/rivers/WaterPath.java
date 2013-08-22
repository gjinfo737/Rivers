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

	private void step() {
		WaterPoint next = points.get(points.size() - 1).getNextPoint();

	}
}
