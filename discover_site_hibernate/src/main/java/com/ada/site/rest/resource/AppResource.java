package com.ada.site.rest.resource;

import com.ada.data.core.Finder;
import com.ada.data.page.Filter;
import com.ada.discover.rest.base.RequestTokenObject;
import com.ada.discover.rest.base.ResponseTokenObject;
import com.ada.site.api.AppHandler;
import com.ada.site.data.dao.AppDao;
import com.ada.site.data.entity.App;
import com.ada.site.domain.request.AppRequest;
import com.ada.user.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AppResource implements AppHandler {

    @Autowired
    AppDao appDao;


    @Override
    public ResponseTokenObject findToken(AppRequest request) {
        ResponseTokenObject result = new ResponseTokenObject();
        long num = appDao.count(Filter.eq("appKey", request.getAppKey()));
        if (num < 1) {
            result.setCode(-1);
            result.setMsg("该程序不存在");
            return result;
        }
        Finder finder = Finder.create();
        finder.append("from App a where a.appKey =:appKey and a.appSecret=:appSecret ");
        finder.setParam("appKey", request.getAppKey());
        finder.setParam("appSecret", request.getAppSecret());

        App app = appDao.findOne(finder);
        if (app ==null) {
            result.setCode(-2);
            result.setMsg("密钥不正确");
            return result;
        }
        result.setToken(UserUtils.getAppToken(app.getId()));
        return result;
    }

    @Override
    public ResponseTokenObject refreshToken(RequestTokenObject request) {
        ResponseTokenObject result = new ResponseTokenObject();
        try {
            result.setToken(UserUtils.refreshAppToken(request.getToken()));
        }
        catch (Exception e){
            result.setCode(-1);
            result.setMsg("token无效");
        }
        return result;
    }
}
