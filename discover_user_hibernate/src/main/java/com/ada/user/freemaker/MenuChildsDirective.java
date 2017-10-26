package com.ada.user.freemaker;

import com.ada.common.utils.DirectiveUtils;
import com.ada.user.data.entity.Menu;
import com.ada.user.data.service.MenuService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取某个节点下面所有的菜单
 */
public class MenuChildsDirective implements TemplateDirectiveModel {

    @Autowired
    MenuService menuService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
            throws TemplateException, IOException {

        // 其实完全可以不用它，params是个Map，自己通过key取值就可以了，做一下空值判断
        Integer id = DirectiveUtils.getInt("id", params);
        Integer size = DirectiveUtils.getInt("size", params);

        List<Menu> menus = menuService.childs(id);


        Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(params);
        paramWrap.put("list", ObjectWrapper.BEANS_WRAPPER.wrap(menus));
        Map<String, TemplateModel> origMap = DirectiveUtils.addParamsToVariable(env, paramWrap);
        if (body != null) {
            body.render(env.getOut());
        }
        DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);

    }
}