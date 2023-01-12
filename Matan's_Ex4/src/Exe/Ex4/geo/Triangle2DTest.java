package Exe.Ex4.geo;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import Exe.Ex4.Ex4_Const;
import Exe.Ex4.GUIShape;
import Exe.Ex4.GUI_Shapeable;
import Exe.Ex4.ShapeCollection;
import Exe.Ex4.ShapeCollectionable;


class Triangle2DTest {
	Point2D p1 = new Point2D(1,1);
	Point2D p2 = new Point2D(2,2);
	Point2D p3 = new Point2D(3,1);
	@Test
	void testContains() {
		
		Point2D p4 = new Point2D(2,1);
		Point2D p5 = new Point2D(2,3);
		
		Triangle2D t1 = new Triangle2D(p1,p2,p3);
		
		boolean contain1 = t1.contains(p4);
		boolean contain2 = t1.contains(p5);

		assertEquals(contain1, true);
		assertEquals(contain2, false);
		
	}

	@Test
	void testArea() {
		
		Point2D p4 = new Point2D(1.3,3);
		Point2D p5 = new Point2D(4,2.2);
		
		Triangle2D t1 = new Triangle2D(p1,p2,p3);
		Triangle2D t2 = new Triangle2D(p4,p2,p5);
		
		double area1 = t1.area();
		double area2 = t2.area();
		double eps = 0.01;

		assertEquals(area1,0.9940, eps);
		assertEquals(area2,1.065 ,eps);
		
	}

	@Test
	void testPerimeter() {
		
		Point2D p4 = new Point2D(1.3,3);
		Point2D p5 = new Point2D(4,2.2);
		
		Triangle2D t1 = new Triangle2D(p1,p2,p3);
		Triangle2D t2 = new Triangle2D(p4,p2,p5);
		
		double perimeter1 = t1.perimeter();
		double perimeter2 = t2.perimeter();
		double eps = 0.01;

		assertEquals(perimeter1,4.82, eps);
		assertEquals(perimeter2,6.05 ,eps);

		
	}
	
	@Test
	void testMove() {
		
		
		Point2D p4 = new Point2D(3,3);
		Point2D p5 = new Point2D(4,2);
		
		Triangle2D t1 = new Triangle2D(p1,p2,p3);
		Triangle2D t2 = new Triangle2D(p2,p4,p5);
		
		t1.move(p1);		
		double eps = 0.01;

		assertEquals(t1.getPoints()[0].x(),t2.getPoints()[0].x());
		assertEquals(t1.getPoints()[1].x(),t2.getPoints()[1].x());
		assertEquals(t1.getPoints()[2].x(),t2.getPoints()[2].x());
		
		assertEquals(t1.getPoints()[0].x(),t2.getPoints()[0].x(), eps);
		assertEquals(t1.getPoints()[1].x(),t2.getPoints()[1].x(), eps);
		assertEquals(t1.getPoints()[2].x(),t2.getPoints()[2].x(), eps);
		
	}
	
	@Test
	void testCopy() {
		
		ShapeCollectionable _shapes = new ShapeCollection();
				
	
		Point2D p4 = new Point2D(3,3);
		Point2D p5 = new Point2D(4,2);
		Point2D p6 = new Point2D(4,4);
		Point2D p7 = new Point2D(2,1);
		ArrayList<Point2D> polyPoints = new ArrayList<>();
		polyPoints.add(p1);
		polyPoints.add(p7);
		polyPoints.add(p2);
		polyPoints.add(p5);

		
		Triangle2D t1 = new Triangle2D(p1,p2,p3);
		Circle2D c1 = new Circle2D(p2,2);
		Triangle2D t2 = new Triangle2D(p2,p4,p5);
		Rect2D r1 = new Rect2D(p2,p6);
		Polygon2D poly1 = new Polygon2D(polyPoints);
		
		GUI_Shapeable gs1 = new GUIShape(t1, true, Color.black, 0);
		GUI_Shapeable gs2 = new GUIShape(c1, false, Color.blue, 0);
		GUI_Shapeable gs3 = new GUIShape(t2, true, Color.black, 0);
		GUI_Shapeable gs4 = new GUIShape(r1, false, Color.red, 0);
		GUI_Shapeable gs5 = new GUIShape(poly1, true, Color.black, 0);
		GUI_Shapeable gs6 = new GUIShape(poly1, false, Color.green, 0);
		
		_shapes.add(gs1);
		_shapes.add(gs2);
		_shapes.add(gs3);
		_shapes.add(gs4);
		_shapes.add(gs5);
		_shapes.add(gs6);
		
		int sizeBefore= _shapes.size();

		t1.copy();	
		r1.copy();	
		
		int sizeAfter= _shapes.size();

		assertEquals(sizeBefore+2,sizeAfter);
		
	}
	
	@Test
	void testScale() {
		fail("Not yet implemented");
	}
	
	@Test
	void testRotate() {
		Point2D p4 = new Point2D(5,5);
		Point2D p5 = new Point2D(6,3);
		Point2D p6 = new Point2D(4,3);
		Point2D cen = new Point2D(5,2);
		double deg = 90;
		Triangle2D t1 = new Triangle2D(p4,p5,p6);
		t1.rotate(cen, deg);
		
		Point2D[] tArr = t1.getPoints();
		
		Point2D rp4= new Point2D(2,2);
		Point2D rp5= new Point2D(4,3);
		Point2D rp6= new Point2D(4,1);
		
		assertEquals(rp4, tArr[0]);
		assertEquals(rp5, tArr[1]);
		assertEquals(rp6, tArr[2]);
		
		
	}

}