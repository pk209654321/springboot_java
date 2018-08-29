/**
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: 恒生电子股份有限公司</p>
 */
package com.anaer.generator.templateMethod;

import java.util.List;

import freemarker.template.SimpleScalar;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

/**
 * 驼峰转空格. <br/>
 * camelToSpace => camel to space.
 * 
 * @author lvcn
 */
public class CamelToSpace implements TemplateMethodModelEx {

    @SuppressWarnings("rawtypes")
    public Object exec(List args) throws TemplateModelException {
        if (args.size() != 1) {
            throw new TemplateModelException("Wrong arguments");
        }
        String param = ((SimpleScalar) args.get(0)).getAsString();
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(' ');
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return new SimpleScalar(sb.toString().trim());
    }

}
