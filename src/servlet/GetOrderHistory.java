package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import beans.All_Items;
import beans.Item;
import beans.OrderDetails;
import converter.All_Items_Converter;
import ApplicationListener.InitializeContext;

/**
 * Servlet implementation class GetOrderHistory
 */
@WebServlet("/getOrderHistory")
public class GetOrderHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOrderHistory() {
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
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			Connection con=(Connection) InitializeContext.getServletContext().getAttribute("dbCon");
			String stmt="SELECT ITEMID,QUANTITY,PRICE,CARDNO FROM ORDER_HISTORY WHERE USERNAME=?";
			ps=con.prepareStatement(stmt);
			HttpSession session =request.getSession();
			ps.setString(1,(String)request.getSession().getAttribute("username"));
			rs=ps.executeQuery();
			All_Items all_Items=(All_Items) InitializeContext.getServletContext().getAttribute("all_Items");
			ArrayList<Item> items=all_Items.getItems();
			ArrayList<OrderDetails> orderDetails=new ArrayList<OrderDetails>();
			while(rs.next()){
				OrderDetails orderItem=new OrderDetails();
				orderItem.setItemId(rs.getInt(1));
				orderItem.setQuantity(rs.getInt(2));
				orderItem.setPrice(rs.getInt(3));
				orderItem.setCardNo(rs.getLong(4));
				System.out.println("inside the order History");
				for(Item item:items){
					if(item.getId()==orderItem.getItemId()){
						System.out.println("inside matching element");
						orderItem.setImg(item.getImg());
					}
				}
				orderDetails.add(orderItem);
			}
			PrintWriter out=response.getWriter();
			response.setContentType("application/json;charset=UTF-8");
			out.print(new Gson().toJson(orderDetails));			
		}
		catch(SQLException e){
			System.out.println("Error in retreiving orders from purchase history");
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
	}

}
