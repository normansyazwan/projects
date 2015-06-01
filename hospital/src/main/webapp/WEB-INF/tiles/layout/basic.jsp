<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<link rel="stylesheet" href='<c:url value="/resources/css/style.css" />'>

<link rel="stylesheet"
	href='<c:url value="/resources/css/styles.css" />'>

</head>
<body>

	<div class="BackgroundGradient"></div>

	<div class="BodyContent">
		<div class="BorderBorder">
			<div class="BorderBL">
				<div></div>
			</div>
			<div class="BorderBR">
				<div></div>
			</div>
			<div class="BorderTL"></div>
			<div class="BorderTR">
				<div></div>
			</div>
			<div class="BorderT"></div>
			<div class="BorderR">
				<div></div>
			</div>
			<div class="BorderB">
				<div></div>
			</div>
			<div class="BorderL"></div>
			<div class="BorderC"></div>
			<div class="Border">

				<div class="Header">
					<tiles:insertAttribute name="header" />
				</div>
				<div class="Menu">
					<tiles:insertAttribute name="menu" />
				</div>
				<div class="Columns">
					<div class="Column1">
						<tiles:insertAttribute name="navigation" />
					</div>
					<div class="MainColumn">


						<div class="ArticleBorder">
							<div class="ArticleBL">
								<div></div>
							</div>
							<div class="ArticleBR">
								<div></div>
							</div>
							<div class="ArticleTL"></div>
							<div class="ArticleTR">
								<div></div>
							</div>
							<div class="ArticleT"></div>
							<div class="ArticleR">
								<div></div>
							</div>
							<div class="ArticleB">
								<div></div>
							</div>
							<div class="ArticleL"></div>
							<div class="ArticleC"></div>
							<div class="Article">

								<tiles:insertAttribute name="body" />
							</div>
						</div>

					</div>
				</div>
				<div class="Footer">
					<tiles:insertAttribute name="footer" />
				</div>

			</div>
		</div>
	</div>

</body>
</html>