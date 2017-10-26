package com.ada.freemarker;

import com.ada.common.utils.DirectiveUtils;
import com.ada.data.utils.RMB;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by ada on 2017/5/10.
 */
public class RMBDirective implements TemplateDirectiveModel {
    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        String money = DirectiveUtils.getString("money", params);
        if (money!=null){
            try {
                BigDecimal bigDecimal=new BigDecimal(money);
                String  str= RMB.toBigAmt(bigDecimal.doubleValue());
                Writer out = env.getOut();
                out.write(str);
                body.render(out);
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
