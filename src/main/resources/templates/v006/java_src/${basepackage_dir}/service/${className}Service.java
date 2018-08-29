<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameFirstLower = table.classNameFirstLower>  
package ${basepackage}.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sscf.education.common.entity.PageResult;

import ${basepackage}.dto.${className}Dto;
import ${basepackage}.dao.${className}Dao;
import ${basepackage}.entity.${className};
import ${basepackage}.service.${className}Service;

import java.util.List;

<#include "/java_imports.include">
@Component
public class ${className}Service {
      
    /** The ${classNameFirstLower} dao . */    
    @Autowired
    private ${className}Dao ${classNameFirstLower}Dao;

    /**
     * 新增 ${className} .
     *
     * @param entity 对象
     */ 
    public void add${className}(${className} entity) {
        ${classNameFirstLower}Dao.add${className}(entity);
    }
    
    <#if batchSupport == "true" >
    /**
     * 批量新增 ${className} .
     *
     * @param entity 对象
     */ 
    public void addBatch${className}(List<${className}> list) {
        if(list != null && !list.isEmpty()) {
            ${classNameFirstLower}Dao.addBatch${className}(list);
        }
    }
    </#if>

    /**
     * 删除 ${className} .
     *
     * @param id id
     */ 
    <#if longId == "true">
    public void del${className}(Long id) {
    <#else>
    public void del${className}(Integer id) {
    </#if>
        ${classNameFirstLower}Dao.del${className}(id);
    }

    /**
     * 更新 ${className} .
     *
     * @param entity 对象
     */ 
    public void mod${className}(${className} entity) {
        ${classNameFirstLower}Dao.mod${className}(entity);
    }
    
    <#if batchSupport == "true" >
    /**
     * 批量更新 ${className} .
     *
     * @param entity 对象
     */ 
    public void modBatch${className}(List<${className}> list) {
        if(list != null && !list.isEmpty()) {
            ${classNameFirstLower}Dao.modBatch${className}(list);
        }
    }
    </#if>

    /**
     * 查询单个 ${className} .
     *
     * @param dto 查询对象
     * @return 响应结果
     */ 
    public ${className} get${className}(${className}Dto dto) {
        return ${classNameFirstLower}Dao.get${className}(dto);
    }

    /**
     * 查询列表 ${className} .
     *
     * @param dto 查询对象
     * @return 响应结果
     */ 
    public List<${className}> qry${className}(${className}Dto dto) {
        return ${classNameFirstLower}Dao.qry${className}(dto);
    }

    /**
     * 分页查询 ${className} .
     *
     * @param dto 查询对象
     * @return 响应结果
     */ 
    public PageResult<${className}> qryPage${className}(${className}Dto dto) {
        if (dto == null) {
            dto = new ${className}Dto();
        }
        int total = ${classNameFirstLower}Dao.get${className}Count(dto);
        PageResult<${className}> page = new PageResult<>(dto, total);
        if (page.isHasRows()) {
            List<${className}> list = ${classNameFirstLower}Dao.qry${className}(dto);
            page.setRows(list);
        }
        return page;
    }
    
    <#if genApi == "true" >
    /**
     * 分页查询 ${className} .
     *
     * @param dto 查询对象
     * @return 响应结果
     */ 
    public List<${className}> qryApi${className}(${className}Dto dto) {
        if (dto == null) {
            dto = new ${className}Dto();
        }
        return ${classNameFirstLower}Dao.qryApi${className}(dto);
    }
    </#if>
}