package ApplicationListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import converter.All_Items_Converter;
import beans.All_Items;

@WebListener
public class InitializeContext implements ServletContextListener{
    private static ServletContext sc;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		sc=null;
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		// TODO Auto-generated method stub
		
		Initialize_db dbCon=new Initialize_db();
		sc=servletContextEvent.getServletContext();
		sc.setAttribute("dbCon", dbCon.getConnection());
		InitializeItems it=new InitializeItems();
		All_Items all_Items=it.get_items();
		sc.setAttribute("all_Items",all_Items);
		All_Items_Converter.convert_items_to_Json();
	}
	public static ServletContext getServletContext(){
		return sc;
	}
  
}
