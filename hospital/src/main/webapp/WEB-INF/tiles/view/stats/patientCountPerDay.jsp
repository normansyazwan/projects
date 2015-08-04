<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<div class="page-header">
		<h3>Patient Visit Trend</h3>
		<small>For last 2 months</small>
	</div>
	<p>This report shows number of patients visiting daily over past 60 days.</p>
	<table
		class="table table-condensed table-striped table-hover table-responsive">
		<thead>
			<tr>
				<th>Sr.No.</th>
				<th>Date</th>
				<th>Number of patients</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${visitStats}" var="v" varStatus="counter">
				<tr>
					<td style="width: 100">${counter.count }</td>
					<td style="width: 200">${v.date }</td>
					<td>${v.count }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
