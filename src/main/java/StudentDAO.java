import java.sql.*;
import java.util.*;
public class StudentDAO {
	static Connection con;
	public static Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection
("jdbc:mysql://localhost:3306/servlet?autoReconnect=true&useSSL=false","root","SPAVAGCE");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	public static int SaveStud(Student s)
	{
		
		int res=0;
		try
		{
		con=StudentDAO.getConnection();
		PreparedStatement pst=con.prepareStatement("insert into users1 values(?,?,?)");
		pst.setInt(1, s.getRollno());
		pst.setString(2, s.getName());
		pst.setString(3, s.getCity());
		
		res=pst.executeUpdate();
		
		}catch(Exception e)		{
			System.out.println(e);
		}
		return res;
	}
	public static List<Student>showStud()
	{
		List<Student> list=new ArrayList<Student>();
		try
		{
			con=StudentDAO.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select  * from users1");
			while(rs.next())
			{
				Student s=new Student();
				s.setRollno(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setCity(rs.getString(3));
				list.add(s);
			}
			con.close();
		}
		catch(Exception e) {}
		return list;
	}
	
	public static int DelStud(int rno)
	{	
		int res=0;
		try
		{
			con=StudentDAO.getConnection();
			PreparedStatement pst=con.prepareStatement("delete from users1 where rollno=?");
			pst.setInt(1, rno);
			pst.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return res;
	}
	
	public static int UpdateStud(Student s)
	{
		int res=0;
		try
		{
			con=StudentDAO.getConnection();
			PreparedStatement pst=con.prepareStatement("update users1 set name=?,city=? where rollno=?");
			pst.setString(1, s.getName());
			pst.setString(2, s.getCity());
			pst.setInt(3, s.getRollno());
			res=pst.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return res;
	}
	
}

