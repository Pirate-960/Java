// Student Name: Abdelrahman Zahran.
// Student Number: 150120998.
/** Class Payroll: Calculates 
 * the number of hours the workers worked 
 * + the number of items been produced by the worker 
 * + the time in the which the items been produced in 
 * + the payroll of the factory (Salary + Items). */

public class Payroll {
	// Data field workHour keeps the number of hours an employee has worked.
	private int workHour;
	// Data field itemCount keeps the number of items an employee has produced.
	private int itemCount;
	
	// A Payroll object represents the payroll of the employees.
	public Payroll(int workHour , int itemCount) {
		this.workHour = workHour;
		this.itemCount = itemCount;
	}
	/** Payroll object(constructor) */
	public Payroll(Payroll endShift) {
	}
	/** calculateSalary() method: 
	 * calculates salary of the employee according to the number of hours an employee has worked 
	 * and the number of items produced.
	 * */
	public int calculateSalary() {
		int salary = workHour * 3 + itemCount * 2;
		return salary;		
	}
	/** toString() method: 
	 * returns a String containing information about the work hour and the item count of the payroll.
	 * */
	public String toString() {
		return "The work hour is " + workHour + " and the produced item count is " + itemCount + ".";		
	}
}
// This Program uses End-of-line Style.