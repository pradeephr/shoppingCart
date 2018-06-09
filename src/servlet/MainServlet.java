package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CartItemsOfUser;
import beans.Cart;
import beans.Item;
import ApplicationListener.InitializeContext;
import ApplicationListener.Initialize_db;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/carpetstore")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
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
		//System.out.println("inside MainServlet");
		PrintWriter out=response.getWriter();
		response.setContentType("application/json;charset=UTF-8");
		out.print((String)InitializeContext.getServletContext().getAttribute("json_result"));
		/*Cart cart=(Cart) request.getSession().getAttribute("cart");
		if(cart==null)
			cart=new Cart();
		ArrayList<Item> dbItems=CartItemsOfUser.getCartItemsForUser((String)request.getSession().getAttribute("username"));
		dbItems.addAll(cart.getItems());
		cart.setItems(dbItems);
		request.getSession().setAttribute("cart", cart);*/
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
}
