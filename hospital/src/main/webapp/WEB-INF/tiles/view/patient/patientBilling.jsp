<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<h3>Patient Billing</h3>
	<table cellpadding="5" style="width: 300px;">
		<tr>
			<td><label>Patient Id</label></td>
			<td>${patient.patientId}</td>
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
	<table border="0" style="width: 100%;">
		<thead>
			<tr>
				<th>Sr.No</th>
				<th>Item</th>
				<th>Quantity</th>
				<th>Cost</th>
			</tr>
		</thead>


		<c:forEach items="${billingForm.billingRecords}" var="br" varStatus="status">
		<tr>
			<td>
			
			${status.count}
			
			</td>
			<td>
				<form:select path="billingForm.billingRecords[${status.index}].billableItem"  items="${billableItems}" itemLabel="description">
					
				</form:select> 
			</td>
			<td><form:input path="billingForm.billingRecords[${status.index}].quantity" value="${br.quantity}" cssStyle="text-align:right" /></td>
			<td><form:input path="billingForm.billingRecords[${status.index}].billableItem.cost"  value="${br.billableItem.cost}" cssStyle="text-align:right" /></td>
		</tr>
		</c:forEach>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td>Total to appear here: </td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td><input type="submit" value="Save Record"/> </td>
		</tr>
	</table>
</body>
</html>