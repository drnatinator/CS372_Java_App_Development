
public class Police extends Person implements Employee{//Police are Persons and Employees
public enum role {Patrol, Sergeant, Captain, Chief}//different possible roles for a Police Person
private role pRole;//variable for a particular Police;used below

public int getID(Employee emp) {	//gets a Police's ID
	return Employee.ID;
};


public void givePay() {}//pays a Police (currently, does nothing, as we don't model the city's budget or anything)


public Police() {//default constructor, sets clearly default values
	this.setName("policeName");
	this.setAge(888);
	this.setPnum(5555555);
	pRole = role.Patrol;
	isEmp = true;
}

public Police(String n, int a, int p, role r) {//constructor to make a Police
	this.setName(n);
	this.setAge(a);
	this.setPnum(p);
	pRole = r;
	isEmp = true;
	}

}
