package com.classes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updateTime
 */
@WebServlet("/updateTime")
public class updateTime extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateTime() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Tool tool = new Tool();
		
		String ID = request.getParameter("studentID");
		String InTime = request.getParameter("updatedInTime");
		String OutTime = request.getParameter("updatedOutTime");
		
		InTime = tool.AdjustTime(InTime);
		OutTime = tool.AdjustTime(OutTime);
		String TotalTime = tool.computeTotalTime(InTime, OutTime);
		
		String dbURL = "jdbc:mysql://localhost:3306/EECE351_StudentAttendanceDB";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbURL, "root", "Sah82@MySQL");
			Statement stmt = conn.createStatement();
			String query = "Update ignore StudentAttendance" + " Set In_Time=" + "'" + InTime + "'" + ", out_Time="
					+ "'" + OutTime + "'" + ", Total_Time=" + "'" + TotalTime + "'" + " WHERE S_ID=" + "'" + ID + "' ";

			stmt.executeUpdate(query);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		response.sendRedirect("ClassInfo.jsp");
	}

}
