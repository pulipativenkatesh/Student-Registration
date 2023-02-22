package studentRegistration.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertStudent
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("insert into registration values(?,?,?,?)");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the UserName.....");
		String username = sc.nextLine();
		
		System.out.println("Enter the Studentid.....");
		String studentid  =sc.nextLine();
		
		System.out.println("Enter the Student Name...");
		String studentname = sc.nextLine();
		
		System.out.println("Enter the Password...");
		int password = sc.nextInt();
		
		ps.setString(1, username);
		ps.setString(2, studentid);
		ps.setString(3, studentname);
		ps.setInt(4, password);
		
		int i = ps.executeUpdate();
		
		if(i != 0)
		{
			System.out.println("Inserted data...");
		}
		else
		{
			System.out.println("Not Inserted data.....");
		}
		conn.close();
		
	}

}
