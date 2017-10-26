package com.ada.common.freemarker;

import com.ada.common.utils.DirectiveUtils;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

/**
 * 一个集合标签基类
 * <p>
 * Created by cng19 on 2017/6/26.
 */
public abstract class ListDirective<T> implements TemplateDirectiveModel {
    @Override
    public void execute(Environment env, Map params, TemplateModel[] templateModels, TemplateDirectiveBody body) throws TemplateException, IOException {

        map = params;

        Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(params);
        paramWrap.put("list", DEFAULT_WRAPPER.wrap(list()));
        Map<String, TemplateModel> origMap = DirectiveUtils
                .addParamsToVariable(env, paramWrap);
        if (body != null) {
            body.render(env.getOut());
        }
        DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);
    }

    public abstract List<T> list();

    private Map map;

    private Map getParams() {
        return map;
    }

    /**
     * 从标签里面获取一个int值
     *
     * @param name 参数
     * @return
     */
    public Integer getInt(String name) {
        Integer size = null;
        try {
            size = DirectiveUtils.getInt(name, map);

        } catch (Exception e) {

        }
        return size;
    }

    /**
     * 从标签里面获取一个int值
     *
     * @param name 参数
     * @param num  默认值
     * @return
     */
    public Integer getInt(String name, Integer num) {
        Integer size = null;
        try {
            size = DirectiveUtils.getInt(name, map);
            if (size == null) {
                size = num;
            }
        } catch (Exception e) {

        }
        return size;
    }

    public Long getLong(String name, Long num) {
        Long size = null;
        try {
            size = DirectiveUtils.getLong(name, map);
            if (size == null) {
                size = num;
            }
        } catch (Exception e) {

        }
        return size;
    }

    public String getString(String name, String defaul) {
        String result = null;
        try {
            result = DirectiveUtils.getString(name, map);
        } catch (Exception e) {

        }
        if (defaul == null) {
            defaul = "";
        }
        if (result == null) {
            result = defaul;
        }
        return result;
    }
}
