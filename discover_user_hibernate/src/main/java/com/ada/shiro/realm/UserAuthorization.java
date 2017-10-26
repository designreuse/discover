package com.ada.shiro.realm;

import com.ada.shiro.utils.UserUtil;
import com.ada.user.data.entity.UserInfo;
import com.ada.user.data.entity.UserRole;
import com.ada.user.data.service.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class UserAuthorization {

    Logger logger = LoggerFactory.getLogger("ada");


    private UserInfoService userInfoService;

    public UserAuthorization(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
        UserInfo user = userInfoService.findById(shiroUser.getId());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        if (user != null) {
            logger.info("doGetAuthorizationInfo:" + shiroUser.getName());
            // 把principals放session中
            UserUtil.getSession().setAttribute(String.valueOf(user.getId()), SecurityUtils.getSubject().getPrincipals());
            UserUtil.setCurrentUser(user);

            Set<String> authorities = new HashSet<String>();
            /**
             * 赋予角色
             */
            for (UserRole userRole : user.getRoles()) {
                info.addRole(userRole.getName());
                logger.info("role:" + userRole.getName());
            }
            if (user != null) {
                authorities.addAll(userInfoService.findAuthorities(user.getId()));
            }
            // //设置登录次数、时间
            info.addStringPermissions(authorities);
            userInfoService.updateUserLogin(user);
        }

        return info;
    }
}