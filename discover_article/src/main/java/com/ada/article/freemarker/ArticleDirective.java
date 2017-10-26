package com.ada.article.freemarker;

import com.ada.article.data.entity.Article;
import com.ada.article.data.service.ArticleService;
import com.ada.common.utils.DirectiveUtils;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

public class ArticleDirective implements TemplateDirectiveModel {

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {


        Integer size = DirectiveUtils.getInt("size", params);
        if (size == null) {
            size = 10;
        }
        Integer id = DirectiveUtils.getInt("id", params);

        Pageable pager = new Pageable();
        pager.setPageSize(size);
        pager.getFilters().add(Filter.eq("catalog.id", id));
        pager.getOrders().add(Order.desc("id"));
        Page<Article> page = articleService.page(pager);

        Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(params);
        paramWrap.put("list", DEFAULT_WRAPPER.wrap(page.getContent()));
        Map<String, TemplateModel> origMap = DirectiveUtils
                .addParamsToVariable(env, paramWrap);
        if (body != null) {
            body.render(env.getOut());
        }
        DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);

    }

    @Autowired
    ArticleService articleService;
}