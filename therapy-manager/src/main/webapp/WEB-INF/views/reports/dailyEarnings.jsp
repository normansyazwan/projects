<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="page-header">
	<h3>Financial Report</h3>
</div>


<div class="container-fluidic">

	<div class="row" >
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
								<c:when test="${param.year eq y}">
									<option  value="${y}" selected="selected">${y}</option>	
								</c:when>
								<c:otherwise>
									<option  value="${y}">${y}</option>
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
								<c:when test="${param.month eq entry.key}">
									<option  value="${entry.key}" selected="selected">${entry.value}</option>	
								</c:when>
								<c:otherwise>
									<option  value="${entry.key}">${entry.value}</option>
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
			<div class="col-sm-12"><%-- just for space --%> &nbsp;</div>
			</div>
			<%-- Form ends here --%>
			<div class="table-responsive">
				<table class="table table-bordered table-condensed" >
					<thead>
						<tr>
							<th>Date</th>
							<th class="text-right">Amount</th>
						</tr>
					</thead>
					<tbody>
						<%-- Loop to generate table --%>
						<c:forEach items="${dailyEarnings}" var="e" varStatus="status">
							<tr>
								<td>
									<fmt:formatDate value="${e.createdDate}" var="dateString" pattern="dd-MMM-yyyy" /> 
									<a href='<c:url value="?date=${dateString}" />'>${dateString}</a>	
								</td>
								<td class="text-right">${e.fees}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="col col-sm-7">
			
		</div>
	</div>



</div>