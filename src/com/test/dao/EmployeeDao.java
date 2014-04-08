package com.test.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;

import com.test.datasource.EmployeeMapper;
import com.test.model.Employee;


public class EmployeeDao {
	
	private DataSource dataSource; 
	private JdbcTemplate jdbcTemplateObject;

	public Employee getStudent(Integer id) {
		// TODO Auto-generated method stub
		String SQL = "select * from employee where id = ?";
		Employee employee = jdbcTemplateObject.queryForObject(SQL,new Object[]{id}, new EmployeeMapper() );
		return employee;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		System.out.println("insiede SETTERERE");
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
}
