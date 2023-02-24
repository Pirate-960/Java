// Student Name: Abdelrahman Zahran.
// Student Number: 150120998.

// This program is the implement of a simple company system with the following OOP classes

/**
a) You should read input from a file and create new objects based on the line read. A set of sample lines in your input file is given below:
� Department 1 Accounting
o You should create a new Department with an id of 1 and name of Accounting.
� Project AutoCredit 01/05/2018 Open
o You should create a new Project with the name of AutoCredit, startDate 01/05/2018 and state Open.
� Product Product1 01/01/2019 10000
o You should create a new Product with the name of Product1, saleDate 01/01/2019 and price of 10000.
� Person Ayse Caliskan 111 Woman 05/05/1986 Married Yes
o You should create a new Person with the name of Ayse, surname Caliskan, id of 111, gender 1, birth date 05/05/1986, maritalStatus 2 and hasDriverLicence true.
� Employee 111 5000 10/10/2017 Accounting
o You should create a new Employee by finding the Person with the given id (111) and invoke the overloaded constructor of Employee with the Person found, salary: 5000, hireDate: 10/10/2017 and department: Accounting.
� RegularEmployee 111 25
o You should create a new RegularEmployee by finding the Employee with the given id (111) and invoke the overloaded constructor of RegularEmployee with the Employee found and performanceScore 25.
� Developer 111 CreditCard Robotic
o You should create a new Developer by finding the RegularEmployee with the given id (111) and invoke the overloaded constructor of Developer with the RegularEmployee found, project list: CreditCard and Robotics. It should be noted that the number of projects may change.
� Customer 224 Product1 Product2 Product5
o You should create a new Customer by finding the Person with the given id (224) and invoke the overloaded constructor of Customer with the Person found, product list: Product1 Product2 and Product5. It should be noted that the number of products may change.
b) After reading the input file and constructing the objects (keep your objects in ArrayLists polymorphically in the test file), the following sample scenario can be given in your test class:
i) invoke distributeBonusBudget method for each Manager polymorphically.
ii) invoke raiseSalary method for each Manager polymorphically with the percent value of 0.2.
iii) invoke raiseSalary method for each RegularEmployee polymorphically with the percent value of 0.3.
iv) invoke raiseSalary method for each Developer polymorphically with the percent value of 0.23.
v) invoke raiseSalary method for each SalesEmployee polymorphically with the percent value of 0.18.
vi) invoke raiseSalary method for a SalesEmployee who has maximum value of sales (in terms of total price) polymorphically with the amount of 1000.
c) After performing these operations, print each department, its manager, its employee list with details. A sample output file is already generated based on the given sample input file and the execution scenario mentioned in Step b.
 **/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;

public class Test {

	public static void main(String[] args) throws Exception {
		
		
		// Create a File object
		java.io.File file = new File("input.txt");
		//Create a Scanner object for read to inputs from .txt file
		Scanner input = new Scanner(file);
		// Create many arrayList for store created objects below
		ArrayList<Department> departementsArrayList = new ArrayList<Department> ();
		ArrayList<Product> productsArrayList = new ArrayList<Product> ();
		ArrayList<Person> personArrayList = new ArrayList<Person> ();
		ArrayList<Project> projectsArraylist = new ArrayList<Project> ();
		
		
		
		while(input.hasNext()) {
			try {
				String classType = input.next();
				// Check object type
				switch (classType) {
				case "Customer":
					int idOfCustomer = input.nextInt();
					String customerLine = input.nextLine();
					Person personOfCustomer = null;
					boolean isCustomerCreatedFromPerson = false;
					ArrayList <Product> boughtProducts = new ArrayList<Product>();
					// Check Customer is created from a person. If it is, use valid constructor and remove person at arrPerson.
					for (int i = 0 ; i < personArrayList.size() ; i++) {
						if (idOfCustomer == personArrayList.get(i).getId()) {
							personOfCustomer = personArrayList.get(i);
							personArrayList.remove(i);
							isCustomerCreatedFromPerson = true;
							break;
						}
					}
					if (isCustomerCreatedFromPerson) {
						String[] customerLineArray = customerLine.split(" ");
						// Check and add Customer's products which is bought and add them to arrayList
						for (int i = 0 ; i < customerLineArray.length ; i++) {
							String product = customerLineArray[i];
							for (int j = 0 ; j < productsArrayList.size() ; j++) {
								if (product.equals(productsArrayList.get(j).getProductName())) {
									boughtProducts.add(productsArrayList.get(j));
									break;
								}
							}
						}
							
						// Create Customer object and add them to arrPerson
						Customer customer = new Customer(personOfCustomer, boughtProducts);
						personArrayList.add(customer);
					}
					// If Customer is not created from a person, get require informations
					else {
						String firstNameOfCustomer = input.next();
						String lastNameOfCustomer= input.next();
						String genderOfCustomer = input.next();
						String birthDateOfCustomer = input.next();
						String maritalStatusOfCustomer = input.next();
						String hasDriverLicenseOfCustomer = input.next();
						
						// Check birtDate and split them to day, month, year
						String[]birthDateArray = birthDateOfCustomer.split("/");
						int dayOfBirthDate = Integer.parseInt(birthDateArray[0]);
						int monthOfBirthDate = Integer.parseInt(birthDateArray[1]);
						int yearOfBirthDate = Integer.parseInt(birthDateArray[2]);
						
						// Create a Calendar object and set them to received informations
						Calendar calendarOfBirthDate = Calendar.getInstance();
						calendarOfBirthDate.clear();
						calendarOfBirthDate.set(yearOfBirthDate, monthOfBirthDate, dayOfBirthDate);
						
						// Check and add Customer's products which is bought and add them to arrayList
						String[] customerLineArray = customerLine.split(" ");
						for (int i = 0 ; i < customerLineArray.length ; i++) {
							String product = customerLineArray[i];
							for (int j = 0 ; j < productsArrayList.size() ; j++) {
								if (product.equals(productsArrayList.get(j).getProductName())) {
									boughtProducts.add(productsArrayList.get(j));
									break;
								}
							}
						}
						// Create Customer object and add them to arrPerson
						Customer customer = new Customer(idOfCustomer, firstNameOfCustomer, lastNameOfCustomer, genderOfCustomer, calendarOfBirthDate, maritalStatusOfCustomer, hasDriverLicenseOfCustomer, boughtProducts);
						personArrayList.add(customer);
					}		
					break;		
				case "Department":
					int departmentId = input.nextInt();
					String departmentName = input.next();
					// Create a Department object and add them to arr
					Department department = new Department(departmentId, departmentName);
					departementsArrayList.add(department);
					break;
				case "Developer":
					int idOfDeveloper = input.nextInt();
					String developerLine = input.nextLine();
					RegularEmployee regularEmployeeOfDeveloper = null;
					boolean isDeveloperCreatedFromPerson = false;
					ArrayList <Project> madeProjects = new ArrayList<Project>();
					// Check Developer is created from a person. If it is, use valid constructor and remove person at arrPerson.
					for (int i = 0 ; i < personArrayList.size() ; i++) {
						if (idOfDeveloper == personArrayList.get(i).getId()) {
							regularEmployeeOfDeveloper = (RegularEmployee) personArrayList.get(i);
							personArrayList.remove(i);
							isDeveloperCreatedFromPerson = true;
							break;
						}
					}
					if (isDeveloperCreatedFromPerson) {
						// Check and add Developer's projects which is made and add them to arrayList
						String[] developerLineArray = developerLine.split(" ");
						for (int i = 0 ; i < developerLineArray.length ; i++) {
							String projects = developerLineArray[i];
							for (int j = 0 ; j < projectsArraylist.size() ; j++) {
								if (projects.equals(projectsArraylist.get(j).getProjectName())) {
									madeProjects.add(projectsArraylist.get(j));
									break;
								}
							}
						}
							
						// Create a Developer object and add them to arrPerson
						Developer developer = new Developer(regularEmployeeOfDeveloper, madeProjects);
						personArrayList.add(developer);
					}
					// If Developer is not created from a person, get require informations
					else {
						String firstNameOfDeveloper = input.next();
						String lastNameOfDeveloper= input.next();
						String genderOfDeveloper = input.next();
						String birthDateOfDeveloper = input.next();
						String maritalStatusOfDeveloper = input.next();
						String hasDriverLicenseOfDeveloper = input.next();
						double salaryOfSalesDeveloper = input.nextInt();
						String hireDateOfDeveloper = input.next();
						String departmentNameOfDeveloper = input.next();
						Department departmentOfDeveloper = null;
						double pScore = input.nextDouble();
						
						// Get department of developer from department name
						for (int i = 0 ; i < departementsArrayList.size() ; i++) {
							if (departementsArrayList.get(i) instanceof Department) {
								Department departmentObject = (Department) departementsArrayList.get(i);
								if (departmentObject.getDepartmentName().equals(departmentNameOfDeveloper)) {
									departmentOfDeveloper = departmentObject;
								}
							}
						}
						
						// Check birtDate, hireDate; and split them to day, month, year
						String[]birthDateArray = birthDateOfDeveloper.split("/");
						int dayOfBirthDate = Integer.parseInt(birthDateArray[0]);
						int monthOfBirthDate = Integer.parseInt(birthDateArray[1]);
						int yearOfBirthDate = Integer.parseInt(birthDateArray[2]);
						
						String[]hireDateArray = hireDateOfDeveloper.split("/");
						int dayOfHireDate = Integer.parseInt(hireDateArray[0]);
						int monthOfHireDate = Integer.parseInt(hireDateArray[1]);
						int yearOfHireDate = Integer.parseInt(hireDateArray[2]);
						
						// Create Calendar objects and set them to received informations
						Calendar calendarOfBirthDate = Calendar.getInstance();
						calendarOfBirthDate.set(yearOfBirthDate, monthOfBirthDate, dayOfBirthDate);
						
						Calendar calendarOfHireDate = Calendar.getInstance();
						calendarOfHireDate.clear();
						calendarOfHireDate.set(yearOfHireDate, monthOfHireDate, dayOfHireDate);
						
						// Check and add Developer's projects which is made and add them to arrayList
						String[] developerLineArray = developerLine.split(" ");
						for (int i = 0 ; i < developerLineArray.length ; i++) {
							String projects = developerLineArray[i];
							for (int j = 0 ; j < productsArrayList.size() ; j++) {
								if (projects.equals(projectsArraylist.get(j).getProjectName())) {
									madeProjects.add(projectsArraylist.get(j));
									break;
								}
							}
						}
						// Create a Developer object and add them to arrPerson
						Developer developer = new Developer(idOfDeveloper, firstNameOfDeveloper, lastNameOfDeveloper, genderOfDeveloper, calendarOfBirthDate, maritalStatusOfDeveloper, hasDriverLicenseOfDeveloper, salaryOfSalesDeveloper, calendarOfHireDate, departmentOfDeveloper, pScore, madeProjects);
						personArrayList.add(developer);
					}
					break;
				case "Employee":
					int idOfEmployee = input.nextInt();
					boolean isEmployeeCreatedFromPerson = false;
					Person personOfEmployee = null;
					// Check Employee is created from a person. If it is, use valid constructor and remove person at arrPerson.
					for (int i = 0 ; i < personArrayList.size() ; i++) {
						if (idOfEmployee == personArrayList.get(i).getId()) {
							personOfEmployee = personArrayList.get(i);
							personArrayList.remove(i);
							isEmployeeCreatedFromPerson = true;
							break;
						}
					}
					
					if (isEmployeeCreatedFromPerson) {
						double salaryOfEmployee = input.nextDouble();
						String hireDate = input.next();
						String departmentNameOfEmployee = input.next();
						Department departmentOfEmployee = null;
						
						// Check birtDate and split them to day, month, year
						String[] hireDateArray = hireDate.split("/");
						int dayOfHireDate = Integer.parseInt(hireDateArray[0]);
						int monthOfHireDate = Integer.parseInt(hireDateArray[1]);
						int yearOfHireDate = Integer.parseInt(hireDateArray[2]);
						
						// Create a Calendar object and set them to received informations
						Calendar calendarOfHireDate = Calendar.getInstance();
						calendarOfHireDate.clear();
						calendarOfHireDate.set(yearOfHireDate, monthOfHireDate, dayOfHireDate);
						
						// Get department of Employee from department name
						for (int i = 0 ; i < departementsArrayList.size() ; i++) {
							if (departementsArrayList.get(i) instanceof Department) {
								Department departmentObject = (Department) departementsArrayList.get(i);
								if (departmentObject.getDepartmentName().equals(departmentNameOfEmployee)) {
									departmentOfEmployee = departmentObject;
								}
							}
						}
						// Create a Employee object and add them to arrPerson
						Employee employee = new Employee(personOfEmployee, salaryOfEmployee, calendarOfHireDate, departmentOfEmployee);
						personArrayList.add(employee);
					}
					// If Employee is not created from a person, get require informations
					else {
						String firstNameOfEmployee = input.next();
						String lastNameOfEmployee = input.next();
						String genderOfEmployee = input.next();
						String birthDateOfEmployee = input.next();
						String maritalStatusOfEmployee = input.next();
						String hasDriverLicenseOfEmployee = input.next();
						double salaryOfEmployee = input.nextDouble();
						String hireDateOfEmployee = input.next();
						
						// Check birtDate, hireDate; and split them to day, month, year
						String[]birthDateArray = birthDateOfEmployee.split("/");
						int dayOfBirthDate = Integer.parseInt(birthDateArray[0]);
						int monthOfBirthDate = Integer.parseInt(birthDateArray[1]);
						int yearOfBirthDate = Integer.parseInt(birthDateArray[2]);
						
						String[]hireDateArray = hireDateOfEmployee.split("/");
						int dayOfHireDate = Integer.parseInt(hireDateArray[0]);
						int monthOfHireDate = Integer.parseInt(hireDateArray[1]);
						int yearOfHireDate = Integer.parseInt(hireDateArray[2]);
						
						// Create Calendar objects and set them to received informations
						Calendar calendarOfHireDate = Calendar.getInstance();
						calendarOfHireDate.clear();
						calendarOfHireDate.set(yearOfHireDate, monthOfHireDate, dayOfHireDate);
						
						Calendar calendarOfBirthDate = Calendar.getInstance();
						calendarOfBirthDate.clear();
						calendarOfBirthDate.set(yearOfBirthDate, monthOfBirthDate, dayOfBirthDate);
						
						String departmentNameOfEmployee = input.next();
						Department departmentOfEmployee = null;
						
						// Get department of developer from department name
						for (int i = 0 ; i < departementsArrayList.size() ; i++) {
							if (departementsArrayList.get(i) instanceof Department) {
								Department departmentObject = (Department) departementsArrayList.get(i);
								if (departmentObject.getDepartmentName().equals(departmentNameOfEmployee)) {
									departmentOfEmployee = departmentObject;
								}
							}
						}
						// Create a Employee object and add them to arrPerson
						Employee employee = new Employee(idOfEmployee, firstNameOfEmployee, lastNameOfEmployee, genderOfEmployee, calendarOfBirthDate, maritalStatusOfEmployee, hasDriverLicenseOfEmployee, salaryOfEmployee, calendarOfHireDate, departmentOfEmployee);
						personArrayList.add(employee);
					}
					break;
				case "Manager":
					int idOfManager = input.nextInt();
					boolean isManagerCreatedFromEmployee = false;
					Employee employeeOfManager = null;
					
					// Check Manager is created from a person. If it is, use valid constructor and remove person at arrPerson.
					for (int i = 0 ; i < personArrayList.size() ; i++) {
						if (idOfManager == personArrayList.get(i).getId()) {
							employeeOfManager = (Employee) personArrayList.get(i);
							personArrayList.remove(i);
							isManagerCreatedFromEmployee = true;
							break;
						}
					}
					
					if (isManagerCreatedFromEmployee) {
						double bonusBudget = input.nextDouble();
						
						// Create a Manager object and add them to arrPerson
						Manager manager = new Manager(employeeOfManager, bonusBudget);
						personArrayList.add(manager);
					}
					// If Manager is not created from a person, get require informations
					else {
						String firstNameOfManager = input.next();
						String lastNameOfManager = input.next();
						String genderOfManager = input.next();
						String birthDateOfManager = input.next();
						String maritalStatusOfManager = input.next();
						String hasDriverLicenseOfManager = input.next();
						double salaryOfManager = input.nextDouble();
						String hireDateOfManager = input.next();
						
						// Check birtDate, hireDate; and split them to day, month, year
						String[]birthDateArray = birthDateOfManager.split("/");
						int dayOfBirthDate = Integer.parseInt(birthDateArray[0]);
						int monthOfBirthDate = Integer.parseInt(birthDateArray[1]);
						int yearOfBirthDate = Integer.parseInt(birthDateArray[2]);
						
						String[]hireDateArray = hireDateOfManager.split("/");
						int dayOfHireDate = Integer.parseInt(hireDateArray[0]);
						int monthOfHireDate = Integer.parseInt(hireDateArray[1]);
						int yearOfHireDate = Integer.parseInt(hireDateArray[2]);
						
						// Create Calendar objects and set them to received informations
						Calendar calendarOfHireDate = Calendar.getInstance();
						calendarOfHireDate.clear();
						calendarOfHireDate.set(yearOfHireDate, monthOfHireDate, dayOfHireDate);
						
						Calendar calendarOfBirthDate = Calendar.getInstance();
						calendarOfBirthDate.clear();
						calendarOfBirthDate.set(yearOfBirthDate, monthOfBirthDate, dayOfBirthDate);
						
						String departmentNameOfManager = input.next();
						Department departmentOfManager = null;
						
						// Get department of manager from department name
						for (int i = 0 ; i < departementsArrayList.size() ; i++) {
							if (departementsArrayList.get(i) instanceof Department) {
								Department departmentObject = (Department) departementsArrayList.get(i);
								if (departmentObject.getDepartmentName().equals(departmentNameOfManager)) {
									departmentOfManager = departmentObject;
								}
							}
						}
						double bonusBudget = input.nextDouble();
						
						// Create a Manager object and add them to arrPerson
						Manager manager = new Manager(idOfManager, firstNameOfManager, lastNameOfManager, genderOfManager, calendarOfBirthDate, maritalStatusOfManager, hasDriverLicenseOfManager, salaryOfManager, calendarOfHireDate, departmentOfManager, bonusBudget);
						personArrayList.add(manager);
					}
					break;
				case "Person":
						String firstName = input.next();
						String lastName = input.next();
						int id = input.nextInt();
						String gender = input.next();
						String birthDate = input.next();
						String maritalStatus = input.next();
						String hasDriverLicense = input.next();
						
						// Check birtDate and split them to day, month, year
						String[] callArr1 = birthDate.split("/");
						int day1 = Integer.parseInt(callArr1[0]);
						int month1 = Integer.parseInt(callArr1[1]);
						int year1 = Integer.parseInt(callArr1[2]);
						
						// Create a Calendar object and set them to received informations
						Calendar birthDate1 = Calendar.getInstance();
						birthDate1.clear();
						birthDate1.set(year1, month1, day1);
						
						// Create a Person object and add them to arrPerson
						Person person = new Person(id, firstName, lastName, gender, birthDate1, maritalStatus, hasDriverLicense);
						personArrayList.add(person);

					
					break;
				case "Product":
					String productName = input.next();
					String saleDate = input.next();
					int price = input.nextInt();
					
					// Check saleDate and split them to day, month, year
					String[] saleDateArray = saleDate.split("/");
					int dayOfSaleDate = Integer.parseInt(saleDateArray[0]);
					int monthOfSaleDate = Integer.parseInt(saleDateArray[1]);
					int yearOfSaleDate = Integer.parseInt(saleDateArray[2]);
					
					// Create a Calendar object and set them to received informations
					Calendar calendarOfSaleDate = Calendar.getInstance();
					calendarOfSaleDate.clear();
					calendarOfSaleDate.set(yearOfSaleDate, monthOfSaleDate, dayOfSaleDate);
					
					// Create a Product object and add them to arrProducts
					Product product = new Product(productName, calendarOfSaleDate, price);
					productsArrayList.add(product);
					
					break;
				case "Project":
					
						String pName = input.next();
						String calendar = input.next();
						String state = input.next();
						
						// Check projectDate and split them to day, month, year
						String[] callArr = calendar.split("/");
						int day = Integer.parseInt(callArr[0]);
						int month = Integer.parseInt(callArr[1]);
						int year = Integer.parseInt(callArr[2]);
						
						// Create a Calendar object and set them to received informations
						Calendar calendar1 = Calendar.getInstance();
						calendar1.clear();
						calendar1.set(year, month, day);
						
						// Create a Project object and add them to arrProjects
						Project project = new Project(pName, calendar1, state);
						projectsArraylist.add(project);
					break;
				case "RegularEmployee":
					int idOfRegularEmployee = input.nextInt();
					boolean isRegularEmployeeCreatedFromEmployee = false;
					Employee employeeOfRegularEmployee = null;
					
					// Check RegularEmployee is created from a person. If it is, use valid constructor and remove person at arrPerson.
					for (int i = 0 ; i < personArrayList.size() ; i++) {
						if (idOfRegularEmployee == personArrayList.get(i).getId()) {
							employeeOfRegularEmployee = (Employee) personArrayList.get(i);
							personArrayList.remove(i);
							isRegularEmployeeCreatedFromEmployee = true;
							break;
						}
					}
					
					if (isRegularEmployeeCreatedFromEmployee) {
						int performanceScore = input.nextInt();
						
						// Create a RegularEmployee object and add them to arrPerson
						RegularEmployee regularEmployee = new RegularEmployee(employeeOfRegularEmployee, performanceScore);
						personArrayList.add(regularEmployee);
					}
					// If RegularEmployee is not created from a person, get require informations
					else {
						String firstNameOfRegularEmployee = input.next();
						String lastNameOfRegularEmployee = input.next();
						String genderOfRegularEmployee = input.next();
						String birthDateOfRegularEmployee = input.next();
						String maritalStatusOfRegularEmployee = input.next();
						String hasDriverLicenseOfRegularEmployee = input.next();
						double salaryOfRegularEmployee = input.nextDouble();
						String hireDateOfRegularEmployee = input.next();
						
						// Check birtDate, hireDate; and split them to day, month, year
						String[]birthDateArray = birthDateOfRegularEmployee.split("/");
						int dayOfBirthDate = Integer.parseInt(birthDateArray[0]);
						int monthOfBirthDate = Integer.parseInt(birthDateArray[1]);
						int yearOfBirthDate = Integer.parseInt(birthDateArray[2]);
						
						String[]hireDateArray = hireDateOfRegularEmployee.split("/");
						int dayOfHireDate = Integer.parseInt(hireDateArray[0]);
						int monthOfHireDate = Integer.parseInt(hireDateArray[1]);
						int yearOfHireDate = Integer.parseInt(hireDateArray[2]);
						
						// Create Calendar objects and set them to received informations
						Calendar calendarOfHireDate = Calendar.getInstance();
						calendarOfHireDate.clear();
						calendarOfHireDate.set(yearOfHireDate, monthOfHireDate, dayOfHireDate);
						
						Calendar calendarOfBirthDate = Calendar.getInstance();
						calendarOfBirthDate.clear();
						calendarOfBirthDate.set(yearOfBirthDate, monthOfBirthDate, dayOfBirthDate);
						
						String departmentNameOfRegularEmployee = input.next();
						Department departmentOfRegularEmployee = null;
						
						// Get department of developer from department name
						for (int i = 0 ; i < departementsArrayList.size() ; i++) {
							if (departementsArrayList.get(i) instanceof Department) {
								Department departmentObject = (Department) departementsArrayList.get(i);
								if (departmentObject.getDepartmentName().equals(departmentNameOfRegularEmployee)) {
									departmentOfRegularEmployee = departmentObject;
								}
							}
						}	
						int performanceScore = input.nextInt();
						
						// Create a RegularEmployee object and add them to arrPerson
						RegularEmployee regularEmployee = new RegularEmployee(idOfRegularEmployee, firstNameOfRegularEmployee, lastNameOfRegularEmployee, genderOfRegularEmployee, calendarOfBirthDate, maritalStatusOfRegularEmployee, hasDriverLicenseOfRegularEmployee, salaryOfRegularEmployee, calendarOfHireDate, departmentOfRegularEmployee, performanceScore);
						personArrayList.add(regularEmployee);
					}
					
					break;
				case "SalesEmployee":
					int idOfSalesEmployee = input.nextInt();
					String salesEmployeeLine = input.nextLine();
					RegularEmployee regularEmployeeOfSalesEmployee = null;
					boolean isSalesEmployeeCreatedFromPerson = false;
					ArrayList <Product> soldProducts = new ArrayList<Product>();
					
					// Check SalesEmployee is created from a person. If it is, use valid constructor and remove person at arrPerson.
					for (int i = 0 ; i < personArrayList.size() ; i++) {
						if (idOfSalesEmployee == personArrayList.get(i).getId()) {
							regularEmployeeOfSalesEmployee = (RegularEmployee) personArrayList.get(i);
							personArrayList.remove(i);
							isSalesEmployeeCreatedFromPerson = true;
							break;
						}
					}
					if (isSalesEmployeeCreatedFromPerson) {
						String[] salesEmployeeLineArray = salesEmployeeLine.split(" ");
						for (int i = 0 ; i < salesEmployeeLineArray.length ; i++) {
							String products = salesEmployeeLineArray[i];
							// Check and add SalesEmployee's products which is sold and add them to arrayList
							for (int j = 0 ; j < productsArrayList.size() ; j++) {
								if (products.equals(productsArrayList.get(j).getProductName())) {
									soldProducts.add(productsArrayList.get(j));
									break;
								}
							}
						}
							
						// Create a SalesEmployee object and add them to arrPerson
						SalesEmployee salesEmployee = new SalesEmployee(regularEmployeeOfSalesEmployee, soldProducts);
						personArrayList.add(salesEmployee);
					}
					// If SalesEmployee is not created from a person, get require informations
					else {
						String firstNameOfSalesEmployee = input.next();
						String lastNameOfSalesEmployee= input.next();
						String genderOfSalesEmployee = input.next();
						String birthDateOfSalesEmployee = input.next();
						String maritalStatusOfSalesEmployee = input.next();
						String hasDriverLicenseOfSalesEmployee = input.next();
						double salaryOfSalesEmployee = input.nextInt();
						String hireDateOfSalesEmployee = input.next();
						String departmentNameOfSalesEmployee = input.next();
						Department departmentOfSalesEmployee = null;
						double pScore = input.nextDouble();
						
						// Get department of developer from department name
						for (int i = 0 ; i < departementsArrayList.size() ; i++) {
							if (departementsArrayList.get(i) instanceof Department) {
								Department departmentObject = (Department) departementsArrayList.get(i);
								if (departmentObject.getDepartmentName().equals(departmentNameOfSalesEmployee)) {
									departmentOfSalesEmployee = departmentObject;
								}
							}
						}
						
						// Check birtDate, hireDate; and split them to day, month, year
						String[]birthDateArray = birthDateOfSalesEmployee.split("/");
						int dayOfBirthDate = Integer.parseInt(birthDateArray[0]);
						int monthOfBirthDate = Integer.parseInt(birthDateArray[1]);
						int yearOfBirthDate = Integer.parseInt(birthDateArray[2]);
						
						String[]hireDateArray = hireDateOfSalesEmployee.split("/");
						int dayOfHireDate = Integer.parseInt(hireDateArray[0]);
						int monthOfHireDate = Integer.parseInt(hireDateArray[1]);
						int yearOfHireDate = Integer.parseInt(hireDateArray[2]);
						
						// Create Calendar objects and set them to received informations
						Calendar calendarOfBirthDate = Calendar.getInstance();
						calendarOfBirthDate.set(yearOfBirthDate, monthOfBirthDate, dayOfBirthDate);
						
						Calendar calendarOfHireDate = Calendar.getInstance();
						calendarOfHireDate.clear();
						calendarOfHireDate.set(yearOfHireDate, monthOfHireDate, dayOfHireDate);
						
						
						String[] salesEmployeeLineArray = salesEmployeeLine.split(" ");
						for (int i = 0 ; i < salesEmployeeLineArray.length ; i++) {
							String products = salesEmployeeLineArray[i];
							// Check and add SalesEmployee's products which is sold and add them to arrayList
							for (int j = 0 ; j < productsArrayList.size() ; j++) {
								if (products.equals(productsArrayList.get(j).getProductName())) {
									soldProducts.add(productsArrayList.get(j));
									break;
								}
							}
						}
						
						// Create a SalesEmployee object and add them to arrPerson
						SalesEmployee salesEmployee = new SalesEmployee(idOfSalesEmployee, firstNameOfSalesEmployee, lastNameOfSalesEmployee, genderOfSalesEmployee, calendarOfBirthDate, maritalStatusOfSalesEmployee, hasDriverLicenseOfSalesEmployee, salaryOfSalesEmployee, calendarOfHireDate, departmentOfSalesEmployee, pScore, soldProducts);
						personArrayList.add(salesEmployee);
					}
					break;
				}
			}
			// If an invoked method causes an exception handle it
			catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
			
		}
		
		input.close();
		
		// If Manager and RegularEmployee are working at same department, add RegularEmployee to Manager's employee list
		for (int i = 0 ; i < personArrayList.size() ; i++) {
			if (personArrayList.get(i) instanceof Manager) {
				Manager manager = (Manager) (personArrayList.get(i));
				for (int j = 0 ; j < personArrayList.size() ; j++) {
					if (personArrayList.get(j) instanceof RegularEmployee) {
						RegularEmployee regularEmployee = (RegularEmployee) (personArrayList.get(j));
						if (regularEmployee.getDepartment() == manager.getDepartment()) {
							manager.addEmployee(regularEmployee);
						}
					}
				}
			}
		}
		
		int numberOfBestSeller = 0;
		SalesEmployee bestSeller = null;
		
		try {
			for (Person m: personArrayList) {
				// Invoke distributeBonusBudget for all managers and raise them salary with 0.2 percent
				if (m instanceof Manager) {
					((Manager) m).distributeBonusBudget();
					((Manager) m).raiseSalary(0.2);
				}
				// Raise all SalesEmployees salary with 0.18 percent and find the best seller SalesEmployee
				else if (m instanceof SalesEmployee) {
					((SalesEmployee)m).raiseSalary(0.18);
					int numberOfSoldProduct = ((SalesEmployee)m).getSales().size();
					if (numberOfSoldProduct > numberOfBestSeller) {
						bestSeller = ((SalesEmployee)m);
						numberOfBestSeller = numberOfSoldProduct;
					}
				}
				// Raise all Developers salary with 0.23 percent
				else if (m instanceof Developer) {
					((Developer)m).raiseSalary(0.23);
				}
				// Raise all RegularEmployees salary with 0.3 percent
				else if (m instanceof RegularEmployee) {
					((RegularEmployee)m).raiseSalary(0.3);
				}
			}
			// Add 1000$ to best seller SalesEmployee's salary
			bestSeller.raiseSalary(1000);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		try {
			// Create a FileWriter object for print each department, it�s manager, it�semployee list with details.
			FileWriter write = new FileWriter("output.txt");
			write.write("************************************************\r\n");
			for (Department department: departementsArrayList) {
				
				write.write(department.toString() + "\r\n");
				for (Person manager: personArrayList) {
					if(manager instanceof Manager) {
						if (((Manager) manager).getDepartment() == department) {
							write.write(manager.toString());
							int numOfEmployee = 1;
							for (RegularEmployee re: ((Manager) manager).getRegularEmployees()) {
								if (re instanceof Developer) {
									write.write("				" + numOfEmployee + ". Developer				");
									write.write(re.toString());
									numOfEmployee++;
								}
								else if (re instanceof SalesEmployee) {
									write.write("				" + numOfEmployee + ". SalesEmployee				");
									write.write(re.toString());
									numOfEmployee++;
								}
								else if (re instanceof RegularEmployee) {
									write.write("				" + numOfEmployee + ". RegularEmployee				");
									write.write(re.toString());
									numOfEmployee++;
								}
							}
							write.write("************************************************" + "\r\n");
						}
					}
				}
				
				
			}
			write.write("**********************CUSTOMERS************************" + "\r\n");
			for (Person customer: personArrayList) {
				if (customer instanceof Customer) {
					write.write(customer.toString());
					write.write("\r\n");
				}
			}
			write.write("**********************PEOPLE************************" + "\r\n");
			for (Person person: personArrayList) {
				if (person instanceof Person && !(person instanceof Employee) && !(person instanceof Customer)) {
					if (person.getBirthDate().get(Calendar.MONTH) == 12) {
						write.write("Person [id=" + person.getId() + ", firstName=" + person.getFirstName() + ", lastName=" + person.getLastName() + ", gender=" + person.getGender() + ", birthDate=" + person.getBirthDate().get(Calendar.DATE) + "/" + (person.getBirthDate().get(Calendar.MONTH) + 12) + "/" + (person.getBirthDate().get(Calendar.YEAR) - 1) + ", maritalStatus=" + person.getMaritalStatus() + ", hasDriverLicense=" + person.getHasDriverLicence() + "]");
						write.write("\r\n");
					}
					write.write("Person [id=" + person.getId() + ", firstName=" + person.getFirstName() + ", lastName=" + person.getLastName() + ", gender=" + person.getGender() + ", birthDate=" + person.getBirthDate().get(Calendar.DATE) + "/" + person.getBirthDate().get(Calendar.MONTH) + "/" + person.getBirthDate().get(Calendar.YEAR) + ", maritalStatus=" + person.getMaritalStatus() + ", hasDriverLicense=" + person.getHasDriverLicence() + "]");
					write.write("\r\n");
				}
			}
			write.close();
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		
	}

}



