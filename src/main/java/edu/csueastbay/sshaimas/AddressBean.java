// Sebastian Shaimas
// CS 351, Section 1
// Assignment 7

package edu.csueastbay.sshaimas;

import java.io.Serializable;
import java.sql.*;

public class AddressBean implements Serializable{
	private String fname;
	private String sname;
	private String telephone;
	private String mobile;
	private String email;
	private String address;
	private String postalnr;
	private String town;
	private String country;
	
	public AddressBean() {}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalnr() {
		return postalnr;
	}

	public void setPostalnr(String postalnr) {
		this.postalnr = postalnr;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public boolean checkValidity() {
		if(fname != null && (telephone != null || mobile != null || email != null)) {
			return true;
		}
		return false;
	}
	
	public void insertToDB() throws SQLException{
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs351_db", "root" , "root");
			statement=connection.prepareStatement("INSERT INTO addresses VALUES(NULL,?,?,?,?,?,?,?,?,?)");
			statement.setString(1,fname);
			statement.setString(2,sname);
			statement.setString(3,telephone);
			statement.setString(4,mobile);
			statement.setString(5,email);
			statement.setString(6,address);
			statement.setString(7,postalnr);
			statement.setString(8,town);
			statement.setString(9,country);
			statement.executeUpdate();  
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		finally {
			if (resultSet != null) {
				resultSet.close();
			}
			
			if (statement != null) {
				statement.close();
			}
			
			if (connection != null) {
				connection.close();
			}
		}
	}

}
