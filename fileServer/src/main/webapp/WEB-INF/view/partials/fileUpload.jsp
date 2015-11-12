<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<h1>Single File Upload</h1>
	<form method="post" enctype="multipart/form-data" >
		Upload File: <input type="file" name="file">
		<br /><br />
		Name: <input type="text" name="name"/>
		<br/><br/><input type="submit" value="Upload"> 
	</form>
	
<hr/>

