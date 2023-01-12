package Exe.Ex4.geo;

/** 
 * This class represents a 2D circle in the plane. 
 * Please make sure you update it according to the GeoShape interface.
 * Ex4: you should update this class!
 * @author boaz.benmoshe
 *
 */
public class Circle2D implements GeoShapeable{
	private Point2D _center;
	private double _radius;

	public Circle2D(Point2D cen, double rad) {
		this._center = new Point2D(cen);
		this._radius = rad;
	}

	public double x() {return _center.x();}
	public double y() {return _center.y();}

	public double getRadius() {return this._radius;}

	public Point2D getCenter() {return this._center;}

	@Override
	public String toString()
	{ return _center.toString()+", "+_radius;}
	@Override
	public boolean contains(Point2D ot) {
		double dist = ot.distance(this._center);
		return dist<=this._radius;
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
	public GeoShapeable copy() {
		return new Circle2D(_center, _radius);
	}
	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] =new Point2D(this._center);
		ans[1] = new Point2D(ans[0].x(), ans[0].y()+this._radius);
		return ans;
	}
	@Override
	public void scale(Point2D center, double ratio) {

		double xUL = this._center.x()- center.x();
		double yUL = this._center.y()- center.y();
		double newX1 = center.x() + (xUL*ratio);
		double newY1 = center.y() + (yUL*ratio);
		this._center = new Point2D(newX1,newY1);

		this._radius = _radius*ratio;

	}


	@Override
	public void rotate(Point2D center, double angleDegrees) {

		double radians = Math. toRadians (angleDegrees);
		double sin = Math.sin (radians);
		double cos = Math. cos (radians) ;
		double dx = this._center.x() - center.x ();
		double dy = this._center.y() - center.y ();
		this._center = new Point2D (center.x() + dx * cos - dy * sin, center.y() + dx * sin + dy * cos);

	}

}
