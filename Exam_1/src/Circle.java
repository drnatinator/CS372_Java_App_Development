import java.awt.Color;

public class Circle implements Shape {

	double ID=-1;
	String shapeName="Circle";
	double sides[] = {0};//for Circle, this simple contains the radius
	String col="no color";
	double area=0;
	double perim=0;

	public String toString() {
		return String.format("%s (%s)", shapeName, (int)ID);//for use on the buttons on the left
	}
	public String getKind() {
		return shapeName;//returns the kind of shape this is
	}
	public String getDetString() {
		area = sides[0]*sides[0]*Math.PI*1000;//finds area, multiplies by 1000
		int a = (int)area;//casts as int to throw away extra decimal places
		area = (double)a/1000;//resets to  proper order of magnitude
		perim = sides[0]*2*Math.PI*1000;
		int p = (int) perim;//same procedure as above, for perimeter
		perim = (double) p/1000;
		return String.format("%s (ID# %s)\nColor: %s\nRadius: %s\nArea: %s\nPerimeter: %s", shapeName, (int)ID,col,sides[0],area,perim);//to be printed on the right side of the window
	}
	public int getID() {
		return (int)ID;//returns the integer ID [stored here as a double for convenience, since the side lengths are all doubles]
	}
	public Circle() {//default constructor
		sides[0]=(double)0;//for circles, this is actually the radius, but I wanted to keep the variables named the same things
	}
	
	
	public Circle(double ID, double r, String col) {
		this.ID = ID;//constructor for circles
		sides[0] = r;
		this.col = col;
	}

}
