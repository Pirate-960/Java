// Student Name: Abdelrahman Zahran.
// Student Number: 150120998.
/** Class Factory: A full-Scan of all the factory's components starting from 
 * (Revenue , paid salaries , employees number , adding more employees , removing employees , calculating the payrolls of the factory). */

import java.util.Arrays;

public class Factory {
	// Data field name represents the name of the factory.
    private String name;
    // Data field employees represents employees working for the factory.
    private Employee[] employees;
    // Data field id capacity keeps the capacity (the maximum number of items that can be stored) of the Storage object created.
    private int capacity;
    // Data field storage represents the storage area of the factory.
    private Storage storage;
    // Data field payrolls represents the payrolls belonging to the employees.
    private Payroll[] payrolls;
    // Data field itemPrice represents the price for one item (Suppose that all items have the same price).
    private double itemPrice;
    
    /** A Factory object represents a factory with employees. */
    public Factory(String name, int capacity, double itemPrice){
        this.name = name;
        this.capacity = capacity;
        this.itemPrice = itemPrice;
        this.storage = storage;
        storage = new Storage(capacity);
        //(0) size of arrays.
        employees = new Employee[0];
        payrolls = new Payroll[0];
    }
    /** getRevenue() method:
     *  returns the revenue according to the number of items in the storage data field and itemPrice data field. */
    public double getRevenue() {
    	double revenueValue = storage.getStorageCount() * itemPrice;
        return revenueValue;
    }
    /** getPaidSalaries() method: calculates the paid salaries of the employees according to the payrolls array. 
     * Note that you need to use calculateSalary() method of payroll objects in payrolls array. */
    public double getPaidSalaries() {
        double paidSalary = 0;
        for(Payroll payroll : payrolls) {
        	paidSalary += payroll.calculateSalary();
        }
        return paidSalary;
    }
    /** addEmployee(employee:Employee) method: 
     * adds an employee to the employees array.
     * Note that you need to resize the employees array for this.
     * Then, you need to call startShift() method of the newly added employee and add all the items returned from startShift() method to storage, 
     * using addItem(item:Item) method of storage data field. */
    public void addEmployee(Employee employee) {
		if (employees == null) {
			int x = 1;
			employees = new Employee[x];
			int y = 0;
			employees[y] = employee;
		}
		else {
			employees = Arrays.copyOf(employees, employees.length + 1);
		}
		employees[employees.length - 1] = employee; 
        //start shift
        Item[] Items = employees[employees.length - 1].startShift();
        //add item to storage
        for(Item item : Items){
            storage.addItem(item);
        }
    }
    /** removeEmployee(id:int) method: 
     * removes the employee from employees array.
     * If there are no employees, it prints an appropriate error message.
     * If the employee with a given id is not found, it prints an appropriate error message.
     * If the employee is found, it removes employee from the employees array.
     * Note that you need to resize the employees array for this.
     * Then, you need to call endShift() method of the newly removed employee and call addPayroll(payroll:Payroll) method with the returned payroll by the endShift() method.
     * At the end, you need to return the removed employee. */
    public Employee removeEmployee(int id){
    	// Employees = (0).
    	if (employees == null || employees.length == 0) {
    		System.out.println("There are no employees!");
    		return null;
    	}
    	int employeeIndexNumber = -1; 
    	for (int i = 0; i < employees.length; ++i) {
    		if (employees[i].getId() == id) {
    			employeeIndexNumber = i;
    			break;
    		}
    	}
    	// Invalid Input. 
    	if (employeeIndexNumber == -1) {
    		System.out.println("Employee does not exist!");
    		return null;
    	}
    	Employee removedNumberOfEmployees = employees[employeeIndexNumber];
    	Payroll valueOfEndShiftPayroll = (removedNumberOfEmployees.endShift());
    	addPayroll(valueOfEndShiftPayroll);
    	System.arraycopy(employees, employeeIndexNumber + 1, employees, employeeIndexNumber, employees.length - employeeIndexNumber - 1);
    	return removedNumberOfEmployees;
    }
    /** addPayroll(payroll:Payroll) method:
     *  adds the payroll passed as the parameter to the payrolls data field. 
     *  Note that you need to resize the payrolls array for this. */
    public void addPayroll(Payroll payroll){
        if (payrolls == null) {
        	payrolls = new Payroll[1];
        } 
        else {
            payrolls = Arrays.copyOf(payrolls, payrolls.length + 1);
        }
        payrolls[payrolls.length - 1] = payroll;
    }
}
// This Program uses End-of-line Style.