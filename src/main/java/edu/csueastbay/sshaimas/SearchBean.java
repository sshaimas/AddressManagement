// Sebastian Shaimas
// CS 351, Section 1
// Assignment 7

package edu.csueastbay.sshaimas;

import java.io.Serializable;
import java.sql.*;

public class SearchBean implements Serializable{
	private String fname;
	private String sname;
	private String telephone;
	private String mobile;
	private String email;
	private String address;
	private String postalnr;
	private String town;
	private String country;
	
	public SearchBean() {}

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
	
	public String searchDB() throws SQLException{
		String results = "";
		
		if(fname == null && sname == null && telephone == null && mobile == null && email == null && address == null && postalnr == null && town == null && country == null) {
			return "";
		}
		
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs351_db", "root" , "root");

			String searchQuery = "SELECT * FROM addresses WHERE ";
			
			boolean fnameB = false;
			boolean snameB = false;
			boolean telephoneB = false;
			boolean mobileB = false;
			boolean emailB = false;
			boolean addressB = false;;
			boolean postalnrB = false;
			boolean townB = false;
			boolean countryB = false;
			
			boolean needAnd = false;
			if(fname != null) {
				searchQuery += "fname = ? ";
				needAnd = true;
				fnameB = true;
			}
			if(sname != null && needAnd) {
				searchQuery += "AND sname = ? ";
				snameB = true;
			}
			else if(sname != null && !needAnd) {
				searchQuery += "sname = ?";
				needAnd = true;
				snameB = true;
			}
			if(telephone != null && needAnd) {
				searchQuery += "AND telephone = ? ";
				telephoneB = true;
			}
			else if(telephone != null && !needAnd) {
				searchQuery += "telephone = ? ";
				needAnd = true;
				telephoneB = true;
			}
			if(mobile != null && needAnd) {
				searchQuery += "AND mobile = ? ";
				mobileB = true;
			}
			else if(mobile != null && !needAnd) {
				searchQuery += "mobile = ? ";
				needAnd = true;
				mobileB = true;
			}
			if(email != null && needAnd) {
				searchQuery += "AND email = ? ";
				emailB = true;
			}
			else if(email != null && !needAnd) {
				searchQuery += "email = ? ";
				needAnd = true;
				emailB = true;
			}
			if(address != null && needAnd) {
				searchQuery += "AND address = ? ";
				addressB = true;
			}
			else if(address != null && !needAnd) {
				searchQuery += "address = ? ";
				needAnd = true;
				addressB = true;
			}
			if(postalnr != null && needAnd) {
				searchQuery += "AND postalnr = ? ";
				postalnrB = true;
			}
			else if(postalnr != null && !needAnd) {
				searchQuery += "postalnr = ? ";
				needAnd = true;
				postalnrB = true;
			}
			if(town != null && needAnd) {
				searchQuery += "AND town = ? ";
				townB = true;
			}
			else if(town != null && !needAnd) {
				searchQuery += "town = ? ";
				needAnd = true;
				townB = true;
			}
			if(country != null && needAnd) {
				searchQuery += "AND country = ?";
				countryB = true;
			}
			else if(country != null && !needAnd) {
				searchQuery += "country = ?";
				needAnd = true;
				countryB = true;
			}
			
			preparedStatement = connection.prepareStatement(searchQuery);
			
			int count = 1;
			if(fnameB) {
				preparedStatement.setString(count++, fname);
			}
			if(snameB) {
				preparedStatement.setString(count++, sname);
			}
			if(telephoneB) {
				preparedStatement.setString(count++, telephone);
			}
			if(mobileB) {
				preparedStatement.setString(count++, mobile);
			}
			if(emailB ) {
				preparedStatement.setString(count++, email);
			}
			if(addressB) {
				preparedStatement.setString(count++, address);
			}
			if(postalnrB) {
				preparedStatement.setString(count++, postalnr);
			}
			if(townB) {
				preparedStatement.setString(count++, town);
			}
			if(countryB) {
				preparedStatement.setString(count++, country);
			}
			
			resultSet = preparedStatement.executeQuery();			

			while (resultSet.next()) {
				String fnameOutput = "-";
				String snameOutput = "-";
				String telephoneOutput = "-";
				String mobileOutput = "-";
				String emailOutput = "-";
				String addressOutput = "-";
				String postalnrOutput = "-";
				String townOutput = "-";
				String countryOutput = "-";
				
				if(resultSet.getString("fname") != null) {
					fnameOutput = resultSet.getString("fname");
				}
				if(resultSet.getString("sname") != null) {
					snameOutput = resultSet.getString("sname");
				}
				if(resultSet.getString("telephone") != null) {
					telephoneOutput = resultSet.getString("telephone");
				}
				if(resultSet.getString("mobile") != null) {
					mobileOutput = resultSet.getString("mobile");
				}
				if(resultSet.getString("email") != null) {
					emailOutput = resultSet.getString("email");
				}
				if(resultSet.getString("address") != null) {
					addressOutput = resultSet.getString("address");
				}
				if(resultSet.getString("postalnr") != null) {
					postalnrOutput = resultSet.getString("postalnr");
				}
				if(resultSet.getString("town") != null) {
					townOutput = resultSet.getString("town");
				}
				if(resultSet.getString("country") != null) {
					countryOutput = resultSet.getString("country");
				}
				
				results += "<tr><td>" + fnameOutput + "</td><td>" + snameOutput + "</td><td>" + telephoneOutput + 
						"</td><td>" + mobileOutput + "</td><td>" + emailOutput + "</td><td>" + addressOutput + 
						"</td><td>" + postalnrOutput + "</td><td>" + townOutput + "</td><td>" + countryOutput + "</td></tr>";
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (resultSet != null) {
				resultSet.close();
			}
			
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			
			if (connection != null) {
				connection.close();
			}
		}
		
		return results;
	}

}
