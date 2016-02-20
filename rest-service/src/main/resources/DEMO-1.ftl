<#if isFirst ??>
<?xml version="1.0" encoding="UTF-8"?>
<referenceData>
</#if>
<demo>
	<#if (demo_id)??><id>${demo_id}</id></#if>
	<#if (demo_version) ??><version>${demo_version}</version></#if>
	<#if (demo_isin) ??><isin>${demo_isin}</isin></#if>
</demo>	
<#if isLast ??>	
</referenceData>
</#if>