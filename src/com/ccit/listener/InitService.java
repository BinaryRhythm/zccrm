package com.ccit.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.ccit.service.ManagerService;
import com.ccit.service.StaffService;
import com.ccit.service.core.ServiceFactory;

/**
 * 容器启动，实例化service对象，病缓冲如serviceContext， 供servlet使用 Application Lifecycle
 * Listener implementation class InitService
 *
 * @author skyloon
 * @version 1.0
 * @time 2014/8/31
 */
@WebListener
public class InitService implements ServletContextListener {

	StaffService ss = null;
    ManagerService ms = null;
	
	/**
	 * tomcat一旦启动就会执行下面这个函数，赋值ss Default constructor.
	 */
	public InitService() {
		ss = (StaffService) ServiceFactory.getService("StaffService");
		ms = (ManagerService) ServiceFactory.getService("ManagerService");
	}

	/**
	 * 加载ss
	 * 
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext application = arg0.getServletContext();
		application.setAttribute("ss", ss);
		application.setAttribute("ms", ms);
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		ServletContext application = arg0.getServletContext();
		application.removeAttribute("ss");
		application.removeAttribute("ms");
	}

}
