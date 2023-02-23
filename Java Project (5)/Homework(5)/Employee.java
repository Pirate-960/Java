// Student Name: Abdelrahman Zahran.
// Student Number: 150120998.
/** Class Employee: Represents the number of items + work hours of the employees + number of the employees + the salaries of the employees + Employees's Ids. */

public class Employee {
	// Data field id keeps the id number of the Employee object created.
	private int id;
	// Data field name keeps the name of the employee.
	private String name;
	// Data field surname keeps the surname of the employee.
	private String surname;
	// Data field workHour keeps the number of hours an employee will work.
	private int workHour;
	// Data field speed keeps the number of items that the employee can produce in an hour.
	private int speed;
	// Data field items array holds the items produced by the employee.
	private Item[] items;
	// Data field payroll keeps the payroll of the employee.
	private Payroll payroll;
	
	// An Employee object represents an employee working for the factory.
	public Employee(int id , String name , String surname , int workHour , int speed) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.workHour = workHour;
		this.speed = speed;
	}
	/** startShift() method: 
	 * finds how many items this employee should produce according to speed and workHour values. 
	 * After that, it creates appropriate number of items with randomly generated ids between 1-100 and put them into items array. 
	 * It then returns items array. */
	public Item[] startShift() {
		int numberOfItems = workHour * speed;
		Item items[] = new Item[numberOfItems];
		for (int x = 0; x < numberOfItems;++x) {
			int randomNumberOfItems = ((int)(Math.random() * 100) + 1);
			items[x] = new Item(randomNumberOfItems);
		}
		return items;
	}
	/** endShift() method: creates a Payroll object with employee’s work hour and the number of items s/he creates. 
	 * It assigns this object to payroll data field. 
	 * It then returns payroll object.*/
	public Payroll endShift() {
		int numberOfItems = workHour * speed;
		Payroll payroll = new Payroll(workHour , numberOfItems);
		return payroll;
	}
	/** toString() method: 
	 * returns a String with employee’s id and the return value of the payroll object’s toString() method. */
	public String toString() {
		int numberOfItems = workHour * speed;
		return "This is the employee with id " + id + " speed " + speed + ". The work hour is " + workHour + " and the produced item count is " + numberOfItems + ".";
	}
	/** Id(Method) returns the value of the employee's Id.*/
	public int getId() {
		return id;
	}
}
// This Program uses End-of-line Style.