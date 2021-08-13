package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class user {

	// connect to the database
	private Connection connect() { 
	 
		Connection con = null; 
			try{ 
				
					Class.forName("com.mysql.jdbc.Driver"); 
	 
					//database name, username , password
					con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/slt", "root", ""); 
			} 
			catch (Exception e) {
				
				e.printStackTrace();
				
			} 
			
			return con; 
	 } 
	
	
	
	
	public String insertUser(String first_name, String last_name, String em, String usern, String pass) { 
	 
		String output = "";
		
		try{ 
			
			Connection con = connect();
			
			if (con == null) {
				
				return "Error while connecting to the database for inserting."; 
				
			} 
			
			//query
			String query = " insert into user (`first_name`,`last_name`,`em`,`usern`, `pass`)"+ " values (?, ?, ?, ?, ?)"; 
			
			//create preparestatement
			PreparedStatement preparedStmt = con.prepareStatement(query); 
			
			// set values
			preparedStmt.setString(1, first_name); 
			preparedStmt.setString(2, last_name); 
			preparedStmt.setString(3, em); 
			preparedStmt.setString(4, usern); 
			preparedStmt.setString(5, pass); 
	 
			//execute
			preparedStmt.execute(); 
			con.close();
			
			String newUser = readUser(); 
			 output = "{\"status\":\"success\", \"data\": \"" + 
			 newUser + "\"}"; 
			
		} 
		catch (Exception e) { 
			output = "{\"status\":\"error\", \"data\":  \"Error while inserting the user.\"}"; 
					 System.err.println(e.getMessage()); 
		} 
		
		return output; 
	 } 
	
	public String readUser() { 
		
		String output = ""; 
		
		
			try{ 
				
				Connection con = connect(); 
				
				if (con == null) {
					
					return "Error while connecting to the database for reading."; 
					
				} 
	 
				//create html table
				output = "<table border=\"1\"><tr> <th>First Name</th> <th>Last Name</th> <th>Email</th> <th>Username</th> <th>Password</th> <th>Update</th><th>Remove</th></tr>"; 
				
				//query
				String query = "select * from user"; 
				//create statement
				Statement stmt = (Statement) con.createStatement(); 
				
				//create resultset
				ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
				
				
				while (rs.next()) { 
					
						String id = Integer.toString(rs.getInt("id")); 
						String first_name = rs.getString("first_name"); 
						String last_name = rs.getString("last_name"); 
						String em =rs.getString("em"); 
						String usern = rs.getString("usern"); 
						String pass = rs.getString("pass");
						
						// Add into the html table
						output += "<tr><td><input id='hidItemIDUpdate' name='hidItemIDUpdate' type='hidden' value='" + id + "'>"
								 + first_name + "</td>";
								 //output += "<td>"+ first_name + "</td>"; 
								 output += "<td>" + last_name + "</td>"; 
								 output += "<td>" + em + "</td>"; 
								 output += "<td>" + usern + "</td>";
								 output += "<td>" + pass + "</td>";
						
						
						
						// buttons
								 output += "<td><input name='btnUpdate' type='button' value='Upadate' class='btnUpdate btn btn-danger' data-id='" + id + "'>"
										 +"</td>"
										 +"<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-id='" + id + "'></td>";
										

								 
								 
								 
								 
									
				}
				
				con.close(); 
				output += "</table>";
			} 
			catch (Exception e) { 
				
				 output = "{\"status\":\"error\", \"data\":  \"Error while updating the user.\"}"; 
				 System.err.println(e.getMessage()); 
			 
	 
			} 
			return output; 
	
	} 
	
	public String updateUser(String id,String first_name, String last_name, String em, String usern, String pass){ 
		
		
		 String output = ""; 
		 
		 try{
			 
			 
			 Connection con = connect(); 
			 
			 if (con == null) {
				 
				 return "Error while connecting to the database for updating."; 
				 
			 } 
			 
			 
			 	// query
			 	String query = "UPDATE user SET first_name=?,last_name=?,em=?,usern=?, pass=? WHERE id=?"; 
			 	
			 	//create statement
			 	PreparedStatement preparedStmt = con.prepareStatement(query); 
			 	
			 	
			 		// set values
			 		
			 		preparedStmt.setString(1, first_name); 
			 		preparedStmt.setString(2, last_name); 
			 		preparedStmt.setString(3, em); 
			 		preparedStmt.setString(4, usern); 
			 		preparedStmt.setString(5, pass);
			 		preparedStmt.setInt(6, Integer.parseInt(id));
			 		
			 		// execute the statement
			 		preparedStmt.execute(); 
			 		con.close();
			 		
			 		String newUser = readUser(); 
					 output = "{\"status\":\"success\", \"data\": \"" + 
					 newUser + "\"}"; 
		 
		 } 
		 
		 
		 catch (Exception e) { 
			 
			 output = "{\"status\":\"error\", \"data\":  \"Error while updating the user.\"}"; 
			 System.err.println(e.getMessage()); 
		 
		 }
		 
		 return output; 
		 
	} 
	
	
		public String deleteUser(String id) { 
			
			
		 String output = ""; 
		 
		 try{ 
			 
			 
			 	Connection con = connect(); 
			 	
			 	
			 		if (con == null) {
			 			
			 			return "Error while connecting to the database for deleting.";
			 			
			 		} 
			 		
			 		
			 			// query
			 			String query = "delete from user where id=?"; 
			 			
			 			//create statment
			 			PreparedStatement preparedStmt = con.prepareStatement(query);
			 			
			 			
			 			// binding values
			 			preparedStmt.setInt(1, Integer.parseInt(id)); 
			 			
			 			// execute the statement
			 			preparedStmt.execute(); 
			 			con.close(); 
			 			
			 			String newUser = readUser(); 
						 output = "{\"status\":\"success\", \"data\": \"" + 
						 newUser + "\"}"; 
		 
		 } 
		 
		 catch (Exception e) {
			 
			 output = "{\"status\":\"error\", \"data\":  \"Error while deleting the user.\"}"; 
			 System.err.println(e.getMessage());
		 } 
		 
		 	return output; 
		 
		} 
		
		public String login(String EMP_NAME) {
			
			String output ="";
			
			try {
				
				Connection con = connect();
				
				if(con == null) {
					
					return "error while connecting to dadabase";
				}
				
				System.out.println("error");
				
				//query
				String query = "select `EMP_NAME` from user where EMP_NAME =?";
				
				//create statement
				PreparedStatement preparedStmt = con.prepareStatement(query);
				
				System.out.println(preparedStmt);
				System.out.println(EMP_NAME);
				
				
				preparedStmt.setString(1, EMP_NAME);
				
				
				ResultSet rs = preparedStmt.executeQuery();
				
				
				if(rs.next()) {
					
					con.close();
					output = "success";
				}
				else {
					
					con.close();
					if(EMP_NAME.equals("")) {
						
						return "User cannot be empty";
					}
					
					
					else {
						
						return "incorrect username or password";
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				output = "Error while deleting the user."; 
				 System.err.println(e.getMessage()); 
				
			}
			return output;
		}
		
		
		public String insertAdmin(String first_name, String last_name, String em, String usern, String pass) { 
			 

			String output = "";
			
			try{ 
				
				Connection con = connect();
				
				if (con == null) {
					
					return "Error while connecting to the database for inserting."; 
					
				} 
				
				//query
				String query = " insert into admin (`first_name`,`last_name`,`em`,`usern`, `pass`)"+ " values (?, ?, ?, ?, ?)"; 
				
				//create preparestatement
				PreparedStatement preparedStmt = con.prepareStatement(query); 
				
				// set values
				preparedStmt.setString(1, first_name); 
				preparedStmt.setString(2, last_name); 
				preparedStmt.setString(3, em); 
				preparedStmt.setString(4, usern); 
				preparedStmt.setString(5, pass); 
		 
				//execute
				preparedStmt.execute(); 
				con.close();
				
				String newUser = readUser(); 
				 output = "{\"status\":\"success\", \"data\": \"" + 
				 newUser + "\"}"; 
				
			} 
			catch (Exception e) { 
				output = "{\"status\":\"error\", \"data\":  \"Error while inserting the admin.\"}"; 
						 System.err.println(e.getMessage()); 
			} 
			
			return output; 
		 } 
		
		public String readAdmin() { 
			
			String output = ""; 
			
			
			try{ 
				
				Connection con = connect(); 
				
				if (con == null) {
					
					return "Error while connecting to the database for reading."; 
					
				} 
	 
				//create html table
				output = "<table border=\"1\"><tr> <th>Reference Number</th> <th>MSAN_Name</th> <th>Prgress Status</th> <th>Request Time</th> <th>Enterd By</th> <th>Enterd On</th> <th>Assign To</th> <th>Assign On</th> <th>Completed On</th> <th>Update</th><th>Remove</th></tr>"; 
				
				//query
				String query = "select * from msan_req"; 
				//create statement
				Statement stmt = (Statement) con.createStatement(); 
				
				//create resultset
				ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
				
				
				while (rs.next()) { 
					
						String RF_NO = Integer.toString(rs.getInt("RF_NO")); 
						String MSAN_NAME = rs.getString("MSAN_NAME"); 
						String PROGRESS_STATUS = rs.getString("PROGRESS_STATUS"); 
						String REQ_TIME =rs.getString("REQ_TIME"); 
						String ENTERED_BY = rs.getString("ENTERED_BY"); 
						String ENTERED_ON = rs.getString("ENTERED_ON");
						String ASSIGN_TO = rs.getString("ASSIGN_TO");
						String ASSIGN_ON = rs.getString("ASSIGN_ON");
						String COMLETED_ON = rs.getString("COMLETED_ON");
						
						// Add into the html table
						output += "<tr><td><input id='hidItemIDUpdateA' name='hidItemIDUpdateA' type='hidden' value='" + RF_NO + "'>"
								 + RF_NO + "</td>";
								 output += "<td>"+ MSAN_NAME + "</td>"; 
								 output += "<td>"+ PROGRESS_STATUS + "</td>"; 
								 output += "<td>" + REQ_TIME + "</td>"; 
								 output += "<td>" + ENTERED_BY + "</td>"; 
								 output += "<td>" + ENTERED_ON + "</td>";
								 output += "<td>" + ASSIGN_TO + "</td>";
								 output += "<td>" + ASSIGN_ON + "</td>";
								 output += "<td>" + COMLETED_ON + "</td>";
						
						
						
						// buttons
								 output += "<td><input name='btnUpdateA' type='button' value='Upadate' class='btnUpdateA btn btn-danger' data-id='" + RF_NO + "'>"
										 +"</td>"
										 +"<td><input name='btnRemoveA' type='button' value='Remove' class='btnRemoveA btn btn-danger' data-id='" + RF_NO + "'></td>";
										

								 
								 
								 
								 
									
				}
				
				con.close(); 
				output += "</table>";
			} 
			catch (Exception e) { 
				
				 output = "{\"status\":\"error\", \"data\":  \"Error while updating the admin.\"}"; 
				 System.err.println(e.getMessage()); 
			 
	 
			} 
			return output; 
	
	} 
		
		public String updateAdmin(String id,String first_name, String last_name, String em, String usern, String pass){ 
			
			
			 String output = ""; 
			 
			 try{
				 
				 
				 Connection con = connect(); 
				 
				 if (con == null) {
					 
					 return "Error while connecting to the database for updating."; 
					 
				 } 
				 
				 
				 	// query
				 	String query = "UPDATE admin SET first_name=?,last_name=?,em=?,usern=?, pass=? WHERE id=?"; 
				 	
				 	//create statement
				 	PreparedStatement preparedStmt = con.prepareStatement(query); 
				 	
				 	
				 		// set values
				 		
				 		preparedStmt.setString(1, first_name); 
				 		preparedStmt.setString(2, last_name); 
				 		preparedStmt.setString(3, em); 
				 		preparedStmt.setString(4, usern); 
				 		preparedStmt.setString(5, pass);
				 		preparedStmt.setInt(6, Integer.parseInt(id));
				 		
				 		// execute the statement
				 		preparedStmt.execute(); 
				 		con.close();
				 		
				 		String newUser = readUser(); 
						 output = "{\"status\":\"success\", \"data\": \"" + 
						 newUser + "\"}"; 
			 
			 } 
			 
			 
			 catch (Exception e) { 
				 
				 output = "{\"status\":\"error\", \"data\":  \"Error while updating the user.\"}"; 
				 System.err.println(e.getMessage()); 
			 
			 }
			 
			 return output; 
			 
		} 
		
		public String deleteAdmin(String id) { 
			
			
			 String output = ""; 
			 
			 try{ 
				 
				 
				 	Connection con = connect(); 
				 	
				 	
				 		if (con == null) {
				 			
				 			return "Error while connecting to the database for deleting.";
				 			
				 		} 
				 		
				 		
				 			// query
				 			String query = "delete from admin where id=?"; 
				 			
				 			//create statment
				 			PreparedStatement preparedStmt = con.prepareStatement(query);
				 			
				 			
				 			// binding values
				 			preparedStmt.setInt(1, Integer.parseInt(id)); 
				 			
				 			// execute the statement
				 			preparedStmt.execute(); 
				 			con.close(); 
				 			
				 			String newUser = readUser(); 
							 output = "{\"status\":\"success\", \"data\": \"" + 
							 newUser + "\"}"; 
			 
			 } 
			 
			 catch (Exception e) {
				 
				 output = "{\"status\":\"error\", \"data\":  \"Error while deleting the user.\"}"; 
				 System.err.println(e.getMessage());
			 } 
			 
			 	return output; 
			 
			} 
		
		
		public String insertResearch(String first_name, String last_name, String em, String usern, String pass) { 
			 
			String output = "";
			
			try{ 
				
				Connection con = connect();
				
				if (con == null) {
					
					return "Error while connecting to the database for inserting."; 
					
				} 
				
				//query
				String query = " insert into research (`first_name`,`last_name`,`em`,`usern`, `pass`)"+ " values (?, ?, ?, ?, ?)"; 
				
				//create preparestatement
				PreparedStatement preparedStmt = con.prepareStatement(query); 
				
				// set values
				preparedStmt.setString(1, first_name); 
				preparedStmt.setString(2, last_name); 
				preparedStmt.setString(3, em); 
				preparedStmt.setString(4, usern); 
				preparedStmt.setString(5, pass); 
		 
				//execute
				preparedStmt.execute(); 
				con.close();
				
				String newUser = readUser(); 
				 output = "{\"status\":\"success\", \"data\": \"" + 
				 newUser + "\"}"; 
				
			} 
			catch (Exception e) { 
				output = "{\"status\":\"error\", \"data\":  \"Error while inserting the researcher.\"}"; 
						 System.err.println(e.getMessage()); 
			} 
			
			return output; 
		 } 
			
		public String readResearch() { 
			
			String output = ""; 
			
			
			try{ 
				
				Connection con = connect(); 
				
				if (con == null) {
					
					return "Error while connecting to the database for reading."; 
					
				} 
	 
				//create html table
				output = "<table border=\"1\"><tr> <th>First Name</th> <th>Last Name</th> <th>Email</th> <th>Username</th> <th>Password</th> <th>Update</th><th>Remove</th></tr>"; 
				
				//query
				String query = "select * from research"; 
				//create statement
				Statement stmt = (Statement) con.createStatement(); 
				
				//create resultset
				ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
				
				
				while (rs.next()) { 
					
						String id = Integer.toString(rs.getInt("id")); 
						String first_name = rs.getString("first_name"); 
						String last_name = rs.getString("last_name"); 
						String em =rs.getString("em"); 
						String usern = rs.getString("usern"); 
						String pass = rs.getString("pass");
						
						// Add into the html table
						output += "<tr><td><input id='hidItemIDUpdateR' name='hidItemIDUpdateR' type='hidden' value='" + id + "'>"
								 + first_name + "</td>";
								 //output += "<td>"+ first_name + "</td>"; 
								 output += "<td>" + last_name + "</td>"; 
								 output += "<td>" + em + "</td>"; 
								 output += "<td>" + usern + "</td>";
								 output += "<td>" + pass + "</td>";
						
						
						
						// buttons
								 output += "<td><input name='btnUpdateR' type='button' value='Upadate' class='btnUpdateR btn btn-danger' data-id='" + id + "'>"
										 +"</td>"
										 +"<td><input name='btnRemoveR' type='button' value='Remove' class='btnRemoveR btn btn-danger' data-id='" + id + "'></td>";
										

								 
								 
								 
								 
									
				}
				
				con.close(); 
				output += "</table>";
			} 
			catch (Exception e) { 
				
				 output = "{\"status\":\"error\", \"data\":  \"Error while updating the research.\"}"; 
				 System.err.println(e.getMessage()); 
			 
	 
			} 
			return output; 
	
	} 
		
		public String updateResearch(String id,String first_name, String last_name, String em, String usern, String pass){ 
			
			
			 String output = ""; 
			 
			 try{
				 
				 
				 Connection con = connect(); 
				 
				 if (con == null) {
					 
					 return "Error while connecting to the database for updating."; 
					 
				 } 
				 
				 
				 	// query
				 	String query = "UPDATE research SET first_name=?,last_name=?,em=?,usern=?, pass=? WHERE id=?"; 
				 	
				 	//create statement
				 	PreparedStatement preparedStmt = con.prepareStatement(query); 
				 	
				 	
				 		// set values
				 		
				 		preparedStmt.setString(1, first_name); 
				 		preparedStmt.setString(2, last_name); 
				 		preparedStmt.setString(3, em); 
				 		preparedStmt.setString(4, usern); 
				 		preparedStmt.setString(5, pass);
				 		preparedStmt.setInt(6, Integer.parseInt(id));
				 		
				 		// execute the statement
				 		preparedStmt.execute(); 
				 		con.close();
				 		
				 		String newUser = readUser(); 
						 output = "{\"status\":\"success\", \"data\": \"" + 
						 newUser + "\"}"; 
			 
			 } 
			 
			 
			 catch (Exception e) { 
				 
				 output = "{\"status\":\"error\", \"data\":  \"Error while updating the user.\"}"; 
				 System.err.println(e.getMessage()); 
			 
			 }
			 
			 return output; 
			 
		} 
		
		public String deleteResearch(String id) { 
			
			
			 String output = ""; 
			 
			 try{ 
				 
				 
				 	Connection con = connect(); 
				 	
				 	
				 		if (con == null) {
				 			
				 			return "Error while connecting to the database for deleting.";
				 			
				 		} 
				 		
				 		
				 			// query
				 			String query = "delete from research where id=?"; 
				 			
				 			//create statment
				 			PreparedStatement preparedStmt = con.prepareStatement(query);
				 			
				 			
				 			// binding values
				 			preparedStmt.setInt(1, Integer.parseInt(id)); 
				 			
				 			// execute the statement
				 			preparedStmt.execute(); 
				 			con.close(); 
				 			
				 			String newUser = readUser(); 
							 output = "{\"status\":\"success\", \"data\": \"" + 
							 newUser + "\"}"; 
			 
			 } 
			 
			 catch (Exception e) {
				 
				 output = "{\"status\":\"error\", \"data\":  \"Error while deleting the user.\"}"; 
				 System.err.println(e.getMessage());
			 } 
			 
			 	return output; 
			 
			} 
		
		

		public String loginAdmin(String usern, String pass) {
			
			String output ="";
			
			try {
				
				Connection con = connect();
				
				if(con == null) {
					
					return "error while connecting to dadabase";
				}
				
				System.out.println("error");
				
				//query
				String query = "select `usern`, `pass` from admin where usern =? and pass=?";
				
				//create statement
				PreparedStatement preparedStmt = con.prepareStatement(query);
				
				System.out.println(preparedStmt);
				System.out.println(usern);
				System.out.println(pass);
				
				preparedStmt.setString(1, usern);
				preparedStmt.setString(2, pass);
				
				ResultSet rs = preparedStmt.executeQuery();
				
				
				if(rs.next()) {
					
					con.close();
					output = "success";
				}
				else {
					
					con.close();
					if(usern.equals("")) {
						
						return "User cannot be empty";
					}
					else if(pass.equals("")) {
						
						return "password cannot be empty";
						
					}
					
					else {
						
						return "incorrect username or password";
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				output = "Error while deleting the user."; 
				 System.err.println(e.getMessage()); 
				
			}
			return output;
		}
		
		
		

		public String loginResearch(String usern, String pass) {
			
			String output ="";
			
			try {
				
				Connection con = connect();
				
				if(con == null) {
					
					return "error while connecting to dadabase";
				}
				
				System.out.println("error");
				
				//query
				String query = "select `usern`, `pass` from research where usern =? and pass=?";
				
				//create statement
				PreparedStatement preparedStmt = con.prepareStatement(query);
				
				System.out.println(preparedStmt);
				System.out.println(usern);
				System.out.println(pass);
				
				preparedStmt.setString(1, usern);
				preparedStmt.setString(2, pass);
				
				ResultSet rs = preparedStmt.executeQuery();
				
				
				if(rs.next()) {
					
					con.close();
					output = "success";
				}
				else {
					
					con.close();
					if(usern.equals("")) {
						
						return "User cannot be empty";
					}
					else if(pass.equals("")) {
						
						return "password cannot be empty";
						
					}
					
					else {
						
						return "incorrect username or password";
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				output = "Error while deleting the user."; 
				 System.err.println(e.getMessage()); 
				
			}
			return output;
		}
		
		

}
