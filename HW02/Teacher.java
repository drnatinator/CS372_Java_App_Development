
public class Teacher extends Person implements Employee{//Tearchers are Persons and Employees
private String grdLvl;//Teacher's grade level (the grade they teach)
private String cert;//the name of a Teacher's certification

public int getID(Employee emp) {	//gets a Teacher's ID
	return Employee.ID;
};
public void givePay() {}//pays a Teacher (currently, does nothing, as we don't model a city's budget or anything)


public Teacher() {//default constructor, sets clearly default values
	this.setName("teacherName");
	this.setAge(999);
	this.setPnum(5555555);
	grdLvl = "0";
	cert = "nope";
	isEmp = true;
}

public Teacher(String n, int a, int p, String g, String c) {//constructor to make a Teacher
	this.setName(n);
	this.setAge(a);
	this.setPnum(p);
	grdLvl = g;
	cert = c;
	isEmp = true;
}



}
