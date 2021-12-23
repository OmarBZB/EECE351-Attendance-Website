package com.classes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class sortStudents
 */
@WebServlet("/sortStudents")
public class sortStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public sortStudents() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String buttonPressed = request.getParameter("sortButton");
		if (buttonPressed.equals("By ID")) {
			session.setAttribute("sortingOrder", "S_ID");
		}
		if (buttonPressed.equals("By Date")) {
			session.setAttribute("sortingOrder", "Date");
		}
		if (buttonPressed.equals("By In Time")) {
			session.setAttribute("sortingOrder", "In_Time");
		}
		if (buttonPressed.equals("By Out Time")) {
			session.setAttribute("sortingOrder", "Out_Time");
		}
		if (buttonPressed.equals("By Total Time")) {
			session.setAttribute("sortingOrder", "Total_Time");
		}
		response.sendRedirect("ClassInfo.jsp");

	}

}
