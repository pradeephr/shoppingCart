package beans;

import java.util.ArrayList;

public class Cart{
	private ArrayList<Item> items;
	  public Cart() {
			super();
			// TODO Auto-generated constructor stub
			items=new ArrayList<Item>();
		}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	  
}
