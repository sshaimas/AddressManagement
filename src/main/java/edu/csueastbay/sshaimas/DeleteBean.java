// Sebastian Shaimas
// CS 351, Section 1
// Assignment 7

package edu.csueastbay.sshaimas;

import java.io.Serializable;
import java.sql.*;

public class DeleteBean implements Serializable{
	
	public DeleteBean() {}
	
	public String fetchRecords() throws SQLException{
		String records = "";
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs351_db", "root" , "root");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from addresses");
			while (resultSet.next()) {
				String fname = "-";
				String sname = "-";
				String telephone = "-";
				String mobile = "-";
				String email = "-";
				String address = "-";
				String postalnr = "-";
				String town = "-";
				String country = "-";
				
				if(resultSet.getString("fname") != null) {
					fname = resultSet.getString("fname");
				}
				if(resultSet.getString("sname") != null) {
					sname = resultSet.getString("sname");
				}
				if(resultSet.getString("telephone") != null) {
					telephone = resultSet.getString("telephone");
				}
				if(resultSet.getString("mobile") != null) {
					mobile = resultSet.getString("mobile");
				}
				if(resultSet.getString("email") != null) {
					email = resultSet.getString("email");
				}
				if(resultSet.getString("address") != null) {
					address = resultSet.getString("address");
				}
				if(resultSet.getString("postalnr") != null) {
					postalnr = resultSet.getString("postalnr");
				}
				if(resultSet.getString("town") != null) {
					town = resultSet.getString("town");
				}
				if(resultSet.getString("country") != null) {
					country = resultSet.getString("country");
				}
				
				records += "<tr><td>" + fname + "</td><td>" + sname + "</td><td>" + telephone + "</td><td>" + mobile + "</td><td>" + email + "</td><td>" + address + "</td><td>" + postalnr + "</td><td>" + town + "</td><td>" + country + 
						 "</td><td><form name=\"deleteForm\" method=\"post\" action=\"exDelete.jsp\"><input type=\"submit\" name=\"button\" value=\"Delete\"><input type=\"hidden\" id=\"deleteID\" name=\"deleteID\" value=" +
						 resultSet.getString("id") + "></form></td></tr>";
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
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

		return records;
	}
	
	public void deleteRecord(int record) throws SQLException{
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs351_db", "root" , "root");
			statement=connection.prepareStatement("DELETE FROM addresses WHERE ID = ?");
			statement.setInt(1,record);
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
