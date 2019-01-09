/**
 * HW02 City
 * @author Nate Williams
 * @version 1.00, 08 January 2019
 */

//PT -- javadoc. -2

public interface Employee {//Employees have IDs and can get paid. This differentiates them from other types of Person, like a Kid.
	int ID=0;//Id initialized to zero
int getID(Employee emp);
void givePay();//pays employees (currently, does nothing)
}
