package com.debs.sample;

public class Rectangle {
	
	private Point a;
	
	private Point b;

	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		this.a = a;
	}

	public Point getB() {
		return b;
	}

	public void setB(Point b) {
		this.b = b;
	}
	
	Rectangle(Point a, Point b){
		this.a=a;
		this.b=b;
	}

}
