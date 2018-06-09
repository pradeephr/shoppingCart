package ApplicationListener;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import beans.All_Items;
import beans.Item;

public class InitializeItems {
    public All_Items get_items(){
    	All_Items all_Items=new All_Items();
    	try{
	    	ArrayList<Item> items=new ArrayList<Item>();
	    	ServletContext sc=InitializeContext.getServletContext();
	    	Connection con=(Connection)sc.getAttribute("dbCon");
	    	String query="SELECT ID,COLOR,WIDTH,HEIGHT,MATERIAL,THICKNESS,COUNT,PRICE,TYPE,IMG FROM ITEMS";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()){
				Item item=new Item();
				item.setId(rs.getInt(1));
				item.setColor(rs.getString(2));
				item.setWidth(rs.getInt(3));
				item.setHeight(rs.getInt(4));
				item.setMaterial(rs.getString(5));
				item.setThickness(rs.getInt(6));
				item.setCount(rs.getInt(7));
				item.setPrice(rs.getInt(8));
				item.setType(rs.getString(9));
				item.setImg(rs.getString(10));
				items.add(item);
			}
			all_Items.setItems(items);
    	}
    	catch(SQLException e){
    		System.out.println("Error in fetching items from db");
    		e.printStackTrace();
    	}
    	return all_Items;
    }
}
