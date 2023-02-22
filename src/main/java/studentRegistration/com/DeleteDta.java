package studentRegistration.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteDta
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("delete from registration where StudentName=?");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Student Name....");
		String studentName = sc.nextLine();
		
		ps.setString(1, studentName);
		int i = ps.executeUpdate();
		if(i != 0)
		{
			System.out.println("Sucessfully data deleted....");
		}
		else
		{
			System.out.println("something went wrong...");
		}
		conn.close();
		
		
	}

}
