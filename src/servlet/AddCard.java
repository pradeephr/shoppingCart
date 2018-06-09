package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PersistCardDetails;
import beans.Card;

/**
 * Servlet implementation class AddCard
 */
@WebServlet("/addCard")
public class AddCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCard() {
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
		Card newCard=new Card();
		System.out.println("Card no is "+request.getParameter("cardno"));
		newCard.setCardNo(Long.parseLong(request.getParameter("cardno")));
		newCard.setAddress(request.getParameter("address"));
		newCard.setCvv(Integer.parseInt(request.getParameter("cvv")));
		newCard.setExpMonth(Integer.parseInt(request.getParameter("month")));
		newCard.setExpYear(Integer.parseInt(request.getParameter("year")));
		newCard.setName(request.getParameter("name"));
		PersistCardDetails.persistCardDetails(newCard,(String)request.getSession().getAttribute("username"));
		
	}

}
