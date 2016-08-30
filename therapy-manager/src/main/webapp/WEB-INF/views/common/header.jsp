<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value="/" />">PreCure</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" 
			id="bs-example-navbar-collapse-1">
			<%-- Menu for Patient related actions --%>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Patient<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value="/patients/register" />" >Registration</a></li>
						<li><a href="<c:url value="/patients/?page=1" />">All Patients</a></li>
						<li role="separator" class="divider"></li>
					</ul>
				</li>
			</ul>
			<%-- Menu for reporting --%>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Reports<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value="/reports/dailyEarnings" />" >Daily Financial Report</a></li>
					</ul>
				</li>
			</ul>
			
			<%-- Menu for settings --%>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Settings<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value="/settings/treatments" />" >Add/Edit Treatments</a></li>
					</ul>
				</li>
			</ul>
			
			<c:url value='/search' var="searchAction" />
			<form method="GET" action="${searchAction}" class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input name="q" type="text" value="${q}" class="form-control" placeholder="Search with.. Name, mobile, email etc.."  size="50" />
				</div>
				<button type="submit" class="btn btn-default">Search</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Actions<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value="/aboutUs"/>'>About Us</a></li>
						<li><a href='<c:url value="/contactUs"/>'>Contact Us</a></li>
						<li><a href='<c:url value="/disclaimer"/>'>Disclaimer</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>