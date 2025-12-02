package com.healthcare.pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet(urlPatterns ="/hello",loadOnStartup = 2)
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void destroy() {
		System.out.println("in destroy "+getClass());
	}


	@Override
	public void init() throws ServletException {
		System.out.println("in init "+getClass());
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in do-get 1234"+getClass());
		
		// 1. set resp content type
		response.setContentType("text/html");
		// 2. Get write to sedn resp -> clnt
		try(PrintWriter pw=response.getWriter()) {
			//3. dyn resp
			pw.print("<h5> Welcome 2 Servlets , Server TS "+LocalDateTime.now()+"</h5>");
		} // JVM - pw.close -> resp is rendered

	}

}
