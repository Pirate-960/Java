// Student Name: Abdelrahman Zahran.
// Student Number: 150120998.

/**
 * SmartLight is a subclass of SmartObject class and it implements LocationControl and Programmable interfaces.
 * It has three data fields: hasLightTurned takes the value of true if the light is turned on. 
 * programTime keeps the exact time of automatic activation of the smart device.
 * programAction keeps the next action of the smart device (either turn on or turn off).
 */
import java.util.Calendar;

public class SmartLight extends SmartObject implements LocationControl , Programmable {
	//------------------------------------------------------------------------------------------------------//
	/** Data Fields **/
	private boolean hasLightTurned;
	private Calendar programTime;
	private boolean programAction;
	//------------------------------------------------------------------------------------------------------//
	/** Default Constructor **/
	public SmartLight() {
		super();
		this.hasLightTurned= hasLightTurned;
		this.programTime = programTime;
		this.programAction = programAction;
	}
	/** Constructor **/
	public SmartLight(String alias , String macId){
		super();
		this.hasLightTurned= hasLightTurned;
		this.programTime = programTime;
		this.programAction = programAction;
		setMacId(macId);
		setAlias(alias);
	}
	//------------------------------------------------------------------------------------------------------//
	/** Methods **/
	// Turn on the Light of the smartObject (Smart Light).
	public void turnOnLight() {
		super.connect(getIP());
		Calendar LightIsOn = Calendar.getInstance();
		if (hasLightTurned == true) {
			System.out.println(super.getAlias() + " - Living Room Light has been already turned on" 
		    + "(Current time: " + LightIsOn.get(Calendar.HOUR) + ":" + LightIsOn.get(Calendar.MINUTE) + ":" + LightIsOn.get(Calendar.SECOND) + ")");
		}
		else if (hasLightTurned == false) {
			hasLightTurned = true;
			System.out.println("Smart Light - " + super.getAlias() + " is turned on now " 
			+ "(Current time: " + LightIsOn.get(Calendar.HOUR) + ":" + LightIsOn.get(Calendar.MINUTE) + ":" + LightIsOn.get(Calendar.SECOND) + ")");
		}
		programAction = !hasLightTurned;
	}
	
	// Turn off the Light of the smartObject (Smart Light).
	public void turnOffLight() {
		super.connect(getIP());
		Calendar LightIsOff = Calendar.getInstance();
		if (hasLightTurned == true) {
			hasLightTurned = false;
			System.out.println("Smart Light - " + super.getAlias() + " is turned off now " 
			+ "(Current time: " + LightIsOff.get(Calendar.HOUR) + ":" + LightIsOff.get(Calendar.MINUTE) + ":" + LightIsOff.get(Calendar.SECOND) + ")");
		}
		else if (hasLightTurned == false) {
			System.out.println("Smart Light - " + super.getAlias() + " has been already turned off" 
		    + "(Current time: " + LightIsOff.get(Calendar.HOUR) + ":" + LightIsOff.get(Calendar.MINUTE) + ":" + LightIsOff.get(Calendar.SECOND) + ")");
		}
		programAction = hasLightTurned;
	}
	//------------------------------------------------------------------------------------------------------//
	/** Abstract Methods Implementation **/
	// The method setTimer should set the timer of a smart light with the given amount of seconds.
	@Override
	public void setTimer(int seconds) {
		super.connect(getIP());
		programTime = Calendar.getInstance();
		programTime.add(Calendar.SECOND , seconds);
		setProgramTime(programTime);
		if (hasLightTurned == true) {
			System.out.println("Smart light - " + super.getAlias() + " will be turned off "+ seconds + " seconds later!" 
		+ "(Current time: " + programTime.get(Calendar.HOUR) + ":" + programTime.get(Calendar.MINUTE) + ":" + programTime.get(Calendar.SECOND) + ")");
		}
		else if (hasLightTurned == false) {
			System.out.println("Smart light - " + super.getAlias() + " will be turned on "+ seconds + " seconds later!" 
					+ "(Current time: " + programTime.get(Calendar.HOUR) + ":" + programTime.get(Calendar.MINUTE) + ":" + programTime.get(Calendar.SECOND) + ")");
		}
	}
	
	// The method cancelTimer should check the connection of a smart light, and then it should cancel the timer of a smart light by assigning the value of null to the programTime property.
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
		 else if ((programTime != null)) {
			 if (programTime.get(Calendar.SECOND) == currentTime.get(Calendar.SECOND)) {
				 System.out.println("runProgram -> Smart Light - " + super.getAlias());
				 if (programAction == true) {
					 turnOnLight();
				 }
				 else {
					 turnOffLight();
				 }
			 }
		 }	 
		 programTime = null;
		 programAction = false;
		 // setProgramTime(null);
	}
	
	// The method onLeave should check the connection of a smart light firstly and then it should turn off the light.
	@Override
	public void onLeave() {
		super.connect(getIP());
		System.out.println("On Leave -> Smart Light - " + super.getAlias());
		turnOffLight();
	}
	
	// The method onCome should check the connection of a smart light firstly, and then it should turn on the light.
	@Override
	public void onCome() {
		super.connect(getIP());
		System.out.println("On Come -> Smart Light - " + super.getAlias());
		turnOnLight();
	}
	
	// Check the connection of a smart light + test the functionalities of the smart light.
	@Override
	public boolean testObject() {
		boolean connectionStatus = super.connect(getIP());
		System.out.println(super.getAlias() + " connection established");
		System.out.println("Test is starting for SmartLight");
		// In case Object is connected.
		if (connectionStatus == true) {
			super.connect(getIP());
			super.SmartObjectToString();
			turnOnLight();
			turnOffLight();
		}
		// In case Object is not connected.
		else if (connectionStatus == false) {
			System.out.println("This device is not connected. SmartLight -> " + super.getAlias());
			super.connect(getIP());
			super.SmartObjectToString();
		}
		System.out.println("Test completed for SmartLight");
		System.out.println();
		return connectionStatus;
	}
	
	// check the connection of a smart light + turn off the light of the smart object.
	@Override
	public boolean shutDownObject() {
		boolean connectionStatus = super.connect(getIP());
		if (connectionStatus == true) {
			super.SmartObjectToString();
			if (hasLightTurned == true) {
				this.hasLightTurned = false;
				turnOffLight();
			}
			else if (hasLightTurned == false) {
				turnOffLight();
			}
		}
		else if (connectionStatus == false) {
			super.SmartObjectToString();
		}
		return connectionStatus;
	}
	//------------------------------------------------------------------------------------------------------//
	/** Setter and Getter Methods for the class data fields **/
	// Getter & Setter Methods for (hasLightTurned).
	public boolean isHasLightTurned() {
		return hasLightTurned;
	}
	public void setHasLightTurned(boolean hasLightTurned) {
		this.hasLightTurned = hasLightTurned;
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