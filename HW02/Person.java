/**
 * HW02 City
 * @author Nate Williams
 * @version 1.00, 08 January 2019
 */



public abstract class Person {//Abstract class, since Person types like Police or Teacher are related
protected String name; //person's first name
protected int age;//person's age, in years
protected int pnum;//person's phone number, simply as a 7-digit int
protected boolean isEmp = false;//is the person an employee?


public Person() {//default constructor, sets clearly default values
	name = "name";
	age = 999;
	pnum = 5555555;
}



public void setName(String n){//sets name
	name = n;
	}
public void setAge(int a) {//sets age
	//PT -- validate age, phone. -2
	age = a;
	}
public void setPnum(int num) {//sets phone number
	pnum = num;
}
public String getName() {//gets name
	return name;
}
public int getAge() {//gets age
	return age;
}
public int getPnum() {//gets phone number
	return pnum;
}
}
