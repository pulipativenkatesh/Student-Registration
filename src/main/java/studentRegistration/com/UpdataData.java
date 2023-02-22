package studentRegistration.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdataData 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
		
		PreparedStatement ps  = conn.prepareStatement("update registration set StudentName = ? where studentid=?");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Student id ....");
		String studentid = sc.nextLine();
		
		System.out.println("Enter the Update Student Name....");
		String studentname = sc.nextLine();
		
		ps.setString(1, studentname);
		ps.setString(2, studentid);
		
		int i = ps.executeUpdate();
		if(i != 0)
		{
			System.out.println("sucessfully Updated....");
		}
		else
		{
			System.out.println("Not Updated data something went wrong...");
		}
		conn.close();
	}

}
