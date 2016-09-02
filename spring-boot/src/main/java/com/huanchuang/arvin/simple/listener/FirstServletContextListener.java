package com.huanchuang.arvin.simple.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 使用@WebListener注解，实现ServletContextListener接口
 *
 */
@WebListener
public class FirstServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext监听器 ：ServletContex初始化");
		System.out.println(sce.getServletContext().getServerInfo());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext监听器 ：ServletContex销毁");
	}

}
