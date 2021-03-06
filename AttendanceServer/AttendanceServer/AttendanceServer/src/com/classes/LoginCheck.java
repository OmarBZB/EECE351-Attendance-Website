package com.classes;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	
	public Connection conn = null;
	
	private static final long serialVersionUID = 1L;
    
	/**
     * @see HttpServlet#HttpServlet()
     */
	
	static final String dbURL1 = "jdbc:mysql://localhost:3306/EECE351_InstructorRecordsDB";
	static final String dbURL2 = "jdbc:mysql://localhost:3306/EECE351_StudentAttendanceDB";

	public LoginCheck() {
		super();
		// TODO Auto-generated constructor stub
		}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated constructor stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String result = "None Available";
		String UserName = request.getParameter("UserName");
		String PassWord = request.getParameter("PassWord");
		conn = null;
		
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			conn = DriverManager.getConnection(dbURL1, "root", "Sah82@MySQL");

			Statement stmt = conn.createStatement();

			String query0 = "SELECT ID FROM InstructorCredentials WHERE username=" + "'" + UserName + "'"
						  + " and password=" + "'" + PassWord + "'";
			
			ResultSet rs0 = stmt.executeQuery(query0);
			
			if (!rs0.isBeforeFirst()) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
				PrintWriter out = response.getWriter();
				out.println("<html><head>");
				out.println("<h2 align=center><font color=red face =Verdana, Geneva, sans-serif size=+1>"
						+ "The username or password you entered is incorrect</font></h2>");
				out.println("</head><body></body></html>");
				rd.include(request, response);
			} else {
				rs0.next();
				String id = rs0.getString(1);
				String query1 = "SELECT class " + "FROM InstructorClasses " + "WHERE ID= " + "'" + id + "'";
				ResultSet rs = stmt.executeQuery(query1);
				StringBuffer sb = new StringBuffer();
				rs.next();
				sb.append(rs.getString(1));
				while (rs.next()) {
					sb.append(",");
					sb.append(rs.getString(1));
				}
				result = sb.toString();
				HttpSession session = request.getSession();
				session.setAttribute("UserName", UserName);
				response.sendRedirect("ClassInfo.jsp");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

}
