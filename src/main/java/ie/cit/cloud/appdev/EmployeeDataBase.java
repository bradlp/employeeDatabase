package ie.cit.cloud.appdev;

import java.util.Collection;

import ie.cit.cloud.appdev.model.Employee;

public interface EmployeeDataBase {

	int addEmployee(Employee employee);
	
	int deleteEmployee(Employee employee);
	
	Employee getEmployeeByName(String fistname, String lastName);
	
	Employee getEmployeeById(int employeeID);
	
	Collection <Employee> getAllEmployees();

}
