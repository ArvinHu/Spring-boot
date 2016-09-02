package com.huanchuang.arvin.simple.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听Session的创建与销毁
 *
 */
@WebListener
public class FirstHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Session监听器 ：Session 被创建");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Session监听器 ：ServletContex初始化");
	}

}