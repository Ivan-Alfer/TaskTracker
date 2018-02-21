<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>


	<%-- <font color="red"> ${SPRING_SECURITY_LAST_EXCEPTION.message} </font> --%>
	
	
	<form action="<%=request.getContextPath()%>/login" method="POST">
		Enter Email: <input type="text" name="email" /><br />
		<br /> Enter Password: <input type="password" name="password" /> <br />
		<br /> <input type="submit" value="Login" /> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>







	<br />
	<a href="${pageContext.request.contextPath}/registration">Registration</a>

</body>
</html>