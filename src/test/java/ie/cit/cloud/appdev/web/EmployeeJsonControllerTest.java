package ie.cit.cloud.appdev.web;

import static org.junit.Assert.*;

import java.util.List;

import ie.cit.cloud.appdev.EmployeeService;
import ie.cit.cloud.appdev.model.Employee;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

public class EmployeeJsonControllerTest {

	private EmployeeJsonController myController;
	private EmployeeService employeeService;

	@Before
	public void setUp() throws Exception {
		employeeService = Mockito.mock(EmployeeService.class);
		myController = new EmployeeJsonController();
		myController.employeeService=employeeService;
	}

	@Test
	public void testEmployeeController()
	{
		EmployeeJsonController controller = new EmployeeJsonController();
		assertNotNull(controller);
	}

	@Test
	public void testGetEmployeeList()
	{
		List<Employee> employees = myController.getEmployeeList();
		assertNull(employees);
	}

	@Test
	public void testFindEmployeeByName()
	{
		Employee employee = myController.getEmployeeByName("Paul:Bradley");
		assertNull(employee);
	}
	
	@Test
	public void testFindEmployeeSalaryByName()
	{
		Employee employee = myController.getEmployeeByID(0);
		assertNull(employee);
	}

}
