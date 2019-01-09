
public class School extends Building {//a School is a kind of Building
	public School() {//default constructor, sets generic names and no Persons inside
		this.setName("Education Center");
		this.setAddress("0002 Main St.");
		this.setOcc(null);
	}

	public School(String n, String a, Person[] p) {//constructor for creating a School
		this.setName(n);
		this.setAddress(a);
		this.setOcc(p);
	}
}
