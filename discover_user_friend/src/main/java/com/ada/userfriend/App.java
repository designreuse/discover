package com.ada.userfriend;

import com.ada.imake.ChainMake;
import com.ada.imake.template.hibernate.TemplateHibernateDir;
import com.ada.imake.templates.adminlte.TemplateAdminLTE;
import com.ada.userfriend.data.entity.UserFollow;
import com.ada.userfriend.data.entity.UserFriend;
import com.ada.userfriend.data.entity.UserFriendRequest;

import java.io.File;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        File file = new File("E:\\mvnspace\\xjob\\web\\src\\main\\webapp\\WEB-INF\\ftl\\admin");
        ChainMake make = new ChainMake(TemplateAdminLTE.class, TemplateHibernateDir.class);
        make.setAction("com.ada.userfriend.controller.admin");
        make.setView(file);
        make.setDao(true);
        make.setService(true);
        make.setAction(false);
        make.setView(false);
        make.setMenus("1,16,28");
        // UserOauthToken.
        make.makes(UserFollow.class);
        make.makes(UserFriend.class);
        make.makes(UserFriendRequest.class);

    }
}
