import java.awt.Color;
import java.util.ArrayList;

public class Triangle implements Shape {

	
	double ID=-1;
	String shapeName="Triangle";
	double sides[]= {0,0,0};//triangles need three side lengths to define them
	String col="no color";
	double perim = 0;
	double area=0;
	
	

	public String toString() {//returns kind of shape and ID, to be printed on the buttons on the left
		return String.format("%s (%s)", shapeName, (int)ID);
	}
	public String getKind() {//returns kind of shape
		return shapeName;
	}
	public String getDetString() {
		//System.out.printf("side 1: %s; side 2: %s; side 3: %s\n", sides[0],sides[1],sides[2]);//for debugging
		perim = sides[0]+sides[1]+sides[2];//sum of three side lengths
		if (sides[0]+sides[1]>sides[2]&&sides[1]+sides[2]>sides[0]&&sides[0]+sides[2]>sides[1]) {//checks to see if this is a valid triangle
			//System.out.println("here");//for debuging
			double p = perim/2;//for use below
			double a = p*(p-sides[0])*(p-sides[1])*(p-sides[2]);//formula for area of a triangle, once it's square rooted[below]
			area = Math.sqrt(a);
		}
		//returns the details about this shape, to be printed on the right side of the window
		return String.format("%s (ID# %s)\nColor: %s\nSide 1: %s\nSide 2: %s\nSide 3: %s\nPerimeter: %s\nArea: %s", shapeName, (int)ID,col,sides[0],sides[1],sides[2], perim,area);
	}
	public int getID() {//returns the ID as an int [stored here as a double for convenience]
		return (int)ID;
	}
	
	public Triangle() {//default constructor
		sides[0]=(double)0;
		sides[1]=(double)0;
		sides[2]=(double)0;
	}
	
	public Triangle(double ID, double side1, double side2, double side3, String col) {
		this.ID = ID;//constructor
		sides[0]=side1;
		sides[1]=side2;
		sides[2]=side3;
		this.col = col;
	}

}
