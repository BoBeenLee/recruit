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
<title>개발 - 채용 정보 모음</title>
<link rel="stylesheet" href='<c:url value="${baseURL}/resources/css/normalize.css"/>'>
<link rel="stylesheet" href='<c:url value="${baseURL}/resources/css/bootstrap.min.css"/>'> 
<link rel="stylesheet" href='<c:url value="${baseURL}/resources/css/style.css"/>'>
</head>
<body ng-controller="SiteCtrl" ng-init="init()">
	<nav class="navbar">
		<div class="navbar-header">
		    <a class="navbar-brand" href="#">Recruit</a>
		    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
		      <span class="icon-bar"></span>
		      <span class="icon-bar"></span>
		      <span class="icon-bar"></span>
		    </button>
	    </div>
		<div class="navbar-collapse collapse">
		    <ul class="nav navbar-nav">
		      	<c:forEach var="site" items="${ sites }">
					<li><a href="#" ng-click="site('${baseURL}/recruit/get', ${site.stId}, '${ site.url }')">${site.name}</a>
				</c:forEach>
		    </ul>
		</div>
	</nav>
	<article>
	<div>
		<a class="cur-url" href="{{ link }}" target="_blank">Link</a>
	</div>
	<ul>
		<li ng-repeat="siteGroup in siteGroups">
			<div ng-repeat="siteMap in siteGroup.siteMaps">{{ siteMap.smKey }} - {{ siteMap.smValue }}</div>
		</li>
	</ul>
	</article>
	<footer> </footer>
	<script src='<c:url value="${baseURL}/resources/js/common/jquery-2.1.3.min.js" />'></script>
	<script src='<c:url value="${baseURL}/resources/js/common/bootstrap.min.js" />'></script>
	<script src='<c:url value="${baseURL}/resources/js/common/angular.min.js" />'></script>
	<script src='<c:url value="${baseURL}/resources/js/site.js" />'></script>
</body>
</html>