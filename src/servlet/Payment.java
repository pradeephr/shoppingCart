package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PersistOrder;
import beans.Cart;
import beans.Item;

/**
 * Servlet implementation class payment
 */
@WebServlet("/payment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Payment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		int price=0;
		System.out.println("cardNo");
		Long cardNo=Long.parseLong((String)request.getParameter("cardNo"));
		ArrayList<Item> items=cart.getItems();
		for(Item item:items)
			price+=item.getPrice();
		PersistOrder.recordPayment((String)request.getSession().getAttribute("username"), items,cardNo);
		request.getSession().removeAttribute("cart");
		PrintWriter out=response.getWriter();
		out.print("Payment of "+price+"$ was recieved!");
		out.print("Thankyou for you payment");
	}
}
