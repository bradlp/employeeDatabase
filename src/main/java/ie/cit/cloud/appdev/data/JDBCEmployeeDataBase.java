/**
 * 
 */
package ie.cit.cloud.appdev.data;


import ie.cit.cloud.appdev.model.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 
 * @author Paul Bradley
 */
@Repository
public class JDBCEmployeeDataBase implements EmployeeDataBase {
	JdbcTemplate jdbcTemplate;
	private static final Logger logger = Logger.getLogger(JDBCEmployeeDataBase.class);

	/**
	 * 
	 */
	@Autowired
	public JDBCEmployeeDataBase(DataSource ds) {
		jdbcTemplate = new JdbcTemplate(ds);
	}

	/*
	 * addEmployee
	 * 
	 * @see
	 * ie.cit.cloud.appdev.EmployeeDataBase#AddEmployee(ie.cit.cloud.appdev.
	 * model.Employee)
	 */
	public int addEmployee(Employee employee) {
		jdbcTemplate
				.update("insert into Employee "
						+ "(employeeId, firstname,lastname, jobTitle, department,phoneExtn, salary) values(?,?,?,?,?,?,?)",
						employee.getEmployeeId(),employee.getLastName(), employee.getFirstName(),
						employee.getJobTitle(), employee.getDepartment(),
						employee.getPhoneExtn(), employee.getSalary());
		return 0;
	}

	/*
	 * deleteEmployee
	 * 
	 * @see ie.cit.cloud.appdev.EmployeeDataBase#DeleteEmployeeById(int)
	 */
	public int deleteEmployee(Employee employee) {
		jdbcTemplate.update("delete from Employee where id=?",
				employee.getEmployeeId());
		return 0;
	}

	// Function Name =  getAllEmployees()
	// Look up for a employee based on entire company, catch exception in case its empty
	// Caller will check for null returns
	//
	public Employee getEmployeeByName(String fistname, String lastName) {
		Employee employee;
		try {
			employee = jdbcTemplate.queryForObject(
					"select employeeId, firstname, lastname, jobTitle, department,phoneExtn, salary from Employee where lastname=?",
					new EmployeeRowMapper(),lastName );
		}
		catch (DataAccessException ex) {
			logger.error("No data returned for query on Employee Name.");
			employee=null;
		}
		return employee;
	}
    
	// Function Name =  getAllEmployees()
	// Look up for a employee based on entire company, catch exception in case its empty
	// Caller will check for null returns
	//
	public List<Employee> getAllEmployees() {
		List<Employee> employees;
		try {
			employees = jdbcTemplate.query("select employeeId, firstname, lastname, jobTitle, department,phoneExtn, salary from Employee",
					new EmployeeRowMapper());
		}
		catch (DataAccessException ex) {
			logger.error("No data returned for query on all employees.");
			employees=null;
		}
		return employees;
	}

	// Function Name =  getAllEmployeesByDepartment()
	// Look up for a employee based on Dept, catch exception in case its empty
	// Caller will check for null returns
	//
	public List<Employee> getAllEmployeesByDepartment(String department) {
		List<Employee> employees;
		try {
			employees = jdbcTemplate.query("select employeeId, firstname, lastname, jobTitle, department,phoneExtn, salary from Employee where department=?",
					new EmployeeRowMapper(),department);
		}
		catch (DataAccessException ex) {
			logger.error("No data returned for query on dept.");
			employees=null;
		}
		return employees;
	}
	
	// Function Name =  getEmployeeById()
	// Look up for a employee based on ID, catch exception in case its empty
	// Caller will check for null returns
	//
	public Employee getEmployeeById(int employeeId) {
		Employee employee;
		try {
			employee = jdbcTemplate.queryForObject(
					"select employeeId, firstname, lastname,  jobTitle, department,phoneExtn, salary from Employee where employeeId=?",
					new EmployeeRowMapper(), employeeId);
		}
		catch (DataAccessException ex) {
			logger.error("No data returned for query on ID.");
			employee=null;
		}
		return employee;
	}

	/**
	 * Mapper that converts ResultSet into {@link Employee} object
	 */
	public static class EmployeeRowMapper implements RowMapper<Employee> {
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Employee(rs.getInt("employeeId"),rs.getString("firstname"),
					rs.getString("lastname"), rs.getString("jobTitle"),
					rs.getString("department"), rs.getInt("phoneExtn"),
					rs.getInt("salary"));

		}
	}
}
