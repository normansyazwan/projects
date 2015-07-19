<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h3>Patient Billing</h3>
<table style="width: 300px;">
	<tr>
		<td><label>Patient Id</label></td>
		<td>${patient.personId}</td>
	</tr>
	<tr>
		<td><label>Patient Name</label></td>
		<td>${patient.firstName}&nbsp;${patient.lastName}</td>
	</tr>
	<tr>
		<td></td>
	</tr>
</table>
<hr />


<form:form method="post" modelAttribute="billingForm">
<form:hidden path="patientId" />
<table id="billingTable" class="table "
	style="width: 100%; text-align: left;">
	<thead>
		<tr>
			<th width="50px;">Sr.No</th>
			<th>Item</th>
			<th>Quantity</th>
			<th>Cost</th>
		</tr>
	</thead>
	<c:forEach items="${billingForm.billingRecords}" var="br"
		varStatus="status">
		
		<tr>
			<td>${status.count}</td>
			<td><form:select
					path="billingRecords[${status.index}].billableItem"
					items="${billableItems}" itemLabel="itemName" itemValue="itemId"
					onchange="this.form.submit()">
				</form:select></td>
			<td>
				<form:input path="billingRecords[${status.index}].quantity"
					value="${br.quantity}" cssStyle="text-align:right" />
			</td>
	</c:forEach>
</table>
</form:form>