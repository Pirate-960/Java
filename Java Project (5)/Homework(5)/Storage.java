// Student Name: Abdelrahman Zahran.
// Student Number: 150120998.
/** Class Storage: shows the capacity of the storage + number of Items + size of the storage. */

import java.util.Arrays;

public class Storage {
	// Data field id capacity keeps the capacity (the maximum number of items that can be stored) of the Storage object created.
	private int capacity;
	// Data fields items array keeps the items put inside the storage.
	private Item[] Items;
	// Data field numberOfItems keeps the number of item objects created.
	private int numberOfItems;
	
	/** A Storage object represents a storage area for the factory. */
	public Storage(int capacity) {
		this.capacity = capacity;
		this.numberOfItems = 0;
		this.Items = new Item[this.capacity];		
	}		
	/**addItem(item:Item) method:
	 *  adds the item passed as the parameter to the items data field. 
	 *  Note that you need to resize the items array for this. */
	public void addItem(Item item) {
		int newArraySize = numberOfItems;
		Items[newArraySize] = item;
		numberOfItems++;	
	}
	/** getNumberOfItems() method to get the value of number of items. */
	public int getNumberOfItems() {
		return numberOfItems;
	}
	/**  getStorageCount() method to get the value of number of items.*/
	public double getStorageCount() {
		return numberOfItems;
	}
}
// This Program uses End-of-line Style.