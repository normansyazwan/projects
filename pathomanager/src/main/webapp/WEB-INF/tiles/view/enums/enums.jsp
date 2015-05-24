<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

	<h3 class="pageHeading">Enum Master</h3>
	<form:form commandName="appEnum">
		<table>
			<tr>
				<td><label>Enum Id</label></td>
				<td><form:input path="enumId" /></td>
			</tr>
			<tr>
				<td><label>Enum Group</label></td>
				<td><form:input path="enumGroup" /></td>
			</tr>
			<tr>
				<td><label>Enum Value</label></td>
				<td><form:input path="enumValue" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="button" value="Reset"> &nbsp; <input
					type="submit" value="Save"></td>
			</tr>
		</table>
	</form:form>
	
	<c:choose>
		<c:when test="${!empty tests}">
			<table class="gridtable">
				<tr>
					<th width="80">Enum ID</th>
					<th width="120">Enum Group</th>
					<th width="120">Enum Value</th>
					<th width="60">Edit</th>
					<th width="60">Delete</th>
				</tr>
				<c:forEach var="t" items="${tests}">
					<tr>
						<td>${t.enumId}</td>
						<td>${t.enumGroup}</td>
						<td>${t.enumValue}</td>
						<td><a
							href="<c:url value='/master/enums/edit/${t.enumId}' />">Edit</a></td>
						<td><a
							href="<c:url value='/master/enums/delete/${t.enumId}' />">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h3>Data not available!</h3>
		</c:otherwise>
	</c:choose>
	<c:if test="${!empty tests}">



	</c:if>
</body>
</html>