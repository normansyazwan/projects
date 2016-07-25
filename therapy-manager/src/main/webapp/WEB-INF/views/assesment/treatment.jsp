<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div class="page-header">
	<h3>Treatment</h3>
	<h5>Add treatment for ailment</h5>
</div>

<div class="container-fulid">
	<div class="row">
		<div class="col-sm-12">
			<table class="gridtable" style="width: 100%;">
				<tr>
					<td width="100"><label>Patient Name:</label></td>
					<td>${patient.firstName}&nbsp;${patient.lastName}</td>
					<td width="60"><label>Gender:</label></td>
					<td>${patient.gender}</td>
					<td width="40"><label>Age:</label></td>
					<td>${patient.age}</td>
					<td width="90"><label>Blood Group:</label></td>
					<td>${patient.bloodGroup}</td>
					<td width="120"><label>Existing Ailments:</label></td>
					<td>${patient.existingAilments}</td>
					<td width="60"><label>Allergies:</label></td>
					<td>${patient.allergies}</td>
				</tr>
			</table>

		</div>

		<div class="row">
			<div class="col-sm-12">
				<hr />
			</div>
		</div>


		<div class="row">
			<div class="col-sm-12 pre-scrollable">
				<div class="col-sm-6 pre-scrollable">
					<c:forEach items="${assesments}" var="a">

						<a
							href="<c:url value="/patients/${a.patientId}/treatment?assessmentId=${a.assesmentId}&sittings=list" />">
							<div class="well well-sm"
								title="${a.presentCondition},${a.onset},${a.duration}"
								data-toggle="tooltip" data-placement="bottom">
								<table
									class="table table-hover table-responsive table-striped table-condensed table-sm">
									<tr>
										<td><label>Present Condition</label></td>
										<td>${a.presentCondition}</td>
									</tr>
									<tr>
										<td><label>onset</label></td>
										<td>${a.onset}</td>
									</tr>
									<tr>
										<td><label>Duration</label></td>
										<td>${a.duration}</td>
									</tr>
								</table>
							</div>
						</a>

					</c:forEach>
				</div>
				<div class="col-sm-6 pre-scrollable">
					<div class="row">
						<div class="col-sm-12">
							<form:form method="POST" commandName="sitting"
								cssClass="form-horizontal">

								<spring:bind path="treatment">
									<div class="form-group ${status.error ? 'has-error' : ''}">
										<form:label path="treatment" cssClass="col-sm-2 control-label">Sitting:</form:label>
										<div class="col-sm-6">
											<form:select path="treatment" cssClass="form-control"
												id="treatment">
												<option value=""></option>
												<c:forEach var="t" items="${treatments}">
													<form:option value="${t.name}">${t.name} - ${t.fees} </form:option>
												</c:forEach>
											</form:select>
										</div>
										<div class="col-sm-4">
											<form:errors path="treatment" cssClass="text-danger"
												class="control-label" />
										</div>
									</div>
								</spring:bind>
								<form:input path="fees" value="${fees}" cssClass="form-control" maxlength="20" />

							</form:form>

						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>



