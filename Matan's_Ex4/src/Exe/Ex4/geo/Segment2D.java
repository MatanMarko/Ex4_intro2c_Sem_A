package Exe.Ex4.geo;

import Exe.Ex4.Ex4_Const;

/**
 * This class represents a 2D segment on the plane, 
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Segment2D implements GeoShapeable{

	//////////data//////////

	private Point2D _point1;
	private Point2D _point2;

	//////////constructor//////////
	
	public Segment2D(Point2D p1, Point2D p2) {
		_point1 = new Point2D(p1);
		_point2 = new Point2D(p2);
	}

	//////////functions//////////

	public double[] getXs() {

		double[] arrX = {this._point1.x(), this._point2.x()};
		return arrX;
	}

	public double[] getYs() {

		double[] arrY = {this._point1.y(), this._point2.y()};
		return arrY;
	}



	@Override
	public boolean contains(Point2D ot) {
		
		double eps = Ex4_Const.EPS;
		double dist1 = this._point1.distance(ot);
		double dist2 = this._point2.distance(ot);
		double dist3=  this._point1.distance(this._point2);
		double a = dist1 + dist2 ;
		if(dist3 >= a - eps || dist3 == a + eps) {return true;}
		return false;
	}

	@Override
	public double area() {
		return 0;
	}

	@Override
	public double perimeter() {
		return this._point1.distance(_point2)*2;
	}

	@Override
	public void move(Point2D vec) {
		this._point1.move(vec);
		this._point2.move(vec);
	}

	@Override
	public GeoShapeable copy() {
		return new Segment2D(_point1 , _point2);
	}

	@Override
	public void scale(Point2D center, double ratio) {

		double x1 = this._point1.x()- center.x();
		double y1 = this._point1.y()- center.y();
		double newX1 = center.x() + (x1*ratio);
		double newY1 = center.y() + (y1*ratio);
		this._point1 = new Point2D(newX1,newY1);
		
		double x2 = this._point2.x()- center.x();
		double y2 = this._point2.y()- center.y();
		double newX2 = center.x() + (x2*ratio);
		double newY2 = center.y() + (y2*ratio);
		this._point2 = new Point2D(newX2,newY2);
	}

	@Override
	public void rotate(Point2D center, double angleDegrees) {
		
		this._point1.rotate(center, angleDegrees);
		this._point2.rotate(center, angleDegrees);		
	}

	@Override
	public Point2D[] getPoints() {
		Point2D[] points = new Point2D[2];
		points[0]= _point1;
		points[1]= _point2;

		return points;
	}
	@Override
	public String toString() {
		return "Rect2D: ["+_point1+","+_point2+"]";
	}
}