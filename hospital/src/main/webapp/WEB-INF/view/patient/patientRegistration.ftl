<#import "/spring.ftl" as spring>
<@layout.defaultLayout title="Patient Registration Form">
 
<fieldset>
    <legend>Register Patient</legend>
  	<form name="patientReg" action="/patient" method="POST">
	  	<table>
	  		<tr>
	  			<td><label for="firstName">Name:</label></td>
	  			<td><input name="firstName" type="text">&nbsp;<input name="lastName" type="text"></td>
	  		</tr>
	  		<tr>
	  			<td><label for="age">Age:</label></td>
	  			<td><input name="age" type="text"/></td>
	  		</tr>
	  		<tr>
	  			<td>&nbsp;</td>
	  			<td><input value="Save" type="submit"></td>
	  		</tr>
	  	</table>
  	</form>
</fieldset>
	

</@layout.defaultLayout>