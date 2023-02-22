package studentRegistration.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

public class DisplayDatas 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
		System.out.println("User Nmae\t\tStudent Id\t\tStudent Name \t\t\tPassword");
		//Statement st = conn.createStatement();
		//ResultSet rs = st.executeQuery("select * from registration");
		/*while(rs.next())
		{
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t\t\t "+rs.getString(3)+"\t\t"+rs.getInt(4));
		}
		conn.close();*/
		PreparedStatement ps = conn.prepareStatement("select * from registration where username = ?");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the username...");
		String username = sc.nextLine();
		
		ps.setString(1, username);
		
		ResultSet rs= ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
		}
		
		
		conn.close();
		
	
	}

}
