// Student Name: Abdelrahman Zahran.
// Student Number: 150120998.

/**
 * Each Product has a name, saleDate and price data fields.
 * There are setter/getter and toString() methods.
 **/

import java.util.Calendar;

public class Product {
	//---------------------------------------------------------------------------------------------//
	/** Data Fields **/
	private String productName;
	private Calendar saleDate;
	private double price;
	//---------------------------------------------------------------------------------------------//
	/** Main Method **/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//---------------------------------------------------------------------------------------------//
	/** no-argument Constructor **/
	public Product() {

	}
	/** Constructor **/
	public Product(String sName , java.util.Calendar sDate , double price) throws Exception {
		this.productName = productName;
		this.saleDate = saleDate;
		this.price = price;
		setProductName(sName);
		saleDate = sDate;
		setPrice(price);
	}
	//---------------------------------------------------------------------------------------------//
	/** Setter and Getter Methods for of class data fields **/
	// Getter & Setter Methods for (productName).	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) throws Exception {
		if (productName.length() < 3) {
			throw new Exception ("Invalid Product Name.");
		}
		else {
			this.productName = productName;	
		}
	}
	
	// Getter & Setter Methods for (saleDate).	
	public Calendar getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Calendar saleDate) {
		this.saleDate = saleDate;
	}
	
	// Getter & Setter Methods for (price).	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) throws Exception {
		if (price < 0) {
			throw new Exception ("Invalid Price.");
		}
		else {
			this.price = price;	
		}
	}
	//---------------------------------------------------------------------------------------------//
	@Override
	public String toString() {
		if (saleDate.get(Calendar.MONTH) == 12) {
			return "Product [productName=" + productName + ", saleDate=" + saleDate.get(Calendar.DATE) + "/" + (saleDate.get(Calendar.MONTH) + 12) + "/" + (saleDate.get(Calendar.YEAR) - 1) + ", price=" + price + "]";
		}
		else {
			return "Product [productName=" + productName + ", saleDate=" + saleDate.get(Calendar.DATE) + "/" + saleDate.get(Calendar.MONTH) + "/" + saleDate.get(Calendar.YEAR) + ", price=" + price + "]";
		}
	}
	//---------------------------------------------------------------------------------------------//
}
