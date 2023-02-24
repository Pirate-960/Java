// Student Name: Abdelrahman Zahran.
// Student Number: 150120998.

/**
 * Each Project has a name, startDate and state data fields. If the Project is open, state should be true; otherwise, false.
 * In setState method, a string value (“Open” or “Close”) is given, and the method should set the state as true or false.
 * In getState method, a string value (“Open” or “Close”) should be returned based on the state value.
 * In close method, you should close the project if it is open.
 * There are setter/getter and toString() methods.
 **/

import java.util.Calendar;

public class Project {
	//---------------------------------------------------------------------------------------------//
	/** Data Fields **/
	private String projectName;
	private Calendar startDate;
	private boolean state;
	//---------------------------------------------------------------------------------------------//
	/** Main Method **/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//---------------------------------------------------------------------------------------------//
	/** no-argument Constructor **/
	public Project (){

	}
	/** Constructor **/
	public Project(String pName , Calendar startDate , String state) throws Exception {
		this.projectName = projectName;
		this.startDate = startDate;
		projectName = pName;
		setState(state);
		setProjectName(projectName);
	}
	//---------------------------------------------------------------------------------------------//
	/** Methods **/
	public void setState(String state) throws Exception {
		if (state.equals("Open")) {
			this.state = true;
		}
		else if (state.equals("Close")) {
			this.state = false;
		}
		else {
			throw new Exception("Invalid State.");
		}
	}
	public String getState() {
		String State = null;
		if (state == true) {
			State = "Open";
		}
		else if (state == false) {
			State = "Close";
		}
		return State;
	}
	public void close() {
		if (state == true) {
			state = false;
		}
	}
	//---------------------------------------------------------------------------------------------//
	/** Setter and Getter Methods for of class data fields **/
	// Getter & Setter Methods for (projectName).
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) throws Exception {
		if (projectName.length() < 3) {
			throw new Exception ("Invalid Project Name.");
		}
		else {
			this.projectName = projectName;	
		}
	}
	
	// Getter & Setter Methods for (startDate).
	public Calendar getStartDate() {
		return startDate;
	}
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}
	
	// Getter & Setter Methods for (state).
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	//---------------------------------------------------------------------------------------------//
	@Override
	public String toString() {
		if (startDate.get(Calendar.MONTH) == 0) {
			return "Project [projectName=" + projectName + ", startDate=" + startDate.get(Calendar.DAY_OF_MONTH) + "/" + (startDate.get(Calendar.MONTH) + 12) + "/" + (startDate.get(Calendar.YEAR) - 1) + ", state=" + state + "]";
		}
		else {
			return "Project [projectName=" + projectName + ", startDate=" + startDate.get(Calendar.DAY_OF_MONTH) + "/" + startDate.get(Calendar.MONTH) + "/" + startDate.get(Calendar.YEAR) + ", state=" + state + "]";
		}
		
	}
	//---------------------------------------------------------------------------------------------//	
}
