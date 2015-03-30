<#import "/spring.ftl" as spring>
<@layout.defaultLayout title="Patient Profile: ${patient.firstName}">

<table>
	<td><label>Name:</label></td>
		<td>${patient.firstName} ${patient.lastName}</td>
	</tr>
	<tr>
		<td><label>Gender:</label></td>
		<td>${patient.gender}</td>
	</tr>
	<tr>
		<td><label>Age:</label></td>
		<td>${patient.age}</td>
	</tr>
	<tr>
		<td><label>Mobile:</label></td>
		<td>${patient.mobile}</td>
	</tr>
	<tr>
		<td><label>Landline:</label></td>
		<td>${patient.phone}</td>
	</tr>
	<tr>
		<td><label>email:</label></td>
		<td>
			<#if patient.email??>
				<a href="mailto:${patient.email}">${patient.email}</a>
			</#if>
		</td>
	</tr>
	<tr>
		<td><label>Address:</label></td>
		<td> Not implimented</td>
	</tr>
</table>	
<table>	
	<tr>
		<td colspan="2">
			<a class="Button" href="#">
			    <span>Book Appointment</span>
			</a>
			<a class="Button" href="#">
			    <span>Billing</span>
			</a>
			<a class="Button" href="#">
			    <span>History</span>
			</a>
			<a class="Button" href='<@spring.url relativeUrl="/patient/edit/${patient.patientId}"/>'>
			    <span>Edit Profile</span>
			</a>
		</td>
	</tr>
</table>



</@layout.defaultLayout>
