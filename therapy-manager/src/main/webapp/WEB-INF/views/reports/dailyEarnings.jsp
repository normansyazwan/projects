<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="page-header">
	<h3>Financial Report</h3>
</div>


<div class="container-fluidic">

	<div class="row">
		<div class="col col-sm-5">

			<%-- Form starts --%>
			<div class="row">

				<form method="get" class="form-horizontal" action="dailyEarnings">

					<%-- Years --%>
					<div class="col-sm-5">
						<select class="form-control" id="year" name="year">
							<option value="0">-- select year --</option>
							<c:forEach var="y" items="${years}">

								<c:choose>
									<c:when test="${param.year eq y or selectedYear eq y}">
										<option value="${y}" selected="selected">${y}</option>
									</c:when>
									<c:otherwise>
										<option value="${y}">${y}</option>
									</c:otherwise>
								</c:choose>

							</c:forEach>
						</select>
					</div>
					<%-- Months --%>
					<div class="col-sm-5">
						<select class="form-control" id="month" name="month">
							<option value="0">-- select month --</option>
							<c:forEach var="entry" items="${months}">
								<c:choose>
									<c:when test="${param.month eq entry.key or selectedMonth eq entry.key}">
										<option value="${entry.key}" selected="selected">${entry.value}</option>
									</c:when>
									<c:otherwise>
										<option value="${entry.key}">${entry.value}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
					<div class="col-sm-2">
						<%-- submit button --%>
						<input type="submit" value="Go" class="btn btn-success" />
					</div>
				</form>
				<%-- Form ends --%>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<%-- just for space --%>
					&nbsp;
				</div>
			</div>
			<%-- Form ends here --%>
			<div class="table-responsive">
				<table class="table table-bordered table-condensed">
					<thead>
						<tr>
							<th>Date</th>
							<th class="text-right">Total Amount</th>
						</tr>
					</thead>
					<tbody>
						<%-- Loop to generate table --%>
						<c:forEach items="${dailyEarnings}" var="e" varStatus="status">
							<tr>
								<td><fmt:formatDate value="${e.createdDate}"
										var="dateString" pattern="dd-MMM-yyyy" /> <a
									href='<c:url value="?date=${dateString}&year=${param.year}&month=${param.month}" />'>${dateString}</a>
								</td>
								<td class="text-right">${e.fees}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="col col-sm-7">
			<c:choose>
				<c:when test="${fn:length(perDayStats) eq 0}">
					<div class="alert alert-warning alert-sm" role="alert">
						<span class="glyphicon glyphicon-exclamation-sign"
							aria-hidden="true"></span> <span class="sr-only">Error:</span>
						Please click on <span class="text-success">Date</span> on the left panel to view <span class="text-success">day wise</span> details.
					</div>
				</c:when>
				<c:otherwise>
					<%-- Table to render daily stats --%>					
					<div class="table-responsive">
						<table class="table table-bordered table-condensed">
							<thead>
								<tr>
									<th>Date</th>
									<th>Patient Id</th>
									<th>Name</th>
									<th class="text-right">Amount</th>
								</tr>
							</thead>
							<tbody>
								<%-- Loop to generate table --%>
								<c:forEach items="${perDayStats}" var="e" varStatus="status">
									<tr>
										<td><fmt:formatDate value="${e.createdDate}"
												var="dateStr" pattern="dd-MMM-yyyy" />${dateStr}
										</td>
										<td>${e.patientId}</td>
										<td>${e.firstName}&nbsp;${e.lastName}</td>
										<td class="text-right">${e.fees}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<%-- Table to render daily stats ends --%>	
				</c:otherwise>
			</c:choose>
		</div>
	</div>



</div>