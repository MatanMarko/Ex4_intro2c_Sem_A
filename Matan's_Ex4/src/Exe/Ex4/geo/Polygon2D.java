package Exe.Ex4.geo;

import java.util.ArrayList;

/**
 * This class represents a 2D polygon, as in https://en.wikipedia.org/wiki/Polygon
 * This polygon can be assumed to be simple in terms of area and contains.
 * 
 * You should update this class!
 * @author boaz.benmoshe
 *
 */
public class Polygon2D implements GeoShapeable{

	//////////Data//////////

	private ArrayList<Point2D> _points;

	//////////Constructor//////////

	private Polygon2D() {
		_points = new ArrayList<>();
	}

	//copy constructor
	public Polygon2D(ArrayList<Point2D> points) {
		_points = (ArrayList<Point2D>)points.clone();
	}

	//////////Functions//////////

	public void addPoint(Point2D p) {
		_points.add(new Point2D(p));
	}

	public double[] getXs() {
		double[] ans = new double[_points.size()];
		for (int i=0; i<_points.size(); i++) {
			ans[i]= _points.get(i).x();
		}
		return ans;
	}

	public double[] getYs() {
		double[] ans = new double[_points.size()];
		for (int i=0; i<_points.size(); i++) {
			ans[i]= _points.get(i).y();
		}
		return ans;
	}

	@Override
	public boolean contains(Point2D ot) {
		boolean isInside = false;
		for (int i = 0, j = _points.size() - 1; i < _points.size(); j = i++) {
			if ((getYs()[i] > ot.y()) != (getYs()[j] > ot.y()) &&
					(ot.x() < (getXs()[j] - getXs()[i]) * (ot.y() - getYs()[i]) / (getYs()[j] - getYs()[i]) + getXs()[i])) {
				isInside = !isInside;
			}
		}
		return isInside;
	}

	@Override
	public double area() {

		double area = 0;
		for (int i = 0, j = _points.size() - 1; i < _points.size(); j = i++) {
			area += (getXs()[i] + getXs()[j]) * (getYs()[i] - getYs()[j]);
		}
		area /= 2;
		return Math.abs(area);
	}


	@Override
	public double perimeter() {

		ArrayList<Point2D> periPoints = (ArrayList<Point2D>)_points.clone();
		double total_peri=0;
		for (int i=0; i<periPoints.size()-1; i++) {
			total_peri += periPoints.get(i).distance(periPoints.get(i+1));
		}
		total_peri += periPoints.get(periPoints.size()-1).distance(periPoints.get(0));
		return total_peri;
	}

	@Override
	public void move(Point2D vec) {
		for(int i=0; i<_points.size(); i++) {
			_points.get(i).move(vec);
		}
	}

	@Override
	public GeoShapeable copy() {
		Polygon2D poly = new Polygon2D();
		for (int i=0; i<_points.size(); i++) {
			poly.addPoint(new Point2D(_points.get(i).x() , _points.get(i).y()));
		}
		return poly;
	}

	@Override
	public void scale(Point2D center, double ratio) {

		for(int i=0; i<_points.size(); i++) {
			
			Point2D newPoint = new Point2D(_points.get(i).x()- center.x(), _points.get(i).y()- center.y());
			Point2D newerPoint = new Point2D(center.x() + (newPoint.x()*ratio), center.y() + (newPoint.y()*ratio));
			
			this._points.set(i, newerPoint);
		}
		
	}

	@Override
	public void rotate(Point2D center, double angleDegrees) {

		for(int i=0; i<_points.size(); i++) {
			_points.get(i).rotate(center, angleDegrees);
		}
		
	}

	@Override
	public Point2D[] getPoints() {

		return (Point2D[])_points.toArray();
	}
	@Override
	public String toString() {
		String ans="";
		for(int i=0;i<_points.size();i++) {
			ans+=_points.toString();
			if(i<_points.size()-1)
				ans+=",";
		}
		return ans;
	}

}
