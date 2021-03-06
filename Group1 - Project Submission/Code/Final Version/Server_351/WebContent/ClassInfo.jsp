<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
	String CurrentUser = (String) session.getAttribute("UserName");
if (CurrentUser == null || CurrentUser == "") {
	RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
	PrintWriter cout = response.getWriter();
	cout.println("<html><head>");
	cout.println("<h2 align=center><font color=red face =Verdana, Geneva, sans-serif size=+1>"
	+ "You are not logged in!</font></h2>");
	cout.println("</head><body></body></html>");
	rd.include(request, response);

} else {
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Attendance Server</title>
<link rel="shortcut icon" href="favicon.ico" />
<style>
body {
	background-image: linear-gradient(rgba(0, 0, 0, 0.55),
		rgba(0, 0, 0, 0.5)), url(backround.png);
	height: 100vh;
	background-size: cover;
	background-position: center;
}

.button {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
}

.LogOutbutton {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	float: right;
	margin-top: 80px;
	margin-right: 120px;
}

.container {
	height: 200px;
	position: relative;
}

.center {
	margin: 0;
	position: absolute;
	top: 50%;
	left: 50%;
	-ms-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
}

.forms input {
	position: relative;
	z-index: 1;
	max-width: 200px;
	margin: 0 auto 100px;
	padding: 45px;
	text-align: center;
	font-family: "Roboto", sans-serif;
	outline: 1;
	background: #f2f2f2;
	width: 100%;
	border: 0;
	margin: 0 0 15px;
	padding: 15px;
	box-sizing: 14px;
}

.formsSort input {
	background-color: #4CAF50;
}
</style>
</head>
<body>
	<div class="header">
		<h1 align="center">Welcome, Instructor ${UserName} !</h1>
	</div>


	<div class="container">
		<div class="center"></div>
		<form action="LogoutFunc" method="post">
			<input type="submit" class="LogOutbutton" value="Logout" />
		</form>
	</div>

	<div id="ShowHideButton">
		<div style="align: center">
			<button onclick="myFunctionUpdateButton()" class="button">Update
				Table...</button>
		</div>
		<div id="UpdateTableButton"
			style="display: none; margin: 25px 0px 0px; float: left; max-width: 700px;">
			<button onclick="myFunctionTimeButton()" class="button">Change
				Time</button>
			<div align="left" id="UpdateTimeButton"
				style="display: none; margin: 20px 0px 0px; position: fixed;">
				<form class="forms" method="post" action="updateTime">
					<input type="text" placeholder="Enter Student ID" name="studentID" />
					<input type="text" placeholder="Enter In Time (hh:mm:ss)"
						name="updatedInTime" /> <input type="text"
						placeholder="Enter Out Time (hh:mm:ss)" name="updatedOutTime" />
					<button type="submit" value=Change-Time style="margin-bottom: 25px">Change
						Time</button>
				</form>
			</div>

			<button onclick="myFunctionRemoveButton()" class="button">Remove
				Student</button>
			<div id="RemoveStudentButton"
				style="display: none; margin: 20px 0px 0px; position: fixed;">
				<form class="forms" method="post" action="removeStudent">
					<input type="text" placeholder="Enter Student ID" name="studentID" />
					<button type="submit" value=Remove-Student>Remove Student</button>
				</form>
			</div>

			<button onclick="myFunctionAddButton()" class="button">Add
				Student</button>
			<div id="AddStudentButton"
				style="display: none; margin: 20px 0px 0px; position: fixed;">
				<form class="forms" method="post" action="addStudent">
					<input type="text" placeholder="Enter Student ID" name="studentID" />
					<input type="text" placeholder="Enter Date Attended (yyyy:mm:dd)"
						name="dateAttended" /> <input type="text"
						placeholder="Enter In Time (hh:mm:ss)" name="updatedInTime" /> <input
						type="text" placeholder="Enter Out Time (hh:mm:ss)"
						name="updatedOutTime" />
					<button type="submit" value=Remove-Student>Add Student</button>
				</form>
			</div>

			<button onclick="myFunctionSortButton()" class="button">Sort
				By...</button>
			<div id="SortButton"
				style="display: none; margin: 20px 0px 0px; position: fixed;">
				<form class="formsSort" method="post" action="sortStudents">
					<input type="submit" name="sortButton" value="By ID" /> <input
						type="submit" name="sortButton" value="By Date" /> <input
						type="submit" name="sortButton" value="By In Time" /> <input
						type="submit" name="sortButton" value="By Out Time" /> <input
						type="submit" name="sortButton" value="By Total Time" />
				</form>
			</div>



		</div>
		<div style="float: right; margin-right: 270px; position: :fixed;">
			<h2 align="center">
				<font><strong>351 Class</strong></font>
			</h2>

			<table cellpadding="5" cellspacing="5" border="1">
				<tr>

				</tr>
				<tr bgcolor="#A52A2A">
					<td><b>id</b></td>
					<td><b>date</b></td>
					<td><b>in time</b></td>
					<td><b>out time</b></td>
					<td><b>total time</b></td>
				</tr>
				<%@page import="java.util.*"%>
				<%@page import="java.io.*"%>
				<%@page import="com.classes.*"%>
				<%
					String sortOrder = (String) session.getAttribute("sortingOrder");
				ArrayList<ArrayList<String>> Rows = getClass.getClassInfo(sortOrder);
				for (ArrayList<String> row : Rows) {
				%>
				<tr bgcolor="#4d69d6">

					<td><%=row.get(0)%></td>
					<td><%=row.get(1)%></td>
					<td><%=row.get(2)%></td>
					<td><%=row.get(3)%></td>
					<td><%=row.get(4)%></td>

				</tr>
				<%
					}
				%>
			</table>
		</div>
	</div>


	<script>
		function myFunctionUpdateButton() {
			var thisButton = document.getElementById("UpdateTableButton");
			if (thisButton.style.display === "none") {
				thisButton.style.display = "block";
			} else {
				thisButton.style.display = "none";
			}
		}

		var e1 = document.getElementById("UpdateTimeButton");
		var e2 = document.getElementById("RemoveStudentButton");
		var e3 = document.getElementById("AddStudentButton");
		var e4 = document.getElementById("SortButton");

		function myFunctionTimeButton() {
			if (e1.style.display === "none") {
				if (e2.style.display === "block")
					e2.style.display = "none";
				if (e3.style.display === "block")
					e3.style.display = "none";
				if (e4.style.display === "block")
					e4.style.display = "none";
				e1.style.display = "block";
			} else {
				e1.style.display = "none";
			}
		}

		function myFunctionRemoveButton() {
			if (e2.style.display === "none") {
				if (e1.style.display === "block")
					e1.style.display = "none";
				if (e3.style.display === "block")
					e3.style.display = "none";
				if (e4.style.display === "block")
					e4.style.display = "none";
				e2.style.display = "block";
			} else {
				e2.style.display = "none";
			}
		}

		function myFunctionAddButton() {
			if (e3.style.display === "none") {
				if (e1.style.display === "block")
					e1.style.display = "none";
				if (e2.style.display === "block")
					e2.style.display = "none";
				if (e4.style.display === "block")
					e4.style.display = "none";
				e3.style.display = "block";
			} else {
				e3.style.display = "none";
			}
		}

		function myFunctionSortButton() {
			if (e4.style.display === "none") {
				if (e1.style.display === "block")
					e1.style.display = "none";
				if (e2.style.display === "block")
					e2.style.display = "none";
				if (e3.style.display === "block")
					e3.style.display = "none";
				e4.style.display = "block";
			} else {
				e4.style.display = "none";
			}
		}
	</script>

</body>
</html>
<%
	}
%>