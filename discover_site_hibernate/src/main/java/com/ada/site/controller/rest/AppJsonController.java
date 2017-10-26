package com.ada.site.controller.rest;

import com.ada.discover.rest.base.RequestTokenObject;
import com.ada.discover.rest.base.ResponseTokenObject;
import com.ada.site.api.AppHandler;
import com.ada.site.domain.request.AppRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ada on 2017/7/25.
 */

@RestController
@RequestMapping(value = "json")
public class AppJsonController {



    @RequestMapping(value = "/app/findToken")
    public ResponseTokenObject findToken(@RequestBody AppRequest request) {
        return handler.findToken(request);
    }

    @RequestMapping(value = "/app/refreshToken")
    public ResponseTokenObject refreshToken(@RequestBody RequestTokenObject request) {
        return handler.refreshToken(request);
    }

    @Autowired
    AppHandler handler;

}
