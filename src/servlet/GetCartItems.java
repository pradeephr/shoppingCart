package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CartItemsOfUser;
import service.PersistToCart;

import com.google.gson.Gson;

import beans.Cart;
import beans.Item;

/**
 * Servlet implementation class GetCartItems
 */
@WebServlet("/getCartItems")
public class GetCartItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCartItems() {
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
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		if(((String)request.getSession().getAttribute("username")).length()>0){
			cart=new Cart();
			System.out.println("inside getting cart");
			ArrayList<Item> dbItems=CartItemsOfUser.getCartItemsForUser((String)request.getSession().getAttribute("username"));
			dbItems.addAll(cart.getItems());
			cart.setItems(dbItems);
			PersistToCart.persistAllItemsToCart(request.getParameter("username"), cart);
		}
		ArrayList<Item> items=cart.getItems();
		request.getSession().setAttribute("cart", cart);
		String result=new Gson().toJson(items);
		PrintWriter out=response.getWriter();
		response.setContentType("application/json;charset=UTF-8");
		out.print(result);
		
	}

}
