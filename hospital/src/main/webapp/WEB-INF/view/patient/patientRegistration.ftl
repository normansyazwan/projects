<#import "/spring.ftl" as spring>
<@layout.defaultLayout title="Patient Registration Form">
 
<fieldset>
    <legend>Register Patient</legend>
    
    <#if savedPatientId??>
	    <div class="success">
	    	Registration Successful! Patient Id: ${savedPatientId!}
	    </div>
	 <#elseif updateCount??>   
	    <div class="success">
	    	 ${updateCount!} record updated successfully.
	    </div>
    </#if>

  	<form name="patientReg" action="<@spring.url relativeUrl="/patient/add"/>" method="POST">
  	
  		<@spring.bind "patient" />

		<input type="hidden" name="patientId" value="${patient.patientId?default("")}"/>
	  	<table style="width:100%">
	  		<tr>
	  			<td><label for="firstName">Name:</label></td>
	  			<td><input name="firstName" type="text" value="${patient.firstName?default("")}">&nbsp;<input name="lastName" type="text" value="${patient.lastName?default("")}"></td>
	  		</tr>
	  		<tr>
	  			<td><label for="age">Gender:</label></td>
	  			<td>
	  				<input type="radio" name="gender" value="Male" <#if patient.gender! == "Male">checked</#if> />Male
					<br>
					<input type="radio" name="gender" value="Female" <#if patient.gender! == "Female">checked</#if>/>Female
				</td>
	  		</tr>
	  		<tr>
	  			<td><label for="age">Age:</label></td>
	  			<td><input name="age" type="text"  value="${patient.age?default("")}"/></td>
	  		</tr>
	  		<tr>
	  			<td><label for="email">Email:</label></td>
	  			<td><input name="email" type="text"  value="${patient.email?default("")}"/></td>
	  		</tr>
	  		<tr>
	  			<td><label for="mobile">Mobile:</label></td>
	  			<td><input name="mobile" type="text"  value="${patient.mobile?default("")}"/></td>
	  		</tr>
	  		<tr>
	  			<td><label for="phone">Landline:</label></td>
	  			<td><input name="phone" type="text"  value="${patient.phone?default("")}"/></td>
	  		</tr>
			<tr>
	  			<td colspan="2"><hr/></td>
	  		</tr>
	  		<tr>
	  			<td><label for="address.apartment">House No:</label></td>
	  			<td><input name="address.apartment" type="text"  ></td>
	  		</tr>
	  		<tr>
	  			<td><label for="address.street">Street:</label></td>
	  			<td><input name="address.street" type="text"></td>
	  		</tr>
	  		<tr>
	  			<td><label for="address.area">Area:</label></td>
	  			<td><input name="address.area" type="text"></td>
	  		</tr>
	  		<tr>
	  			<td><label for="address.city">City:</label></td>
	  			<td><input name="address.city" type="text"></td>
	  		</tr>
	  		<tr>
	  			<td>&nbsp;</td>
	  			<td><input value="Save" type="submit"></td>
	  		</tr>
	  	</table>	
  	</form>
</fieldset>
	

</@layout.defaultLayout>