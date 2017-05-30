<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div
		style="border: 10px solid; margin: 0% 10%; padding-bottom: 90%; position: relative; color: black; background-color: #FDFDD7">

		<div
			style="border: 5px solid; margin: 0% 0%; position: relative; color: black; background-color: teal; color: white;">
			<center>
				<h1>Welcom to Home Page</h1>
				<div >
					<h1>${msg}</h1>
				</div>
				<div align="right">
					${firstName} 
				</div>
			</center>
		</div>
		<div
			style="border: 1px solid; margin: 0% 10%; padding-bottom: 90%; position: relative; color: black; background-color: pink;">
			<center>
				<h1>File Upload</h1>
				<form method="post" action="uploadFile" enctype="multipart/form-data">
					<table border="0">
						<tr>
							<td>Description:</td>
							<td><input type="text" name="description" size="40" /></td>
						</tr>
						<tr>
							<td>Pick file 1:</td>
							<td><input type="file" name="fileUpload" size="40" /></td>
						</tr>
						<tr>
							<td>Pick file 2:</td>
							<td><input type="file" name="fileUpload" size="40" /></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="submit" value="Upload" /></td>
						</tr>
						<tr>
							<th colspan="2"><a href="viewallFile">View !!</a></th>
							</td>
						</tr>
						</tr>
						<br>
					</table>
				</form>
				<div style="border: 5px solid; margin: 0% 0%; position: relative; background-color: black; color: white;">
						<th colspan="2"><a href="downlodDBTable/intoEXLSfile">Tuch me 4 Downlod FileProperty in exls</a></th>
				</div>

				<div style="color: teal; font-size: 15px">
					List of the File
					<c:if test="${!empty fileList}">
						<hr></hr>
						<hr></hr>
						<table border="1" bgcolor="black" width="600px">
							<tr
								style="background-color: teal; color: white; text-align: center;"
								height="40px">
								<th>ID</th>
								<th>File Upload Date</th>
								<th>File Location</th>
								<th>File Name</th>
								<th>File Size</th>
								<th>Edit</th>
								<th>Delete</th>
								<th>Download</th>
							</tr>
							<c:forEach items="${fileList}" var="file">
								<tr
									style="background-color: silver; color: black; text-align: center;"
									height="30px">
									<td>${file.id}</td>
									<td>${file.fdate}</td>
									<td>${file.flocation}</td>
									<td>${file.fname}</td>
									<td>${file.fsize}</td>
									<td><a href="edit?id=/${file.id}">Edit</a></td>
									<td><a href="delete/${file.id}">Delete</a></td>
									<td><a href="download/${file.id}">Download</a></td>
									<!-- /download-document-${user.id}-${doc.id} -->
								</tr>
							</c:forEach>
						</table>
					</c:if>
				</div>
			</center>
		</div>
	</div>
</body>
</html>