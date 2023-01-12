package Exe.Ex4.geo;

import java.util.Comparator;

import Exe.Ex4.Ex4_Const;
import Exe.Ex4.GUI_Shapeable;

/**
 * This class represents a Comparator over GUI_Shapes - 
 * as a linear order over GUI_Shapes.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
/*public class ShapeComp implements Comparator<GUI_Shapeable>{
	//////////add your code below ///////////


	public static final Comparator<GUI_Shapeable> CompByToString = new ShapeComp(Ex4_Const.Sort_By_toString);
	public static final Comparator<GUI_Shapeable> Sort_By_Anti_toString = new ShapeComp(Ex4_Const.Sort_By_Anti_toString);
	public static final Comparator<GUI_Shapeable> Comp_By_Tag = new ShapeComp(Ex4_Const.Sort_By_Tag);
	public static final Comparator<GUI_Shapeable> Sort_By_Anti_Tag = new ShapeComp(Ex4_Const.Sort_By_Anti_Tag);
	public static final Comparator<GUI_Shapeable> Sort_By_Perimeter = new ShapeComp(Ex4_Const.Sort_By_Perimeter);
	public static final Comparator<GUI_Shapeable> Sort_By_Anti_Perimeter = new ShapeComp(Ex4_Const.Sort_By_Anti_Perimeter);
	public static final Comparator<GUI_Shapeable> Sort_By_Area = new ShapeComp(Ex4_Const.Sort_By_Area);
	public static final Comparator<GUI_Shapeable> Sort_By_Anti_Area = new ShapeComp(Ex4_Const.Sort_By_Anti_Area);

	private int _flag;

	public ShapeComp(int flag) {
		_flag = flag;

	}
	@Override
	public int compare(GUI_Shapeable o1, GUI_Shapeable o2) {
		int ans=0;
		if(_flag == Ex4_Const.Sort_By_toString) {
			ans = o1.toString().compareTo(o2.toString());
		}
		if(_flag == Ex4_Const.Sort_By_Anti_toString) {
			ans= o2.getClass().getSimpleName().compareTo(o1.getClass().getSimpleName());
		}
		if(_flag == Ex4_Const.Sort_By_Tag) {

			int tag1 = o1.getTag();
			int tag2 = o2.getTag();

			if (tag1<tag2) {ans=-1;}
			if (tag1>tag2) {ans=1;}
			if (tag1==tag2){ans=0;}
		}

		if(_flag == Ex4_Const.Sort_By_Anti_Tag) {

			int tag1 = o1.getTag();
			int tag2 = o2.getTag();

			if (tag1>tag2) {ans=-1;}
			if (tag1<tag2) {ans=1;}
			if (tag1==tag2){ans=0;}
		}

		if(_flag == Ex4_Const.Sort_By_Perimeter) {
			double perimeter1 = o1.getShape().perimeter();
			double perimeter2 =o2.getShape().perimeter();
			
			if (perimeter1<perimeter2) {ans=-1;}
			if (perimeter1>perimeter2) {ans=1;}
			if (perimeter1==perimeter2){ans=0;}
		}

		if(_flag == Ex4_Const.Sort_By_Anti_Perimeter) {
			double perimeter1 = o1.getShape().perimeter();
			double perimeter2 =o2.getShape().perimeter();
			
			if (perimeter1>perimeter2) {ans=-1;}
			if (perimeter1<perimeter2) {ans=1;}
			if (perimeter1==perimeter2) {ans=0;}
		}

		if(_flag == Ex4_Const.Sort_By_Area) {
			double area1 = o1.getShape().area();
			double area2 = o2.getShape().area();
			
			if (area1<area2) {ans=-1;}
			if (area1>area2) {ans=1;}
			if (area1==area2) {ans=0;}
		}

		if(_flag == Ex4_Const.Sort_By_Anti_Area) {
			double area1 = o1.getShape().area();
			double area2 = o2.getShape().area();
			
			if (area1<area2) {ans=-1;}
			if (area1>area2) {ans=1;}
			if (area1==area2) {ans=0;}
		}
		return ans;
	}

}*/








import java.util.Comparator;

import Exe.Ex4.Ex4_Const;
import Exe.Ex4.GUI_Shapeable;

/**
 * This class represents a Comparator over GUI_Shapes - 
 * as a linear order over GUI_Shapes.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class ShapeComp implements Comparator<GUI_Shapeable>{
	//////////add your code below ///////////


	public static final Comparator<GUI_Shapeable> Comp_By_ToString = new ShapeComp(Ex4_Const.Sort_By_toString);
	public static final Comparator<GUI_Shapeable> Comp_By_Anti_ToString = new ShapeComp(Ex4_Const.Sort_By_Anti_toString);
	public static final Comparator<GUI_Shapeable> Comp_By_Tag = new ShapeComp(Ex4_Const.Sort_By_Tag);
	public static final Comparator<GUI_Shapeable> Comp_By_Anti_Tag = new ShapeComp(Ex4_Const.Sort_By_Anti_Tag);
	public static final Comparator<GUI_Shapeable> Comp_By_Perimeter = new ShapeComp(Ex4_Const.Sort_By_Perimeter);
	public static final Comparator<GUI_Shapeable> Comp_By_Anti_Perimeter = new ShapeComp(Ex4_Const.Sort_By_Anti_Perimeter);
	public static final Comparator<GUI_Shapeable> Comp_By_Area = new ShapeComp(Ex4_Const.Sort_By_Area);
	public static final Comparator<GUI_Shapeable> Comp_By_Anti_Area = new ShapeComp(Ex4_Const.Sort_By_Anti_Area);

	private int _flag;

	public ShapeComp(int flag) {
		_flag = flag;

	}
	@Override
	public int compare(GUI_Shapeable o1, GUI_Shapeable o2) {
		int ans=0;
		if(_flag == Ex4_Const.Sort_By_toString) {
			ans = o1.toString().compareTo(o2.toString());
		}

		if(_flag == Ex4_Const.Sort_By_Anti_toString) {
			ans= (-1*(o1.toString().compareTo(o2.toString())));
		}

		if(_flag == Ex4_Const.Sort_By_Tag) {
			ans = (o1.getTag() - o2.getTag());
		}

		if(_flag == Ex4_Const.Sort_By_Anti_Tag) {
			ans = (-1*(o1.getTag() - o2.getTag()));
		}

		if(_flag == Ex4_Const.Sort_By_Perimeter) {
			ans = (int) (o1.getShape().perimeter() - o2.getShape().perimeter());	
		}

		if(_flag == Ex4_Const.Sort_By_Anti_Perimeter) {
			ans = (int) (-1*(o1.getShape().perimeter() - o2.getShape().perimeter()));	
		}

		if(_flag == Ex4_Const.Sort_By_Area) {
			ans = (int) (o1.getShape().area() - o2.getShape().area());	

		}

		if(_flag == Ex4_Const.Sort_By_Anti_Area) {
			ans = (int) (-1*(o1.getShape().area() - o2.getShape().area()));	

		}


		return ans;
	}

}