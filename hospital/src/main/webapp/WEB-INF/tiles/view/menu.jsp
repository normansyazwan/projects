<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
	<ul>
		<li><a href="#" class="ActiveMenuButton"><span>Home</span></a></li>
		<li><a href="#" class="MenuButton"><span>Categories</span></a></li>
		<li><a href="#" class="MenuButton"><span>Archive</span></a></li>
		<li><a href='<c:url value="/aboutUs" />' class="MenuButton"><span>About Us</span></a></li>
	</ul>
</body>
</html>