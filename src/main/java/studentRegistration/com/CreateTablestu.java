package studentRegistration.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTablestu 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
		Statement st = conn.createStatement();
		
		st.execute("create table registration (username varchar(40) not null,studentid varchar(10) not null,StudentName varchar(40) not null,Password int(10) primary key)");
		System.out.println("Table Created....");
		
		conn.close();
	}

}
