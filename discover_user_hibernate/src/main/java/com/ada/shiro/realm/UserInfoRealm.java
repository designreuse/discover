package com.ada.shiro.realm;

import com.ada.shiro.utils.UserUtil;
import com.ada.user.data.entity.UserInfo;
import com.ada.user.data.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ada on 2017/6/12.
 */
public class UserInfoRealm extends AuthorizingRealm {



    Logger logger = LoggerFactory.getLogger("ada");

    @Autowired
    UserInfoService userService;

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UserAuthorization authorization=new UserAuthorization(userService);
        return authorization.doGetAuthorizationInfo(principals);
    }

    public Class getAuthenticationTokenClass() {
        return UserInfoToken.class;
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UserInfoToken casToken = (UserInfoToken) token;
        if (token == null) {
            return null;
        } else {
            Long userid = (Long) casToken.getCredentials();
            if (userid==null||userid<0l) {
                return null;
            } else {
                try {
                    UserInfo oauthToken = userService.findById(userid);
                    ShiroUser shiroUser = new ShiroUser(oauthToken.getId(), oauthToken.getId()+"", oauthToken.getName());
                    // 设置用户session
                    Session session = UserUtil.getSession();
                    session.setAttribute("user", oauthToken);
                    PrincipalCollection principalCollection = new SimplePrincipalCollection(shiroUser, this.getName());
                    SimpleAuthenticationInfo aa = new SimpleAuthenticationInfo(principalCollection, userid);
                    return aa;
                } catch (Exception e) {
                    return null;
                }
            }
        }
    }


}
