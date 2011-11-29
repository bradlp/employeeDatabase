package ie.cit.cloud.appdev;

import ie.cit.cloud.appdev.model.Employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
/**
 * EmployeeContoller
 * 
 * @author paul bradley
 */
@Service
public class EmployeeService {

	private JDBCEmployeeDataBase repository;
	
	@Autowired
	public EmployeeService(EmployeeDataBase employeDataBase) {
		this.repository = (JDBCEmployeeDataBase) employeDataBase;
	}

	public List<Employee> getAllEmployees() {
		return ( this.repository.getAllEmployees());
	}
	
	public int getEmployeesCount() {
		int size= this.repository.getAllEmployees().size();
		return repository.getAllEmployees().size();
	}
	
	public Employee addNewEmployee(String firstname, String lastname, String jobtitle, 
								String department, int salary) {
		int nextAvailibleID = this.getNextAvailibleEmployeeId();
		Employee newEmployee = new Employee(nextAvailibleID, firstname, lastname, jobtitle,
												department, 001, salary);
		repository.addEmployee(newEmployee);
		//SecurityContextHolder.getContext().getAuthentication().
		return newEmployee;
	}
	

	
	private int getNextAvailibleEmployeeId(){
		return (this.getEmployeesCount()+1);
	
	}
	public Employee getEmployeeByName(String firstname, String lastname) {
		return ( this.repository.getEmployeeByName(firstname, lastname));
	}
	public Employee getEmployeeByID(int employeeID) {
		return ( this.repository.getEmployeeById(employeeID));
	}
}
