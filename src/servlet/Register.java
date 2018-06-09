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
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		try{
			System.out.println(request.getParameter("username")+":::"+request.getParameter("password"));
			Connection con=(Connection)InitializeContext.getServletContext().getAttribute("dbCon");
			String stmt="INSERT INTO USERS(USER_NAME,PASSWORD) VALUES(?,?)";
		    ps=con.prepareStatement(stmt);
		    ps.setString(1,request.getParameter("username"));
		    ps.setString(2,request.getParameter("password"));
		    int rs=ps.executeUpdate();
		    if(rs==1){
		    	HttpSession sess=request.getSession();
		    	sess.setAttribute("username",request.getParameter("username"));
		    	System.out.println("Updated the user details");
		    	PrintWriter out=response.getWriter();
		    	out.write("Thankyou! "+request.getParameter("username")+" for creating your account");
		    	out.write("Enjoy Shopping!");
		    }
		    else{
		    	System.out.println("Couldn't create user profile");
		    }
		}
		catch(SQLException e){
			e.getMessage().contains("UNIQUE");
			PrintWriter out=response.getWriter();
	    	out.write("Please chose a different username");
			System.out.println("There is an error in registering user");
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
		  }
	}
}
