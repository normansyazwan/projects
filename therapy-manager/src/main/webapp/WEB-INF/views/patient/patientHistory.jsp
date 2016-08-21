<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="th" uri="http://tomcat.apache.org/therapy-taglib"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="page-header">
	<h3>Treatment History for ${patient.firstName}</h3>
</div>

<th:patientDetailsBar patient="${patient}" />

<hr />
<div class="panel-group" id="accordion">

	<c:choose>
		<%-- Show forms only when there are assessments available --%>
		<c:when test="${fn:length(assessments) gt 0}">

			<c:forEach items="${assessments}" var="a" varStatus="status">

				<fmt:formatDate value="${a.createdDate}" pattern="dd-MMM-yyyy"
					var="createDateString" />
				<fmt:formatDate value="${a.updatedDate}" pattern="dd-MMM-yyyy"
					var="updatedDateString" />

				<div class="panel panel-default">

					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapse${status.count+1}"> ${status.index +1 }
								&nbsp;<span class="glyphicon glyphicon-minus"></span>&nbsp;
								${createDateString}&nbsp;<span class="glyphicon glyphicon-minus"></span>&nbsp;
								${a.presentCondition} &nbsp;<span class="badge">Total
									${fn:length(a.sittings)} Sittings for this Assessment</span>
							</a>
						</h4>
					</div>

					<div id="collapse${status.count+1}"
						class="panel-collapse collapse ">
						<div class="panel-body">
							<ul class="list-group ">
								<li class="list-group-item"><label>Present
										Condition: &nbsp;</label>${a.presentCondition}</li>
								<li class="list-group-item"><label>Onset: &nbsp;</label>${a.onset}</li>
								<li class="list-group-item"><label>Duration: &nbsp;</label>${a.duration}</li>
								<li class="list-group-item"><label>Surgical
										History: &nbsp;</label>${a.surgicalHistory}</li>
								<li class="list-group-item"><label>Red Flag: &nbsp;</label>${a.redFlag}</li>
								<li class="list-group-item"><label>Physiotherapy
										Treatment History: &nbsp;</label>${a.physiotherapyTreatmentHistory}</li>
								<li class="list-group-item"><label>Current
										Exercises: &nbsp;</label>${a.currentExercises}</li>
								<li class="list-group-item"><label>Family History:
										&nbsp;</label>${a.familyHistory}</li>
								<li class="list-group-item"><label>Swelling: &nbsp;</label>${a.swelling}</li>
								<li class="list-group-item"><label>Area Of Pain:
										&nbsp;</label>${a.areaOfPain}</li>
								<li class="list-group-item"><label>Deformity:
										&nbsp;</label>${a.deformity}</li>
								<li class="list-group-item"><label>Gait: &nbsp;</label>${a.gait}</li>
								<li class="list-group-item"><label>Built: &nbsp;</label>${a.built}</li>
								<li class="list-group-item"><label>Warmth: &nbsp;</label>${a.warmth}</li>
								<li class="list-group-item"><label>Muscle Spasm:
										&nbsp;</label>${a.muscleSpasm}</li>
								<li class="list-group-item"><label>Tenderness:
										&nbsp;</label>${a.tenderness}</li>
								<li class="list-group-item"><label>Vas Scale:
										&nbsp;</label>${a.vasScale}</li>
								<li class="list-group-item"><label>Aggrevating
										Factors: &nbsp;</label>${a.aggrevatingFactors}</li>
								<li class="list-group-item"><label>ROM: &nbsp;</label>${a.rom}</li>
								<li class="list-group-item"><label>End Feel: &nbsp;</label>${a.endFeel}</li>
								<li class="list-group-item"><label>MMT: &nbsp;</label>${a.mmt}</li>
								<li class="list-group-item"><label>SpecialTests:
										&nbsp;</label>${a.specialTests}</li>
								<li class="list-group-item"><label>Cardiorespiratory:
										&nbsp;</label>${a.cardiorespiratory}</li>
								<li class="list-group-item"><label>RunctionalAssesment:
										&nbsp;</label>${a.functionalAssesment}</li>
								<li class="list-group-item"><label>WellnessAssesment:
										&nbsp;</label>${a.wellnessAssesment}</li>
								<li class="list-group-item"><label>RecoveryPotential:
										&nbsp;</label>${a.recoveryPotential}</li>
								<li class="list-group-item"><label>TherapyPlan:
										&nbsp;</label>${a.therapyPlan}</li>
								<li class="list-group-item"><label>Is Treatment
										Active: &nbsp;</label>${a.isActive}</li>
								<li class="list-group-item"><label>Created On:
										&nbsp;</label>${createDateString}</li>
								<li class="list-group-item"><label>Updated On:
										&nbsp;</label>${updatedDateString}</li>
							</ul>
						</div>
					</div>
				</div>
			</c:forEach>

		</c:when>
		<c:otherwise>


			<div class="row">
				<div class="col col-sm-3"></div>
				<div class="col col-sm-6">

					<div class="alert alert-warning alert-sm" role="alert">
						<span class="glyphicon glyphicon-exclamation-sign"
							aria-hidden="true"></span> <span class="sr-only">Error:</span>
						There are no Assessments for this patient!
					</div>

				</div>
				<div class="col col-sm-3"></div>
			</div>

			<div class="row">
				<div class="col col-sm-3"></div>
				<div class="col col-sm-6">

					<div class="btn-group">
						<a
							href='<c:url value="/patients/${patient.patientId}/assesment" />'
							class="btn btn-default btn-sm" title="New Assessment">New
							Assessment</a>
					</div>
				</div>
				<div class="col col-sm-3"></div>
			</div>


		</c:otherwise>


	</c:choose>
</div>