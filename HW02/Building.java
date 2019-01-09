/**
 * HW02 City
 * @author Nate Williams
 * @version 1.00, 08 January 2019
 */


public abstract class Building {//abstract class, since different buildings like School or CityHall are related
String name;//building name
String address;//building address
Person[] occupants;//an array of Persons who are currently in the Building



public Building() {//default constructor, sets clearly default values
	name = "bName";
	address = "0001 Main St.";
	occupants = null;
}



public void setName(String n) {//sets the Building's name
	name = n;
	}
public void setAddress(String ad) {//sets the Building's address
	address = ad;
	}
public void setOcc(Person[] people) {//sets the array of Persons inside the Building
	occupants = people;
}
public String getName() {//gets the Bulding's name
	return name;
}
public String getAddr() {//gets the Building's address
	return address;
}
public Person[] getOcc() {//gets the array of Persons inside the Building
	return occupants;
}
}
