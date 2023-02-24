// Student Name: Abdelrahman Zahran.
// Student Number: 150120998.

/**
 *RegularEmployee is the superclass of SalesEmployee and Developer classes.
 *Each RegularEmployee has a performanceScore and an amount of bonus, which will be given by his/her manager based on the performance score. 
 * Each RegularEmployee can be created with one of the given two constructors.
 * In RegularEmployee’s constructor, you are supposed to call the super class’s constructor.
 * There are setter/getter and toString() methods. 
 **/

import java.util.Calendar;

public class RegularEmployee extends Employee {
	//---------------------------------------------------------------------------------------------//
	/** Data Fields **/
	private double performanceScore;
	private double bonus;
	//---------------------------------------------------------------------------------------------//
	/** Main Method **/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//---------------------------------------------------------------------------------------------//
	/** no-argument Constructor **/
	public RegularEmployee() {
		super();
	}

	/** Constructor **/
	public RegularEmployee(int id , String firstName , String lastName , String gender , Calendar birthDate , String maritalStatus ,
			String hasDriverLicence , double salary , Calendar hireDate , Department department , double performanceScore) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department);
		this.performanceScore = performanceScore;
		this.bonus = bonus;
		setPerformanceScore(performanceScore);
	}
	/** Constructor **/
	public RegularEmployee(Employee employee , double perfScore) throws Exception {
		super(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getBirthDate(),
				employee.getMaritalStatus(), employee.getHasDriverLicence(), employee.getSalary(), employee.getHireDate(), employee.getDepartment());
		this.performanceScore = performanceScore;
		this.bonus = bonus;
		setPerformanceScore(performanceScore);
	}
	//---------------------------------------------------------------------------------------------//
	/** Methods **/
	public static boolean contains(Object re) {
		return true;
	}
	//---------------------------------------------------------------------------------------------//
	/** Setter and Getter Methods for of class data fields **/
	// Getter & Setter Methods for (performanceScore).
	public double getPerformanceScore() {
		return performanceScore;
	}
	public void setPerformanceScore(double performanceScore) throws Exception {
		if (performanceScore < 0) {
			throw new Exception ("Invalid Perfomance Score.");
		}
		else {
			this.performanceScore = performanceScore;	
		}
	}
	
	// Getter & Setter Methods for (bonus).
	public double getBouns() {
		return bonus;
	}
	public void setBouns(double bonus) throws Exception {
		if (bonus < 0) {
			throw new Exception ("Invalid Bonus.");
		}
		else {
			this.bonus = bonus;	
		}
	}
	//---------------------------------------------------------------------------------------------//
	@Override
	public String toString() {
		return super.toString() + "				RegularEmployee Info [performanceScore=" + performanceScore + ", bonus=" + bonus + "]";
	}
	//---------------------------------------------------------------------------------------------//
}
