package ie.cit.cloud.appdev.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import ie.cit.cloud.appdev.EmployeeService;
import ie.cit.cloud.appdev.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * EmployeeContoller
 * 
 * @author paul bradley
 */
@Controller
public class EmployeeContoller {
	
	@Autowired
	private EmployeeService employeeService;

	// Function Name =  index()
	// Handles the Home Page
	// Show Options to List All Employees,Add New Employees
	//
	@RequestMapping(value = { "index", "" }, method = GET)
	public String index(Model model ) {
		model.addAttribute("employeeCount", employeeService.getEmployeesCount());
	return "index";
	}
	
	// Function Name =  getEmployeeList()
	// Goes to the database and gets a list of all active employees
	// Pay is rescricted so does not get that
	//
	@RequestMapping(value = { "listAll" }, method = GET)
	public String getEmployeeList( Model model ) {
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "listalldetails";
	}
	
	// Function Name =  findEmployee()
	// find the details of one individual employee.
	//
	@RequestMapping(value = { "findEmployee", "" }, method = GET)
	public String findEmployee(	@RequestParam String firstname,
								@RequestParam String lastname,
								Model model ) {
		model.addAttribute("employee", employeeService.getEmployeeByName(firstname, lastname));
		return "finddetails";
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
		model.addAttribute("employee", employeeService.addNewEmployee(firstname, lastname, jobtitle,department,salary));
		return "details";
	}
	
   
	@RequestMapping(value = "secure/donedetails", method = GET)
    public String done( Model model) {
	return "redirect:/index.html";
    }
	
	@RequestMapping(value = "donedetails", method = GET)
    public String donedetails( Model model) {
	return "redirect:/index.html";
    }
}
