package converter;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import beans.All_Items;
import beans.Item;
import ApplicationListener.InitializeContext;

public class All_Items_Converter {
 public static void convert_items_to_Json(){
	 ServletContext sc=InitializeContext.getServletContext();
	 All_Items all_Items=(All_Items) sc.getAttribute("all_Items");
	 ArrayList<Item> items=all_Items.getItems();
	 sc.setAttribute("json_result", new Gson().toJson(items));
 }
}
