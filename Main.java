package labJDBCMaven;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		try
		{
		System.out.println("Enter the Data you want to perform:");
		System.out.println("1. Create Table");
		System.out.println("2. Insert Data");
		System.out.println("3. Update Data");
		System.out.println("4. Delete Data");
		System.out.println("5. Fetch  Data");
		int ch=sc.nextInt();
		switch (ch)
		{
			case 1:	CreateTable ct=new CreateTable();
					ct.createtable();
					break;
					
			case 2: Insert_Data Id=new Insert_Data();
					Id.insertdata();
					break;
					
			case 3: Update_Data ud=new Update_Data();
					ud.updateData();
					break;
					
			case 4: Delete_Data del=new Delete_Data();
					del.deleteData();
					break;
					
			case 5: Fetch_Data fd=new Fetch_Data();
					fd.fetchdata();
					break;	
		}
		}
		catch(Exception e){}
		finally
		{	
			sc.close();
		}

	}

}
