package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ApplicationListener.InitializeContext;



public class Verify_Admin_Login {
   public static boolean verify_if_admin(String username,String password){
	   try{
		   Connection con=(Connection)InitializeContext.getServletContext().getAttribute("dbCon");
		   String query="Select USER_NAME FROM ADMIN WHERE USER_NAME=? AND PASSWORD=?";
		   PreparedStatement ps=con.prepareStatement(query);
		   ps.setString(1, username);
		   ps.setString(2, password);
		   ResultSet rs=ps.executeQuery();
		   if(rs.next())
			   return true;
	   }
	   catch(SQLException e){
		   System.out.println("Error in validating User/Admin");
		   e.printStackTrace();
	   }
	   return false;
   }
}
