<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<link rel="stylesheet" href="/resources/css/styles.css">
</head>
<body>

	<div class="container">
		<div class="header layout">
			<tiles:insertAttribute name="header" />
		</div>
		<div class="navigation layout">
			<tiles:insertAttribute name="navigation" />
		</div>
		<div class="main layout">
			<tiles:insertAttribute name="body" />
		</div>
		<div class="footer layout">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>

</body>
</html>