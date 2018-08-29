<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.entity;

import java.util.Date;
<#if useJsonView == "true" >
import com.fasterxml.jackson.annotation.JsonView;
</#if>

<#include "/java_imports.include">
public class ${className} {
    <#if useJsonView == "true" >
    public interface Api{}

    public interface Normal extends Api{}
    </#if>
    
    <#list table.columns as column>
    /**
     * The ${column.underscoreName?replace("_", " ")} .
     * 
     * @Fields ${column.underscoreName} ${column.columnAlias}
    */
    <#if useJsonView == "true" >
    @JsonView(Api.class)
    </#if>
    private ${column.simpleJavaType} ${column.underscoreName};
    </#list>

    <@generateJavaColumns/>

}