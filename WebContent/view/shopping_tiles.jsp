<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@page import="com.bookpublisher.app.dto.FilePropertiseDTO"%> --%>
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

.divbox {
	padding: 7px;
	margin-bottom: 5px;
	border: 1px solid transparent;
	border-radius: 1px;
	color: #a94444;
	background-color: #f2dedd;
	border-color: #ebccd2;
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

#obj-box {
	width: 500px;
	height: 300px; padding : 20px;
	margin: 50px auto;
	background: #fff;
	-webkit-border-radius: 1px;
	-moz-border-radius: 1px;
	border: 1px solid #000;
	padding: 20px;
}
</style>

</head>
<body>
	<h1>ONLINE SHOPPING</h1>
	<h3>True Story Books </h3>
	<center>

				<div style="color: teal; font-size: 15px">
					<h2>List of the File</h2><br>
					<a href="shopping_tiles">Go for shopping Sir !!</a>
					<c:if test="${!empty fileList}">
						<hr></hr>
						<hr></hr>
				<table border="1" bgcolor="pink" width="900px">
					<c:forEach items="${fileList}" var="file">
						<tr
							style="background-color: silver; color: black; text-align: center;height="30px">
							<td>
								<div class="error " width="400px">
									<h1>Books image</h1>
									<h1>Books image</h1>
									<h1>Books image</h1>

								</div>
							</td>
							<td>
								<div class="msg"">
									${file.id}<br> 
									${file.fdate}<br> 
									${file.flocation}<br>
									${file.fname}<br> 
									${file.fsize}<br> <a
									href="delete/${file.id}"><h2>BUY NOW</h2></a>

								</div>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
				</div>
	</center>
	
	
	
	
	<h1>ONLINE SHOPPING</h1>
	<h3>True Story Books </h3>
	<center>

				<div style="color: teal; font-size: 15px">
					<h1>List of the Books,Authers and Publishers Name</h1> <br>
					<a href="book_list">Go for shopping Sir !!</a>
					<c:if test="${!empty bookDetailsList}">
						<hr></hr>
						<hr></hr>
				<table border="1" bgcolor="pink" width="900px">
					<c:forEach items="${bookDetailsList}" var="books">
						<tr
							style="background-color: silver; color: black; text-align: center;height="30px">
							<td>
								<div class="error " width="400px">
									<h1>Books image</h1>
									<h1>Books image</h1>
									<h1>Books image</h1>
								</div>
							</td>
							<td>
								<div class="msg"">
								author_id: 	${books.author_id}<br> 
								author_name ${books.author_name}<br> 
								author_ratings${books.author_ratings}<br> 
								publishar_name${books.publisher.publishar_name}<br>
								<a href="delete/${file.id}"><h2>BUY NOW</h2></a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
				</div>
	</center>
	

</body>
</html>