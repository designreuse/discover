package com.ada.web.data.common;

import com.ada.web.data.entity.WebConfig;
import com.ada.web.data.service.WebConfigService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author: XiaoBingBy
 * Email: XiaoBingBy@qq.com
 * Date: 2017/3/5
 * Time: 15:40
 * Describe: 网站配置初始化
 */
public class InitConfig {

    @Autowired
    private WebConfigService webConfigMapper;

    private static WebConfig webConfig;

    public void initWebConfig() {
        webConfig = webConfigMapper.findById(1l);
        if (webConfig==null){
            webConfig=new WebConfig();
            webConfig.setTheme("default");
            webConfigMapper.save(webConfig);
        }
    }

    public static WebConfig getWebConfig() {
        if (webConfig==null){
            webConfig=new WebConfig();
            webConfig.setTheme("default");
        }
        return webConfig;
    }

    public static void setWebConfig(WebConfig webConfig) {
        InitConfig.webConfig = webConfig;
    }
}
