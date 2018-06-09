package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ApplicationListener.InitializeContext;
import ApplicationListener.Initialize_db;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			Connection con=(Connection)InitializeContext.getServletContext().getAttribute("dbCon");
			String query="SELECT USER_NAME FROM USERS WHERE USER_NAME=? AND PASSWORD=?";
			ps=con.prepareStatement(query);
			ps.setString(1, request.getParameter("username"));
			ps.setString(2, request.getParameter("password"));
		    rs=ps.executeQuery();
			 if(rs.next()){
				 request.setAttribute("status","Login success");
				 HttpSession session=request.getSession();
				 session.setAttribute("username",request.getParameter("username"));
				 PrintWriter out=response.getWriter();
				 out.println("Login Success");
			     return;	
			 }
		}
		catch(SQLException e){
			System.out.println("Error in loggin in");
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
