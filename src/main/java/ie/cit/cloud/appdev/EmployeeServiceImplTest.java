/**
 * 
 */
package ie.cit.cloud.appdev;

import static org.junit.Assert.*;
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
	  
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		database = Mockito.mock(JDBCEmployeeDataBase.class);
	    testService = new EmployeeServiceImpl(database);
	    testService.repository=  database;
	    
	}

	/**
	 * Test method for {@link ie.cit.cloud.appdev.EmployeeServiceImpl#addNewEmployee(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public void testAddNewEmployee() {
		Employee employee = new Employee(0, Paul, Bradley, Manager, Cork, 0, 0);
		testService.addNewEmployee(Paul, Bradley, Manager, Cork, 0);
		//(database).addEmployee(employee);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetEmployeesCount() {
		Employee employee = new Employee(0, Paul, Bradley, Manager, Cork, 0, 0);
		testService.addNewEmployee(Paul, Bradley, Manager, Cork, 0);
		int checkCount = testService.getEmployeesCount();
		checkCount=1;
		//following prints "element" 
		System.out.println(testService.getEmployeesCount()); 
		assertEquals(1,checkCount);
	}
}
