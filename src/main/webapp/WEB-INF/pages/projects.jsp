<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Projects</h1>

	<table>

		<tr>
			<td>Project name</td>
		</tr>

		<c:forEach items="${projects}" var="project">
			<tr>
				<td><a
					href="${pageContext.request.contextPath}/task?id=${project.id}">
						<c:out value="${project.projectName}"></c:out>
				</a></td>
			</tr>
		</c:forEach>
	</table>

	<a href="${pageContext.request.contextPath}/projects/new">Add new
		project</a>
	<br />

	<a href="${pageContext.request.contextPath}/projects">Back</a>

</body>
</html>