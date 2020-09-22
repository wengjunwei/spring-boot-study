<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center" width="50%">
		<tr>
			<th>ID</th>
			<th>name</th>
			<th>age</th>
		</tr>
		<c:forEach items="${list }" var="user">
			<tr>
				<th>${user.id }</th>
				<th>${user.name }</th>
				<th>${user.age }</th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>