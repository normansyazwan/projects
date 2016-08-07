<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container-fulid">
	<div class="row">
		<div class="col-sm-12">
			<table class="gridtable" style="width: 100%;">
				<tr>
					<td width="100"><label>Patient Name:</label></td>
					<td><a href='<c:url value="/patients/${patient.patientId}/profile" />'>
								${patient.firstName}&nbsp;${patient.lastName} </a></td>
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
	</div>
</div>