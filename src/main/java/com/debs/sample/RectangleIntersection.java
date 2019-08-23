package com.debs.sample;

public class RectangleIntersection {

	public Boolean ifRectangleIntersection(Rectangle rec1, Rectangle rec2) {

		if (rec1.getA().getX() > rec2.getB().getX() || rec1.getA().getY() > rec2.getB().getY()
				|| rec2.getA().getX() > rec1.getB().getX() || rec2.getA().getY() > rec1.getB().getY())
			return false;
		return true;
	}

}
