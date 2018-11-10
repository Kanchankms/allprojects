import java.util.List;

import javax.persistence.EntityManager;

import com.cg.bean.Address;
import com.cg.bean.Student;
import com.cg.dao.StudentDaoImpl;
import com.cg.util.JPAUtil;


public class TestStuOneToOneClient
{
	static EntityManager em=null;
	static StudentDaoImpl stuDao=null;
	public static void main(String[] args)
	{
		stuDao=new StudentDaoImpl();
		em=JPAUtil.getEntityManager();
		Address address1=new Address();
		address1.setCity("Pune");
		address1.setState("MS");
		address1.setStreet("PK STREET");
		address1.setZipCode("20021");
		
		Address address2=new Address();
		address2.setCity("RANCHI");
		address2.setState("UP");
		address2.setStreet("GT ROAD");
		address2.setZipCode("20021");
		
		Student st1=new Student();
		st1.setStuName("kanchan");
		st1.setStuAdd(address1);
		
		Student st2=new Student();
		st2.setStuName("misti");
		st2.setStuAdd(address2);
		
		stuDao.addStudent(st1);
		stuDao.addStudent(st2);
		System.out.println("Both students are added");
		System.out.println("------------------------------");
		List<Student> stList=stuDao.getAllStudents();
		System.out.println(stList);

	}

}
