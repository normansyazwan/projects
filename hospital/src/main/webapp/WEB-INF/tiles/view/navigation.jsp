<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<ul class="nav nav-pills nav-stacked">
  <li role="presentation" class="active"><a href='<c:url value="/patient/add" />'>Add New
			Patient</a></li>
  <li role="presentation"><a href='<c:url value="/patients" />'>List Patients</a></li>
  <li role="presentation"><a href="#">Messages</a></li>
</ul>