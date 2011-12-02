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
	
	private static final String Paul = null;
	private static final String Bradley = null;
	private static final String Manager = null;
	private static final String Cork = null;
	private EmployeeServiceImpl testService;
	private JDBCEmployeeDataBase database;

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
	    //testService.repository= database;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEmployeeServiceImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllEmployees() {
		List<Employee> employees = testService.getAllEmployees();
		assertNotNull(employees);
		assertTrue(employees.isEmpty());
	}

	@Test
	public void testGetEmployeesCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddNewEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmployeeByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmployeeByID() {
		fail("Not yet implemented");
	}

}
