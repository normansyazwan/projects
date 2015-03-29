<#import "/spring.ftl" as spring>
<@layout.defaultLayout title="Patients ">
 
<div class="CSSTableGenerator" > 
<table>
  <tr>
  	<td width="30">Sr.No.</td>
    <td width="50">PatientId</td>
    <td>Name</td>
	<td width="50">Gender</td>
    <td width="25">Age</td>
	<td width="100">Phone</td>
	<td>Email</td>
  </tr>
<#list patients as patient>
  <tr <#if patient_index / 2 ==0 > class="evenRow"<#else>class="oddRow"</#if>>
  	<td>${patient_index + 1}</td>
  	<td>${patient.patientId}</td>
    <td>${patient.firstName!}&nbsp;${patient.lastName!}</td>
	<td>${patient.gender!}</td>
	<td>${patient.age!}</td>
	<td>
		${patient.mobile!}<br/>
		${patient.phone!}
	</td>
	<td>${patient.email!}</td>
  </tr>
</#list>
</table>
</div>	
	
	
</@layout.defaultLayout>