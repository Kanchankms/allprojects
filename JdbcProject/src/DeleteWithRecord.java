import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class DeleteWithRecord {

	public static void main(String[] args) {
		
				Connection con = null;
				Statement st = null;
				PreparedStatement pst = null;
				ResultSet rs = null;
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String uid = "system";
				String pwd = "corp123";
				Scanner sc = new Scanner(System.in);
				System.out.println("enter Emp id:");
				int eid = sc.nextInt();
				System.out.println("enter Emp Name:");
				String enm = sc.next();
				System.out.println("enter Emp Salary:");
				float esal= sc.nextFloat();
				
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection(url,uid,pwd);
					
					st = con.createStatement();
					pst = con.prepareStatement(QueryMapper.SELECTQRY2);
					pst.setInt(1, eid);
					if(rs!=null)
					{												//not done
						rs = st.executeQuery(QueryMapper.DELETEQRY1);
						pst = con.prepareStatement(QueryMapper.UPDATEQRY1);
						pst.setInt(3, eid);
						pst.setString(1, enm);
						pst.setFloat(2, esal);
						int data = pst.executeUpdate();
						
						System.out.println("Data updated..");
					}
					
				}
				
				
				catch(Exception e)
				{
					e.printStackTrace();
				}


			


	}

}
