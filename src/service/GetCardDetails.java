package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ApplicationListener.InitializeContext;
import beans.Card;

public class GetCardDetails {
 public static ArrayList<Card> getCardDetails(String username){
	 ArrayList<Card> cards=new ArrayList<Card>();
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	 try{
		 Connection con=(Connection) InitializeContext.getServletContext().getAttribute("dbCon");
		 String stmt="SELECT CARDNO,NAMEONCARD,CVV,EXP_MONTH,EXP_YEAR,BILLING_ADDRESS FROM USERS_CARD WHERE USERNAME=?";
		 ps=con.prepareStatement(stmt);
		 ps.setString(1,username);
		 rs=ps.executeQuery();
		 while(rs.next()){
			 Card c=new Card();
			 c.setCardNo(rs.getLong(1));
			 c.setName(rs.getString(2));
			 c.setCvv(rs.getInt(3));
			 c.setExpMonth(rs.getInt(4));
			 c.setExpYear(rs.getInt(5));
			 c.setAddress(rs.getString(6));
			 cards.add(c);
		 }
	}
	 catch(SQLException e){
		 System.out.println("Error in retreiving card details of user");
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
		  try{
			  if(rs!=null){
				 rs.close();
			  }
			  }catch(SQLException e){
				  e.printStackTrace();
			  }
	  }
	 return cards;
 }
}
