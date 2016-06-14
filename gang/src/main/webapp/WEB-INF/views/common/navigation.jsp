<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<ul class="nav nav-pills nav-stacked">
  <li role="presentation" ><a href='<c:url value="/patient/add" />'>Add New
			Patient</a></li>
  <li role="presentation"><a href='<c:url value="/patients" />'>List Patients</a></li>
</ul>

<hr/>
<ul class="nav nav-pills nav-stacked">
  <li role="presentation"><a href='<c:url value="/employee/new" />'>New Employee</a></li>
  <li role="presentation"><a href='<c:url value="/employees" />'>List Employees</a></li>
  <li role="presentation"><a href='<c:url value="/employee/access" />'>Employee Access</a></li>
</ul>

<hr/>
<ul class="nav nav-pills nav-stacked">
  <li role="presentation"><a href='<c:url value="/stats/visitTrend" />'>Patient Visit Trend</a></li>
</ul>