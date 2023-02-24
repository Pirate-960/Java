// Student Name: Abdelrahman Zahran.
// Student Number: 150120998.

/**
 * Each Developer has a set of projects that the developer works on and a numberOfDevelopers data fields.
 * Each Developer can be created with one of the given two constructors.
 * In Developer’s constructor, you are supposed to call the super class’s constructor.
 * When you create a new Developer, you should increment numberOfDevelopers value by 1.
 * In addProject method, you should add the given Projects s to the list of projects.
 * In removeProject method, you should remove the given Product s from the list of projects.
 * There are setter/getter and toString() methods.
 **/

import java.util.ArrayList;
import java.util.Calendar;

public class Developer extends RegularEmployee {
	//---------------------------------------------------------------------------------------------//
	/** Data Fields **/
	private ArrayList<Project> projects;
	public static int numberOfDevelopers;
	//---------------------------------------------------------------------------------------------//
	/** Main Method **/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//---------------------------------------------------------------------------------------------//
	/** no-argument Constructor **/
	public Developer() {
		super();
	}
	/** Constructor **/
	public Developer(int id , String firstName , String lastName , String gender , Calendar birthDate , String maritalStatus , 
			String hasDriverLicence , double salary , Calendar hireDate , Department department , double pScore , ArrayList<Project> p) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department, pScore);
		this.projects = projects;
		this.numberOfDevelopers = numberOfDevelopers;
		projects = p;
		numberOfDevelopers++;
	}
	/** Constructor **/
	public Developer(RegularEmployee re , ArrayList<Project> p) throws Exception {
		super(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(), re.getBirthDate(), re.getMaritalStatus(), re.getHasDriverLicence(), re.getSalary(), re.getHireDate(), re.getDepartment(), re.getPerformanceScore());
		this.projects = projects;
		this.numberOfDevelopers = numberOfDevelopers;
		projects = new ArrayList<Project>();
		projects = p;
		numberOfDevelopers++;
	}
	//---------------------------------------------------------------------------------------------//
	/** Methods **/
	//
	public boolean addProject(Project s) {
		projects.add(s);
		if (projects.contains(s)) {
			return true;
		}
		else {
			return false;
		}
	}
	//
	public boolean removeProject(Project s) {
		projects.remove(s);
		if (projects.contains(s)) {
			return false;
		}
		else {
			return true;	
		}
	}
	//---------------------------------------------------------------------------------------------//
	/** Setter and Getter Methods for of class data fields **/
	// Getter & Setter Methods for (ArrayList<Project> projects).
	public ArrayList<Project> getProjects() {
		return projects;
	}
	public void setProjects(ArrayList<Project> projects) {
		projects = projects;
	}
	
	// Getter & Setter Methods for (numberOfDevelopers).	
	public static int getNumberOfDevelopers() {
		return numberOfDevelopers;
	}
	public static void setNumberOfDevelopers(int numberOfDevelopers) {
		Developer.numberOfDevelopers = numberOfDevelopers;
	}
	//---------------------------------------------------------------------------------------------//
	/** ToString Method **/
	@Override
	public String toString() {
		return super.toString() + "				[projects=" + projects + "]";
	}
	//---------------------------------------------------------------------------------------------//
}
