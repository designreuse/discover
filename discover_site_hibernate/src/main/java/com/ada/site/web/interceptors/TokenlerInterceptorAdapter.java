package com.ada.site.web.interceptors;

import com.ada.site.data.service.AppService;
import com.ada.user.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ada on 2017/7/5.
 */
public class TokenlerInterceptorAdapter extends HandlerInterceptorAdapter {

    @Autowired
    AppService appService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);

        String token = request.getParameter("token");
        if (token != null) {
            Long app = UserUtils.getApp(token);
            if (app != null) {
                appService.visit(app);
            }
        }

    }
}
