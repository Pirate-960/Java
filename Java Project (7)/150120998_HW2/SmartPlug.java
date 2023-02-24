// Student Name: Abdelrahman Zahran.
// Student Number: 150120998.

/**
 * SmartPlug is a subclass of SmartObject class and it implements Programmable interface.
 * It has three data fields: status takes the value of true if the plug is turned on. 
 * programTime keeps the exact time of automatic activation of the smart device. 
 * programAction keeps the next action of the smart device (either turn on or turn off).
 */
import java.util.Calendar;

public class SmartPlug extends SmartObject implements Programmable {
	//------------------------------------------------------------------------------------------------------//
	/** Data Fields **/
	private boolean status;
	private Calendar programTime;
	private boolean programAction;
	//------------------------------------------------------------------------------------------------------//
	/** Default Constructor **/
	public SmartPlug() {
		super();
		this.status = status;
		this.programTime = programTime;
		this.programAction = programAction;
	}
	/** Constructor **/
	public SmartPlug(String alias , String macId) {
		super();
		this.status = status;
		this.programTime = programTime;
		this.programAction = programAction;
		setMacId(macId);
		setAlias(alias);
	}
	//------------------------------------------------------------------------------------------------------//
	/** Methods **/
	// Turn on the Plug of the smartObject (Smart Plug).
	public void turnOn() {
		super.connect(getIP());
		Calendar plugIsOn = Calendar.getInstance();
		if (status == true) {
			System.out.println("Smart Plug - " + super.getAlias() + " has been already turned on" 
		    + "(Current time: " + plugIsOn.get(Calendar.HOUR) + ":" + plugIsOn.get(Calendar.MINUTE) + ":" + plugIsOn.get(Calendar.SECOND) + ")");
		}
		else if (status == false) {
			status = true;
			System.out.println("Smart Plug - " + super.getAlias() + " is turned on now " 
			+ "(Current time: " + plugIsOn.get(Calendar.HOUR) + ":" + plugIsOn.get(Calendar.MINUTE) + ":" + plugIsOn.get(Calendar.SECOND) + ")");
		}
		programAction = !status;
	}
	
	// Turn off the Plug of the smartObject (Smart Plug).
	public void turnOff() {
		super.connect(getIP());
		Calendar plugIsOff = Calendar.getInstance();
		if (status == true) {
			status = false;
			System.out.println("Smart Plug - " + super.getAlias() + " is turned off now " 
			+ "(Current time: " + plugIsOff.get(Calendar.HOUR) + ":" + plugIsOff.get(Calendar.MINUTE) + ":" + plugIsOff.get(Calendar.SECOND) + ")");
		}
		else if (status == false) {
			System.out.println("Smart Plug - " + super.getAlias() + " has been already turned off " + "(Current time: " 
		    + plugIsOff.get(Calendar.HOUR) + ":" + plugIsOff.get(Calendar.MINUTE) + ":" + plugIsOff.get(Calendar.SECOND) + ")");
		}
		programAction = status;
	}
	//------------------------------------------------------------------------------------------------------//
	/** Abstract Methods Implementation **/
	// The method setTimer should set the timer of a smart light with the given amount of seconds.
	@Override
	public void setTimer(int seconds) { 
		super.connect(getIP());
		this.programTime = Calendar.getInstance();
		programTime.add(Calendar.SECOND , seconds);
		setProgramTime(programTime);
		if (status == true) {
			System.out.println("Smart plug - " + super.getAlias() + " will be turned off " + seconds + " seconds later!" 
		+ "(Current time: " + programTime.get(Calendar.HOUR) + ":" + programTime.get(Calendar.MINUTE) + ":" + programTime.get(Calendar.SECOND) + ")");
		}
		else if (status == false) {
			System.out.println("Smart plug - " + super.getAlias() + " will be turned on " + seconds + " seconds later!" 
		+ "(Current time: " + programTime.get(Calendar.HOUR) + ":" + programTime.get(Calendar.MINUTE) + ":" + programTime.get(Calendar.SECOND) + ")");	
		}
	}
	
	// The method cancelTimer should check the connection of a Smart Plug, and then it should cancel the timer of a smart Plug by assigning the value of null to the programTime property.
	@Override
	public void cancelTimer() {
		super.connect(getIP());
		programTime = null;
		setProgramTime(programTime);
	}
	
	// The method runProgram should check the connection of a smart light -> turn on or turn off the light.
	@Override
	public void runProgram() {
		 super.connect(getIP());
		 Calendar currentTime = Calendar.getInstance();
		 if (programTime == null) {
			 
		 }
		 else if (programTime != null) {
			 if (programTime.get(Calendar.SECOND) == currentTime.get(Calendar.SECOND)) {
				 System.out.println("runProgram -> Smart Plug - " + super.getAlias());
				 if (programAction == true) {
					 turnOn();
				 }
				 else {
					 turnOff();
				 }
			 }
		 }	 
		 programTime = null;
		 programAction = false;
		 // setProgramTime(null);
	}
	
	// Check the connection of a Smart Plug + test the functionalities of the Smart Plug.
	@Override
	public boolean testObject() {
		boolean connectionStatus = super.connect(getIP());
		System.out.println(getAlias() + " connection established");
		System.out.println("Test is starting for SmartPlug");
		// In Case Object is connected.
		if (connectionStatus == true) {
			connect(getIP());
			super.SmartObjectToString();
			turnOn();
			turnOff();
		}
		// In case Object is not connected.
		else if (connectionStatus == false) {
			System.out.println("This device is not connected. SmartPlug -> " + super.getAlias());
			super.connect(getIP());
			super.SmartObjectToString();
		}
		System.out.println("Test completed for SmartPlug");
		System.out.println();
		return connectionStatus;
	}
	
	// check the connection of a Smart Plug + turn off the Plug of the smart object.
	@Override
	public boolean shutDownObject() {
		boolean connectionStatus = super.connect(getIP());
		if (connectionStatus == true) {
			super.SmartObjectToString();
			if (status == true) {
				this.status = false;
				turnOff();
			}
			else if (status == false) {
				turnOff();
			}
		}
		else if (connectionStatus == false) {
			super.SmartObjectToString();
		}
		return connectionStatus;
	}
	//------------------------------------------------------------------------------------------------------//
	/** Setter and Getter Methods for the class data fields **/
	// Getter & Setter Methods for (status).
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	// Getter & Setter Methods for (programTime).
	public Calendar getProgramTime() {
		return programTime;
	}
	public void setProgramTime(Calendar programTime) {
		this.programTime = programTime;
	}
	
	// Getter & Setter Methods for (programAction).
	public boolean isProgramAction() {
		return programAction;
	}
	public void setProgramAction(boolean programAction) {
		this.programAction = programAction;
	}
	//------------------------------------------------------------------------------------------------------//
}