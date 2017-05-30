<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#reg-box {
	width: 500px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>

</head>
<body>
<center><h1>User Registration</h1></center>

<center><font color="blue">${msg}</font></center>
<div id="reg-box">	
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
		
		
<form action="user" method="post">
	<table>
		<tr>
			<td>Full Name:</td>
			<td><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td>E mail:</td>
			<td><input type="text" name="login.email"/></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="login.password"/></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><input type="text" name="u_address"/></td>
		</tr>
		<tr>
			<td>Phon No</td>
			<td><input type="text" name="u_pnonNo"/></td>
		<tr>
			<td>Qualification</td>
			<td><input type="text" name="u_qualification"/></td>
		</tr>
		<tr>
				 <td></td>
				<td><input type="submit" value="Register"/></td>
		</tr>
	</table>
	<a href="login_link">Login</a>
</form>
</div>	
</body>
</html>