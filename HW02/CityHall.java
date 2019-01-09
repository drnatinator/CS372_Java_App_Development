
public class CityHall extends Building {//a CityHall is a kind of Building
public CityHall() {//default constructor, sets generic names and no Persons inside
	this.setName("City Hall");
	this.setAddress("0001 Main St.");
	this.setOcc(null);
}

public CityHall(String n, String a, Person[] p) {//constructor for creating a CityHall
	this.setName(n);
	this.setAddress(a);
	this.setOcc(p);
}
}
