package com.cg.ems.UI;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.service.EmployeeService;
import com.cg.ems.service.EmployeeServiceImpl;

public class TestEmployeeClient {
	static Scanner sc = null;
	static EmployeeService empSer = null;

	public static void main(String[] args)
	{
		sc = new Scanner(System.in);
		empSer = new EmployeeServiceImpl();
		int choice= 0;
		while(true)
		{
			System.out.println("What do u want to do?");
			System.out.println("1.Add emp \t 2.Fetch all emp \n");
			System.out.println("3.Delete emp \t 4.Search emp by id \n");
			System.out.println("5.Search emp by name \t 6.update \n");
			System.out.println("7.exit\n");
			System.out.println("Enter ur choice");

			choice=sc.nextInt();
			switch(choice)
			{
			case 1 :addEmp();
					break;
			case 2 :showEmpInfo();
					break;
			case 3 :deleteEmp();
					break;
			case 4 :SearchEmpById();
					break;
			case 5 :SearchEmpByName();
					break;
			case 6 :update();
					break;		
			default :System.exit(0);		
			}
		}
	}
	private static void update() {
		// TODO Auto-generated method stub
		
	}
	private static void addEmp()
	{
		System.out.println("Enter Emp Id");
		int eid = sc.nextInt();
		try
		{
			if(empSer.validateDigit(eid))
			{
				System.out.println("Enter Emp name");
				String nm = sc.next();
				if(empSer.validateName(nm))
				{
					System.out.println("Enter salary");
					float sal = sc.nextFloat();
					System.out.println("enter DOJ(dd-MM-YYYY)");
					String empDOJStr = sc.next();
					
					Employee ee = new Employee(eid,nm,sal,empSer.convertFromStrToLocalDate(empDOJStr));
					int empId = empSer.addEmployee(ee);
					System.out.println(empId + "Added Successfully");
				}

			}
		}
		catch(EmployeeException e)
		{
			e.printStackTrace();
			
		}
	}
	private static void showEmpInfo()
	{
		HashSet<Employee> empSet = empSer.fetchAllEmp();
		Iterator<Employee> it = empSet.iterator();
		System.out.println("----------------------");
		System.out.println("EMPID \t \t EMPNAME \t \t EMPSalary");
		
		while(it.hasNext())
		{
			Employee ee = it.next();
			System.out.println(ee.getEmpId()+"\t\t"+ee.getEmpName()+"\t\t"+ee.getEmpsal()+"\t\t"+ee.getEmpDOJ());
		}
	}
	
	private static void SearchEmpById()
	{
		System.out.println("Enter Emp id");
		int empId = sc.nextInt();
		Employee e = empSer.getEmpById(empId);
		if(e!=null)
		{
			System.out.println(e);
		}
		else 
			System.out.println("Id not Found");
	}
	private static void SearchEmpByName()
	{
		System.out.println("Enter Emp Name");
		String name = sc.next();
		HashSet<Employee> e = empSer.searchEmpByName(name);
		if(e!=null)
		{
			System.out.println(e);
		}
		else 
			System.out.println("Name not Found");
	}
	
	private static void deleteEmp(){
		System.out.println("Enter Emp id to delete");
		int empId = sc.nextInt();
		int n = empSer.deleteEmp(empId);
		if(n==1)
		{
			System.out.println( empId+" successfully removed");
		}
		else{
			System.out.println("not found");
		}
	}
	
}
