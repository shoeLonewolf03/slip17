//Write a java program to create a student table with field’s rno, name and per.
//Insert values in the table. Display all the details of the student on screen.
//(Use PreparedStatement Interface).


import java.sql.*;
import java.io.*;
public class Slip16B 
{
	public static void main(String args[]) 
	{
		PreparedStatement ps;
		ResultSet rs;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AssignmentDB", "root","aroroot10@");

			if (con == null) 
			{
				System.out.println("Connection Failed......");
				System.exit(1);
			}
			
			System.out.println("Connection Esatablished......");
			Statement stmt = con.createStatement();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String query = "insert into Student values(?,?,?)";
			ps = con.prepareStatement(query);
			System.out.println("Enter roll no : ");
			int rno = Integer.parseInt(br.readLine());
			System.out.println("Enter name : ");
			String sname = br.readLine();
			System.out.println("Enter per : ");
			int per = Integer.parseInt(br.readLine());
			ps.setInt(1, rno);
			ps.setString(2, sname);
			ps.setInt(3, per);
			int no = ps.executeUpdate();
			if (no != 0)
				System.out.println("Data inserted succesfully.....");
			else
				System.out.println("Data not inserted");
			// display details
			rs = stmt.executeQuery("select * from Student");
			System.out.println("rno\t" + "sname\t" + "per");
			while (rs.next()) 
			{
				System.out.println("\n" + rs.getInt(1) + "\t" + rs.getString(2) +"\t" + rs.getInt(3));
			}
			con.close();
		} 
		
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
}
