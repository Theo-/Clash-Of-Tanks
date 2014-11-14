package com.cot;

import java.awt.Point;

public class Vector2D extends Point {
	public double x,y;
	
	public Vector2D(double _x, double _y) {
		x = _x;
		y = _y;
	}
	
	public Vector2D(double _d) {
		x = _d;
		y = _d;
	}
}
