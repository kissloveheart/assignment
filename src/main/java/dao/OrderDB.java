package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Cart;
import model.Order;
import model.Product;

public class OrderDB {
	/**
	 * 
	 * @param order
	 * @return id order
	 */
	public int createOrder(Order order) {
		try {
			int orderId = 0;
			Connection conn = new DBContext().getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into orders(user_mail,order_phone,order_address) "
					+ "values(?,?,?)");
			ps.setString(1, order.getMail());
			ps.setString(2, order.getPhone());
			ps.setString(3, order.getAddress());
			ps.executeUpdate();
			// get new id orders
			
			ps = conn.prepareStatement("select order_id from orders order by order_id desc limit 1");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				orderId = rs.getInt(1);
			}
			
			conn.close();
			return orderId;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());			
		}
		return 0;
	}
	/**
	 * 
	 * @param order
	 * @param cart
	 * @return result of execute sql
	 */
	public int createOrderDetail(Order order, Cart cart) {
		try {
			int orderId = createOrder(order);
			List<Product> list = cart.getListItems();
			Connection conn = new DBContext().getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into Orders_detail(order_id, product_id, amount_product) values(?,?,?)");
			ps.setInt(1, orderId);		
			for (Product product : list) {
				ps.setInt(2, product.getId());
				ps.setInt(3, product.getNumber());
				ps.executeUpdate();
			}
			conn.close();
			return 1;			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
		}
		return 0;
	}
	
	public List<Order> getListOrdered(String email) {
		List<Order> list = new ArrayList<>();	
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from Orders where user_mail = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			//get list order id
			while(rs.next()) {
				int id = rs.getInt(2);
				String status = rs.getString(3);
				Date date = rs.getDate(4);
				String coupon = rs.getString(5);
				String address = rs.getString(6);
				String phone = rs.getString(7);
				
				Order order = new Order(id, status, date, phone, address, coupon);
				list.add(order);
			}
			// get list item each order
			
			for (Order order : list) {
				String query = "select p.product_id,p.product_name,p.product_price,o.amount_product\r\n"
						+ "from Orders_detail as o join Products as p on o.product_id = p.product_id \r\n"
						+ "where order_id = ?";
				ps = conn.prepareStatement(query);
				ps.setInt(1, order.getOrderId());
				rs = ps.executeQuery();
				//add item to the list order
				while(rs.next()) {
					int productId = rs.getInt(1);
					String name = rs.getString(2);
					double price = rs.getDouble(3);
					int amount = rs.getInt(4);
					
					Product product = new Product(productId, name, price, amount);
					order.getListItems().add(product);
				}
			
			}
			
			conn.close();
			return list;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
		}	
		
		return null;
				
	}
	

}
