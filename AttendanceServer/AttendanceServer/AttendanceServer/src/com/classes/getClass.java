package com.classes;
import java.sql.*;
import java.util.ArrayList;

public class getClass {

	public static ArrayList<ArrayList<String>> getClassInfo(String sortOrder) {
		String dbURL = "jdbc:mysql://localhost:3306/EECE351_StudentAttendanceDB";
		String userId = "root";
		String password = "Sah82@MySQL";
		ArrayList<ArrayList<String>> Rows = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet;
		try {
			connection = DriverManager.getConnection(dbURL, userId, password);
			statement = connection.createStatement();
			String sql = "SELECT * FROM StudentAttendance ORDER BY "+ sortOrder;
			resultSet = statement.executeQuery(sql);
			Rows = new ArrayList<ArrayList<String>>();
			while (resultSet.next()) {
				ArrayList<String> Row = new ArrayList<String>();
				for (int i = 1; i <= 5; i++) {
					Row.add(resultSet.getString(i));
				}
				Rows.add(Row);
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
		return Rows;
	}

}
