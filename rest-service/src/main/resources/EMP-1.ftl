<#if isFirst ??>
<?xml version="1.0" encoding="UTF-8"?>
<referenceData>
</#if>
<employee>
	<#if (emp_name)??><name>{emp_name}</name></#if>
	<#if (emp_age) ??><age>${emp_age}</age></#if>
	<#if (emp_salary) ??><salary>${emp_salary}</salary></#if>
</employee>	
<#if isLast ??>	
</referenceData>
</#if>