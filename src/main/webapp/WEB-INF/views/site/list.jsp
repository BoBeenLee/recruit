<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL"
	value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List</title>
<link rel="stylesheet"
	href='<c:url value="${baseURL}/resources/css/normalize.css"/>'>
<link rel="stylesheet"
	href='<c:url value="${baseURL}/resources/css/style.css"/>'>
</head>
<body>
	<header> 사이트 목록 <a href='<c:url value="${baseURL}/recruit/main"/>'>목록</a>
	</header>
	<article>
	<ul>
		<c:forEach var="site" items="${ sites }">
			<li>${board.name}
				<form action="/recruit/remove">
					<input type="hidden" name="id" value="${ site.stId }" /> <input
						type="submit" value="삭제" />
				</form>
			</li>
		</c:forEach>
	</ul>
	</article>
</body>
</html>