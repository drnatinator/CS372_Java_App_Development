import java.awt.Color;
import java.util.ArrayList;

public class Square implements Shape {

	double ID=-1;
	String shapeName="Square";
	double[] sides= {0};//for squares, only needs to contain one value (since the sides are all the same)
	String col="no color";
	double area=0;
	double perim=0;

	public String toString() {
		return String.format("%s (%s)", shapeName, (int)ID);//for be printed on the buttons on the left
	}
	public String getKind() {
		return shapeName;
	}
	public String getDetString() {//to be printed as details about a shape on the right
		return String.format("%s (ID# %s)\nColor: %s\nSide: %s\nArea: %s\nPerimeter: %s", shapeName, (int)ID,col,sides[0],sides[0]*sides[0],sides[0]*4);
	}
	public int getID() {
		return (int)ID;//returns the ID as an int [it's stored here as a double for convenience]
	}
	
	public Square() {//default constructor
		sides[0]=((double)0);
	}
	public Square(double ID, double side, String col) {
		this.ID = ID;//constructor
		sides[0] = side;
		this.col = col;
	}

}