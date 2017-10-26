package com.ada.site.api;

import com.ada.discover.rest.base.RequestTokenObject;
import com.ada.discover.rest.base.ResponseTokenObject;
import com.ada.site.domain.request.AppRequest;

/**
 * Created by ada on 2017/5/16.
 */
public interface AppHandler {

    /**
     * 获取令牌
     * @param request
     * @return
     */
    ResponseTokenObject findToken(AppRequest request);


    /**
     * 刷新令牌
     *
     * @param request
     * @return
     */
    ResponseTokenObject refreshToken(RequestTokenObject request);

}
