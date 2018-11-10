package com.cg.bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestInheritanceClient {

	public static void main(String[] args)
	{
		 EntityManagerFactory fact=Persistence.createEntityManagerFactory("JPA-PU-Oracle");			
		 EntityManager em=fact.createEntityManager();
		 EntityTransaction tran=em.getTransaction();
		 
		 Employee e1=new Employee();
		 e1.setEmpId(111);
		 e1.setEmpName("mansi");
		 e1.setEmpSal(1000.0F);
		 
		 Manager e2=new Manager();
		 e2.setEmpId(112);
		 e2.setEmpName("sia");
		 e2.setEmpSal(2000.0F);
		 e2.setDeptName("IT");
		 
		 tran.begin();
		 em.persist(e1);
		 em.persist(e2);
		 tran.commit();
		 System.out.println("data added");
		 
		 
		
	}

}
