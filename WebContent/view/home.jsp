<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	width: 700px;
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
	<h4>${msg }</h4>

	<div
		style="border: 10px solid; margin: 0% 10%; padding-bottom: 90%; position: relative; color: black; background-color: #FDFDD7;">
		<div
			style="border: 5px solid; margin: 0% 0%; position: relative; color: black; background-color: teal; color: white;">
			<center>
				<h1>Home Page Admin Part</h1>
			</center>
		</div>
		<div id="reg-box">
			
				<center><h3>Launch product</h3></center>

			<c:if test="${not empty error}">
				<div class="error">${error}</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
			</c:if>
			<center>
				<form method="POST" action="publists" modelAttribute="published">
					<fieldset>
						<legend> Admin form :</legend>
						<center>
							<table border="1" width="65%" cellpadding="5">
								<tbody>
									<tr>
										<td class="xyz">book_name</td>
										<td><input type="text" name="book_name" value=""
											size="40" /></td>
										<td></td>
									</tr>
									<tr>
										<td>book_edition</td>
										<td><input type="text" name="book_edition" value=""
											size="40" /></td>
										<td></td>
									</tr>
									<tr>
										<td>book_ratings</td>
										<td><input type="text" name="book_ratings" value=""
											size="40" /></td>
										<td></td>
									</tr>
									<tr>
										<td>author_name</td>

										<td><select name="author_name">
												<option value="Author1">Author 1</option>
												<option value="Author2">Author 2</option>
												<option value="Author3">Author 3</option>
												<option value="Author4">Author 4</option>
										</select></td>

									</tr>



									<tr>
										<td>author_ratings</td>
										<td><input type="text" name="author_ratings" value=""
											size="40" /></td>
										<td></td>
									</tr>
									<tr>
										<td>publishar_name</td>

										<td><select name="publishar_name">
												<option value="publishar1">publishar 1</option>
												<option value="publishar2">publishar 2</option>
												<option value="publishar3">publishar 3</option>
												<option value="publishar4">Aupublisharthor 4</option>
										</select></td>
									</tr>
									<tr>
										<td>publishar_ratings</td>
										<td><input type="text" name="publishar_ratings" value=""
											size="40" /></td>
										<td></td>
									</tr>
									<tr>
										<td colspan="3"><input type="submit" value="Add Form" /></td>
									</tr>
								</tbody>
							</table>
						</center>
					</fieldset>
				</form>
				
				<a href="uplod_books">Go for shopping !!</a>
			</center>
		</div>
	</div>

</body>


</html>