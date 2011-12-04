package ie.cit.cloud.appdev.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import ie.cit.cloud.appdev.EmployeeService;
import ie.cit.cloud.appdev.data.JDBCEmployeeDataBase;
import ie.cit.cloud.appdev.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * listAll:   curl http://localhost:8080/week_4_lab_res/employeeDataBase/listAll
 * update: curl -i -H "Content-Type: application/json" -X PUT -d '{"text":"Remember the Milk"}' http://localhost:8080/week_5_lab_res/api/todo/${id}
 * list:   curl http://localhost:8080/week_4_lab_res/api/list
 * delete: curl -X DELETE curl http://localhost:8080/week_5_lab_res/api/todo/${id}
 * detail: curl http://localhost:8080/week_5_lab_res/api/todo/${id}
 * 
 * 
 * Using security:
 * curl -c cookies.txt --data "j_username=igor&j_password=igor" http://localhost:8080/week_10/j_spring_security_check
 * curl -b cookies.txt 
 */
@Controller
@RequestMapping("employeeDataBase")
public class EmployeeJsonController {

	@Autowired
	EmployeeService employeeService;
	private static final Logger logger = Logger.getLogger(EmployeeService.class);
	
	// Function Name =  getEmployeeList()
	// Goes to the database and gets a list of all active employees
	// Pay is rescricted so does not get that
	// listAll:   curl http://localhost:8080/week_4_lab_res/employeeDataBase/listAll
	@RequestMapping("listAll")
    @ResponseBody
	public List <Employee> getEmployeeList() {
		List<Employee> employees = null;
		int numEmployeeCount = employeeService.getEmployeesCount(); 
		if ( numEmployeeCount > 0 ){
				employees = employeeService.getAllEmployees();
		}
		
		return employees;
	}
    
	// Function Name =  getEmployeeByID()
	// Goes to the database and gets an employee based on the submitted id
	// Pay is rescricted so does not get that, caller needs to NULL check
	// detail: curl http://localhost:8080/week_4_lab_res/employeeDataBase//employeeName/{employeeID}
	//
	@RequestMapping(value = "/employee/{employeeID}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Employee getEmployeeByID(@PathVariable("employeeID") int employeeID) {
		Employee employee=null;
		if (employeeID >= 0  )
			 employee = employeeService.getEmployeeByID(employeeID);
		// Dont want salary exposed via json interface
		employee.setSalary(0);
		return employee;
	}	
	
	// Function Name =  getEmployeeByName()
	// Goes to the database and gets an employee based on the submitted id
	// Pay is rescricted so does not get that, caller needs to NULL check
	// detail: curl http://localhost:8080/week_4_lab_res/employeeDataBase/employeeName/{"Paul":"Bradley"}
	//
	@RequestMapping(value = "/employeeName/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Employee getEmployeeByName(@PathVariable("name") String name) {
	Employee employee;	
		if (name ==null ){
			employee =null;
		}	
		StringTokenizer st = new StringTokenizer(name, ":"); 
		String firstname = st.nextToken(); 
		String lastname = st.nextToken(); 
		
		employee = employeeService.getEmployeeByName(firstname, lastname);
		// Dont want salary exposed via json interface
		employee.setSalary(0);
		return employee;
	}
	
	
	
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public void emptyResult() {
	// no code needed
    }	

	
}