package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import ApplicationListener.InitializeContext;
import beans.Cart;
import beans.Item;

public class PersistToCart {
    public static void persistItemToCart(String username,Item newItem){
    	PreparedStatement ps=null;
    	try{
    	 Connection con=(Connection) InitializeContext.getServletContext().getAttribute("dbCon");
    	 String stmt="INSERT INTO CART(USERNAME,ITEMID,QUANTITY,PRICE) VALUES(?,?,?,?)";
    	 ps=con.prepareStatement(stmt);
    	 ps.setString(1,username);
         ps.setInt(2,newItem.getId());
         ps.setInt(3,newItem.getCount());
         ps.setInt(4,newItem.getCount()*newItem.getPrice());
         ps.executeUpdate();
    	}
    	catch(SQLException e){
    		System.out.println("Error in persisting items to user cart");
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
    public static void persistAllItemsToCart(String username,Cart cart){
    	ArrayList<Item> items=cart.getItems();
    	for(Item item: items){
    		persistItemToCart(username, item);
    	}
    }
    public static void removeItemFromCart(String username,Item oldItem){
    	PreparedStatement  ps=null;
    	try{
    		System.out.println("removing item from db");
	    	Connection con=(Connection) InitializeContext.getServletContext().getAttribute("dbCon");
	   	 	String stmt="DELETE FROM CART WHERE USERNAME=? AND ITEMID=? AND PRICE=?";
	   	 	ps=con.prepareStatement(stmt);
	   	 	ps.setString(1,username);
	        ps.setInt(2,oldItem.getId());
	        ps.setInt(3,oldItem.getPrice());
	        //System.out.println(ps.);
	        System.out.println(ps.executeUpdate());
	        System.out.println("successfully updated cart");
    	}
    	catch(SQLException e){
    		System.out.println("Error in removing item from the cart");
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
