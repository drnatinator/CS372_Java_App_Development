/**
 * HW03 City
 * @author Nate Williams
 * @version 1.00, 13 January 2019
 */



public class Kid extends Person {//Kids are Persons, but not Employees.
	
private String favCndy;//a Kid's favorite candy
/**
 * 
 * @return a kid's candy
 */
public String getCndy() {
	return favCndy;
}

public Kid() {//default constructor, sets clearly default values
	this.setName("Kid");
	this.setAge(0);
	this.setPnum("555-5555");
	favCndy = "Candy";
	isEmp = false;
}	
	
public Kid(String n, int a, String p, String Cndy) {//Constructor for making a Kid
	this.setName(n);
	this.setAge(a);
	this.setPnum(p);
	favCndy = Cndy;
	isEmp = false;
	}
}
