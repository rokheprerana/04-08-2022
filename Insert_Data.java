package labJDBCMaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert_Data 
{
	void insertdata()
	{
		Scanner sc=new Scanner(System.in);
		Scanner s=new Scanner(System.in);
		
		String url = "jdbc:mysql://localhost:3306/project1";
		String driver = "com.mysql.cj.jdbc.Driver";
		String insert="INSERT INTO `student`(`S_id`,`Name`,`subject`,`marks`)VALUES(?,?,?,?)";
		
		Connection con=null;
		PreparedStatement pstmt=null;
		try 
		{
			Class.forName(driver);
			System.out.println("Driver Loaded...");
			
			con=DriverManager.getConnection(url,"root","password");
			System.out.println("Connection established succesfully ...");
			
			pstmt=con.prepareStatement(insert);
			System.out.println("Statement created succesfully ...");
			
			for(int i=0; i<4;i++)
			{
				System.out.println("Enter student Id:");
				int id=sc.nextInt();
				
				System.out.println("Enter student name:");
				String name=s.nextLine();
				
				System.out.println("Enter subject:");
				String sub=s.nextLine();
				
				System.out.println("Enter marks:");
				int mar=sc.nextInt();
				
				pstmt.setInt(1,id);
				pstmt.setString(2, name);
				pstmt.setString(3, sub);
				pstmt.setInt(4, mar);
				
				pstmt.executeUpdate();
				System.out.println("Data Entered successfully...");
			}
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		s.close();
		sc.close();
	}
}
