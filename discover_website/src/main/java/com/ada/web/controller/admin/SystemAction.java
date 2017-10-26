package com.ada.web.controller.admin;

import com.ada.discover.rest.base.ResponseObject;
import com.ada.web.data.common.InitConfig;
import com.ada.web.data.entity.WebConfig;
import com.ada.web.data.entity.WebTheme;
import com.ada.web.data.service.WebConfigService;
import com.ada.web.data.service.WebThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;

/**
 * Author: XiaoBingBy
 * Email: XiaoBingBy@qq.com
 * Date: 2017/2/21
 * Time: 22:53
 * Describe:
 */
@Controller
@RequestMapping(value = "/admin")
public class SystemAction {

    @Autowired
    private WebConfigService webconfigDao;

    @Autowired
    WebThemeService themeService;


    /**
     * 主题视图
     *
     * @return
     */
    @RequestMapping(value = "/theme")
    public String themes(HttpServletRequest request, ModelMap modelMap) {

        ArrayList<WebTheme> themes = null;


        //扫描文件夹 Start
        String basePath = request.getSession().getServletContext().getRealPath("/");
        basePath = basePath + "\\WEB-INF\\ftl\\theme";    //主题路径

        File[] listFiles = new File(basePath).listFiles();

        if (listFiles != null) { //如果不存在文件夹不执行
            themes = new ArrayList<WebTheme>();
            for (int i = 0; i < listFiles.length; i++) {    //循环取出所有文件夹
                if (listFiles[i].isDirectory()) {    //判断是不是文件夹	//设置Model值
                    WebTheme tempThemes = themeService.key(listFiles[i].getName());
                    themes.add(tempThemes);
                }
            }

        }
        //扫描文件夹 End
        modelMap.put("webConfig", InitConfig.getWebConfig());
        modelMap.put("themes", themes);
        return "admin/system/theme";
    }

    /**
     * 更新主题
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updatetheme")
    public ResponseObject updateTheme(String theme) {
        ResponseObject result = new ResponseObject();

        WebConfig webConfig = InitConfig.getWebConfig();
        webConfig.setTheme(theme);
        webconfigDao.update(webConfig);
        InitConfig.setWebConfig(webconfigDao.findById(1l));

        return result;
    }


    /**
     * 数据监控 视图
     *
     * @return
     */
    @RequestMapping(value = "/druid")
    public String druid() {

        return "admin/system/druid";
    }


    /**
     * 性能监控 视图
     *
     * @return
     */
    @RequestMapping(value = "/monitoring")
    public String monitoring() {

        return "admin/system/monitoring";
    }

    /**
     * 多说 视图
     *
     * @return
     */
    @RequestMapping(value = "/duoshuo")
    public String duoshuo() {

        return "admin/system/duoshuo";
    }

    /**
     * 系统设置 视图
     *
     * @return
     */
    @RequestMapping(value = "/config")
    public String config(ModelMap modelMap) {

        WebConfig webConfig = webconfigDao.findById(1l);
        modelMap.put("webConfig", webConfig);
        return "admin/system/config";
    }

    /**
     * 更新网站配置
     *
     * @param webConfig
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updatewebconfig")
    public Integer updateWebConfig(WebConfig webConfig) {
        webconfigDao.update(webConfig);
        return 0;
    }

}
