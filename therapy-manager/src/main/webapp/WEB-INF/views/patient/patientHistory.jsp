<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="th" uri="http://tomcat.apache.org/therapy-taglib"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="page-header">
	<h3>Assessments History for ${patient.firstName}</h3>
</div>

<th:patientDetailsBar patient="${patient}" />

<hr />

<div class="container-fluidic">

	<div class="row">
	
	<c:choose>
		<c:when test="${fn:length(assesmentsInBrief) gt 0}">
	
		<div class="col col-sm-5">
			<h3>Assessments</h3>
			<div class="table-responsive">
				<table class="table table-bordered table-striped table-condensed small">
					<thead>
						<tr>
							<th width="50">Id</th>
							<th>Present Condition</th>
							<th width="80">Created Date</th>
							<th width="80">Updated Date</th>
						</tr>
					</thead>
					<tbody>
						<%-- Loop to generate table --%>
						<c:forEach items="${assesmentsInBrief}" var="a" varStatus="status">
							<tr>
								<td width="50"><a
									href='<c:url value="?assessmentId=${a.assesmentId}" />'>${a.assesmentId }</a>
								</td>
								<td><a
									href='<c:url value="?assessmentId=${a.assesmentId}" />'>${a.presentCondition }</a></td>
								<td><fmt:formatDate value="${a.createdDate}"
										var="createdDateStr" pattern="dd-MMM-yyyy" /> <a
									href='<c:url value="?assessmentId=${a.assesmentId}" />'>
										${createdDateStr}</a></td>
								<td><fmt:formatDate value="${a.updatedDate}"
										var="updatedDateStr" pattern="dd-MMM-yyyy" /> <a
									href='<c:url value="?assessmentId=${a.assesmentId}" />'>
										${updatedDateStr} </a></td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="col col-sm-7">
			<c:choose>
				<c:when test="${assesment ne null}">
				<h3>Assessment Details</h3>
				<div class="table-responsive">
					<table class="table table-bordered table-condensed table-striped small">
						<tbody>
							<tr>
								<td width="120"><label>Present Condition: &nbsp;</label></td><td>${assesment.presentCondition}</td>
							</tr>
							<tr>
								<td width="120"><label>Onset: &nbsp;</label></td><td>${assesment.onset}</td>
							</tr>
							<tr>
								<td width="120"><label>Duration: &nbsp;</label></td><td>${assesment.duration}</td>
							</tr>
							<tr>
								<td width="120"><label>Surgical History: &nbsp;</label></td><td>${assesment.surgicalHistory}</td>
							</tr>
							<tr>
								<td width="120"><label>Red Flag: &nbsp;</label></td><td>${assesment.redFlag}</td>
							</tr>
							<tr>
								<td width="120"><label>Physiotherapy Treatment History: &nbsp;</label></td><td>${assesment.physiotherapyTreatmentHistory}</td>
							</tr>
							<tr>
								<td width="120"><label>Current Exercises: &nbsp;</td><td></label>${assesment.currentExercises}</td>
							</tr>
							<tr>
								<td width="120"><label>Family History: &nbsp;</label></td><td>${assesment.familyHistory}</td>
							</tr>
							<tr>
								<td width="120"><label>Swelling: &nbsp;</label></td><td>${assesment.swelling}</td>
							</tr>
							<tr>
								<td width="120"><label>Area Of Pain: &nbsp;</label></td><td>${assesment.areaOfPain}</td>
							</tr>
							<tr>
								<td width="120"><label>Deformity: &nbsp;</label></td><td>${assesment.deformity}</td>
							</tr>
							<tr>
								<td width="120"><label>Gait: &nbsp;</label></td><td>${assesment.gait}</td>
							</tr>
							<tr>
								<td width="120"><label>Built: &nbsp;</label></td><td>${assesment.built}</td>
							</tr>
							<tr>
								<td width="120"><label>Warmth: &nbsp;</label></td><td>${assesment.warmth}</td>
							</tr>
							<tr>
								<td width="120"><label>Muscle Spasm: &nbsp;</label></td><td>${assesment.muscleSpasm}</td>
							</tr>
							<tr>
								<td width="120"><label>Tenderness: &nbsp;</label></td><td>${assesment.tenderness}</td>
							</tr>
							<tr>
								<td width="120"><label>Vas Scale: &nbsp;</label></td><td>${assesment.vasScale}</td>
							</tr>
							<tr>
								<td width="120"><label>Aggrevating Factors: &nbsp;</label></td><td>${assesment.aggrevatingFactors}</td>
							</tr>
							<tr>
								<td width="120"><label>ROM: &nbsp;</label></td><td>${assesment.rom}</td>
							</tr>
							<tr>
								<td width="120"><label>End Feel: &nbsp;</label></td><td>${assesment.endFeel}</td>
							</tr>
							<tr>
								<td width="120"><label>MMT: &nbsp;</label></td><td>${assesment.mmt}</td>
							</tr>
							<tr>
								<td width="120"><label>Special Tests: &nbsp;</label></td><td>${assesment.specialTests}</td>
							</tr>
							<tr>
								<td width="120"><label>Cardiorespiratory: &nbsp;</label></td><td>${assesment.cardiorespiratory}</td>
							</tr>
							<tr>
								<td width="120"><label>Functional Assessment: &nbsp;</label></td><td>${assesment.functionalAssesment}</td>
							</tr>
							<tr>
								<td width="120"><label>Wellness Assesment: &nbsp;</label></td><td>${assesment.wellnessAssesment}</td>
							</tr>
							<tr>
								<td width="120"><label>Recovery Potential: &nbsp;</label></td><td>${assesment.recoveryPotential}</td>
							</tr>
							<tr>
								<td width="120"><label>Therapy Plan: &nbsp;</label></td><td>${assesment.therapyPlan}</td>
							</tr>
							<tr>
								<td width="120"><label>Is Treatment Active: &nbsp;</label></td><td>${assesment.isActive}</td>
							</tr>
							<tr>
								<td width="120"><label>Created On: &nbsp;</label></td><td>
									<fmt:formatDate value="${assesment.createdDate}" var="createdDtStr" pattern="dd-MMM-yyyy" /> 		
									${createdDtStr}
								</td>
							</tr>
							<tr>
								<td width="120"><label>Updated On:&nbsp;</label></td><td>
								<fmt:formatDate value="${a.updatedDate}" var="updatedDtStr" pattern="dd-MMM-yyyy" />
								${updatedDtStr}</td>
							</tr>
							
						</tbody>
					</table>
				</div>
				</c:when>
				<c:otherwise>
					<div class="alert alert-warning alert-sm" role="alert">
						<span class="glyphicon glyphicon-exclamation-sign"
							aria-hidden="true"></span> <span class="sr-only">Error:</span>
						Please click on any <span class="text-success">Assessment</span> on the left panel to view details.
					</div>
				</c:otherwise>
				</c:choose>
		</div>
		
		</c:when>
		<c:otherwise>
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<div class="row">
					<div class="col-sm-12">
						<div class="alert alert-warning alert-sm" role="alert">
							<span class="glyphicon glyphicon-exclamation-sign"
							aria-hidden="true"></span> <span class="sr-only">Error:</span>
						There are no <span class="text-success">Assessments</span> for this patient. Please add a new Assessment by clicking button below:
						</div>
					</div>
					<div class="col-sm-12"><a href='<c:url value="/patients/${patient.patientId}/assesment" />'
							class="btn btn-default btn-sm" title="Add New Assessment">New Assessment</a></div>
				</div>
			</div>
			<div class="col-sm-3"></div>
		
			
		</c:otherwise>
		</c:choose>
		
	</div>
</div>