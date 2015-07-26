<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h3>Patient Prescription Form</h3>

<c:if test="${param.status ne null}">
	<p class="bg-success">${param.status}:Record saved successfully.
		Patient Id is &nbsp; ${param.patientId}</p>
</c:if>

<form  class="form-horizontal">
	<div class="form-group">
		<label for="exampleInputEmail1">Email address</label>
    	<input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
	</div>
	<div class="form-group">
		<label for="symptoms">Symptoms</label>
		<textarea class="form-control" rows="3" name="symptoms" ></textarea>
	</div>
	<div class="form-group">
		<label for="prescription">Prescription</label>
		<textarea class="form-control" rows="3" name="prescription"></textarea>
	</div>
	<div class="form-group">
		<label for="medicalTests">Medical Tests</label>
		<textarea name="medicalTests" class="form-control" rows="3"></textarea>
	</div>
	<div class="form-group">
		<label for="comments">Comments</label>
		<textarea name="comments" class="form-control" rows="3"></textarea>
	</div>
	<div class="form-group">
		<button class="btn btn-default">Cancel</button>
		<button class="btn btn-primary">Save</button>
	</div>
</form>