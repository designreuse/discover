package com.ada.user;

import com.ada.imake.ChainMake;
import com.ada.imake.template.hibernate.TemplateHibernateDir;
import com.ada.imake.templates.simple.TemplateSimpleDir;
import com.ada.user.data.entity.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ChainMake make = new ChainMake(TemplateSimpleDir.class, TemplateHibernateDir.class);
        make.setAction("com.ada.user.controller.admin");
        File view = new File("E:\\workspace\\iowl\\iowl_web\\src\\main\\webapp\\WEB-INF\\ftl\\admin");
        make.setView(view);

        List<Class<?>> cs = new ArrayList<Class<?>>();
        cs.add(UserRoleCatalog.class);

        make.setDao(true);
        make.setService(true);
        make.setView(false);
        make.setAction(true);
        make.setMenus("1,25,66");
        make.makes(cs);
        System.out.println("ok");
    }
}
