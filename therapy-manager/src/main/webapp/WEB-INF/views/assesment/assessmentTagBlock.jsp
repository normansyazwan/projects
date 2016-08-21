<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<c:if test="${param.assessmentId eq a.assesmentId}">
	<div class="well well-sm">
</c:if>
<table style="font-size: 0.9em; border-bottom: 1px; width: 100%"
	border="0">
	<tr>
		<td style="margin: 2px;width:130px;"><strong>Present Condition</strong></td>
		<td style="padding-left: 10px;">${a.presentCondition}</td>
	</tr>
	<tr>
		<td style="width:130px;"><strong>Onset</strong></td>
		<td style="padding-left: 10px;">${a.onset}</td>
	</tr>
	<tr>
		<td style="width:130px;"><strong>Duration</strong></td>
		<td style="padding-left: 10px;">${a.duration}</td>
	</tr>
	<tr>
		<td style="width:130px;"><strong>Red Flag</strong></td>
		<td style="padding-left: 10px;">${a.redFlag}</td>
	</tr>
	<tr>
		<td style="width:130px;"><strong>Therapy Plan</strong></td>
		<td style="padding-left: 10px;">${a.therapyPlan}</td>
	</tr>
	<tr>
		<td style="width:130px;"><strong>Assessment Date</strong></td>
		<td style="padding-left: 10px;">
		<fmt:formatDate value="${a.createdDate}" var="dateString"
						pattern="dd-MMM-yyyy" />${dateString}
		</td>
	</tr>
</table>
<br/>
<c:if test="${param.assessmentId eq a.assesmentId}">
	</div>
</c:if>