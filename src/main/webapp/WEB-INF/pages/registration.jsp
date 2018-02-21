<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<title>Sign Up</title>
<style type="text/css">
span.error {
	color: red;
}
</style>
</head>
<body>
	<h1>Registration</h1>

	<form:form method="post" commandName="User" modelAttribute="user">
		<table>
 			<tr>
				<td>First name:</td>
				<td><form:input path="firstName" /></td>
				<td><span class="error"><form:errors path="firstName" /></span></td>
			</tr> 

			<tr>
				<td>Surname:</td>
				<td><form:input path="surname" /></td>
				<td><span class="error"><form:errors path="surname" /></span></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><form:password path="password" /></td>
				<td><span class="error"><form:errors path="password" /></span></td>
			</tr>

			<tr>
				<td>Confirm Password:</td>
				<td><form:password path="confirmPassword" /></td>
				<td><span class="error"><form:errors
							path="confirmPassword" /></span></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
				<td><span class="error"><form:errors path="email" /></span></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" value="Sign up" /></td>
			</tr>
		</table>
	</form:form>

	<a href="${pageContext.request.contextPath}/">Back</a>
</body>
</html>