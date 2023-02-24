 // Student Name: Abdelrahman Zahran.
// Student Number: 150120998.

/**
 * SmartObject is an abstract superclass of SmartLight, SmartPlug and SmartCamera classes.
 * The data field alias represents the name of a smart device. Each device has a unique macId to connect to the internet. 
 * The data field IP (Internet Protocol) a networking protocol to communicate with other devices. 
 * The data field connectionStatus represents whether the smart object is connected to the internet or not.
 * */

public abstract class SmartObject {
	//------------------------------------------------------------------------------------------------------//
	/** Data Fields **/
	private String alias;
	private String macId;
	private String IP;
	private boolean connectionStatus;
	//------------------------------------------------------------------------------------------------------//
	/** Default Constructor **/
	public SmartObject() {

	}
	//------------------------------------------------------------------------------------------------------//
	/** Methods **/
	// Connects the smart object with the given IP value + sets -> (IP and connectionStatus) of the smart object.
	public boolean connect(String IP) {
		this.IP = IP;
		connectionStatus = true;
		return true;
	}
	
	// Disconnects the smart object + sets -> (IP and connectionStatus) of the smart object.
	public boolean disconnect() {
		IP = "";
		connectionStatus = false;
		return true;
	}
	
	// Prints the details about a smart object.
	public void SmartObjectToString() {
		System.out.println("This is SmartCamera device " + getAlias());
		System.out.println("\tMacId: " + getMacId());
		System.out.println("\tIP: " + getIP());
	}
	
	// Controls the connection of the smart object.
	public boolean controlConnection() {
		boolean controlValue = false;
		if (connect(IP) == true) {
			controlValue = true;
		}
		else if (disconnect() == true) {
			controlValue = false;
		}
		return controlValue;
	}
	/** Abstract Methods **/
	public abstract boolean testObject();
	public abstract boolean shutDownObject();
	//------------------------------------------------------------------------------------------------------//
	/** Setter and Getter Methods for the class data fields **/
	// Getter & Setter Methods for (alias).
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	// Getter & Setter Methods for (macId).
	public String getMacId() {
		return macId;
	}
	public void setMacId(String macId) {
		this.macId = macId;
	}
	
	// Getter & Setter Methods for (IP).
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	
	// Getter & Setter Methods for (connectionStatus).
	public boolean isConnectionStatus() {
		return connectionStatus;
	}
	public void setConnectionStatus(boolean connectionStatus) {
		this.connectionStatus = connectionStatus;
	}
	//------------------------------------------------------------------------------------------------------//
}