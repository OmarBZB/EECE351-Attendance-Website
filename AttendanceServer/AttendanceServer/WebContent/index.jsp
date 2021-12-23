<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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

.loginPage {
	width: 360px;
	padding: 10% 0 0;
	margin: auto;
}

.form {
	position: relative;
	z-index: 1;
	max-width: 360px;
	margin: 0 auto 100px;
	padding: 45px;
	text-align: center;
}

.form input {
	font-family: "Roboto", sans-serif;
	outline: 1;
	background: #f2f2f2;
	width: 100%;
	border: 0;
	margin: 0 0 15px;
	padding: 15px;
	box-sizing: 14px;
}

.form button {
	font-family: "Roboto", sans-serif;
	text-transform: uppercase;
	outline: 0;
	background: #4caf50;
	width: 111.5%;
	border: 0;
	padding: 15px;
	color: #ffffff;
	font-size: 14px;
	cursor: pointer;
}

.form button:hover, .form button:active {
	background: #43a047;
}
</style>
</head>
<body>
	<div class="loginPage">
		<div class="form">

			<form class="login-form" method="post" action="LoginCheck">
				<input type="text" placeholder="Enter Username" name="UserName" />
				<input type="password" placeholder="Enter Password" name="PassWord" />
				<button type="submit" value=Log-in>Log-in</button>

			</form>
		</div>
	</div>

</body>
</html>