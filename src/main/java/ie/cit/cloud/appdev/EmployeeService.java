package ie.cit.cloud.appdev;

import ie.cit.cloud.appdev.model.Employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * EmployeeContoller
 * 
 * @author paul bradley
 */
@Service
public class EmployeeService {

	/* simple in-memory data repository (!not persistent! and instance specific) */
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
	
	public void addNewEmployee(String firstname, String lastname, String jobtitle) {
		int nextAvailibleID = this.getNextAvailibleEmployeeId();
		Employee newEmployee = new Employee(firstname, lastname, jobtitle, nextAvailibleID);
		repository.addEmployee(newEmployee);
	}
	public void removeEmployee(Employee employee) {
		repository.deleteEmployee(employee);
	}
	
	private int getNextAvailibleEmployeeId(){
		return (this.getEmployeesCount()+1);
	
	}
}
