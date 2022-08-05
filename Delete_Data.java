package labJDBCMaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete_Data 
{
	@SuppressWarnings("null")
	void deleteData()
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/project1";
		String driver = "com.mysql.cj.jdbc.Driver";
		@SuppressWarnings("unused")
		String Delete = "delete from student where marks=?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try
		{
			Class.forName(driver);
			System.out.println("Driver loaded successfully");
			con = DriverManager.getConnection(url,"root","password");
			System.out.println("Connection Established");
			
			System.out.println("Enter marks to delete: ");
			int marks=sc.nextInt();
			pstmt.setInt(1, marks);
			
			pstmt.executeUpdate();
			System.out.println("student with marks" + marks + "has been deleted from database");
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
