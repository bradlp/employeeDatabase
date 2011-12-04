package ie.cit.cloud.appdev.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Collection;
import java.util.List;

import ie.cit.cloud.appdev.EmployeeService;
import ie.cit.cloud.appdev.SecurityCheck;
import ie.cit.cloud.appdev.model.Employee;
import ie.cit.cloud.appdev.data.error.ErrorCodesMessages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.RequestContext;


/**
 * EmployeeContoller
 * 
 * @author paul bradley
 */
@Controller
public class EmployeeContoller {
	
	@Autowired
	EmployeeService employeeService;
	private ErrorCodesMessages errorCodes;

	// Function Name =  index()
	// Handles the Home Page
	// Show Options to List All Employees,Add New Employees
	//
	@RequestMapping(value = { "index", "" }, method = GET)
	public String index(Model model ) {
		model.addAttribute("employeeCount", employeeService.getEmployeesCount());
		return "index";
	}
	
	// Function Name =  getEmployeeListByDepartment()
	// Goes to the database and gets a list of all active employees for that department
	// Pay is restricted so does not get that, that via HR link
	//
	@RequestMapping(value = { "listByDepartment" }, method = GET)
	public String getEmployeeListByDepartment( @RequestParam String department,
												Model model ) {
		String returnView;
		if (department == null){
			model.addAttribute("errorcode",errorCodes.INVALID_DATA_SUBMITTED);
			returnView = "requestNotProcessed";
		}
		List<Employee> employeesByDept = employeeService.getEmployeeByDept(department); 
		
		if ( employeesByDept != null ){
			model.addAttribute("employees", employeesByDept);
			model.addAttribute("department", department);
			returnView = "listalldetails";
		}
		else{
			model.addAttribute("errorcode",errorCodes.NO_EMPLOYEES_FOUND);
			returnView = "requestNotProcessed";
		}
		return returnView;
	}
	
	// Function Name =  getEmployeeList()
	// Goes to the database and gets a list of all active employees for that department
	// Pay is restricted so does not get that
	//
	@RequestMapping(value = { "listAll" }, method = GET)
	public String getEmployeeList( Model model ) {
		int numEmployeeCount = employeeService.getEmployeesCount(); 
		if ( numEmployeeCount > 0 ){
			model.addAttribute("employees", employeeService.getAllEmployees());
			model.addAttribute("department", "ALL");
			return "listalldetails";
		}
		else{
			model.addAttribute("errorcode",errorCodes.NO_EMPLOYEES_FOUND);
			return "requestNotProcessed";
		}
	}
	// Function Name =  findEmployeeByName()
	// find the details of one individual employee.
	// returns errorCode if employee not present
	//
	@RequestMapping(value = { "findEmployeeByName", "" }, method = GET)
	public String findEmployeeByName(	@RequestParam String firstname,
								@RequestParam String lastname,
								Model model ) {
		
		if (firstname ==null || lastname ==null){
			model.addAttribute("errorcode",errorCodes.INVALID_DATA_SUBMITTED);
			return "requestNotProcessed";
		}	
		Employee employee = employeeService.getEmployeeByName(firstname, lastname);
		
		if ( employee != null ){
			model.addAttribute("employee", employee);
			model.addAttribute("secure", false);
			return "finddetails";
		}
		else{
			model.addAttribute("errorcode",errorCodes.EMPLOYEE_NAME_NOT_FOUND);
			return "requestNotProcessed";
		}
	} 
	
	// Function Name =  findEmployeeSalaryByName()
	// find the details of one individual employee.
	// returns errorCode if employee not present
	//
	@RequestMapping(value = { "secure/findEmployeeSalary.html", "" }, method = GET)
	public String findEmployeeSalaryByName(	@RequestParam String firstname,
								@RequestParam String lastname,
								Model model ) {
		
		boolean secureUserWithRole = SecurityCheck.checkIsThisAdmin(); 
		if (firstname ==null || lastname ==null){
			model.addAttribute("errorcode",errorCodes.INVALID_DATA_SUBMITTED);
			return "requestNotProcessed";
		}	
		Employee employee = employeeService.getEmployeeByName(firstname, lastname);
		
		if ( employee != null ){
			model.addAttribute("employee", employee);
			model.addAttribute("secure", true);
			return "finddetails";
		}
		else{
			model.addAttribute("errorcode",errorCodes.EMPLOYEE_NAME_NOT_FOUND);
			return "requestNotProcessed";
		}
	} 
	
	
	// Function Name =  findEmployeeByID()
	// find the details of one individual employee.
	// returns errorCode if employee not present
	//
	@RequestMapping(value = { "findEmployeeByID", "" }, method = GET)
	public String findEmployeeByID(	@RequestParam int  employeeID,
								Model model ) {
		if (employeeID < 0  ){
			model.addAttribute("errorcode",errorCodes.INVALID_DATA_SUBMITTED);
			return "requestNotProcessed";
		}
		Employee employee = employeeService.getEmployeeByID(employeeID);
		
		if ( employee != null ){
			model.addAttribute("employee", employee);
			model.addAttribute("secure", false);
			return "finddetails";
		}
		else{
			model.addAttribute("errorcode",errorCodes.EMPLOYEE_NAME_NOT_FOUND);
			return "requestNotProcessed";
		}
	}
	// Function Name =  createNewEmployeeDetails()
	// user requests to add new employee so we load the submit details page
	//
	@RequestMapping(value = { "secure/addnew", "" }, method = GET)
	public String createNewEmployeeDetails(Model model) {
		return "submitdetails";
	}

	// Function Name =  createNewEmployee()
	// Create a new Employee and then show the requested Details
	//
	@RequestMapping(value = { "secure/newdetails.html", "" }, method = POST)
	public String createNewEmployee(@RequestParam String firstname,
									@RequestParam String lastname, 
									@RequestParam String jobtitle,
									@RequestParam String department, 
									@RequestParam int salary,
									Model model) {
		Employee employee = employeeService.getEmployeeByName(firstname, lastname);
		
		if ( employee != null ){
			model.addAttribute("errorcode",errorCodes.EMPLOYEE_ALERADY_EXISTS);
			model.addAttribute("employee", employee);
			return "requestNotProcessed";
		}
		model.addAttribute("employee", employeeService.addNewEmployee(firstname, lastname, jobtitle,department,salary));
		return "details";
	}
	
	// Function Name =  createNewEmployee()
	// Create a new Employee and then show the requested Details
	//
	@RequestMapping(value = "secure/donedetails", method = GET)
    public String done( Model model) {
	return "redirect:/index.html";
    }
	
	// Function Name =  donedetails()
	// You've seen the details now go back to the home page.
	//
	@RequestMapping(value = "donedetails", method = GET)
    public String donedetails( Model model) {
	return "redirect:/index.html";
    }
	
	// Function Name =  doneErrorCodes()
	// There was an error in your request, we displayed it now we're sending you back to the home page
	//
	@RequestMapping(value = "errorCodes.html", method = GET)
    public String doneErrorCodes( Model model) {
	return "redirect:/index.html";
    }
	// Function Name =  doneSecureErrorCodes()
	// There was an error in your request, we displayed it now we're sending you back to the home page
	//
	@RequestMapping(value = "secure/errorCodes.html", method = GET)
    public String doneSecureErrorCodes( Model model) {
	return "redirect:/index.html";
    }


}
