package com.ada.site.controller.rest;

import com.ada.discover.rest.base.RequestTokenObject;
import com.ada.discover.rest.base.ResponseTokenObject;
import com.ada.site.api.AppHandler;
import com.ada.site.domain.request.AppRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ada on 2017/7/25.
 */

@RestController
@RequestMapping(value = "rest")
public class AppRestController {


    @RequestMapping(value = "/app/findToken")
    public ResponseTokenObject findToken(AppRequest request) {
        return handler.findToken(request);
    }

    @RequestMapping(value = "/app/refreshToken")
    public ResponseTokenObject refreshToken(RequestTokenObject request) {
        return handler.refreshToken(request);
    }

    @Autowired
    AppHandler handler;

}
