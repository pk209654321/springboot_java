<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.dto;

import java.util.Date;
import com.sscf.education.common.entity.PageInfo;

<#include "/java_imports.include">
public class ${className}Dto extends PageInfo{
    <#list table.columns as column>
    /**
     * The ${column.underscoreName?replace("_", " ")} .
     * 
     * @Fields ${column.underscoreName} ${column.columnAlias}
    */
    private ${column.simpleJavaType} ${column.underscoreName};
    </#list>

    <@generateJavaColumns/>

}