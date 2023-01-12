package Exe.Ex4;

import java.awt.Color;
import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import Exe.Ex4.geo.Circle2D;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Rect2D;

/**
 * This class represents a collection of GUI_Shape.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class ShapeCollection implements ShapeCollectionable{
	private ArrayList<GUI_Shapeable> _shapes;

	public ShapeCollection() {
		_shapes = new ArrayList<GUI_Shapeable>();
	}
	@Override
	public GUI_Shapeable get(int i) {
		return _shapes.get(i);
	}

	@Override
	public int size() {
		return _shapes.size();
	}

	@Override
	public GUI_Shapeable removeElementAt(int i) {

		return _shapes.remove(i);
	}

	@Override
	public void addAt(GUI_Shapeable s, int i) {
		if(s!=null && s.getShape()!=null) {
			_shapes.add(i, s);
		}
	}
	@Override
	public void add(GUI_Shapeable s) {
		if(s!=null && s.getShape()!=null) {
			_shapes.add(s);
		}
	}
	@Override
	public ShapeCollectionable copy() {

		ShapeCollection copy = new ShapeCollection();
		ArrayList<GUI_Shapeable> copyArray = new ArrayList();
		for(int i = 0; i < _shapes.size(); i++) {
			copyArray.add(_shapes.get(i).copy());
		}
		copy._shapes = copyArray;
		return copy;

	}

	@Override
	public void sort(Comparator<GUI_Shapeable> comp) {
		_shapes.sort(comp);
	}

	@Override
	public void removeAll() {
		_shapes.clear();
	}

	@Override
	public void save(String file) {

		//Get target folder from user
		FileDialog fd = new FileDialog(new JFrame(), "Save File", FileDialog.SAVE);
		fd.setDirectory("C:\"");
		fd.setVisible(true);
		String filePath = fd.getDirectory() + fd.getFile();//Save the full path
		if(fd.getFile()!=null){//If any folder has chosen
			
		}
		
		try {
			FileWriter myWriter = new FileWriter(filePath);
			for (int i=0; i<_shapes.size(); i++) {
				if(_shapes.get(i) != null) {
					String s = _shapes.get(i).toString();
					myWriter.write(s);
				}
			}
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	
	}

	@Override
	public void load(String file) {

		BufferedReader bReader;
		try {
			bReader = new BufferedReader(new FileReader("file.txt"));
			String line = bReader.readLine();
			while (line != null) {
				System.out.println(line);
				line = bReader.readLine();
			}
			bReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


		//		removeAll();
		//		try {
		//			File f = new File(file);
		//			Scanner s = new Scanner(f);
		//			while (s.hasNextLine()) {
		//				String text = s.nextLine();
		//				String[] newText = text.split(",");
		//				//GUIShape gs = new GUIShape();
		//				//	gs.init(newText);
		//				//	this._shapes.add(gs);
		//			}
		//			s.close();
		//		}
		//		catch (FileNotFoundException e) {
		//			System.out.println("An error has been occurred");
		//			e.printStackTrace();
		//		}

	}
	@Override
	public Rect2D getBoundingBox() {
		Rect2D ans = null;

		double minimum_x = Double.MAX_VALUE;
		double maximum_x = -Double.MAX_VALUE;
		double minimum_y = Double.MAX_VALUE;
		double maximum_y = -Double.MAX_VALUE;
		Circle2D copy ;
		Point2D arrayP[] ;
		int i = 0 ;
		while (i < this._shapes.size()) {
			if(_shapes.get(i).getShape() instanceof Circle2D) {
				copy = (Circle2D) _shapes.get(i).getShape();
				if (copy.getCenter().x() + copy.getRadius() > maximum_x ) {
					maximum_x = copy.getCenter().x() + copy.getRadius();
				}

				else if(copy.getCenter().x() - copy.getRadius() < minimum_x ) {
					minimum_x = copy.getCenter().x() - copy.getRadius();
				}

				else if (copy.getCenter().y() + copy.getRadius() > maximum_y) {
					maximum_y = copy.getCenter().y() + copy.getRadius();
				}

				else if ((copy.getCenter().y() - copy.getRadius() < minimum_y)) {
					minimum_y = copy.getCenter().y() - copy.getRadius();
				}

			}
			else {
				arrayP = _shapes.get(i).getShape().getPoints() ;
				for(int j = 0 ; j < arrayP.length&& arrayP[j] !=null ; j ++ ) {
					if(arrayP[j].x() > maximum_x) {
						maximum_x=arrayP[j].x();
					}
					if((arrayP[j].x() < minimum_x)) {
						minimum_x = arrayP[j] .x();
					}
					if(arrayP[j].y() > maximum_y) {
						maximum_y = arrayP[j].y();
					}
					if((arrayP[j].y() < minimum_y)) {
						minimum_y = arrayP[j].y();
					}
				}
			}
			i++;
		}

		Point2D sidemax = new Point2D(maximum_x , maximum_y) ;
		Point2D sidemin = new Point2D(minimum_x , minimum_y) ;
		return(new Rect2D(sidemin, sidemax));

	}

	@Override
	public String toString() {
		String ans = "";
		for(int i=0; i<size(); i++) {
			ans += this.get(i);
		}
		
		return ("GUIShape"+","+Color.getColor(ans)+","+"tag"+","+"");
	}
	//<GUIShape,color,fill,tag,GeoShape,data1,data2,...>\
}
