// Student Name: Abdelrahman Zahran.
// Student Number: 150120998.

/**
 * Each Department has an id and a name data fields.
 * There are setter/getter and toString() methods.
 **/
		
public class Department {
	//---------------------------------------------------------------------------------------------//
	/** Data Fields **/
	private int departmentId;
	private String departmentName;
	//---------------------------------------------------------------------------------------------//
	/** Main Method **/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//---------------------------------------------------------------------------------------------//
	/** no-argument Constructor **/
	public Department() {

	}
	/** Constructor **/
	public Department(int departmentId , String departmentName) throws Exception {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		setDepartmentId(departmentId);
		setDepartmentName(departmentName);
	}
	//---------------------------------------------------------------------------------------------//
	/** Setter and Getter Methods for of class data fields **/
	// Getter & Setter Methods for (departmentId).
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) throws Exception {
		if (departmentId < 0 ) {
			throw new Exception ("Invalid Departement Id.");
		}
		else {
			this.departmentId = departmentId;	
		}
	}
	
	// Getter & Setter Methods for (departmentName).
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) throws Exception {
		if (departmentName.length() < 3) {
			throw new Exception ("Invalid Departement Name.");
		}
		else {
			this.departmentName = departmentName;	
		}
	}
	//---------------------------------------------------------------------------------------------//
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", derpartmentName=" + departmentName + "]";
	}
	//---------------------------------------------------------------------------------------------//
}
