package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class practice
 */
@WebServlet("/practice")
public class practice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public practice() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String number = request.getParameter("number");
		Student s = new Student(name, Integer.parseInt(age), number);
		System.out.println(s.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html;charset=UTF-8");
		String kinds = request.getParameter("kinds");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String number = request.getParameter("number");
		Animal a = new Animal(kinds, name, Integer.parseInt(age), number);
		System.out.println(a.toString());
	}

}
