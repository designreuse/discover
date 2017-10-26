package com.ada.article.data.app;

import com.ada.article.data.entity.*;
import com.ada.imake.ChainMake;
import com.ada.imake.template.hibernate.TemplateHibernateDir;
import com.ada.imake.templates.adminlte.TemplateAdminLTE;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MakeApps {
    public static void main(String[] args) {
        ChainMake make = new ChainMake(TemplateAdminLTE.class, TemplateHibernateDir.class);
        make.setAction("com.ada.article.controller.admin");

        File view = new File("E:\\mvnspace\\usite\\web\\src\\main\\webapp\\WEB-INF\\ftl\\admin");
        make.setView(view);

        List<Class<?>> cs = new ArrayList<Class<?>>();
        cs.add(Article.class);
        cs.add(ArticleCatalog.class);
        cs.add(ArticleComment.class);
        cs.add(ArticleTag.class);
        cs.add(SensitiveWord.class);
        cs.add(SensitiveCategory.class);


        make.setDao(true);
        make.setService(true);
        make.setView(false);
        make.setAction(true);
        make.makes(cs);
        System.out.println("ok");
    }
}
