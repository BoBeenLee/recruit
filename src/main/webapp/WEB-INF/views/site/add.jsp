<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL"
	value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />

<html ng-app="site">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Article</title>
<link rel="stylesheet"
	href='<c:url value="/resources/css/normalize.css"/>'>
<link rel="stylesheet"
	href='<c:url value="/resources/css/style.css"/>'>
</head>
<body ng-controller="AddCtrl" ng-init="init()">
	<header> 사이트 추가 <a href='<c:url value="/main"/>'>목록</a> </header>
	<article>
	<form method="post" action="add">
		<div>
			<label>제목</label><input type="text" name="name" />
		</div>
		<label>주소</label><input type="text" name="url" /> 
		<label>목록 위치</label><input type="text" name="location" />
		<table>
			<thead>
				<tr>
					<th>이름</th>
					<th>속성</th>
					<th></th>
				</tr>
			</thead>
			<tbody class="menu">
				<tr ng-repeat="num in numbers">
					<td><input type="text" name="sKey" /></td>
					<td><input type="text" name="sValue" /></td>
					<td><input type="button" value="삭제" ng-click="remove($index)" /></td>
				</tr>
			</tbody>
		</table>
		<input type="button" value="목록추가" ng-click="add()" /> <input
			type="submit" value="확인" />
	</form>
	</article>
	<script src='<c:url value="/resources/js/common/jquery-2.1.3.min.js" />'></script>
	<script src='<c:url value="/resources/js/common/angular.min.js" />'></script>
	<script src='<c:url value="/resources/js/site.js" />'></script>
</body>
</html>