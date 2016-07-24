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
		<div class="col-sm-5">
			<div class="row">
				<div class="col-sm-3">
					<label>Patient Id:</label>
				</div>
				<div class="col-sm-9">${patient.patientId}</div>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<label>Gender</label>
				</div>
				<div class="col-sm-9">${patient.gender}</div>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<label>Age</label>
				</div>
				<div class="col-sm-9">${patient.age}</div>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<label>Blood Group</label>
				</div>
				<div class="col-sm-9">${patient.bloodGroup}</div>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<label>Existing Ailments</label>
				</div>
				<div class="col-sm-9">${patient.existingAilments}</div>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<label>Allergies</label>
				</div>
				<div class="col-sm-9">${patient.allergies}</div>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<label>Address</label>
				</div>
				<div class="col-sm-9">${patient.address.apartment}
					<br /> ${patient.address.street} <br /> ${patient.address.area}
				</div>
			</div>

			<div class="row">
				<div class="col-sm-12">
					<hr />
				</div>
			</div>


			<div class="row">
				<div class="col-sm-12 pre-scrollable">

					<c:forEach items="${assesments}" var="a">
						<div class="well well-sm" title="${a.presentCondition},${a.onset},${a.duration}" data-toggle="tooltip">
							<table class="table table-hover table-responsive table-striped table-condensed table-sm">
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
					</c:forEach>

				</div>
			</div>

		</div>
	</div>
</div>


