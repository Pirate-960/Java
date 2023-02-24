// Student Name: Abdelrahman Zahran.
// Student Number: 150120998.

/**
 * Each SalesEmloyee has a set of sales that contains a product list that the SalesEmployee sells and a numberOfSalesEmployees data fields.
 * Each SalesEmloyee can be created with one of the given two constructors.
 * In SalesEmloyee’s constructor, you are supposed to call the super class’s constructor.
 * When you create a new SalesEmloyee, you should increment numberOfSalesEmployees value by 1.
 * In addSale method, you should add the given Product s to the list of sales.
 * In removeSale method, you should remove the given Product s from the list of sales
 * here are setter/getter and toString() methods.
 **/

import java.util.ArrayList;
import java.util.Calendar;

public class SalesEmployee extends RegularEmployee {
	//---------------------------------------------------------------------------------------------//
	/** Data Fields **/
	private ArrayList<Product> sales;
	public static int numberOfSalesEmployees;
	//---------------------------------------------------------------------------------------------//
	/** Main Method **/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//---------------------------------------------------------------------------------------------//
	/** no-argument Constructor **/
	public SalesEmployee() {
		super();
	}
	/** Constructor **/
	public SalesEmployee(int id , String firstName , String lastName , String gender , Calendar birthDate , String maritalStatus ,
			String hasDriverLicence , double salary , Calendar hireDate , Department department , double pScore , ArrayList<Product> s) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department, pScore);
		this.sales = sales;
		this.numberOfSalesEmployees = numberOfSalesEmployees;
		sales = new ArrayList<Product>();
		sales = s;
		numberOfSalesEmployees++;
	}
	/** Constructor **/
	public SalesEmployee(RegularEmployee re , ArrayList<Product> s) throws Exception {
		super(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(), re.getBirthDate(), re.getMaritalStatus(),
				re.getHasDriverLicence(), re.getSalary(), re.getHireDate(), re.getDepartment(), re.getPerformanceScore());
		this.sales = sales;
		this.numberOfSalesEmployees = numberOfSalesEmployees;
		sales = s;
		numberOfSalesEmployees++;
	}
	//---------------------------------------------------------------------------------------------//
	/** Methods **/
	public boolean addSale(Product s) {
		sales.add(s);
		if (sales.contains(s)) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean removeSale(Product s) {
		sales.remove(s);
		if (sales.contains(s)) {
			return false;
		}
		else {
			return true;
		}
	}
	//---------------------------------------------------------------------------------------------//
	/** Setter and Getter Methods for of class data fields **/
	// Getter & Setter Methods for ().
	public ArrayList<Product> getSales() {
		return sales;
	}
	public void setSales(ArrayList<Product> sales) {
		this.sales = sales;
	}
	
	// Getter & Setter Methods for ().
	public static int getNumberOfSalesEmployees() {
		return numberOfSalesEmployees;
	}
	public static void setNumberOfSalesEmployees(int numberOfSalesEmployees) {
		SalesEmployee.numberOfSalesEmployees = numberOfSalesEmployees;
	}
	//---------------------------------------------------------------------------------------------//
	@Override
	public String toString() {
		return super.toString() + "				[Product " + sales + "]";
	}
	//---------------------------------------------------------------------------------------------//
}
