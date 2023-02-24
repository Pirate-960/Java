// Student Name: Abdelrahman Zahran.
// Student Number: 150120998.

/**
 * Person is the superclass of Customer and Employee classes.
 * Person class has several data fields, getter/setter and toString methods.
 * Each person should have an id, a name, a surname, a gender (1: woman, 2: man), birthDate (05/05/2000), maritalStatus (1: single, 2: married) and hasDriverLicense attributes.
 * Since the parameter/return value types are different for getter/setter methods of gender, maritalStatus, and hasDriverLicence attributes, we show them in the UML diagram. You are responsible for implementing getter/setter methods of all data fields.
 * In setGender method, a string value (“Man” or “Woman”) is given, and the method should set the gender as 1 or 2.
 * In getGender method, a string value (“Man” or “Woman”) should be returned based on the gender value.
 * In setMaritalStatus method, a string value (“Single” or “Married”) is given, and the method should set the maritalStatus as 1 or 2.
 * In getMaritalStatus method, a string value (“Single” or “Married”) should be returned based on the maritalStatus value.
 * In setHasDriverLicence method, a string value (“Yes” or “No”) is given, and the method should set the hasDriverLicence as true or false.
 * In getHasDriverLicence method, a string value (“Yes” or “No”) should be returned based on the hasDriverLicence value.
 * There are setter/getter and toString() methods.
 **/

import java.util.Calendar;

public class Person {
	//---------------------------------------------------------------------------------------------//
	/** Data Fields **/
	private int id;
	private String firstName;
	private String lastName;
	private byte gender;
	private Calendar birthDate;
	private byte maritalStatus;
	private boolean hasDriverLicence;
	//---------------------------------------------------------------------------------------------//
	/** Main Method **/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//---------------------------------------------------------------------------------------------//
	/** no-argument Constructor **/
	public Person(){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthDate = birthDate;
		this.maritalStatus = maritalStatus;
		this.hasDriverLicence = hasDriverLicence;
	}
	/** Constructor **/
	public Person(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence) throws Exception {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		getGender();
		getMaritalStatus();
		getHasDriverLicence();
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setGender(gender);
		setBirthDate(birthDate);
		setMaritalStatus(maritalStatus);
		setHasDriverLicence(hasDriverLicence);
	}
	//---------------------------------------------------------------------------------------------//
	/** Methods **/
	// Getter & Setter Methods for (gender).
	public void setGender(String gender) throws Exception {
		if (gender.equals("Woman")) {
			this.gender = 1;
			}
		else if (gender.equals("Man")) {
			this.gender = 2;
			}
		else {
			throw new Exception ("Invalid Gender, Pls try again(1. Woman , 2. Man).");
		}
	}
	//
	public String getGender() {
		String Gender = null;
		if (gender == 1) {
			Gender = "Woman";
			}
		else if (gender == 2){
			Gender = "Man";
			}
		return Gender;
	}
	// Getter & Setter Methods for (maritalStatus).
	public void setMaritalStatus(String status) throws Exception {
		if (status.equals("Single")) {
			this.maritalStatus = 1;
			}
		else if (status.equals("Married")) {
			this.maritalStatus = 2;
			}
		else {
			throw new Exception ("Invalid Marital Status, Pls try again(1.Single , 2.Married).");
			}
	}
	public String getMaritalStatus() {
		String Status = null;
		if (this.maritalStatus == 1) {
			Status = "Single";
			}
		else if (this.maritalStatus == 2) {
			Status = "Married";
			}
		return Status;
	}
	
	// Getter & Setter Methods for (hasDriverLicence).
	public void setHasDriverLicence(String info) throws Exception {
		if (info.equals("Yes")) {
			this.hasDriverLicence = true;
			}
		else if (info.equals("No")) {
			this.hasDriverLicence = true;
			}
		else {
			throw new Exception ("Invalid Input, Pls try again(Yes or No).");
			}	
	}
	public String getHasDriverLicence() {
		String info = null;
		if (this.hasDriverLicence == true) {
			info = "Yes";
			}
		else if (this.hasDriverLicence == false) {
			info = "No";
			}
		return info;
	}
	//---------------------------------------------------------------------------------------------//
	/** Setter and Getter Methods for of class data fields **/
	// Getter & Setter Methods for (id).
	public int getId() {
		return id;
	}
	public void setId(int id) throws Exception {
		if (id < 0) {
			throw new Exception ("Invalid ID.");
		}
		else {
			this.id = id;
		}
	}
	
	// Getter & Setter Methods for (firstName).
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) throws Exception {
		if (firstName.length() < 3) {
			throw new Exception ("Invalid First Name.");
		}
		else {
			this.firstName = firstName;
		}
	}
	
	// Getter & Setter Methods for (lastName).
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) throws Exception {
		if (lastName.length() < 3) {
			throw new Exception ("Invalid Last Name.");
		}
		else {
			this.lastName = lastName;	
		}
	}
	// Getter & Setter Methods for (birthDate).
	public Calendar getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}
	//---------------------------------------------------------------------------------------------//
	/** ToString Method **/
	@Override
	public String toString() {
		return "Person Info [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + getGender() + "]";
	}
	//---------------------------------------------------------------------------------------------//
}
