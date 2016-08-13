<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="th" uri="http://tomcat.apache.org/therapy-taglib"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="page-header">
	<h3>Treatment</h3>
	<h5>Add treatment for ailment</h5>
</div>

<%-- Renders a bar at top of page with patient details --%>
<th:patientDetailsBar patient="${patient}" />

<%-- height of a typical laptop screen is 700px; --%>
<div class="container-fulid" style="height:540px">
	<div class="row">

		<div class="row">
			<div class="col-sm-12">
				<hr />
			</div>
		</div>


		<div class="row">
			<div class="col-sm-12" >
				
				<div class="col-sm-6" >
					<span class="badge">Total ${fn:length(assesments)} Assessments</span>
					<c:forEach items="${assesments}" var="a">
						<a
							href="<c:url value="/patients/${a.patientId}/treatment?assessmentId=${a.assesmentId}&sittings=list" />">
							<th:assessment assessment="${a}" />
						</a>
					</c:forEach>
				</div>
				<div class="col-sm-6">
					<div class="row">
						<div class="col-sm-12">
							<div class="alert-danger">${assessmentNotSelected}</div>
						</div>
						<div class="col-sm-12">

							<form method="POST" class="form-horizontal">

								<div class="form-group ${status.error ? 'has-error' : ''}">
									<label class="col-sm-2 control-label">Sitting:</label>
									<div class="col-sm-7">
										<select id="treatmentId" name="treatmentId"
											class="form-control">
											<option value="">---- select ----</option>
											<c:forEach var="t" items="${treatments}">
												<option value="${t.treatmentId}">${t.name}-
													${t.fees}</option>
											</c:forEach>
										</select>
									</div>
									<input type="submit" value="Add" class="btn btn-success" />
								</div>

							</form>
							<hr />

							<%--  --%>
							<span class="badge">Total ${fn:length(sittings)} Sittings</span>
							<ul class="list-group">
							<c:forEach var="s" items="${sittings}" varStatus="status">
									<li class="list-group-item">
									<fmt:formatDate value="${s.createdDate}" var="dateString"
												pattern="dd-MMM-yyyy" /> ${dateString}
												
									${s.treatment}
									${s.fees}
									</li>
							</c:forEach>
								</ul>

						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>



