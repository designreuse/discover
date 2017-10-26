package com.ada.ad;

import com.ada.ad.data.entity.Ad;
import com.ada.ad.data.entity.AdPosition;
import com.ada.imake.ChainMake;
import com.ada.imake.template.hibernate.TemplateHibernateDir;
import com.ada.imake.templates.adminlte.TemplateAdminLTE;

import java.io.File;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        File file = new File("E:\\mvnspace\\xjob\\web\\src\\main\\webapp\\WEB-INF\\ftl\\admin");
        ChainMake make = new ChainMake(TemplateAdminLTE.class, TemplateHibernateDir.class);
        make.setAction("com.ada.ad.controller.admin");
        make.setView(file);
        make.setDao(true);
        make.setService(true);
        make.setAction(false);
        make.setView(false);
        make.setMenus("1,16,28");
        // UserOauthToken.
        make.makes(AdPosition.class);

    }
}
