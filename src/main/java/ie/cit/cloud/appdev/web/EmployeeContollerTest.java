package ie.cit.cloud.appdev.web;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ie.cit.cloud.appdev.EmployeeService;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

public class EmployeeContollerTest {

	private EmployeeContoller myController;
	private EmployeeService employeeService;

	@Before
	public void setUp() throws Exception {
		employeeService = Mockito.mock(EmployeeService.class);
		myController = new EmployeeContoller();
		myController.employeeService=employeeService;
	}
	
	@Test
	public void testEmployeeControllerr()
	{
		EmployeeContoller controller = new EmployeeContoller();
		assertNotNull(controller);
	}

	@Test
	public void testGetEmployeeList()
	{
		Model model = new ExtendedModelMap();
		String returnValue = myController.getEmployeeList(model);
		assertEquals("requestNotProcessed", returnValue);	
	}

	@Test
	public void testFindEmployeeByName()
	{
		Model model = new ExtendedModelMap();
		String returnValue = myController.findEmployeeByName("Paul", "Bradley", model);
		assertEquals("requestNotProcessed", returnValue);
	}
	
	@Test
	public void testFindEmployeeSalaryByName()
	{
		Model model = new ExtendedModelMap();
		String returnValue = myController.findEmployeeSalaryByName("Paul", "Bradley", model);
		assertEquals("requestNotProcessed", returnValue);
	}
	
	@Test
	public void testFindEmployeeByID()
	{
		Model model = new ExtendedModelMap();
		String returnValue = myController.findEmployeeByID(0, model);
		assertEquals("requestNotProcessed", returnValue);
	}
	
	@Test
	public void testCreateNewEmployee()
	{
		Model model = new ExtendedModelMap();
		String returnValue = myController.createNewEmployee("Paul", "Bradley", "Manager", "Engineering", 50000, model);
		assertEquals("details", returnValue);
	}
	@Test
	public void testDonedetails()
	{
		Model model = new ExtendedModelMap();
		String returnValue = myController.donedetails(model);
		assertEquals("redirect:/index.html", returnValue);
	}
	@Test
	public void testDone()
	{
		Model model = new ExtendedModelMap();
		String returnValue = myController.done(model);
		assertEquals("redirect:/index.html", returnValue);
	}
}
