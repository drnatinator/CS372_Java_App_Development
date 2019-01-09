

//import java.util.DoHomework;//Worth a try :-)

public class City {
	public static void main(String[] args) {
		
		Person[] people = {new Police("Sam", 54, 911, Police.role.Patrol), //initialize an array of Persons, of varied types
							new Police("Walter", 42, 911, Police.role.Chief),
							new Teacher("Marge", 36, 4110123, "first", "elementary"), 
							new Kid("Dave", 6, 1234567, "Snickers"), 
							new Kid("Sally", 8, 2345678, "Tootsie"), 
							new Kid("Joe", 11, 3456789, "broccoli"), 
							new Teacher("Wilson", 41, 4113210, "junior", "secondary")};
		
		Person[] inCH = {people[0], people[1]};//for now, I simply split the Persons above into three smaller arrays to determine who is in 
		Person[] inSch1 = {people[2], people[3]};//what Building. If this were more than a toy program, this would need to change, but it
		Person[] inSch2 = {people[4], people[5], people[6]};//accomplishes the goal for the present.
		
		Building[] buildings = {new CityHall("White House" , "1600 Pennsylvania Ave NW", inCH), //initializes an array with a CityHall and 2 Schools
								new School("Forestview Middle", "135 45th St.", inSch1), 
								new School("Washington High", "9 Parkview Blvd", inSch2) };
		
		for (Person peeps: people) {
			System.out.printf("Name: %s\n", peeps.getName() );//Demonstrates that I can output all the names of Persons in a loop
		}
		System.out.printf("\n\n\n");//readability
		for (Building builds: buildings) {//outputs all the names of buildings in a loop, and the names of the Persons occupying each Building
			System.out.printf("Building name: %s\nOccupants:\n", builds.getName());
			Person[] occupants = builds.getOcc();//stores an array of all the Persons in a given Building (as we iterate through the for-loop above))
			
			for (Person occ: occupants) {//prints the names of each Person in the given Building
				System.out.printf("%s\n", occ.getName());
			}
			System.out.printf("\n\n");//readability
			
		}
		int i=0;//iterator for the below loop
		for (Person peeps: people) {//pay Employees
			if (people[i].isEmp) {//if this particular Person is an Employee, we execute the [currently empty] method givePay() and then print to
				((Employee)people[i]).givePay();//the screen that they were paid
				System.out.printf("%s was paid successfully!\n", peeps.getName());
		}
			else//if not an employee, we simply output to the screen that they are not an employee and have not been paid
				System.out.printf("%s is not an employee, and has not been paid.\n", peeps.getName());
			i++;//iterate through the array of Persons
	}
}}
