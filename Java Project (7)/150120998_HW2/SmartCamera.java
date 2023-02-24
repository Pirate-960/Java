// Student Name: Abdelrahman Zahran.
// Student Number: 150120998.

/**
 * SmartCamera is a subclass of SmartObject class and it implements MotionControl and Comparable interfaces.
 * It has three data fields: status takes the value of true if the camera is recording. 
 * batteryLife represents the battery life of the camera. 
 * nightVision represents the night vision feature of the camera. 
 */
public class SmartCamera extends SmartObject implements MotionControl , Comparable<SmartCamera>{
	//------------------------------------------------------------------------------------------------------//
	/** Data Fields **/
	private boolean status;
	private int batteryLife;
	private boolean nightVision;
	//------------------------------------------------------------------------------------------------------//
	/** Default Constructor **/
	public SmartCamera() {
		this.nightVision = nightVision;
		this.batteryLife = batteryLife;
	}
	/** Constructor **/
	public SmartCamera(String alias , String macId , boolean nightVision , int batteryLife) {
		super();
		this.nightVision = nightVision;
		this.batteryLife = batteryLife;
		setMacId(macId);
		setAlias(alias);
		setBatteryLife(batteryLife);
		setNightVision(nightVision);
	}
	//------------------------------------------------------------------------------------------------------//
	/** Methods **/
	// The recordOn method should check the followings firstly: the connection of a smart camera, the isDay value and the nightVision feature of the smart camera.
	public void recordOn(boolean isDay) {
		super.connect(getIP());
		status = true;
		if (status == true) {
			if (isDay == true) {
				System.out.println("Smart Camera - " + super.getAlias() + " is turned on now");
				System.out.println("Smart Camera - " + super.getAlias() + " Cam is turned off now");
			}
			else if (isDay == false) {
				if (nightVision == true) {
					System.out.println("Smart Camera - " + super.getAlias() + " is turned on now");
					System.out.println("Smart Camera - " + super.getAlias() + " Cam is turned off now");
				}
				else if (nightVision == false) {
					System.out.println("Sorry! Smart Camera - " + super.getAlias() + " does not have night vision feature.");
					System.out.println("Smart Camera - " + super.getAlias() + " Cam is turned off now");
				}
			}
		}
		else {
			 System.out.println("Smart Camera - " + super.getAlias() + " has been already turned on");
			 System.out.println("Smart Camera - " + super.getAlias() + " Cam is turned off now");
		}
	}
	
	// The recordOff method should check the connection of a smart camera firstly and it should stop recording.
	public void recordOff() {
		super.connect(getIP());
		if (status == true) {
			this.status = false;
			System.out.println("Smart Camera - " + super.getAlias() + " Cam is turned off now");
		}
		else if (status == false) {
			System.out.println("Smart Camera - " + super.getAlias() + "Cam has been already turned off");
		}
		setStatus(false);
	}
	
	// The compareTo method should check the batteryLife of the smart camera with the given parameter smartCamera.
	@Override
	public int compareTo(SmartCamera smartCamera) {
		int batteryStatus = 0;
		if (this.batteryLife > smartCamera.batteryLife) {
			batteryStatus = 1;
		}
		else if (this.batteryLife == smartCamera.batteryLife) {
			batteryStatus = 0;
		}
		else if (this.batteryLife < smartCamera.batteryLife) {
			batteryStatus = -1;
		}
		return batteryStatus;
	}
	//------------------------------------------------------------------------------------------------------//
	/** Abstract Methods Implementation **/
	// The controlMotion method should check the hasMotion parameter.
	@Override
	public boolean controlMotion(boolean hasMotion, boolean isDay) {
		boolean ReturnValue = false;
		if (hasMotion == true && isDay == true) {
			ReturnValue = true;
			System.out.println("Motion detected!");
			System.out.println("Smart Camera - " + super.getAlias() + " is turned on now");
		}
		else if (hasMotion == true && isDay == false) {
			ReturnValue = true;
			System.out.println("Motion detected!");
			if (nightVision == true) {
				System.out.println("Smart Camera - " + super.getAlias() + " is turned on now");
			}
		}
		else if (hasMotion == false && isDay == true) {
			ReturnValue = false;
			System.out.println("Motion not detected!");	
			System.out.println("Smart Camera - " + super.getAlias() + " is turned off now");
		}
		else if (hasMotion == false && isDay == false) {
			ReturnValue = false;
			System.out.println("Motion not detected!");	
			if (nightVision == true) {
				System.out.println("Smart Camera - " + super.getAlias() + " is turned off now");
			}
		}
		return ReturnValue;
	}

	// The testObject method should check the connection of a smart camera firstly and it should test the functionalities of the smart camera.
	@Override
	public boolean testObject() {
		boolean connectionStatus = super.connect(getIP());
		System.out.println(getAlias() + " connection established");
		System.out.println("Test is starting for SmartCamera");
		// In Case Object is connected.
		if (connectionStatus == true) {
			connect(getIP());
			super.SmartObjectToString();
			System.out.println("Test is starting for SmartCamera day time");
			recordOn(true);
			System.out.println("Test is starting for SmartCamera night time");
			recordOn(false);
		}
		// In case Object is not connected.
		else if (connectionStatus == false) {
			System.out.println("This device is not connected. SmartCamera -> " + super.getAlias());
			super.connect(getIP());
			super.SmartObjectToString();
		}
		System.out.println("Test completed for SmartCamera");
		System.out.println();
		return connectionStatus;
	}

	// The shutDownObject method should check the connection of a smart camera firstly. Then, it should turn off it (if it has been already turned on).
	@Override
	public boolean shutDownObject() {
		boolean ReturnValue = false;
		super.connect(getIP());
		super.SmartObjectToString();
		if (super.controlConnection() == true) {
			ReturnValue = true;
			if (status == true) {
				recordOff();
				this.status = false;
			}
			else if (status == false) {
				recordOff();
			}
		}
		else if (super.controlConnection() == false) {
			ReturnValue = false;
		}
		return ReturnValue;
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
	
	// Getter & Setter Methods for (batteryLife).
	public int getBatteryLife() {
		return batteryLife;
	}
	public void setBatteryLife(int batteryLife) {
		this.batteryLife = batteryLife;
	}
	
	// Getter & Setter Methods for (nightVision).
	public boolean isNightVision() {
		return nightVision;
	}
	public void setNightVision(boolean nightVision) {
		this.nightVision = nightVision;
	}
	//------------------------------------------------------------------------------------------------------//
	/** toString Method **/
	// The toString method should return a representative string for the smart camera.
	@Override
	public String toString() {
		return "SmartCamera -> " + super.getAlias() + " Cam's battery life is "+ batteryLife + " status is recording";
	}
	//------------------------------------------------------------------------------------------------------//
}
