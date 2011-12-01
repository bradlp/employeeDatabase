package ie.cit.cloud.appdev;

import ie.cit.cloud.appdev.model.Employee;

import java.util.List;

public interface EmployeeService {

	public abstract List<Employee> getAllEmployees();

	public abstract int getEmployeesCount();

	public abstract Employee addNewEmployee(String firstname, String lastname,
			String jobtitle, String department, int salary);

	public abstract Employee getEmployeeByName(String firstname, String lastname);

	public abstract Employee getEmployeeByID(int employeeID);

}