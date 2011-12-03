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
	
	// Function Name =  EmployeeServiceImpl()
	//
	@Autowired
	public EmployeeServiceImpl(EmployeeDataBase employeDataBase) {
		this.repository = (JDBCEmployeeDataBase) employeDataBase;
		telecommsDept = new TeleCommsDeptment();
	}

	// Function Name =  getAllEmployees()
	//
	@Transactional(readOnly = true)
	public List<Employee> getAllEmployees() {
		return ( this.repository.getAllEmployees());
	}
	
	// Function Name =  getEmployeesCount()
	//
	@Transactional(readOnly = true)
	public int getEmployeesCount() {
		return repository.getAllEmployees().size();
	}
	
	// Function Name =  addNewEmployee()
	//
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
	
	// Function Name =  getNextAvailibleEmployeeId()
	//
	private int getNextAvailibleEmployeeId() {
		return(this.getEmployeesCount()+1);
	}

	// Function Name =  getEmployeeByName()
	//
	@Transactional(readOnly = true)
	public Employee getEmployeeByName(String firstname, String lastname) {
		Employee employee = this.repository.getEmployeeByName(firstname, lastname); 
		return (employee);
	}

	// Function Name =  getEmployeeByID()
	//
	@Transactional(readOnly = true)
	public Employee getEmployeeByID(int employeeID) {
		return ( this.repository.getEmployeeById(employeeID));
	}

	// Function Name =  getEmployeeByDept()
	//
	@Transactional(readOnly = true)
	public List<Employee> getEmployeeByDept(String departmentName) {
		return ( this.repository.getAllEmployeesByDepartment(departmentName));
	}
}
