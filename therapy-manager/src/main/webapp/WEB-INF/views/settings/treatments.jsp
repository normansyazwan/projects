<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="th" uri="http://tomcat.apache.org/therapy-taglib"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="page-header">
	<h3>Treatments</h3>
</div>

<div class="container-fluidic">

	<div class="row">
		<div class="col col-sm-6">

			<table class="table table-bordered">
				<thead>
					<tr>
						<th width="100">Treatment Id</th>
						<th>Name</th>
						<th class="text-right">Fee</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ treatments}" var="t" varStatus="status">
						<tr>
							<td>${t.treatmentId}</td>
							<td>${t.name}</td>
							<td class="text-right">${t.fees}</td>
							<td><a class="btn btn-default btn-xs"
								href='<c:url value="?action=edit&treatmentId=${t.treatmentId}" />'>Edit</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col col-sm-6">
			<%-- 
			<c:choose>
				<c:when test="${action_status_success ne null}">
					<div class="alert alert-success">${action_status_success}.</div>
				</c:when>
				<c:when test="${action_status_error ne null}">
					<div class="alert alert-success">${action_status_success}.</div>
				</c:when>
				
				<c:otherwise>
					<div class="alert alert-danger">Action status unknown!</div>
				</c:otherwise>
			</c:choose>
			--%>
			<form:form class="form-horizontal" action="treatments" method="post"
				commandName="t">
				<div class="form-group">
					<label class="control-label col-sm-4" for="treatmentId">Treatment
						Id:</label>
					<div class="col-sm-8">
						<form:input path="treatmentId" class="form-control"
							placeholder="Treatment Id" disabled="disabled" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="name">Treatment
						Description:</label>
					<div class="col-sm-8">
						<form:input path="name" class="form-control"
							placeholder="e.g. Consultation Fee" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="fee">Fee:</label>
					<div class="col-sm-8">
						<form:input path="fees" class="form-control" placeholder="fee" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-8">
						<button type="submit" class="btn btn-default">Save</button>
					</div>
				</div>
			</form:form>

		</div>
	</div>
</div>

