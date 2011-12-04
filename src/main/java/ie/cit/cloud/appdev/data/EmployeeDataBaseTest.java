package ie.cit.cloud.appdev.data;

import static org.junit.Assert.*;

import java.util.Collection;

import javax.sql.DataSource;

import ie.cit.cloud.appdev.EmployeeService;
import ie.cit.cloud.appdev.EmployeeServiceImpl;
import ie.cit.cloud.appdev.model.Employee;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDataBaseTest{
	static DataSource mockDS;
	static JDBCEmployeeDataBase JDBCTestdb;
	static EmployeeDataBase dataBase;
	static JdbcTemplate mockJdbcTemplate;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		mockDS = Mockito.mock(DataSource.class);
		mockJdbcTemplate = Mockito.mock(JdbcTemplate.class);
		
		JDBCTestdb = new JDBCEmployeeDataBase(mockDS);
		dataBase =new JDBCEmployeeDataBase(mockDS);
		JDBCTestdb.jdbcTemplate = mockJdbcTemplate;
	}

	@Test
	public void testgetAllEmployeesByDepartment(){
		// Havent found a way to mock the ds and template so these test currently failing
		Collection<Employee>  employees =dataBase.getAllEmployeesByDepartment("Engineering");
		assertNotNull(employees);
	}

	@Test
	public void testAddEmployee() {
		Employee test = new Employee(0, "Paul", "Bradley", "Manager", "Engineering", 1879, 30000);
		int retCode = dataBase.addEmployee(test);
		assertNotNull(retCode);
	}

	@Test
	public void testDeleteEmployee() {
		Employee test = new Employee(0, "Paul", "Bradley", "Manager", "Engineering", 1879, 30000);
		int retCode = dataBase.deleteEmployee(test);
		assertNotNull(retCode);
	}
	@Test
	public void testListEmployees() {
		Collection<Employee> employees = dataBase.getAllEmployees();
		assertNotNull(employees);
	}
	
	

}
