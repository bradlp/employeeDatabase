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
	@RequestMapping(value = { "index", "" }, method = GET)
	public String index(Model model ) {
		model.addAttribute("employeeCount", employeeService.getEmployeesCount());
	return "index";
	}
	
	@RequestMapping(value = { "index2", "" }, method = GET)
	public String getEmployeeList( Model model ) {
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "index";
	}
	// Function Name = createNewEmployeeDetails
	// Load Up An Employee Details Input Page
	@RequestMapping(value = { "index", "" }, method = POST)
	public String createNewEmployeeDetails(@RequestParam String firstname,
										Model model) {
		return "redirect:submitdetails.html";
	}

	// Function Name = submitdetails
	// Add a new user based on firstname, lastname, jobtitle
	@RequestMapping(value = { "submitdetails", "" }, method = GET)
	public String submitdetails(Model model) {
		return "submitdetails";
	}
	// Add a new user based on firstname, lastname, jobtitle
	@RequestMapping(value = { "submitdetails", "" }, method = POST)
	public String createNewEmployee(@RequestParam String firstname,
									@RequestParam String lastname, 
									@RequestParam String jobtitle,
									Model model) {
		employeeService.addNewEmployee(firstname, lastname, jobtitle);
		return "details";
	}

	// Function Name = getEmployeeDetails
	// Shows All Employees
	@RequestMapping(value = { "details", "" }, method = GET)
	public String getEmployeeDetails(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "index";
	}
   
	@RequestMapping(value = "donedetails", method = GET)
    public String done( Model model) {
	return "redirect:index.html";
    }
}
