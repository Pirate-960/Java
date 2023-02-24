// Student Name: Abdelrahman Zahran.
// Student Number: 150120998.

/**
 * Employee is the superclass of Manager and RegularEmployee classes.
 * Each Employee has a salary, a hireDate (the date when the employee starts to the job), a department and numberofEmployees data fields.
 * Each Employee can be created with one of the given two constructors.
 * In Employee’s constructor, you are supposed to call the super class’s constructor.
 * When a new employee is created, you should increment the value of numberofEmployees by 1.
 * There are two overloaded implementations of raiseSalary method.
 * In the first one, take the increment value as a double (0 >= percent >= 1) and raise the salary value based on the percentage value. For example, if the percent value is 0.5, increment the salary of the employee by 50%.
 * In the second one, raise the salary of the employee by the given fixed amount.
 * There are setter/getter and toString() methods.
 **/

import java.util.Calendar;

public class Employee extends Person {
	//---------------------------------------------------------------------------------------------//
	/** Data Fields **/
	private double salary;
	private Calendar hireDate;
	private Department department;
	public static int numberOfEmployees; 
	//---------------------------------------------------------------------------------------------//
	/** Main Method **/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//---------------------------------------------------------------------------------------------//
	/** no-argument Constructor **/
	public Employee() {
		super();
	}
	/** Constructor **/
	public Employee(int id , String firstName , String lastName , String gender , Calendar birthDate ,
			String maritalStatus , String hasDriverLicence , double salary , Calendar hireDate , Department department) throws Exception {
		super(id , firstName , lastName ,  gender, birthDate, maritalStatus, hasDriverLicence );
		this.salary = salary;
		this.hireDate = hireDate;
		this.department = department;
		this.numberOfEmployees = numberOfEmployees;
		setSalary(salary);
		setHireDate(hireDate);
		setDepartment(department);
		numberOfEmployees++;
	}
	/** Constructor **/
	public Employee(Person person , double salary , Calendar hireDate , Department department) throws Exception {
		super(person.getId() , person.getFirstName() , person.getLastName() , person.getGender() , person.getBirthDate() , person.getMaritalStatus() , person.getHasDriverLicence());
		this.salary = salary;
		this.hireDate = hireDate;
		this.department = department;
		setSalary(salary);
		setHireDate(hireDate);
		setDepartment(department);
		this.numberOfEmployees = numberOfEmployees;
		numberOfEmployees++;
	}
	//---------------------------------------------------------------------------------------------//
	/** Methods **/
	// Raise the salary value of the employee by the percentage value.
	public double raiseSalary(double percent) throws Exception {
		double RaiseAmount;
		if (percent >= 0 && percent <= 1) {
			RaiseAmount = salary * percent;
			salary = salary + RaiseAmount;
			}
		else {
				throw new Exception ("Invalid Percent");
			}
		return salary;
	}
	// Raise the salary of the employee by a given fixed amount.
	public double raiseSalary(int amount) throws Exception {
		if (amount > 0) {
			salary = salary + amount;	
		}
		else if (amount < 0){
			throw new Exception("Invalid amount");
		}
		return salary;	
	}
	//---------------------------------------------------------------------------------------------//
	/** Setter and Getter Methods for of class data fields **/
	// Getter & Setter Methods for (salary).
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) throws Exception{
		if (salary < 0) {
			throw new Exception ("Invalid Salary.");
		}
		else {
			this.salary = salary;	
		}
	}
	
	// Getter & Setter Methods for (hireDate).
	public Calendar getHireDate() {
		return hireDate;
	}
	public void setHireDate(Calendar hireDate) {
		this.hireDate = hireDate;
	}
	
	// Getter & Setter Methods for (department).
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	// Getter & Setter Methods for (numberofEmployees).
	public static int getNumberofEmployees() {
		return numberOfEmployees;
	}
	public void setNumberofEmployees(int numberofEmployees) {
		this.numberOfEmployees = numberofEmployees;
	}
	//---------------------------------------------------------------------------------------------//
	@Override
	public String toString() {
		if (hireDate.get(Calendar.MONTH) == 12) {
			return super.toString() + "				Employee Info [salary=" + salary + ", hireDate=" + hireDate.get(Calendar.DATE) + "/" + (hireDate.get(Calendar.MONTH) + 12) + "/" + (hireDate.get(Calendar.YEAR) - 1) + "]";
		}
		else {
			return super.toString() + "				Employee Info [salary=" + salary + ", hireDate=" + hireDate.get(Calendar.DATE) + "/" + hireDate.get(Calendar.MONTH) + "/" + hireDate.get(Calendar.YEAR) + "]";
		}
	}
	//---------------------------------------------------------------------------------------------//
}
