<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
<#assign entityPackage>${basepackage}.entity</#assign>
<#assign dtoPackage>${basepackage}.dto</#assign>
package ${basepackage}.dao;

import java.util.List;
import ${entityPackage}.${className};
import ${dtoPackage}.${className}Dto;

<#include "/java_imports.include">
public interface ${className}Dao {
    
    /** 
     * 添加${className} .
     * @param req 请求对象
     * @return 
     */
    public int add${className}(${className} req);
    
    <#if batchSupport == "true" >
    /** 
     * 批量添加${className} .
     * @param list 请求列表
     * @return 
     */
    public int addBatch${className}(List<${className}> list);
    </#if>
    
    /** 
     * 获取${className} .
     * @param req 请求对象
     * @return 
     */
    public ${className} get${className}(${className}Dto dto);

    /** 
     * 查询${className} .
     * @param req 请求对象
     * @return 
     */
    public List<${className}> qry${className}(${className}Dto dto);
	
    <#if genApi == "true" >
    /** 
     * 查询${className} .
     * @param req 请求对象
     * @return 
     */
    public List<${className}> qryApi${className}(${className}Dto dto);
    </#if>
    
    /** 
     * 查询${className}条数 .
     * @param req 请求对象
     * @return 
     */
    public int get${className}Count(${className}Dto dto);
	
    /** 
     * 修改${className} .
     * @param req 请求对象
     * @return 
     */
    public int mod${className}(${className} entity);
    
    <#if batchSupport == "true" >
    /** 
     * 批量修改${className} .
     * @param list 请求列表
     * @return 
     */
    public int modBatch${className}(List<${className}> list);
    </#if>
    
    
    /** 
     * 删除${className} .
     * @param req 请求对象
     * @return 
     */
    <#if longId == "true">
    public int del${className}(Long id);
    <#else>
    public int del${className}(Integer id);
    </#if>
    
}
