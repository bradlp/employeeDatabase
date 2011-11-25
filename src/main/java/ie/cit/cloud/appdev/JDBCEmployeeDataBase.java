/**
 * 
 */
package ie.cit.cloud.appdev;


import ie.cit.cloud.appdev.model.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Paul Bradley
 */
@Repository
public class JDBCEmployeeDataBase implements EmployeeDataBase {
	JdbcTemplate jdbcTemplate;

	/**
	 * 
	 */
	@Autowired
	public JDBCEmployeeDataBase(DataSource ds) {
		// TODO Auto-generated constructor stub
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
						+ "(employeeId, lastname, firstname, jobTitle, department,phoneExtn, salary) values(?,?,?,?,?,?,?)",
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

	/*
	 * getEmployeeByName
	 * 
	 * @see
	 * ie.cit.cloud.appdev.EmployeeDataBase#GetEmployeeByName(java.lang.String,
	 * java.lang.String)
	 */
	public Employee getEmployeeByName(String fistname, String lastName) {
		return jdbcTemplate.queryForObject(
				"select employeeId, lastname, firstname, jobTitle, department,phoneExtn, salary from Employee where firstname=?,lastname=?",
				new EmployeeRowMapper(), fistname,lastName );
	}
    
	/*
	 * getAllEmployees
	 * 
	 * @see ie.cit.cloud.appdev.EmployeeDataBase#GetEmployeeById()
	 */
	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query("select employeeId, lastname, firstname, jobTitle, department,phoneExtn, salary from Employee",
				new EmployeeRowMapper());
	}
	
	/*
	 * getEmployeeById
	 * 
	 * @see ie.cit.cloud.appdev.EmployeeDataBase#GetEmployeeById()
	 */
	public Employee getEmployeeById(int employeeId) {
		return jdbcTemplate.queryForObject(
				"select employeeId, lastname, firstname, jobTitle, department,phoneExtn, salary from Employee where employeeId=?",
				new EmployeeRowMapper(), employeeId);
	}

	/**
	 * Mapper that converts ResultSet into {@link Employee} object
	 */
	public static class EmployeeRowMapper implements RowMapper<Employee> {
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Employee(rs.getInt("employeeId"),rs.getString("lastname"),
					rs.getString("firstname"), rs.getString("jobTitle"),
					rs.getString("department"), rs.getInt("phoneExtn"),
					rs.getInt("salary"));

		}
	}
}
