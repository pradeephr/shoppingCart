package ApplicationListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.sqlite.JDBC;

public class Initialize_db {
	public Connection con =null;
  public Connection getConnection(){
	  return con;
  }
  public Initialize_db(){
	  try{
		  String dbUrl="D:/Advanced_www/sqlite-tools-win32-x86-3210000/carpet.db";
		  String jdbc_URL="jdbc:sqlite:"+dbUrl;
		  Class.forName("org.sqlite.JDBC");
		  con=DriverManager.getConnection(jdbc_URL);
		  System.out.println("connected to sqlite");
	  }
	  catch(SQLException e){
		  System.out.println("Error in connection to db ");
		  e.printStackTrace();
	  }
	  catch(ClassNotFoundException e){
		  System.out.println("Error in connection to db ");
		  e.printStackTrace();
	  }
  }  
  public void close_connection(){
	  try{
			  if(con!=null)
				  con.close();
		  }
		  catch(SQLException e){
			  System.out.println("Error in closing connection of db ");
			  e.printStackTrace();
		  }
  }
}
