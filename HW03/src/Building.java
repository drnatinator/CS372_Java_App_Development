/**
 * HW03 City
 * @author Nate Williams
 * @version 1.00, 13 January 2019
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


/**
 * 
 * @param n string containing the name that is to be set
 */
public void setName(String n) {//sets the Building's name
	name = n;
	}
/**
 * 
 * @param ad string containing the address of the building
 */
public void setAddress(String ad) {//sets the Building's address
	address = ad;
	}
/**
 * 
 * @param people array of Persons who are in this building
 */
public void setOcc(Person[] people) {//sets the array of Persons inside the Building
	occupants = people;
}
/**
 * 
 * @return the name of the building
 */
public String getName() {//gets the Bulding's name
	return name;
}

/**
 * 
 * @return the address of the building
 */
public String getAddr() {//gets the Building's address
	return address;
}
/**
 * 
 * @return the array of occupants of the building
 */
public Person[] getOcc() {//gets the array of Persons inside the Building
	return occupants;
}
}
