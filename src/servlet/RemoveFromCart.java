package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import service.PersistToCart;
import beans.Cart;
import beans.Item;
import ApplicationListener.InitializeContext;

/**
 * Servlet implementation class RemoveFromCart
 */
@WebServlet("/removeFromCart")
public class RemoveFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromCart() {
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
		HttpSession session=request.getSession();
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		int price=Integer.parseInt(request.getParameter("price"));
		String username=(String)session.getAttribute("username");
		Cart cart = (Cart) session.getAttribute("cart");
		ArrayList<Item> items=cart.getItems();
		ArrayList<Item> tempItems=new ArrayList<Item>();
		tempItems.addAll(items);
		for(Item item:tempItems){
			if(item.getId()==itemId && item.getPrice()==price){
				System.out.println("removing from cart");
				if(username!=null && username.length()>0)
					PersistToCart.removeItemFromCart(username, item);
				items.remove(item);
			}
		}
		cart.setItems(items);
		session.setAttribute("cart", cart);
	}
}
