package DAO;
import java.util.*;

import model.Member;

import java.sql.*;

public class MemDao {
	public static Connection getConnection()
	{
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "password");
			
		}catch(Exception e) {System.out.println(e);}
		
		return con;
	}
	
	public static int save(model.Member m)
	{
		int status = 0;
		try{
			Connection con = DAO.MemDao.getConnection();
		
		
		PreparedStatement ps = con.prepareStatement(
				
				"insert into member(name,phone,email,password) values(?,?,?,?)"
				
				);
		ps.setString(1,m.getName());
		ps.setString(2,m.getPhone());
		ps.setString(3,m.getEmail());
		ps.setString(4,m.getPassword());
		
		status = ps.executeUpdate();
		con.close();
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		
		return status;
	}
	
	public static List<Member> getAllMember()
	{
		List<Member> list = new ArrayList<Member>();
		
		
		try {
			
			Connection con = MemDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from member");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Member m = new Member();
				m.setMemberID(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setEmail(rs.getString(3));
				m.setPhone(rs.getString(5));
				
				list.add(m);
				
			}
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public static int delete(int memberID)
	{
		int status = 0;
		
		try {
			Connection con = MemDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from member where memberID=?");
			ps.setInt(1, memberID);
			status = ps.executeUpdate();
			
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
		
	}
	
	public static Member getMemberById(int memberID)
	{
		Member m = new Member();
		try {
			Connection con = MemDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"select * from member where memberID=?"
					);
			ps.setInt(1, memberID);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				m.setMemberID(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setEmail(rs.getString(3));
				m.setPassword(rs.getString(4));
				m.setPhone(rs.getString(5));
			}
			con.close();
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		return m;
	}
	
	public static int update(Member m)
	{
		int status = 0;
		try {
			Connection con = MemDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update member set name=?,phone=?,email=?,password=? where memberID=?"
					);
		ps.setString(1, m.getName());
		ps.setString(2, m.getEmail());
		ps.setString(3, m.getPhone());
		ps.setString(4, m.getPassword());
		ps.setInt(5, m.getMemberID());
		
		status = ps.executeUpdate();
		
		con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return status;
	}
}
