<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>newProject</h1>

	<form:form method="post" commandName="Project" modelAttribute="project">
		<table>
 			<tr>
				<td>Project name:</td>
				<td><form:input path="projectName" /></td>
			</tr> 

			<tr>
				<td colspan="3"><input type="submit" value="Sign up" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>