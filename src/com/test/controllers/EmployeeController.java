package com.test.controllers;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.dao.EmployeeDao;
import com.test.model.Employee;

@Controller
public class EmployeeController {
	
	private EmployeeDao employeeDao;

	@Autowired
	public void setEmployeeDao(EmployeeDao employeeDao) {
		System.out.println("Employee dao has been set" + employeeDao);
		this.employeeDao = employeeDao;
	}

	public EmployeeDao getEmployeeDao() {
		return this.employeeDao;
	}
	
	@RequestMapping(value="/employee.html" , method = RequestMethod.GET)
	public String showAddPage(){
		System.out.println("hit!!");
		return "redirect:/EmpData.html";
	}
	
	@RequestMapping(value = "/getEmpName.html", method = RequestMethod.GET)
	public @ResponseBody String getEmployeeName(@RequestParam(value="id", required=true) String id) throws JsonGenerationException, JsonMappingException, IOException{
		System.out.println("ID IS:>>> " + id);
		Employee lEmployee = getEmployeeDao().getStudent(Integer.parseInt(id));
		System.out.println(lEmployee.getFirstName() + "  .... "+ lEmployee.getLastName());
		ObjectMapper objectMapper = new ObjectMapper();  
		return objectMapper.writeValueAsString(lEmployee);
		
	}
	
}
