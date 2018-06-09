package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ApplicationListener.InitializeContext;
import beans.Card;

public class PersistCardDetails {
  public static void persistCardDetails(Card card,String username){
	  PreparedStatement ps=null;
	  try{
		  Connection con=(Connection)InitializeContext.getServletContext().getAttribute("dbCon");
		  String stmt="INSERT INTO USERS_CARD(USERNAME,CARDNO,NAMEONCARD,CVV,EXP_MONTH,EXP_YEAR,BILLING_ADDRESS) VALUES(?,?,?,?,?,?,?)";
		  ps=con.prepareStatement(stmt);
		  ps.setString(1,username);
		  ps.setLong(2,card.getCardNo());
		  ps.setString(3, card.getName());
		  ps.setInt(4,card.getCvv());
		  ps.setInt(5, card.getExpMonth());
		  ps.setInt(6,card.getExpYear());
		  ps.setString(7, card.getAddress());
		  int r=ps.executeUpdate();
		  if(r>0)
			  System.out.println("Persisted card details into DB");
	  }
	  catch(SQLException e){
		  System.out.println("Error in persisting card details");
		  e.printStackTrace();
	  }
	  finally{
		  try{
		  if(ps!=null){
			  ps.close();
		  }
		  }catch(SQLException e){
			  e.printStackTrace();
		  }
	  }
  }
}
