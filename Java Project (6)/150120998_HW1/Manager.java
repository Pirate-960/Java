// Student Name: Abdelrahman Zahran.
// Student Number: 150120998.

/**
 * Each Manager has a set of regularEmployees working in his/her department and a bonusBudget to distribute to the regular employees in the department.
 * Each Manager can be created with one of the given two constructors.
 * In Manager’s constructor, you are supposed to call the super class’s constructor.
 * In addEmployee method, you should add the given RegularEmployee e to the list of regularEmployees.
 * In removeEmployee method, you should remove the given RegularEmployee e from the list of regularEmployees.
 * Each Manager has bonusBudget to distribute it to the regular employees working in his/her department. The distribution will be based on the given formula:
 * Suppose that the bonus budget of the manager is 10000 and there are 4 regular employees in the department with the following salaries and performance scores
 *  E1 → salary: 1000, performanceScore: 50
 *  E2 → salary: 2000, performanceScore: 50
 *  E3 → salary: 6000, performanceScore: 75
 *  E4 → salary: 4000, performanceScore: 100
 *  Then, the bonus value of each regular employee is:
 *  bonus = unit * salary * performanceScore
 *  unit = bonusBudget / Σ(𝐬𝐚𝐥𝐚𝐫𝐲 ∗ 𝐩𝐞𝐫𝐟𝐨𝐫𝐦𝐚𝐧𝐜𝐞𝐒𝐜𝐨𝐫𝐞)
 *  Based on the example above, the bonus value for each regular employee is:
 *   E1 → bonus: 500
 *   E2 → bonus: 1000
 *   E3 → bonus: 4500
 *   E4 → bonus: 4000
 * There are setter/getter and toString() methods.
**/

import java.util.ArrayList;
import java.util.Calendar;

public class Manager extends Employee {
	//---------------------------------------------------------------------------------------------//
	/** Data Fields **/
	private ArrayList<RegularEmployee> regularEmployees = new ArrayList<RegularEmployee>();
	private double bonusBudget; 
	//---------------------------------------------------------------------------------------------//
	/** Main Method **/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//---------------------------------------------------------------------------------------------//
	/** no-argument Constructor **/
	public Manager() {
		super();
	}
	/** Constructor **/
	public Manager(int id , String firstName , String lastName , String gender , Calendar birthDate , String maritalStatus ,
			String hasDriverLicence , double salary , Calendar hireDate , Department department , double bonusBudget) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department);
		this.regularEmployees = regularEmployees;
		this.bonusBudget = bonusBudget;
		setBonusBudget(bonusBudget);
		regularEmployees = new ArrayList<RegularEmployee>();
	}
	/** Constructor **/
	public Manager(Employee employee , double bonusBudget) throws Exception {
		super(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getBirthDate(),
				employee.getMaritalStatus(), employee.getHasDriverLicence(), employee.getSalary(), employee.getHireDate(), employee.getDepartment());
		this.regularEmployees = regularEmployees;
		this.bonusBudget = bonusBudget;
	}
	//---------------------------------------------------------------------------------------------//
	/** Methods **/
	public void addEmployee(RegularEmployee e) throws Exception {
		(this.regularEmployees).add(e);
	}
	public void removeEmployee(RegularEmployee e) throws Exception {
		(this.regularEmployees).remove(e);	
	}
	public void distributeBonusBudget() throws Exception {
		double unitDenominator = 0;
		double unit = 0;
		for (int i = 0; i <= regularEmployees.size(); ++i) {
				unitDenominator += regularEmployees.get(i).getSalary() * regularEmployees.get(i).getPerformanceScore();
		}
		unit = bonusBudget / (unitDenominator); 
		
		for (int j = 0; j <= regularEmployees.size(); ++j) {
			regularEmployees.get(j).setBouns(unit * regularEmployees.get(j).getSalary() * regularEmployees.get(j).getPerformanceScore()); 
		}
	}
	//---------------------------------------------------------------------------------------------//
	/** Setter and Getter Methods for of class data fields **/
	// Getter & Setter Methods for (ArrayList<RegularEmployee> regularEmployees).
	public ArrayList<RegularEmployee> getRegularEmployees() throws Exception {
		Object re = new RegularEmployee();
		if (RegularEmployee.contains(re)) {
			return regularEmployees;
		}
		else {
			throw new Exception();
		}
	}
	public void setRegularEmployees(ArrayList<RegularEmployee> regularEmployees) {
		this.regularEmployees = regularEmployees;
	}
	
	// Getter & Setter Methods for (bonusBudget).
	public double getBonusBudget() {
		return bonusBudget;
	}
	public void setBonusBudget(double bonusBudget) throws Exception {
		if (bonusBudget < 0) {
			throw new Exception ("Invalid Bonus Budget.");
		}
		else {
			this.bonusBudget = bonusBudget;
		}
	}
	//---------------------------------------------------------------------------------------------//
	/** ToString Method **/
	@Override
	public String toString() {
		return "Manager [id: " + getId() + ", " + getFirstName() + " " + getLastName() +  "			# of Employees: " + regularEmployees.size() + "]";
	}
	//---------------------------------------------------------------------------------------------//
}
