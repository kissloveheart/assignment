package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import context.DBContext;
import model.Product;

public class ListProduct {
	public List<Product> getListProduct(String key,int start, int end) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DBContext context = new DBContext();
		List<Product> list = new ArrayList<>();

		try {
			conn = context.getConnection();
//			udfGetProductList is a function on database
			String query = "select * from udfGetProductList('"+key+"',"+start+","+end+")";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String description = rs.getString(3);
				double price = rs.getDouble(4);
				String source = rs.getString(5);
				String type = rs.getString(6);
				String brand = rs.getString(7);
				// create new instance product
				Product product = new Product(id, name, description, price, source, type, brand);
				list.add(product);

			}	
			conn.close();
			return list;
		} catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
			return null;
		} 

	}
	
	public int getNumberProduct(String key) {
		return getListProduct(key, 1, Integer.MAX_VALUE).size();
	}

	public  Product getProduct(String idd) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DBContext context = new DBContext();
		Product product = null;

		try {
			conn = context.getConnection();
			ps = conn.prepareStatement("select * from products where product_id = ?");
			ps.setInt(1,Integer.valueOf(idd));
			rs = ps.executeQuery();

			while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String description = rs.getString(3);
			double price = rs.getDouble(4);
			String source = rs.getString(5);
			String type = rs.getString(6);
			String brand = rs.getString(7);
			
			// create new instance product
			product = new Product(id, name, description, price, source, type, brand);
			
			}
			conn.close();
			return product;
			
		} catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
			return null;
		}

	}

	
}
