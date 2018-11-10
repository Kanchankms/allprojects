import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class TestSelectDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement st = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "system";
		String pwd = "corp123";
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,uid,pwd);
			st = con.createStatement();
			rs = st.executeQuery(QueryMapper.SELECTQRY1);
			//rs.next();  //for iteration 
			System.out.println("EMPID\t\tEMPNAME\t\tEMPSAL\t\tEMPDOB");
			
			while(rs.next())   //to iterate till all the records are fetched
			{
			System.out.println(rs.getInt("emp_id")+"\t\t"+rs.getString("emp_name")+"\t\t"
					+rs.getFloat("emp_sal")+"\t\t"+rs.getDate("emp_dob"));
			}
		}
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
