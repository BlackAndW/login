package com.wuzizhong.test.listener;

import java.sql.SQLException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import com.wuzizhong.test.Util.DBUtil;

/**
 * Application Lifecycle Listener implementation class AppListenser
 *
 */
@WebListener
public class AppListenser implements ServletContextListener {
	DBUtil db = new DBUtil();
	
    public AppListenser() {
        
    }
    
    public void contextDestroyed(ServletContextEvent arg0)  { 
         System.out.println("lala");
    }

    public void contextInitialized(ServletContextEvent arg0)  {
    	try {
			db.getConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
        System.out.println("数据库已连接");
    }
	
}
