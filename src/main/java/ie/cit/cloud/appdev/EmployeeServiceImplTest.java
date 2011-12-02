	package ie.cit.cloud.appdev;
	
	import static org.junit.Assert.*;
	
	import java.util.List;
	
	import ie.cit.cloud.appdev.*;
	import ie.cit.cloud.appdev.model.Employee;
	
	import org.junit.After;
	import org.junit.AfterClass;
	import org.junit.Before;
	import org.junit.BeforeClass;
	import org.junit.Test;
	import org.mockito.Mockito;
	
	/**
	 * @author paul bradley
	 *
	 */

public class EmployeeServiceImplTest {
	
	private static final String PAUL = "Paul";
	private static final String BRADLEY = "Bradley";
	private static final String MANAGER = "Manager";
	private static final String CORK = "Cork";
	private EmployeeServiceImpl testService;
	private JDBCEmployeeDataBase database;

	private EmployeeService testEmployeeService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		database = Mockito.mock(JDBCEmployeeDataBase.class);
	    testService = new EmployeeServiceImpl(database);
		testEmployeeService = new EmployeeServiceImpl(database);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEmployeeServiceImpl() {
		EmployeeServiceImpl testEmployeeService = new EmployeeServiceImpl(database);
		assertNotNull(testEmployeeService);
	}

	@Test
	public void testGetAllEmployees() {
		List<Employee> employees = testEmployeeService.getAllEmployees();
		assertNotNull(employees);
		assertTrue(employees.isEmpty());
	}

	@Test
	public void testGetEmployeesCount() {
		List<Employee> employees = testEmployeeService.getAllEmployees();
		assertNotNull(employees);
		int testCount = testService.getEmployeesCount();
		assertNotNull(testCount);
	}

	@Test
	public void testAddNewEmployee() {
		EmployeeServiceImpl testEmployeeService = new EmployeeServiceImpl(database);
		assertNotNull(testEmployeeService);
		
		Employee employee = new Employee(0, "Paul", "Bradley", "Manager", "Engineering",189,1);	
		//testEmployeeService.addNewEmployee(PAUL, Bradley, Manager, Cork, 0);
		Mockito.verify(database).addEmployee(employee);

	}

	@Test
	public void testGetEmployeeByName() {
		Employee employee  = testEmployeeService.getEmployeeByName(PAUL, BRADLEY);
		assertNull(employee);
	}
	
	@Test
	public void testGetEmployeeByID() {
		Employee employee  = testEmployeeService.getEmployeeByID(0);
		assertNull(employee);	
	}

}
