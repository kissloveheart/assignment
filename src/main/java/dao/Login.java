package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import context.DBContext;
import model.Account;

public class Login {
	public boolean checkLogin(String email,String password) {
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement ps = conn.prepareStatement("select count(*) as count from Account where user_mail =? and password =?");
			ps.setString(1,email);
			ps.setString(2,password);
			
			ResultSet rs = ps.executeQuery();
			int count = 0;
			if(rs.next()) {
				count = rs.getInt("count");
				
			}
			conn.close();
			if(count== 0) {
				return false;
			} else {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
		}
		
		return false;
		
	}
	
	
	public Account getAccount(String queryEmail) {
		try {
			Connection conn = new DBContext().getConnection();
			Account account = null;
			PreparedStatement ps = conn.prepareStatement("select * from Account where user_mail =?");
			ps.setString(1,queryEmail);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String email = rs.getString(1);
				String password = rs.getString(2);
				int  role = rs.getInt(3);
				String  username = rs.getString(4);
				String  address = rs.getString(5);
				String  phone = rs.getString(6);
				
				account = new Account(email, password, role, username, address, phone);
				
				
			}
			conn.close();
			return account;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
		}
		
		return null;
		
	}
	
	public int updateAccount(Account acc) {
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement ps = conn.prepareStatement("update public.account "
					+ "set user_name =?, user_address = ?,user_phone = ? "
					+ "where user_mail = ?");
			ps.setString(1, acc.getUsername());
			ps.setString(2, acc.getAddress());
			ps.setString(3, acc.getPhone());
			ps.setString(4, acc.getMail());
			int rs = ps.executeUpdate();
			
			conn.close();
			
			return rs;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
		}
		return 0;
	}
	
	

}
