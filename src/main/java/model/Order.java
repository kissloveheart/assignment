package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class Order {
	private String mail;
	private int orderId;
	private String status;
	private Date date;
	private String phone;
	private String address;
	private String coupon;	
	private List<Product> listItems;
	private double totalPrice;
	
	
	


	public Order() {
	
	}
	
	public Order(String mail, String phone, String address) {
		this.mail = mail;
		this.phone = phone;
		this.address = address;
	}
	

	
	
	public Order( int orderId, String status, Date date, String phone, String address, String coupon)
			{
		super();
		this.orderId = orderId;
		this.status = status;
		this.date = date;
		this.phone = phone;
		this.address = address;
		this.coupon = coupon;
		listItems = new ArrayList<>();
	}

	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public List<Product> getListItems() {
		return listItems;
	}

	public void setListItems(List<Product> listItems) {
		this.listItems = listItems;
	}
	
	
	public double getTotalPrice() {
		
		double total = listItems.stream().map(Product::getAmount).reduce(0.0,Double::sum);
		return Math.round(total*100)/100.0;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
