/**
 * HW02 City
 * @author Nate Williams
 * @version 1.00, 08 January 2019
 */



public class Police extends Person implements Employee{//Police are Persons and Employees
public enum role {Patrol_Officer, Sergeant, Captain, Chief}//different possible roles for a Police Person
private role pRole;//variable for a particular Police;used below
/**
 * @return an officer's ID number
 */
public int getID(Employee emp) {	//gets a Police's ID
	return Employee.ID;
};

/**
 * 
 * @return an officer's role, as a Police role
 */
public Police.role getRole(){
	return pRole;
}


public void givePay() {}//pays a Police (currently, does nothing, as we don't model the city's budget or anything)


public Police() {//default constructor, sets clearly default values
	this.setName("policeName");
	this.setAge(888);
	this.setPnum("555-5555");
	pRole = role.Patrol_Officer;
	isEmp = true;
}

public Police(String n, int a, String p, role r) {//constructor to make a Police
	this.setName(n);
	this.setAge(a);
	this.setPnum(p);
	pRole = r;
	isEmp = true;
	}

}
