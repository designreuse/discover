package com.ada.activity;

import com.ada.activity.data.entity.Activity;
import com.ada.activity.data.entity.ActivityCatalog;
import com.ada.imake.ChainMake;
import com.ada.imake.template.hibernate.TemplateHibernateDir;
import com.ada.imake.templates.adminlte.TemplateAdminLTE;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ChainMake make = new ChainMake(TemplateAdminLTE.class, TemplateHibernateDir.class);
        make.setAction("com.ada.activity.controller.admin");

        File view = new File("E:\\mvnspace\\usite\\web\\src\\main\\webapp\\WEB-INF\\ftl\\admin");
        make.setView(view);

        List<Class<?>> cs = new ArrayList<Class<?>>();
        cs.add(Activity.class);
        cs.add(ActivityCatalog.class);


        make.setDao(true);
        make.setService(true);
        make.setView(false);
        make.setAction(true);
        make.makes(cs);
        System.out.println("ok");
    }
}
