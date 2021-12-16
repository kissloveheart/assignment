package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import context.DBContext;
import model.Account;

public class NewAccount {
	
	public boolean checkEmail(String email) {
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement ps = conn.prepareStatement("select count(*) as count from account where user_mail =?");
			ps.setString(1,email);	
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
            System.err.println(e.getClass().getName()+": "+e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	public void newAccount(Account account) {
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into public.account(user_mail,password, account_role,user_name)"
					+ "values (?,?,?,?)");
			ps.setString(1,account.getMail());
			ps.setString(2,account.getPassword());
			ps.setInt(3,account.getRole());
			ps.setString(4,account.getUsername());			
			ps.executeUpdate();
			
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
		}
	}

}
