<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

	<div class="BlockBorder">
		<div class="BlockBL">
			<div></div>
		</div>
		<div class="BlockBR">
			<div></div>
		</div>
		<div class="BlockTL"></div>
		<div class="BlockTR">
			<div></div>
		</div>
		<div class="BlockT"></div>
		<div class="BlockR">
			<div></div>
		</div>
		<div class="BlockB">
			<div></div>
		</div>
		<div class="BlockL"></div>
		<div class="BlockC"></div>
		<div class="Block">

			<span class="BlockHeader"><span>Search This Site</span></span>
			<div class="BlockContentBorder">

				<input type="text" style="width: 120px" /> <span
					class="ButtonInput"><span><input type="button"
						value="Search" /></span></span>

			</div>

		</div>
	</div>



	<div class="BlockBorder">
		<div class="BlockBL">
			<div></div>
		</div>
		<div class="BlockBR">
			<div></div>
		</div>
		<div class="BlockTL"></div>
		<div class="BlockTR">
			<div></div>
		</div>
		<div class="BlockT"></div>
		<div class="BlockR">
			<div></div>
		</div>
		<div class="BlockB">
			<div></div>
		</div>
		<div class="BlockL"></div>
		<div class="BlockC"></div>
		<div class="Block">

			<span class="BlockHeader"><span>Links</span></span>
			<div class="BlockContentBorder">

				<ul>
					<li><a href='<c:url value="/patient/add" />'>Add New
							Patient</a></li>
					<li><a href='<c:url value="/patients" />'>List Patients</a></li>
					<li><a href="#">Test Link 3</a></li>
					<li><a href="#">Test Link 4</a></li>
					<li><a href="#">Test Link 5</a></li>
				</ul>

			</div>

		</div>
	</div>

</body>
</html>