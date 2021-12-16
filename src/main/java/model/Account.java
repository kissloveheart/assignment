package model;

public class Account {
	private String mail, password;
	private int role;
	private String username,address,phone;
	

	public Account() {
	}


	public Account(String mail, String password, String username) {
		this(mail,password,2,username,null,null);
	}


	public Account(String mail, String password, int role, String username, String address, String phone) {
		super();
		this.mail = mail;
		this.password = password;
		this.role = role;
		this.username = username;
		this.address = address;
		this.phone = phone;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getRole() {
		return role;
	}


	public void setRole(int role) {
		this.role = role;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	



	
}
