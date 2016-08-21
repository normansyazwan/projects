<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="page-header">
	<h3>Financial Report</h3>
</div>


<div class="container">

	<div class="table-responsive">
		<table class="table table-bordered table-condensed" style="width: 400px;">
			<thead>
				<tr>
					<th>Date</th>
					<th class="text-right">Amount</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dailyEarnings}" var="e" varStatus="status">
					<tr>
						<td><fmt:formatDate value="${e.createdDate}" var="dateString"
								pattern="dd-MMM-yyyy" /> ${dateString}</td>
						<td class="text-right">${e.fees}</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>

</div>