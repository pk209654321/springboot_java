/**
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: 恒生电子股份有限公司</p>
 */
package com.anaer.generator;

import org.apache.commons.lang3.ArrayUtils;

import cn.org.rapid_framework.generator.GeneratorFacade;

/**
 * GeneratorMain .
 *
 * @author lvcn
 */

public class GeneratorMain {

    /** * 请直接修改以下代码调用不同的方法以执行相关生成任务. *
     * @param args the arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        GeneratorFacade g = new GeneratorFacade();
        g.getGenerator().setTemplateRootDirs("E:\\eclipse_work\\rapid-gen\\src\\main\\resources\\templates\\007");
        g.deleteOutRootDir();

        String[] tableNames = { "test" };

        String[] ignoreTables = {};
        for (String tableName : tableNames) {
            if (ArrayUtils.contains(ignoreTables, tableName)) {
                continue;
            }
            g.generateByTable(tableName);
        }
    }

}
