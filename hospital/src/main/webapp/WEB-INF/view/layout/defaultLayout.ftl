<#import "/spring.ftl" as spring>
<#macro defaultLayout title="Hospital">
  <html>
    <head>
      <title>
        ${title}
      </title>
      <link rel="stylesheet" type="text/css" href='<@spring.url relativeUrl="/resources/css/styles.css"/>'>
    </head>
    <body>
      <table class="container" border="1" cellspacing="0" cellpadding="0" >
        <tr>
          <td colspan="2" style="width:100%; height:80px;">
            <#include "header.ftl"/>
          </td>
        </tr>
        <tr>
          <td width="15%" class="sideMenuColumn">
            <#include "menu.ftl"/>
          </td>
          <td width="85%">
            <#nested/>
          </td>
        </tr>
        <tr>
          <td colspan="2">
            <#include "footer.ftl"/>
          </td>
        </tr>
      </table>
    </body>
  </html>
</#macro>