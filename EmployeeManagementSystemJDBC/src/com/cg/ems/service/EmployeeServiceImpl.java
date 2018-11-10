package com.cg.ems.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.regex.Pattern;

import com.cg.ems.dao.EmployeeDao;
import com.cg.ems.dao.EmployeeDaoImpl;
import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;

public class EmployeeServiceImpl implements EmployeeService
{
	EmployeeDao empDao = null;
	public EmployeeServiceImpl()
	{
		empDao = new EmployeeDaoImpl();
	
	}
	@Override
	public int addEmployee(Employee ee) throws EmployeeException {
		// TODO Auto-generated method stub
		return empDao.addEmployee(ee);
	}
	@Override
	public HashSet<Employee> fetchAllEmp() {
		// TODO Auto-generated method stub
		return empDao.fetchAllEmp();
	}
	@Override
	public Employee getEmpById(int empId) {
		// TODO Auto-generated method stub
		return empDao.getEmpById(empId);
	}
	@Override
	public HashSet<Employee> searchEmpByName(String name) {
		// TODO Auto-generated method stub
		return empDao.searchEmpByName(name);
	}
	@Override
	public int deleteEmp(int empId) {
		// TODO Auto-generated method stub
		return empDao.deleteEmp(empId);
	}
	@Override
	public Employee updateEmp(int empId, String newName, float newSal) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean validateDigit(int num) throws EmployeeException {
		
		Integer input = new Integer(num);
		String inputStr = input.toString();
		String digitPattern = "[0-9]+";
		if(Pattern.matches(digitPattern, inputStr))
		{
			return true;
		}
		else
		{
			throw new EmployeeException("Invalid input. only digits allowed");
		
		}
	}
	@Override
	public boolean validateName(String name) throws EmployeeException {
		String namePattern = "[A-Z][a-z]+";
		if(Pattern.matches(namePattern, name))
		{
			return true;
		}
		else
		{
			throw new EmployeeException("Invalid input. only characters allowed "+
					"and should start with capital letters");
		
		}	
	}
	@Override
	public LocalDate convertFromStrToLocalDate(String dtStr) {
		// TODO Auto-generated method stub
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.parse(dtStr, myFormat);
		return date;
	}
	
	/*public Date convertFromLocalDateToStrDate(LocalDate emp_dob) {
		java.sql.Date sqlDob = java.sql.Date.valueOf(localDOB)
		
		return sqldate;
	}
	*/
}
