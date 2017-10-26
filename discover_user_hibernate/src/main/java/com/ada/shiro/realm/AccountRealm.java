package com.ada.shiro.realm;

import com.ada.shiro.utils.UserUtil;
import com.ada.user.data.entity.UserAccount;
import com.ada.user.data.service.UserAccountService;
import com.ada.user.data.service.UserInfoService;
import com.ada.user.enums.AccountType;
import com.ada.user.utils.Encodes;
import com.ada.user.utils.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户登录授权service(shrioRealm)
 *
 * @author ty
 * @date 2015年1月14日
 */
@Service
public class AccountRealm extends AuthorizingRealm {

    Logger logger = LoggerFactory.getLogger("ada");
    @Autowired
    private UserAccountService accountService;
    @Autowired
    private UserInfoService userService;

    private UserAccount userAccount;

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 认证回调函数,登录时调用.
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        UserAccount account = accountService.findByUserName(token.getUsername(), AccountType.Account);
        if (account==null){
            account = accountService.findByUserName(token.getUsername(), AccountType.Phone);
        }
        if (account==null){
            account = accountService.findByUserName(token.getUsername(), AccountType.Email);
        }
        userAccount=account;
        logger.info("account:" + token.getUsername());
        if (account != null) {
            byte[] salt = Encodes.decodeHex(account.getSalt());
            ShiroUser shiroUser = new ShiroUser(account.getUser().getId(), account.getUsername(), account.getUser().getName());
            // 设置用户session
            Session session = UserUtil.getSession();
            session.setAttribute("user", account.getUser());
            try {
                SimpleAuthenticationInfo aa = new SimpleAuthenticationInfo(shiroUser, account.getPassword(),
                        ByteSource.Util.bytes(salt), getName());
                return aa;
            } catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UserAuthorization authorization=new UserAuthorization(userService);
        if (userAccount!=null){
            accountService.updateUserLogin(userAccount);
        }
        return authorization.doGetAuthorizationInfo(principals);
    }

    /**
     * 设定Password校验的Hash算法与迭代次数.
     */
    @SuppressWarnings("static-access")
    @PostConstruct
    public void initCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(SecurityUtil.HASH_ALGORITHM);
        matcher.setHashIterations(SecurityUtil.HASH_INTERATIONS);
        setCredentialsMatcher(matcher);
    }

}
