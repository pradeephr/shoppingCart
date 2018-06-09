package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.All_Items;
import beans.Item;
import ApplicationListener.InitializeContext;

public class CartItemsOfUser {
  public static ArrayList<Item> getCartItemsForUser(String username){
	  ArrayList<Item> items=new ArrayList<Item>();
	  PreparedStatement ps=null;
	  ResultSet rs=null;
	  try{
		  Connection con =(Connection) InitializeContext.getServletContext().getAttribute("dbCon");
		  String stmt="SELECT ITEMID,QUANTITY,PRICE FROM CART WHERE USERNAME='"+username+"'";
		  System.out.println(stmt);
		  ps=con.prepareStatement(stmt);
		  //ps.setString(1, username);
		  rs=ps.executeQuery();
		  System.out.println("size of result is "+rs.getStatement());
		  All_Items all_Items=(All_Items) InitializeContext.getServletContext().getAttribute("all_Items");
		  ArrayList<Item> allItems=all_Items.getItems();
		  while(rs.next()){
			 for(Item item:allItems){
				 System.out.println("item "+item.getId());
				 if(item.getId()==rs.getInt(1)){
					 Item i=new Item(item);
					 i.setCount(rs.getInt(2));
					 i.setPrice(rs.getInt(3));
					 items.add(i);
					 System.out.println("adding item");
				 }
			 }
		  }
	 }
	  catch(SQLException e){
		  System.out.println("Error in retreiving cart of user form DB");
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
	  return items;
  }
}
