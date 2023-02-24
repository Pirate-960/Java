// Student Name: Abdelrahman Zahran.
// Student Number: 150120998.

/**
 * Each Customer can be created with one of the given two constructors.
 * In Customer’s constructor, you are supposed to call the super class’s constructor.
 * Each Customer has a list of products that he/she bought.
 * There are setter/getter and toString() methods.
 **/

import java.util.ArrayList;
import java.util.Calendar;

public class Customer extends Person {
	//---------------------------------------------------------------------------------------------//
	/** Data Fields **/
	private ArrayList<Product> products; 
	//---------------------------------------------------------------------------------------------//
	/** Main Method **/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//---------------------------------------------------------------------------------------------//
	/** no-argument Constructor **/
	public Customer() {
		super();
	}
	/** Constructor **/
	public Customer(int id , String firstName , String lastName , String gender ,
			Calendar birthDate , String maritalStatus ,String hasDriverLicence , ArrayList<Product> products) throws Exception{
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence);
		this.products = products;
		products.addAll(products);
		products = new ArrayList<Product>();
	}
	/** Constructor **/
	public Customer(Person person , ArrayList<Product> products) throws Exception {
		super(person.getId() , person.getFirstName() , person.getLastName() , person.getGender() , person.getBirthDate() , person.getMaritalStatus() , person.getHasDriverLicence());
		this.products = products;
	}
	//---------------------------------------------------------------------------------------------//
	/** Setter and Getter Methods for of class data fields **/
	// Getter & Setter Methods for (ArrayList<Product> products).
	public ArrayList<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	//---------------------------------------------------------------------------------------------//
	/** ToString Method **/
	@Override
	public String toString() {
		return "Customer [id: " + getId() + " " + "products=" + products + "]";
	}
	//---------------------------------------------------------------------------------------------//
}
