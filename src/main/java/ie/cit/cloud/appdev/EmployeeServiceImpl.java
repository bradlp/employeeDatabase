package ie.cit.cloud.appdev;

import ie.cit.cloud.appdev.data.EmployeeDataBase;
import ie.cit.cloud.appdev.data.JDBCEmployeeDataBase;
import ie.cit.cloud.appdev.data.TeleCommsDeptment;
import ie.cit.cloud.appdev.model.Employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * EmployeeContoller
 * 
 * @author paul bradley
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	JDBCEmployeeDataBase repository;
	TeleCommsDeptment telecommsDept;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDataBase employeDataBase) {
		this.repository = (JDBCEmployeeDataBase) employeDataBase;
		telecommsDept = new TeleCommsDeptment();
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.EmployeeService#getAllEmployees()
	 */
	public List<Employee> getAllEmployees() {
		return ( this.repository.getAllEmployees());
	}
	
	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.EmployeeService#getEmployeesCount()
	 */
	public int getEmployeesCount() {
		return repository.getAllEmployees().size();
	}
	
	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.EmployeeService#addNewEmployee(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)
	 */
	public Employee addNewEmployee(String firstname, String lastname, String jobtitle, 
								String department, int salary) {
		int nextAvailibleID = this.getNextAvailibleEmployeeId();
		int nextAvailiblePhone = telecommsDept.getNetxAvailibleNumber();
		Employee newEmployee = new Employee(nextAvailibleID, firstname, lastname, jobtitle,
												department, nextAvailiblePhone, salary);
		repository.addEmployee(newEmployee);
		//SecurityContextHolder.getContext().getAuthentication().
		return newEmployee;
	}
	
	private int getNextAvailibleEmployeeId() {
		return(this.getEmployeesCount()+1);
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.EmployeeService#getEmployeeByName(java.lang.String, java.lang.String)
	 */
	public Employee getEmployeeByName(String firstname, String lastname) {
		Employee employee = this.repository.getEmployeeByName(firstname, lastname); 
		return (employee);
	}
	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.EmployeeService#getEmployeeByID(int)
	 */
	public Employee getEmployeeByID(int employeeID) {
		return ( this.repository.getEmployeeById(employeeID));
	}
}
