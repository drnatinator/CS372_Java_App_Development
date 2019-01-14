/**
 * HW02 City
 * @author Nate Williams
 * @version 1.00, 08 January 2019
 */



public abstract class Person {//Abstract class, since Person types like Police or Teacher are related
protected String name; //person's first name
protected int age;//person's age, in years
protected String pnum;//person's phone number, simply as a 7-digit int
protected boolean isEmp = false;//is the person an employee?


public Person() {//default constructor, sets clearly default values
	name = "name";
	age = 999;
	pnum = "555-5555";
}


/**
 * 
 * @param n is the person's name, in a string
 */
public void setName(String n){//sets name
	name = n;
	}
/**
 * 
 * @param a is the person's age, in an int
 */
public void setAge(int a) {//sets age
	age = a;
	}
/**
 * 
 * @param num is the person's phone number, as a string, in the form xxx-xxxx
 */
public void setPnum(String num) {//sets phone number
	pnum = num;
}
/**
 * 
 * @return the person's name in a string
 */
public String getName() {//gets name
	return name;
}
/**
 * 
 * @return the person's age in an int
 */
public int getAge() {//gets age
	return age;
}
/**
 * 
 * @return the person's phone number as a string in the form xxx-xxxx
 */
public String getPnum() {//gets phone number
	return pnum;
}
}
