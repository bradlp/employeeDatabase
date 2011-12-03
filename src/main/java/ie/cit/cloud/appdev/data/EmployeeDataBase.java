package ie.cit.cloud.appdev.data;

import java.util.Collection;
import java.util.List;

import ie.cit.cloud.appdev.data.JDBCEmployeeDataBase.EmployeeRowMapper;
import ie.cit.cloud.appdev.model.Employee;

public interface EmployeeDataBase {

	int addEmployee(Employee employee);
	
	int deleteEmployee(Employee employee);
	
	Employee getEmployeeByName(String fistname, String lastName);
	
	Employee getEmployeeById(int employeeID);
	
	Collection <Employee> getAllEmployees();
	
	List<Employee> getAllEmployeesByDepartment(String department);
}
