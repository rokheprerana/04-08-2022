package labJDBCMaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Fetch_Data 
{
	void fetchdata()
	 {
		
		String url = "jdbc:mysql://localhost:3306/project1";
		String driver = "com.mysql.cj.jdbc.Driver";
		String select = "select * from student ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try
		{
			Class.forName(driver);
			System.out.println("Driver loaded successfully");
			
			con = DriverManager.getConnection(url,"root","password");
			System.out.println("Connection Established");
			
			pstmt = con.prepareStatement(select);
			System.out.println("Platform created successfully ");
			ResultSet rs = pstmt.executeQuery(select);

			while(rs.next())
			{
				int S_id = rs.getInt("S_id");
				String Name = rs.getString("Name");
			
				String subject = rs.getString("subject");
				int marks = rs.getInt("marks");
				System.out.println(S_id+" "+Name+" "+subject+" "+marks);
			}
	    }
		catch(ClassNotFoundException | SQLException e)
		{
			System.out.println(e);
		}
			try 
			{
				pstmt.close();
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
	}
}
