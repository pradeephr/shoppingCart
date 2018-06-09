package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import ApplicationListener.InitializeContext;
import beans.Item;

public class PersistOrder {
    public static void recordPayment(String username,ArrayList<Item> items,Long cardNo){
    	PreparedStatement ps=null;
    	try{
	    	Connection con=(Connection) InitializeContext.getServletContext().getAttribute("dbCon");
	    	String stmt="INSERT INTO ORDER_HISTORY(USERNAME,ITEMID,QUANTITY,PRICE,CARDNO) VALUES(?,?,?,?,?)";
	    	ps=con.prepareStatement(stmt);
	    	ps.setString(1, username);
	    	for(Item item:items){
	    		ps.setInt(2, item.getId());
	    		ps.setInt(3, item.getCount());
	    		ps.setInt(4, item.getPrice());
	    		ps.setLong(5,cardNo);
	    		ps.executeUpdate();
	    		PersistToCart.removeItemFromCart(username,item);
	    	}
	    }
    	catch(SQLException e){
    		System.out.println("Error in recording payemnt");
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
