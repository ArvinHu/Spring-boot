package com.huanchuang.arvin.simple.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//匹配的时候，如果有多个路径都能符合这个servlet的话，都能访问到，如果有别的servlet的路径该路径的子路径，那访问的也是别的serlvet，以精确的为主要的访问路径
//@WebServlet(urlPatterns = "/servlet/*", description = "Servlet的说明")

@WebServlet(urlPatterns = "/servlet/first", description = "Servlet的说明")
public class FirstServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println(">>>>>>>>>>doPost1()<<<<<<<<<<<");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello World</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>大家好，我的名字叫Servlet</h1>");
		out.println("<h2>i am first servlet</h2>");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println(">>>>>>>>>>doGet1()<<<<<<<<<<<");
		this.doPost(req, resp);
	}
}
