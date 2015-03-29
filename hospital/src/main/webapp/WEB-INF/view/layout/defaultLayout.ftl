<#import "/spring.ftl" as spring>
<#macro defaultLayout title="Hospital">
<!DOCTYPE html>
<html>
<head>
	<title>
        ${title}
     </title>
    <title>Web Site Name</title>
	<link rel="stylesheet" type="text/css" href='<@spring.url relativeUrl="/resources/css/styles.css"/>'>
    <link rel="stylesheet" type="text/css" href='<@spring.url relativeUrl="/resources/css/style.css"/>'>
    <link rel="stylesheet" type="text/css" href='<@spring.url relativeUrl="/resources/css/table-style.css"/>'>
    <link rel="stylesheet" type="text/css" href='<@spring.url relativeUrl="/resources/css/validation-style.css"/>'>
</head>
<body>
    <div class="BackgroundGradient"> </div>
    <div class="BodyContent">

    <div class="BorderBorder"><div class="BorderBL"><div></div></div><div class="BorderBR"><div></div></div><div class="BorderTL"></div><div class="BorderTR"><div></div></div><div class="BorderT"></div><div class="BorderR"><div></div></div><div class="BorderB"><div></div></div><div class="BorderL"></div><div class="BorderC"></div><div class="Border">

        <div class="Header">
          <#include "header.ftl"/>
        </div>
        <div class="Menu">
            <ul><li><a href="#" class="ActiveMenuButton"><span>Home</span></a></li> <li><a href="#" class="MenuButton"><span>Categories</span></a></li> <li><a href="#" class="MenuButton"><span>Archive</span></a></li> <li><a href="#" class="MenuButton"><span>About</span></a></li></ul>
        </div><div class="Columns"><div class="Column1">
        <div class="BlockBorder"><div class="BlockBL"><div></div></div><div class="BlockBR"><div></div></div><div class="BlockTL"></div><div class="BlockTR"><div></div></div><div class="BlockT"></div><div class="BlockR"><div></div></div><div class="BlockB"><div></div></div><div class="BlockL"></div><div class="BlockC"></div><div class="Block">

            <span class="BlockHeader"><span>Search This Site</span></span>
            <div class="BlockContentBorder">

                <input type="text" style="width:120px" />
                <span class="ButtonInput"><span><input type="button" value="Search" /></span></span>

            </div>

        </div></div>


        <div class="BlockBorder"><div class="BlockBL"><div></div></div><div class="BlockBR"><div></div></div><div class="BlockTL"></div><div class="BlockTR"><div></div></div><div class="BlockT"></div><div class="BlockR"><div></div></div><div class="BlockB"><div></div></div><div class="BlockL"></div><div class="BlockC"></div><div class="Block">

            <span class="BlockHeader"><span>Links</span></span>
            <div class="BlockContentBorder">
                <#include "menu.ftl"/>
            </div>

        </div></div>

        </div><div class="MainColumn">
        <div class="ArticleBorder"><div class="ArticleBL"><div></div></div><div class="ArticleBR"><div></div></div><div class="ArticleTL"></div><div class="ArticleTR"><div></div></div><div class="ArticleT"></div><div class="ArticleR"><div></div></div><div class="ArticleB"><div></div></div><div class="ArticleL"></div><div class="ArticleC"></div><div class="Article">

		<#nested/>     

        </div></div>
		</div></div>
        <div class="Footer">
          <#include "footer.ftl"/>
        </div>                

    </div></div>
    </div>
</body>
</html>
</#macro>