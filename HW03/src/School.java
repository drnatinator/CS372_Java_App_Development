/**
 * HW03 City
 * @author Nate Williams
 * @version 1.00, 13 January 2019
 */



public class School extends Building {//a School is a kind of Building
	public School() {//default constructor, sets generic names and no Persons inside
		this.setName("Education Center");
		this.setAddress("0002 Main St.");
		this.setOcc(null);
	}
/**
 * 
 * @param n name of the school, in a String
 * @param a address of the school, in a String
 * @param p array of Person occupants of the school
 */
	public School(String n, String a, Person[] p) {//constructor for creating a School
		this.setName(n);
		this.setAddress(a);
		this.setOcc(p);
	}
}
