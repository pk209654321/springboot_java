<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sscf.education.common.entity.PageResult;
import com.sscf.education.common.entity.Result;
import com.sscf.education.common.util.ResultUtil;

import ${basepackage}.dto.${className}Dto;
import ${basepackage}.entity.${className};
import ${basepackage}.service.${className}Service;

<#include "/java_imports.include">
@RestController
@RequestMapping(value = "/admin-api")
public class ${className}Controller extends BaseController {

    /** The ${camelToSpace(className)} service . */
    @Autowired
    private ${className}Service ${classNameLower}Service;

    /**
     * 查询 ${className} .
     *
     * @param dto 查询对象
     * @return 响应结果
     */ 
    @RequestMapping(value = "/qry${className}")
    @ResponseBody
    public Result qry${className}(@RequestBody(required = false) ${className}Dto dto) {
        PageResult<${className}> page = ${classNameLower}Service.qryPage${className}(dto);
        return ResultUtil.success(page);
    }
    
    /**
     * 新增 ${className} .
     *
     * @param ${classNameLower} 新增对象
     * @return 响应结果
     */ 
    @RequestMapping(value = "/add${className}")
    public Result add${className}(@RequestBody @Valid ${className} ${classNameLower}) {
        <#if addLastUser == "true" >
        ${classNameLower}.setLast_user(getLoginUserName());
        </#if>
        ${classNameLower}Service.add${className}(${classNameLower});
        return ResultUtil.success();
    }
    
    <#if batchSupport == "true" >
    /**
     * 批量新增 ${className} .
     *
     * @param ${classNameLower} 新增对象
     * @return 响应结果
     */ 
    @RequestMapping(value = "/addBatch${className}")
    public Result add${className}(@RequestBody List<${className}> list) {
        ${classNameLower}Service.addBatch${className}(list);
        return ResultUtil.success();
    }
    </#if>
    
    /**
     * 修改 ${className} .
     *
     * @param ${classNameLower} 修改对象
     * @return 响应结果
     */ 
    @RequestMapping(value = "/mod${className}")
    public Result mod${className}(@RequestBody @Valid ${className} ${classNameLower}) {
        <#if addLastUser == "true" >
        ${classNameLower}.setLast_user(getLoginUserName());
        </#if>
        ${classNameLower}Service.mod${className}(${classNameLower});
        return ResultUtil.success();
    }
    
    <#if batchSupport == "true" >
    /**
     * 批量修改 ${className} .
     *
     * @param list 修改列表
     * @return 响应结果
     */ 
    @RequestMapping(value = "/modBatch${className}")
    public Result mod${className}(@RequestBody List<${className}> list) {
        ${classNameLower}Service.modBatch${className}(list);
        return ResultUtil.success();
    }
    </#if>
    
    /**
     * 删除 ${className} .
     *
     * @param id id
     * @return 响应结果
     */ 
    @RequestMapping(value = "/del${className}")
    public Result del${className}(@RequestBody ${className} ${classNameLower}) {
        <#if longId == "true">
        Long id = ${classNameLower}.getId();
        <#else>
        Integer id = ${classNameLower}.getId();
        </#if>
        if(id != null) {
          ${classNameLower}Service.del${className}(id);
        }
        return ResultUtil.success();
    }

}
