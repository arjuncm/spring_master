<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Enter Customer Information</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles.css">

</head>
<body>
	<jsp:include page="_header.jsp" />
	<jsp:include page="_menu.jsp" />



	<div class="page-title">Enter Customer Information</div>
	<%=request.getAttribute("account")%> 
	<%-- <table>
		<c:forEach items="${account}" var="person">
			<tr>
				<td>${person.first_name}</td>
				<td>${person.last_name}</td>
			</tr>
		</c:forEach>
	</table> --%>
	<form:form method="POST" modelAttribute="account"
		action="${pageContext.request.contextPath}/shoppingCartCustomer">

		<table>
			<tr>
				<td>Name *</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" class="error-message" /></td>
			</tr>

			<tr>
				<td>Password *</td>
				<td><form:input path="password" /></td>
				<td><form:errors path="password" class="error-message" /></td>
			</tr>


			<tr>
				<td>Email *</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" class="error-message" /></td>
			</tr>

			<tr>
				<td>First Name *</td>
				<td><form:input path="first_name" /></td>
				<td><form:errors path="first_name" class="error-message" /></td>
			</tr>

			<tr>
				<td>Last Name *</td>
				<td><form:input path="last_name" /></td>
				<td><form:errors path="last_name" class="error-message" /></td>
			</tr>

			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Submit" /> <input type="reset"
					value="Reset" /></td>
			</tr>
		</table>

	</form:form>


	<jsp:include page="_footer.jsp" />


</body>
</html>