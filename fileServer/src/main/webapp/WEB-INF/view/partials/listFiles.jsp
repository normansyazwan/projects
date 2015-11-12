<%@page import="org.apache.commons.io.FileUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<h3>Files</h3>
<div class="container">

<c:forEach var="f" items="${fileList}">
<div class="row">
	<div class="col-xs-6">
		<a href='<spring:url value="/download?file=${f[0]}" />'>${f[0]}</a>
	</div>
	<div class="col-xs-3">
		${f[1]}
	</div>
	<div class="col-xs-3">
		${f[2]}
	</div>
</div>
</c:forEach>

</div>