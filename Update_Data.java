package labJDBCMaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update_Data 
{
	private Scanner s;

	void updateData()
	{
		Scanner sc=new Scanner(System.in);
		Scanner s=new Scanner(System.in);
		
		String url = "jdbc:mysql://localhost:3306/project1";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		String update_id="update student set S_id=? where S_id=? ;";
		String update_name="update student set Name=? where S_id=?;";
		String update_sub="update student set subject=? where S_id=?;";
		String update_mar="update student set marks =? where S_id=? ;";
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try
		{
			Class.forName(driver);
			System.out.println("Driver loaded successfully");
			con = DriverManager.getConnection(url,"root","password");
			System.out.println("Connection Established");
			
			System.out.println("Enter student id to update: ");
			int S_id=s.nextInt();
			
			System.out.println("Enter the data you want to update: ");
			System.out.println("1: student id ");
			System.out.println("2: student name ");
			System.out.println("3: student subject ");
			System.out.println("4: student marks ");
			int ch=s.nextInt();
			
			switch(ch)
			{
			case 1: pstmt = update_Laptop_Model_no(sc,  update_id, con, S_id);
					break;
					
			case 2: pstmt = update_Laptop_Name(sc, update_name, con, S_id);
					break;
					
			case 3: pstmt = update_Laptop_Brand(sc, update_sub, con, S_id);
					break;
					
			case 4: pstmt = update_Loptop_Prices(s, update_mar, con, S_id);
					break;
					
			}
			
			System.out.println("Data Updated....");
		}
		catch(ClassNotFoundException | SQLException e)
		{
			System.out.println(e);
		}
		finally
		{
			try 
			{
				pstmt.close();
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			sc.close();
			s.close();
		}
	}

	private PreparedStatement update_Loptop_Prices(Scanner sc, String update_mar, Connection con, int S_id)
	throws SQLException
	{
		PreparedStatement pstmt;
			System.out.println("Enter student marks: ");
					int mar=s.nextInt();
					pstmt=con.prepareStatement(update_mar);
					pstmt.setInt(2, S_id);
					pstmt.setInt(1,mar);
					pstmt.executeUpdate();
			return pstmt;
	}

	private PreparedStatement update_Laptop_Brand(Scanner sc, String update_sub, Connection con, int S_id) 
			throws SQLException
	{
		PreparedStatement pstmt;
		System.out.println("Enter student subject: ");
				String sub=sc.nextLine();
				pstmt=con.prepareStatement(update_sub);
				pstmt.setInt(2, S_id);
				pstmt.setString(1,sub);
				pstmt.executeUpdate();
		return pstmt;
	}

	private PreparedStatement update_Laptop_Name(Scanner sc, String update_name, Connection con, int S_id) 
			throws SQLException
	{
		PreparedStatement pstmt;
		System.out.println("Enter student Name: ");
				String name=sc.nextLine();
				pstmt=con.prepareStatement(update_name);
				pstmt.setInt(2, S_id);
				pstmt.setString(1,name);
				pstmt.executeUpdate();
		return pstmt;
	}

	private PreparedStatement update_Laptop_Model_no(Scanner sc, String update_id, Connection con, int S_id) 
			throws SQLException
	{	
		PreparedStatement pstmt;
		System.out.println("Enter student id : ");
				int id=sc.nextInt();
				pstmt=con.prepareStatement(update_id);
				pstmt.setInt(2, S_id);
				pstmt.setInt(1,id);
				pstmt.executeUpdate();
		return pstmt;
	}
}
