<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles"%>

<html>
<head>
<title><tiles:getAsString name="title" /></title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.12.4.js" />"></script>

<link rel="stylesheet" href='<c:url value="/resources/css/styles.css" />' />

<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js" />"></script>
<link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.css" />'>
<link rel="stylesheet" href='<c:url value="/resources/css/bootstrap-theme.css" />'>


</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12"><tiles:insertAttribute name="header" /></div>
			<div class="col-md-12" style="margin-top:30px;"><tiles:insertAttribute name="body" /></div>
			<div class="col-md-12"><tiles:insertAttribute name="footer" /></div>
		</div>
	</div>

</body>
</html>