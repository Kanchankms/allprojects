package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.cg.bean.Student;
import com.cg.util.JPAUtil;



public class StudentDaoImpl
{
	EntityTransaction tran=null;
	EntityManager em=null;
	public StudentDaoImpl()
	{
		em=JPAUtil.getEntityManager();
	}
	public Student addStudent(Student stu)
	{
		
		tran=em.getTransaction();
		tran.begin();
		em.persist(stu);			//insert
		tran.commit();
		return stu;
	}
	public List<Student> getAllStudents()
	{
		String selQuery="SELECT st FROM Student st";
		TypedQuery<Student> myQry=em.createQuery(selQuery,Student.class);
		List<Student> stuList=myQry.getResultList();
		return stuList;
	
	}
	public Student getStuByRollNo(int rollNo)
	{
		Student st=em.find(Student.class, rollNo);
		return st;
	}
	public Student updateStudent(int rno, String newName)
	{
		Student st=new Student();
		st.setRollNo(rno);
		st.setStuName(newName);
		tran.begin();
		em.merge(st);
		tran.commit();
		return st;
	}
	public Student deleteStudent(int rollNo)
	{
		Student st=em.find(Student.class, rollNo);
		tran.begin();
		em.remove(st);
		tran.commit();
		return st;
	}
	
	
}
