package com.ada.user.rest.resource;

import com.ada.data.core.Finder;
import com.ada.discover.rest.base.ResponseObject;
import com.ada.user.api.SendCodeApi;
import com.ada.user.api.UserHandler;
import com.ada.user.data.dao.*;
import com.ada.user.data.entity.UserAccount;
import com.ada.user.data.entity.UserInfo;
import com.ada.user.data.entity.UserOauthToken;
import com.ada.user.data.entity.UserVerification;
import com.ada.user.domain.request.*;
import com.ada.user.domain.response.UserResponse;
import com.ada.user.enums.AccountType;
import com.ada.user.oauth.api.OauthHander;
import com.ada.user.oauth.domain.OauthResponse;
import com.ada.user.rest.vo.SendCodeVo;
import com.ada.user.utils.CodeCatalog;
import com.ada.user.utils.SecurityUtil;
import com.ada.user.utils.UserUtils;
import com.ada.user.word.AdaptiveRandomWordFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by ada on 2017/6/29.
 */

@Scope("prototype")
@Transactional
@Component
public class UserResource implements UserHandler {


    @Autowired
    UserVerificationDao verificationDao;

    @Autowired
    UserAccountDao accountDao;

    @Autowired
    UserInfoDao userInfoDao;

    @Autowired
    UserOauthConfigDao configDao;


    @Autowired
    SendCodeApi codeApi;

    @Autowired
    UserOauthTokenDao oauthTokenDao;

    public SendCodeVo validate(Date lastDate) {
        SendCodeVo result = new SendCodeVo();
        Long time = checkDate(lastDate);
        if (time < 5 * 60 * 1000) {
            result.setCode(-1);
        }
        return result;
    }

    public SendCodeVo check(Date lastDate) {
        SendCodeVo result = new SendCodeVo();
        Long time = checkDate(lastDate);
        if (time > 5 * 60 * 1000) {
            result.setCode(-1);
        }
        return result;
    }

    private Long checkDate(Date lastDate) {
        if (lastDate == null) {
            Calendar calendar = Calendar.getInstance();
            lastDate = calendar.getTime();
        }
        return new Date().getTime() - lastDate.getTime();
    }

    public SendCodeVo send(String template, String phone) {
        SendCodeVo result = new SendCodeVo();

        AdaptiveRandomWordFactory f = new AdaptiveRandomWordFactory();
        f.setMinLength(4);
        f.setMaxLength(4);
        f.setCharacters("1234567890");
        String vcode = "" + f.getNextWord();
        result.setSendCode(vcode);
        boolean res = codeApi.sendCode(vcode, "建筑资质查询", " 建筑资质查询 ", template, phone);
        if (!res) {
            result.setCode(-1);
        }
        return result;
    }


    @Override
    public ResponseObject sendCode(UserCodeRequest request) {
        ResponseObject result = new ResponseObject();

        Integer catalog = CodeCatalog.catalog(request.getCatalog());
        if (catalog == null) {
            result.setCode(-1);
            result.setMsg("参数异常");
            return result;
        }
        if (request.getCatalog().equals("register") || request.getCatalog().equals("changePhone")) {
            UserAccount userAccount = findAccount(request.getPhone());
            if (userAccount != null) {
                result.setCode(-2);
                result.setMsg("该手机号已经注册过了");
                return result;
            }

        }

        UserVerification verification = verificationDao.findByName(request.getPhone(), catalog);
        if (verification != null) {
            Date lastDate = verification.getLastDate();
            SendCodeVo validateCode = validate(lastDate);
            if (validateCode.getCode() != 0) {
                result.setCode(-3);
                result.setMsg("验证码还没有过期");
                return result;
            }
            SendCodeVo send = send(request.getCatalog(), request.getPhone());
            if (send.getCode() != 0) {
                result.setCode(-1);
                result.setMsg("发送验证码失败");
                return result;
            }
            verification.setName(request.getPhone());
            verification.setCode(send.getSendCode());
            verification.setLastDate(new Date());
            verificationDao.update(verification);
        } else {
            UserVerification v = new UserVerification();
            SendCodeVo send = send(request.getCatalog(), request.getPhone());
            if (send.getCode() != 0) {
                result.setCode(-1);
                result.setMsg("发送验证码失败");
                return result;
            }
            v.setName(request.getPhone());
            v.setCode(send.getSendCode());
            v.setCatalog(catalog);
            verificationDao.save(v);
        }
        return result;
    }

    @Override
    public UserResponse loginByCode(UserLoginCodeRequest request) {
        UserResponse result = new UserResponse();


        if (checkCode(request.getPhone(), request.getCode(), 2, result)) return result;

        UserInfo user = null;

        UserAccount userAccount = findAccount(request.getPhone());
        if (userAccount == null) {
            user = new UserInfo();
            user.setName("");
            user.setLoginSize(0);
            user.setLastDate(new Date());
            user.setAddDate(new Date());
            user.setAvatar("");
            user.setPhone(request.getPhone());
            userInfoDao.save(user);


            userAccount = new UserAccount();
            AdaptiveRandomWordFactory factory = new AdaptiveRandomWordFactory();
            factory.setMinLength(6);
            factory.setMaxLength(6);
            factory.setCharacters("1234567890");
            String password = "" + factory.getNextWord();

            SecurityUtil util = new SecurityUtil();
            userAccount.setSalt(util.getSalt());
            userAccount.setPassword(util.entryptPassword(password));
            userAccount.setUsername(request.getPhone());
            userAccount.setAccountType(AccountType.Phone);
            userAccount.setAddDate(new Date());
            userAccount.setLoginSize(0);
            userAccount.setLastDate(new Date());
            userAccount.setUser(user);
            userAccount = accountDao.save(userAccount);

            /**
             * 发送手机注册时候的密码
             */
            codeApi.sendCode(password, "建筑资质查询", " 建筑资质查询 ", "init", request.getPhone());
        }
        userAccount.setLastDate(new Date());

        user = userAccount.getUser();
        handleUserInfo(result, user);

        return result;
    }

    private UserAccount findAccount(String phone) {
        Finder finder = Finder.create();
        finder.append("from UserAccount u where u.username=:username");
        finder.setParam("username", phone);
        return accountDao.findOne(finder);
    }

    @Override
    public UserResponse registerByCode(UserRegisterCodeRequest request) {
        UserResponse result = new UserResponse();

        if (request.getPhone() == null) {
            result.setCode(-1);
            result.setMsg("手机号不能为空");
            return result;
        }
        if (checkCode(request.getPhone(), request.getCode(), 1, result)) return result;


        UserInfo user = null;
        UserAccount userAccount = findAccount(request.getPhone());
        if (userAccount != null) {
            result.setCode(-5);
            result.setMsg("改手机号已经注册过了");
            return result;
        }
        user = new UserInfo();
        user.setName(name(request.getPhone()));
        user.setLoginSize(0);
        user.setLastDate(new Date());
        user.setAddDate(new Date());
        user.setAvatar("");
        user.setPhone(request.getPhone());
        userInfoDao.save(user);


        userAccount = new UserAccount();
        SecurityUtil util = new SecurityUtil();
        userAccount.setSalt(util.getSalt());
        userAccount.setPassword(util.entryptPassword(request.getPassword()));
        userAccount.setUsername(request.getPhone());
        userAccount.setAccountType(AccountType.Phone);
        userAccount.setAddDate(new Date());
        userAccount.setLoginSize(0);
        userAccount.setLastDate(new Date());
        userAccount.setUser(user);
        userAccount = accountDao.save(userAccount);
        handleUserInfo(result, user);

        return result;
    }

    public String name(String phone) {
        if (phone == null) {
            return "用户";
        }
        if (phone.length() > 10) {
            return phone.substring(0, 3) + "****" + phone.substring(7);
        } else {
            return phone;
        }

    }

    public static void main(String[] args) {
        UserResource resource = new UserResource();
        System.out.println(resource.name("18229060103"));
    }

    private void handleUserInfo(UserResponse result, UserInfo user) {
        if (user == null) {
            return;
        }
        result.setUserToken(UserUtils.getToken(user.getId()));
        result.setName(user.getName());
        result.setAvatar(user.getAvatar());
        result.setPhone(user.getPhone());
    }

    @Override
    public UserResponse login(UserLoginRequest request) {
        UserResponse result = new UserResponse();

        UserAccount userAccount = findAccount(request.getPhone());
        if (userAccount == null) {
            result.setCode(-1);
            result.setMsg("该账号不存在");
            return result;
        }
        SecurityUtil util = new SecurityUtil(userAccount.getSalt());
        if (!util.checkPassword(userAccount.getPassword(), request.getPassword())) {
            result.setCode(-2);
            result.setMsg("密码错误");
            return result;
        }

        handleUserInfo(result, userAccount.getUser());

        return result;
    }

    @Override
    public UserResponse loginOauth(UserLoginOatuthRequest request) {
        UserResponse result = new UserResponse();
        String onpenid = "";

        OauthHander oauthHander = configDao.id(request.getType());
        if (oauthHander == null) {
            result.setCode(-1);
            result.setMsg("该登陆方式无效");
            return result;
        }
        OauthResponse response = oauthHander.login(request.getAccessToken(), request.getOpenId());
        if (response != null) {
            onpenid = response.getOpenid();
        }
        if (onpenid == null || onpenid.length() == 0) {
            result.setCode(-3);
            result.setMsg("链接第三方失败");
            return result;
        }


        Finder finder = Finder.create();
        finder.append("from UserOauthToken u where u.uid=:uid and u.token_type=:token_type");
        finder.setParam("uid", onpenid);
        finder.setParam("token_type", request.getType());

        UserOauthToken token = oauthTokenDao.findOne(finder);
        if (token != null) {
            handleUserInfo(result, token.getUser());
        } else {
            result.setCode(-2);
            result.setMsg("没有注册，请注册！");
        }
        return result;
    }

    @Override
    public UserResponse loginOauthOk(UserLoginOatuthRequest request) {
        UserResponse result = new UserResponse();
        String onpenid = "";

        OauthHander oauthHander = configDao.id(request.getType());
        if (oauthHander == null) {
            result.setCode(-1);
            result.setMsg("该登陆方式无效");
            return result;
        }
        OauthResponse response = oauthHander.login(request.getAccessToken(), request.getOpenId());
        if (response != null) {
            onpenid = response.getOpenid();
        }
        if (onpenid == null || onpenid.length() == 0) {
            result.setCode(-3);
            result.setMsg("链接第三方失败");
            return result;
        }


        Finder finder = Finder.create();
        finder.append("from UserOauthToken u where u.uid=:uid and u.token_type=:token_type");
        finder.setParam("uid", onpenid);
        finder.setParam("token_type", request.getType());

        UserOauthToken token = oauthTokenDao.findOne(finder);
        if (token == null) {
            UserInfo userInfo = new UserInfo();
            userInfoDao.save(userInfo);
            token = new UserOauthToken();
            token.setUser(userInfo);
            token.setLoginSize(0);
            token.setUid(onpenid);
            token.setToken_type(request.getType());
            token.setAccess_token(request.getAccessToken());
            oauthTokenDao.save(token);
        }
        handleUserInfo(result, token.getUser());
        return result;
    }


    @Override
    public UserResponse registerOauth(UserRegisterOatuthRequest request) {


        UserResponse result = new UserResponse();


        if (checkCode(request.getPhone(), request.getCode(), 3, result)) return result;


        UserInfo user = new UserInfo();
        String openid = "";

        OauthHander oauthHander = configDao.id(request.getType());
        if (oauthHander == null) {
            result.setCode(-1);
            result.setMsg("该登陆方式无效");
            return result;
        }
        OauthResponse response = oauthHander.login(request.getAccessToken(), request.getOpenId());

        if (response != null) {
            openid = response.getOpenid();
            user.setName(response.getName());
            user.setAvatar(response.getAvatar());
        }
        if (openid == null || openid.length() == 0) {
            result.setCode(-3);
            result.setMsg("链接第三方失败");
            return result;
        }

        UserAccount userAccount = findAccount(request.getPhone());
        if (userAccount == null) {
            user.setPhone(request.getPhone());
            userInfoDao.save(user);
            userAccount = new UserAccount();
            AdaptiveRandomWordFactory factory = new AdaptiveRandomWordFactory();
            factory.setMinLength(6);
            factory.setMaxLength(6);
            factory.setCharacters("1234567890");
            String password = "" + factory.getNextWord();
            SecurityUtil util = new SecurityUtil();
            userAccount.setSalt(util.getSalt());
            userAccount.setPassword(util.entryptPassword(password));
            userAccount.setUsername(request.getPhone());
            userAccount.setAccountType(AccountType.Phone);
            userAccount.setAddDate(new Date());
            userAccount.setLoginSize(0);
            userAccount.setLastDate(new Date());
            userAccount.setUser(user);
            userAccount = accountDao.save(userAccount);

            /**
             * 发送手机注册时候的密码
             */
            codeApi.sendCode(password, "建筑资质查询", " 建筑资质查询 ", "init", request.getPhone());
        } else {
            UserInfo dbuser = userAccount.getUser();
            if (dbuser.getAvatar() == null || dbuser.getAvatar().length() < 10) {
                dbuser.setAvatar(user.getAvatar());
            }
            if (dbuser.getName() == null || dbuser.getName().length() < 1) {
                dbuser.setName(user.getName());
            }
            user = dbuser;
        }

        Finder finder = Finder.create();
        finder.append("from UserOauthToken u where u.uid=:uid and u.token_type=:token_type");
        finder.setParam("uid", openid);
        finder.setParam("token_type", request.getType());

        UserOauthToken token = oauthTokenDao.findOne(finder);
        if (token == null) {
            UserOauthToken oauthToken = new UserOauthToken();
            oauthToken.setLoginSize(0);
            oauthToken.setUser(user);
            oauthToken.setUid(openid);
            oauthToken.setToken_type(request.getType());
            oauthTokenDao.save(oauthToken);
        } else {
            user = token.getUser();
        }

        handleUserInfo(result, user);
        return result;
    }

    @Override
    public UserResponse resetPassword(UserResetPasswordRequestion request) {

        UserResponse result = new UserResponse();

        if (checkCode(request.getPhone(), request.getCode(), 4, result)) return result;

        UserAccount userAccount = findAccount(request.getPhone());
        if (userAccount == null) {
            result.setMsg("该账号不存在");
            result.setCode(-5);
            return result;
        }
        SecurityUtil util = new SecurityUtil();
        userAccount.setSalt(util.getSalt());
        userAccount.setPassword(util.entryptPassword(request.getPassword()));
        handleUserInfo(result, userAccount.getUser());

        return result;
    }

    @Override
    public ResponseObject changePhone(UserChangePhoneRequestion request) {

        ResponseObject result = new ResponseObject();

        Long member = UserUtils.getMember(request.getUserToken());

        if (member == null) {
            result.setCode(-6);
            result.setMsg("非法操作，token不可用");
            return result;
        }

        if (checkCode(request.getPhone(), request.getCode(), 5, result)) return result;


        UserAccount userAccount = findAccount(request.getPhone());
        if (userAccount != null) {
            result.setMsg("该手机号已被使用");
            result.setCode(-5);
            return result;
        }

        UserInfo user = userInfoDao.findById(member);
        if (user == null) {
            result.setMsg("该用户信息不存在");
            result.setCode(-6);
            return result;
        }
        Finder finder = Finder.create();
        finder.append("from UserAccount u where u.user.id=:uid");
        finder.setParam("uid", member);
        UserAccount tempAccount = accountDao.findOne(finder);
        if (tempAccount == null) {
            result.setMsg("该账号不存在");
            result.setCode(-7);
            return result;
        }
        tempAccount.setUsername(request.getPhone());
        user.setPhone(request.getPhone());

        return result;
    }

    public boolean checkCode(String phone, String code, Integer type, ResponseObject result) {

        if (code == null) {
            result.setCode(-1);
            result.setMsg("验证码不能为空");
            return true;
        }
        if (phone == null) {
            result.setCode(-1);
            result.setMsg("手机号不能为空");
            return true;
        }
        UserVerification verification = verificationDao.findByName(phone, type);
        if (verification == null) {
            result.setCode(-2);
            result.setMsg("该验证码不可用");
            return true;
        }

        Date lastDate = verification.getLastDate();
        SendCodeVo validateCode = check(lastDate);
        if (validateCode.getCode() != 0) {
            result.setCode(-3);
            result.setMsg("验证码已经过期");
            return true;
        }
        if (!code.equals(verification.getCode())) {
            result.setCode(-4);
            result.setMsg("验证码错误");
            return true;
        }
        return false;
    }

    @Override
    public ResponseObject checkPhoneCode(CheckPhoneCodeRequest request) {
        ResponseObject result = new ResponseObject();

        Integer catalog = CodeCatalog.catalog(request.getType());
        if (catalog == null) {
            result.setCode(-1);
            result.setMsg("参数异常");
            return result;
        }
        checkCode(request.getPhone(), request.getCode(), catalog, result);
        return result;
    }

    @Override
    public ResponseObject changePassword(UserChangePasswordRequestion request) {
        ResponseObject result = new ResponseObject();

        Long member = UserUtils.getMember(request.getUserToken());

        if (member == null) {
            result.setCode(-6);
            result.setMsg("非法操作，token不可用");
            return result;
        }
        UserInfo user = userInfoDao.findById(member);
        if (user == null) {
            result.setMsg("该用户信息不存在");
            result.setCode(-6);
            return result;
        }
        Finder finder = Finder.create();
        finder.append("from UserAccount u where u.user.id=:uid");
        finder.setParam("uid", member);
        UserAccount tempAccount = accountDao.findOne(finder);
        if (tempAccount == null) {
            result.setMsg("该账号不存在");
            result.setCode(-7);
            return result;
        }
        SecurityUtil util = new SecurityUtil(tempAccount.getSalt());
        if (!util.checkPassword(tempAccount.getPassword(), request.getOldPassword())) {
            result.setMsg("老密码不正确");
            result.setCode(-8);
            return result;
        }
        tempAccount.setPassword(util.entryptPassword(request.getPassword()));
        return result;
    }

    @Override
    public UserResponse update(UserUpdateRequestion request) {
        UserResponse result = new UserResponse();

        Long member = UserUtils.getMember(request.getUserToken());

        if (member == null) {
            result.setCode(-6);
            result.setMsg("非法操作，token不可用");
            return result;
        }
        UserInfo user = userInfoDao.findById(member);
        if (user == null) {
            result.setMsg("该用户信息不存在");
            result.setCode(-6);
            return result;
        }
        if (request.getName() != null && request.getName().length() > 0) {
            user.setName(request.getName());
        }
        if (request.getAvatar() != null && request.getAvatar().length() > 5) {
            user.setAvatar(request.getAvatar());
        }
        handleUserInfo(result, user);
        return result;
    }
}
