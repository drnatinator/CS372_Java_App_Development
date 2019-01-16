import java.awt.Color;
import java.util.ArrayList;

public class Rectangle implements Shape {

	double ID=-1;
	String shapeName="Rectangle";
	double sides[]= {0,0};//rectangles need two different side lengths to define them
	String col="no color";
	double area=0;
	double perim=0;

	public String toString() {//returns the kind of shape and its ID, to be printed on the buttons on the left
		return String.format("%s (%s)", shapeName, (int)ID);
	}
	public String getKind() {
		return shapeName;//returns the kind of shape
	}
	public String getDetString() {//returns the details about a given shape to be printed on the right side of the window
		return String.format("%s (ID# %s)\nColor: %s\nLength: %s\nWidth: %s\nArea: %s\nPerimeter: %s", shapeName, (int)ID,col,sides[0],sides[1],sides[0]*sides[1],sides[0]*2+sides[1]*2);
	}
	public int getID() {//returns the ID as an int [stored here as a double for convenience]
		return (int)ID;
	}
	
	
	public Rectangle() {//default constructor
		sides[0]=(double)0;
		sides[1]=(double)0;
	}
	public Rectangle(double ID, double length, double width, String col) {
		this.ID = ID;//constructor
		sides[0]=length;
		sides[1]=width;
		this.col = col;
	}

}
