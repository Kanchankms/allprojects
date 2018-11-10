package com.cg.ems.junit;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.ems.dao.EmployeeDao;
import com.cg.ems.dao.EmployeeDaoImpl;
import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;

public class EmployeeDaoImplTest {
static EmployeeDao empdao = null;
	
@BeforeClass
public static void setUp()
{
	empdao = new EmployeeDaoImpl();
	
}

@Test
public void addEmpTest() throws EmployeeException
{
	Assert.assertEquals(112, empdao.addEmployee(new Employee(112,"aaa",1111.0F,LocalDate.now())));
}
}
