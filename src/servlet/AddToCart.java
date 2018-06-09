package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import service.PersistToCart;
import ApplicationListener.InitializeContext;
import beans.All_Items;
import beans.Cart;
import beans.Item;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/cart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("adding to cart");
		
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		if(session.getAttribute("username")!=null && ((String)session.getAttribute("username")).length()>0){
			Cart cart=(Cart)session.getAttribute("cart");
			if(cart==null)
				cart=new Cart();
			int itemId=Integer.parseInt(request.getParameter("id"));
			int quantity=Integer.parseInt(request.getParameter("quantity"));
			ArrayList<Item> cart_Items=cart.getItems();
			ServletContext sc=InitializeContext.getServletContext();
			All_Items all_Items=(All_Items)sc.getAttribute("all_Items");
			ArrayList<Item> items=all_Items.getItems();
			Item newItem=null;
			for(int i=0;i<items.size();i++){
				if(items.get(i).getId()==itemId){
					newItem=new Item(items.get(i));
				}
			}
			newItem.setCount(quantity);
			newItem.setPrice(newItem.getPrice()*quantity);
			String username=(String)session.getAttribute("username");
			if(username!=null && username.length()>0)
			   PersistToCart.persistItemToCart(username,newItem);
			cart_Items.add(newItem);
			cart.setItems(cart_Items);
			session.setAttribute("cart",cart);
			out.print(new Gson().toJson(cart.getItems()));
		}
		else{
			out.println("You cannot purchase untill you login!");
		}
	}
}
