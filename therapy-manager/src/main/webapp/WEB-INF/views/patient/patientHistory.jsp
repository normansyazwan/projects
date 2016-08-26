<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="th" uri="http://tomcat.apache.org/therapy-taglib"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="page-header">
	<h3>Assessment History for ${patient.firstName}</h3>
</div>

<th:patientDetailsBar patient="${patient}" />

<hr />

<div class="container-fluidic">

	<div class="row">
	
	<c:choose>
		<c:when test="${fn:length(assesmentsInBrief) gt 0}">
	
		<div class="col col-sm-5">
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
				<div class="table-responsive">
					<table class="table table-bordered table-condensed table-striped small">
						<tbody>
							<tr>
								<td><label>Present Condition: &nbsp;</label>${assesment.presentCondition}</td>
							</tr>
							<tr>
								<td><label>Present Condition: &nbsp;</label>${assesment.presentCondition}</td>
							</tr>
							<tr>
								<td><label>Onset: &nbsp;</label>${assesment.onset}</td>
							</tr>
							<tr>
								<td><label>Duration: &nbsp;</label>${assesment.duration}</td>
							</tr>
							<tr>
								<td><label>Surgical History: &nbsp;</label>${assesment.surgicalHistory}</td>
							</tr>
							<tr>
								<td><label>Red Flag: &nbsp;</label>${assesment.redFlag}</td>
							</tr>
							<tr>
								<td><label>Physiotherapy Treatment History: &nbsp;</label>${assesment.physiotherapyTreatmentHistory}</td>
							</tr>
							<tr>
								<td><label>Current Exercises: &nbsp;</label>${assesment.currentExercises}</td>
							</tr>
							<tr>
								<td><label>Family History: &nbsp;</label>${assesment.familyHistory}</td>
							</tr>
							<tr>
								<td><label>Swelling: &nbsp;</label>${assesment.swelling}</td>
							</tr>
							<tr>
								<td><label>Area Of Pain: &nbsp;</label>${assesment.areaOfPain}</td>
							</tr>
							<tr>
								<td><label>Deformity: &nbsp;</label>${assesment.deformity}</td>
							</tr>
							<tr>
								<td><label>Gait: &nbsp;</label>${assesment.gait}</td>
							</tr>
							<tr>
								<td><label>Built: &nbsp;</label>${assesment.built}</td>
							</tr>
							<tr>
								<td><label>Warmth: &nbsp;</label>${assesment.warmth}</td>
							</tr>
							<tr>
								<td><label>Muscle Spasm: &nbsp;</label>${assesment.muscleSpasm}</td>
							</tr>
							<tr>
								<td><label>Tenderness: &nbsp;</label>${assesment.tenderness}</td>
							</tr>
							<tr>
								<td><label>Vas Scale: &nbsp;</label>${assesment.vasScale}</td>
							</tr>
							<tr>
								<td><label>Aggrevating Factors: &nbsp;</label>${assesment.aggrevatingFactors}</td>
							</tr>
							<tr>
								<td><label>ROM: &nbsp;</label>${assesment.rom}</td>
							</tr>
							<tr>
								<td><label>End Feel: &nbsp;</label>${assesment.endFeel}</td>
							</tr>
							<tr>
								<td><label>MMT: &nbsp;</label>${assesment.mmt}</td>
							</tr>
							<tr>
								<td><label>SpecialTests: &nbsp;</label>${assesment.specialTests}</td>
							</tr>
							<tr>
								<td><label>Cardiorespiratory: &nbsp;</label>${assesment.cardiorespiratory}</td>
							</tr>
							<tr>
								<td><label>Functional Assessment: &nbsp;</label>${assesment.functionalAssesment}</td>
							</tr>
							<tr>
								<td><label>WellnessAssesment: &nbsp;</label>${assesment.wellnessAssesment}</td>
							</tr>
							<tr>
								<td><label>RecoveryPotential: &nbsp;</label>${assesment.recoveryPotential}</td>
							</tr>
							<tr>
								<td><label>TherapyPlan: &nbsp;</label>${assesment.therapyPlan}</td>
							</tr>
							<tr>
								<td><label>Is Treatment Active: &nbsp;</label>${assesment.isActive}</td>
							</tr>
							<tr>
								<td><label>Created On: &nbsp;</label>
									<fmt:formatDate value="${assesment.createdDate}" var="createdDtStr" pattern="dd-MMM-yyyy" /> 		
									${createdDtStr}
								</td>
							</tr>
							<tr>
								<td><label>Updated On:&nbsp;</label>
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