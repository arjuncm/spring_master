<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Removed Users List</h2>
	<table>
		<tr>
			<td><strong>Name</strong></td>
			<td><strong>Email</strong></td>
		</tr>
		<c:forEach items="${removedlist}" var="user">
			<tr>
				<td>${user.name}</td>
				<td>${user.email}</td>
				<td><a href="removeUser/${user.id}">edit</a></td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>