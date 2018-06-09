package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ApplicationListener.InitializeContext;
import ApplicationListener.Initialize_db;

/**
 * Servlet implementation class AddItem
 */
@WebServlet("/addItem")
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItem() {
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
		if(Boolean.parseBoolean((String)request.getSession().getAttribute("admin"))){
			PreparedStatement ps=null;
			try{
				Connection con=(Connection)InitializeContext.getServletContext().getAttribute("dbCon");
				String stmt="INSERT INTO ITEMS(ID,COLOR,WIDTH,HEIGHT,MATERIAL,THICKNESS,COUNT,PRICE,TYPE,IMG) VALUES(NULL,?,?,?,?,?,?,?,?,?)";
				//to be completed 
				ps=con.prepareStatement(stmt);
				System.out.println("Color while inserting is "+request.getParameter("color"));
				ps.setString(1,request.getParameter("color"));
				ps.setInt(2,Integer.parseInt(request.getParameter("width")));
				ps.setInt(3,Integer.parseInt(request.getParameter("height")));
				ps.setString(4, request.getParameter("material"));
				ps.setInt(5, Integer.parseInt(request.getParameter("thickness")));
				ps.setInt(6, Integer.parseInt(request.getParameter("quantity")));
				ps.setInt(7, Integer.parseInt(request.getParameter("price")));
				ps.setString(8,request.getParameter("type"));
				ps.setString(9,request.getParameter("img"));
				
				int r=ps.executeUpdate();
				if(r>0){
					System.out.println("Successfully added the  new item");
				}
				
			}
			catch(SQLException e){
				System.out.println("Error in adding new Item from admin side");
				e.printStackTrace();
			}
			finally{
				try{
					ps.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
	}

}
