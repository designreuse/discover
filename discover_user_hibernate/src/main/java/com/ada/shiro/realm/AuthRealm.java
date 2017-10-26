package com.ada.shiro.realm;

import com.ada.shiro.utils.UserUtil;
import com.ada.user.data.entity.UserOauthToken;
import com.ada.user.data.service.UserInfoService;
import com.ada.user.data.service.UserOauthTokenService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ada on 2017/6/9.
 */
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    UserOauthTokenService oauthTokenService;

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
        UserAuthorization authorization = new UserAuthorization(userService);
        return authorization.doGetAuthorizationInfo(principals);
    }

    public Class getAuthenticationTokenClass() {
        return AuthToken.class;
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
        AuthToken casToken = (AuthToken) token;
        if (token == null) {
            return null;
        } else {
            String ticket = (String) casToken.getCredentials();
            if (!StringUtils.hasText(ticket)) {
                return null;
            } else {
                try {
                    UserOauthToken oauthToken = oauthTokenService.findByUid(ticket);
                    ShiroUser shiroUser = new ShiroUser(oauthToken.getUser().getId(), oauthToken.getUid(), oauthToken.getUser().getName());
                    // 设置用户session
                    Session session = UserUtil.getSession();
                    session.setAttribute("user", oauthToken.getUser());
                    PrincipalCollection principalCollection = new SimplePrincipalCollection(shiroUser, this.getName());
                    SimpleAuthenticationInfo aa = new SimpleAuthenticationInfo(principalCollection, ticket);
                    return aa;
                } catch (Exception e) {
                    return null;
                }
            }
        }
    }
}
