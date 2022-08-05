package labJDBCMaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Statement;

public class CreateTable 
{
	void createtable() 
	{
		String url = "jdbc:mysql://localhost:3306/project1";
		String driver = "com.mysql.cj.jdbc.Driver";
		String create = "CREATE TABLE `student` (`S_id` INT NOT NULL,`Name` CHAR(45) NOT NULL, `subject` CHAR(45) NOT NULL, `marks` INT(4) NOT NULL,PRIMARY KEY(`S_id`), UNIQUE INDEX `S_id_UNIQUE` (`S_id` ASC) VISIBLE);";
		Connection con = null;
		Statement stmt = null;
		
		try
		{
			Class.forName(driver);
			System.out.println("Driver loaded successfully");
			
			con = DriverManager.getConnection(url,"root","password");
			System.out.println("Connection Established Successfully..");
			
			stmt = con.createStatement();
			System.out.println("Platform created successfully ..");
			
			stmt.execute(create);
			System.out.println("Table created...");
		}
		catch(ClassNotFoundException | SQLException e)
		{
			System.out.println(e);
		}
		
			try 
			{
				stmt.close();
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}

	
	}

}
