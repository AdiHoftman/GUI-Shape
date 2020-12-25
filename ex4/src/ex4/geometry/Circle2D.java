package ex4.geometry;

import java.util.Objects;

/**
 * This class represents a 2D circle in the plane. Please make sure you update it 
 * according to the GeoShape interface.
 * Ex4: you can update this class (additional documentation is needed)!
 * @author boaz.benmoshe
 *
 */
public class Circle2D implements GeoShape{
	private Point2D _center;
	private double _radius;

	public Circle2D(){
		this._center = new Point2D(0,0);
		this._radius = 0;
	}
	public Circle2D(Point2D cen, double rad) {
		this._center = new Point2D(cen);
		this._radius = rad;
	}	

	public Circle2D(Circle2D c) {
		this._center = c._center;
		this._radius = c._radius;
	}

	public Point2D center() {
		return _center;
	}

	public double radius() {
		return _radius;
	}

	public double getRadius() {return this._radius;}

	@Override
	public String toString()
	{ return _center.toString() + "," + this._radius;}

	@Override
	public boolean contains(Point2D ot) {
		double dist = ot.distance(this._center);
		return dist<=this._radius;
	}

	@Override
	public Point2D centerOfMass() {
		return new Point2D(this._center);
	}

	@Override
	public double area() {
		double ans = Math.PI * Math.pow(this._radius, 2);
		return ans;
	}

	@Override
	public double perimeter() {
		double ans = Math.PI * 2 * this._radius;
		return ans;
	}

	@Override
	public void move(Point2D vec) {
		_center.move(vec);
	}

	@Override
	public GeoShape copy() {
		return new Circle2D(this._center, this._radius);
	}

	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] =new Point2D(this._center);
		ans[1] = new Point2D(ans[0].x(), ans[0].y()+this._radius);
		return ans;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Circle2D circle2D = (Circle2D) o;
		return Double.compare(circle2D._radius, _radius) == 0 &&
				Objects.equals(_center, circle2D._center);
	}
}