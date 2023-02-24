// Student Name: Abdelrahman Zahran.
// Student Number: 150120998.

/**
 * SmartHome represents a smart house containing several smart objects (smartObjects are kept in smartObjectList). 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class SmartHome {
	//------------------------------------------------------------------------------------------------------//
	/** Data Fields **/
	private ArrayList<SmartObject> smartObjectList = new ArrayList<>();
	//------------------------------------------------------------------------------------------------------//
	/** Default Constructor **/
	public SmartHome() {
		
	}
	//------------------------------------------------------------------------------------------------------//
	/** Methods **/
	// The addSmartObject method adds the given smartObject to the smartObjectList. Firstly, it invokes connect method of the smartObject by sending its IP value.
	public boolean addSmartObject(SmartObject smartobject) {
		System.out.println("---------------------------------------------------------------------------" 
	+"\n---------------------------------------------------------------------------" 
				+ "\nAdding new SmartObject" 
	+ "\n---------------------------------------------------------------------------");
		if (smartObjectList.contains(smartobject)) {
			String IP = "10.0.0." + (smartObjectList.size() + 100);
			smartobject.connect(IP);
			smartObjectList.add(smartobject);
			smartobject.testObject();
		}
		else if (!smartObjectList.contains(smartobject)) {
			String IP = "10.0.0." + (smartObjectList.size() + 100);
			smartobject.connect(IP);
			smartObjectList.add(smartobject);
			smartobject.testObject();
		}
		return true;
	}
	
	// The removeSmartObject method removes the given smartObject from the smartObjectList.
	public boolean removeSmartObject(SmartObject smartobject) {
		if (smartObjectList.contains(smartobject)) {
			smartObjectList.remove(smartobject);
		}
		return true;
	}
	
	// The controlLocation method should traverse the smartObjectList -> an object implementing LocationControl interface- > invoke either onCome or onLeave method of it by checking the onCome boolean parameter.
	public void controlLocation(boolean onCome) {
		System.out.println("---------------------------------------------------------------------------" 
	+ "\n---------------------------------------------------------------------------" 
				+ "\nLocationControl: OnCome" 
	+ "\n---------------------------------------------------------------------------");
		for (SmartObject smartObject: smartObjectList) {
			if (smartObject instanceof LocationControl) {
				if (onCome == true) {
					((LocationControl)smartObject).onCome();
				}
				else if (onCome == false) {
					((LocationControl)smartObject).onLeave();
				}
			}
		}
	}
	
	// The controlMotion method should traverse the smartObjectList and if it finds an object implementing MotionControl interface, then, it should invoke its method controlMotion by sending hasMotion and isDay boolean parameters.
	public void controlMotion(boolean hasMotion , boolean isDay) {
		System.out.println("---------------------------------------------------------------------------" 
	+ "\n---------------------------------------------------------------------------" 
				+ "\nMotionControl: HasMotion, isDay" 
	+ "\n---------------------------------------------------------------------------");
		for (SmartObject smartObject: smartObjectList) {
			if (smartObject instanceof MotionControl) {
				((MotionControl)smartObject).controlMotion(hasMotion, isDay);
			}
		}
	}
	
	// The controlProgrammable method should traverse the smartObjectList and if it finds an object implementing Programmable interface, then, it should invoke its method runProgram.
	public void controlProgrammable() {
		System.out.println("---------------------------------------------------------------------------" 
	+ "\n---------------------------------------------------------------------------" 
				+ "\nProgrammable: runProgram" 
	+ "\n---------------------------------------------------------------------------");
		for (SmartObject smartObject: smartObjectList) {
			if (smartObject instanceof Programmable) {
				if (smartObject instanceof SmartLight) {
					((SmartLight)smartObject).runProgram();
				}
				if (smartObject instanceof SmartPlug) {
					((SmartPlug)smartObject).runProgram();
				}
			}
		}
	}
	
	// • The controlTimer method should traverse the smartObjectList and it should search for a smart object implementing Programmable interface. In case of finding such an object, it should invoke setTimer method of it if the given seconds value is greater than 0, and it should invoke cancelTimer method if the given seconds value is equal to 0.
	public void controlTimer(int seconds) {
		System.out.println("---------------------------------------------------------------------------" 
	+ "\n---------------------------------------------------------------------------" 
				+ "\nProgrammable: Timer = 10 seconds" 
	+ "\n---------------------------------------------------------------------------");
		for (SmartObject smartObject: smartObjectList) {
			if (smartObject instanceof Programmable) {
				if (seconds == 10) {
					((Programmable)smartObject).setTimer(seconds);
				}
				else if (seconds > 0) {
					((Programmable)smartObject).cancelTimer();
				}
			}
		}
	}
	
	// The controlTimerRandomly method should traverse the smartObjectList and it should search for a smart object implementing Programmable interface. In case of finding such an object, it should invoke its method setTimer with the value of 5 or 10 seconds randomly. If the random number is 0, then it should invoke cancelTimer method.
	public void controlTimerRandomly() {
		System.out.println("---------------------------------------------------------------------------" 
	+ "\n---------------------------------------------------------------------------" 
				+ "\nProgrammable: Timer = 5 or 10 seconds randomly" 
	+ "\n---------------------------------------------------------------------------");

		for (SmartObject smartObject: smartObjectList) {
			if (smartObject instanceof Programmable) {
				int seconds = (int) (Math.random() * 11);
				if (seconds < 5 && seconds != 0) {
					seconds = 5;
				}
				if (seconds > 5 && seconds <= 10) {
					seconds = 10;
				}
				if (seconds == 5  || seconds == 10) {
					((Programmable)smartObject).setTimer(seconds);
					if (smartObject instanceof SmartLight) {
						((SmartLight)smartObject).setTimer(seconds);
					}
					else if (smartObject instanceof SmartPlug) {
						((SmartPlug)smartObject).setTimer(seconds);
					}
				}
				else if (seconds == 0) {
					((Programmable)smartObject).cancelTimer();
					}	
				}
			}
	}
	
	// The sortCameras method should traverse the smartObjectList and it should search for smart cameras implementing Comparable interface. Then, it should invoke Arrays.sort method to sort smart cameras based on the battery life.
	public void sortCameras() {
		System.out.println("---------------------------------------------------------------------------" 
	+ "\n---------------------------------------------------------------------------" 
				+ "\nSort Smart Cameras" 
	+ "\n---------------------------------------------------------------------------");
		ArrayList<SmartCamera> smartCameraArrayList = new ArrayList<>();
		for(SmartObject smartCamera : smartObjectList) {
			if(smartCamera instanceof Comparable) {
				smartCameraArrayList.add((SmartCamera)smartCamera);
			}
		}	
		for(SmartCamera smartCamera : smartCameraArrayList) {
			System.out.println(smartCamera.toString());
		}
	}
	//------------------------------------------------------------------------------------------------------//
	/** Setter and Getter Methods for the class data fields **/
	// Getter & Setter Methods for (smartObjectList).
	public ArrayList<SmartObject> getSmartObjectList() {
		return smartObjectList;
	}

	public void setSmartObjectList(ArrayList<SmartObject> smartObjectList) {
		this.smartObjectList = smartObjectList;
	}
	//------------------------------------------------------------------------------------------------------//
}
