package ie.cit.cloud.appdev.model;
/**
 * EmployeeContoller
 * 
 * @author paul bradley
 */
public class Employee {

	private String firstName;
	private String lastName;

	private int employeeId;
	private String department;

	private int phoneExtn;
	private int salary;
	private String jobTitle;
	
	
	public Employee(String firstName, String lastName, String jobTitle, int employeeId) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmployeeId(employeeId);
		this.setJobTitle(jobTitle);
	}

	public Employee(int int1, String string, String string2, String string3,
			String string4, int int2, int int3) {
		// TODO Auto-generated constructor stub
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getPhoneExtn() {
		return phoneExtn;
	}

	public void setPhoneExtn(int phoneExtn) {
		this.phoneExtn = phoneExtn;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
}
