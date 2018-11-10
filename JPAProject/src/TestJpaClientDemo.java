import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.cg.bean.Student;
import com.cg.dao.StudentDaoImpl;


public class TestJpaClientDemo {

	public static void main(String[] args)
	{
		StudentDaoImpl stoDao=new StudentDaoImpl();
		Scanner sc=new Scanner(System.in);
		/*System.out.println(" Enter roll No:");
		int rn=sc.nextInt();*/
		System.out.println("Enter Name:");
		String nm=sc.next();
		
		Student st=new Student();
		//st.setRollNo(rn);
		st.setStuName(nm);
		Student stu=stoDao.addStudent(st);
		System.out.println("Data inserted in the table\n"+stu);
		
		System.out.println("---------Retrieve Student Base on rollno.------------");
		//System.out.println("Enter ");				//do it by user input
		Student student=stoDao.getStuByRollNo(1);
		System.out.println(student);
		
		System.out.println("---------Retrieve all data and display------------");
		List<Student> stList=stoDao.getAllStudents();
		Iterator<Student> it=stList.iterator();
		System.out.println(" RollNo\t\t\t STUNAME");
		System.out.println("------------------------------------------------");
		while(it.hasNext())
		{
			Student tempStu=it.next();
			System.out.println(tempStu.getRollNo()+"\t\t"+tempStu.getStuName());
		}
		
		
		System.out.println("-------------------------------------------------");
		System.out.println("Delete rollno 6");
		System.out.println("Record deleted for:"+stoDao.deleteStudent(6));
		
		
		System.out.println("--------------------Update name----------------------------");
		Student st3=stoDao.updateStudent(3, "karamjeet");
		System.out.println("updated: "+st3);
	}

}
