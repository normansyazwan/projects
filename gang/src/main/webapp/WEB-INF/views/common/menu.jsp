<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

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
			<c:url value='/' var="homePageAction" />
			<a class="navbar-brand" href="${homePageAction}">MediAider</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href='<c:url value="/aboutUs" />'><span>About
							Us</span></a></li>
			</ul>
			<c:url value='/patients/search' var="searchAction" />
			<form class="navbar-form navbar-left" role="search"
				action="${searchAction}" method="POST">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search Query"
						name="query" value="${query}" />
				</div>
				<button type="submit" class="btn btn-md btn-default">Search</button>
				<c:if test="${patients ne null and patients.size() > 15}">
					<small class="text-danger">Too many results in search.
						Please provide some more info in search query</small>
				</c:if>
			</form>

			<ul class="nav navbar-nav navbar-right">
				
				<security:authorize access="isAuthenticated()">
   				<li><a href="#">Welcome! <security:authentication property="name" /></a></li>
   				<li><a href="javascript:formSubmit()">Logout</a></li> 
				</security:authorize>
				<security:authorize access="! isAuthenticated()">
    			<li><c:url value="/login" var="loginVar" /><a href="${loginVar}">Login</a> </li>
				</security:authorize>
				
			</ul>

		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>


<c:url value="/j_spring_security_logout" var="logoutUrl" />

<!-- csrt for log out-->
<form action="${logoutUrl}" method="post" id="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>

<script>
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}
</script>