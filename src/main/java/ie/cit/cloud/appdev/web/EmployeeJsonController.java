package ie.cit.cloud.appdev.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import ie.cit.cloud.appdev.EmployeeService;
import ie.cit.cloud.appdev.model.Employee;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * create: curl -i -H "Content-Type: application/json" -X POST -d '{"text":"Remember the Milk"}' http://localhost:8080/week_5_lab_res/api/todo
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
@RequestMapping("api")
public class EmployeeJsonController {

	@Autowired
	private EmployeeService employeeService;

	// Function Name =  getEmployeeList()
	// Goes to the database and gets a list of all active employees
	// Pay is rescricted so does not get that
	//
	@RequestMapping("list")
    @ResponseBody
	public List <Employee> getEmployeeList() {
		return employeeService.getAllEmployees();
	}
}
