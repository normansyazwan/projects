public class ${className}{
	
	<#list fields as field>
	private ${field.fieldType} ${field.fieldName};
	</#list>
	
	public ${className}(){
	}
	
	<#list fields as field>
    public ${field.fieldType} get${field.fieldName?cap_first}(){
    	return this.${field.fieldName};
    }
    
    public void set${field.fieldName?cap_first}(${field.fieldType} ${field.fieldName}){
    	this.${field.fieldName} = ${field.fieldName};
    }
    
	</#list>
}