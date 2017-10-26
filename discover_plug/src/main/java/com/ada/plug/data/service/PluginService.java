/*
 * 
 * 
 * 
 */
package com.ada.plug.data.service;


import com.ada.plug.api.PushPlugin;
import com.ada.plug.api.SendCodePlugin;
import com.ada.plug.api.StoragePlugin;

import java.util.List;

/**
 * Service - 插件
 */
public interface PluginService {

    /**
     * 获取支付插件
     *
     * @return 支付插件
     */
    List<PushPlugin> getPushPlugins();

    /**
     * 获取存储插件
     *
     * @return 存储插件
     */
    List<StoragePlugin> getStoragePlugins();


    /**
     * 获取发送短信插件
     *
     * @return
     */
    List<SendCodePlugin> getSendCodePlugins();


    /**
     * 获取支付插件
     *
     * @param isEnabled 是否启用
     * @return 支付插件
     */
    List<PushPlugin> getPushPlugins(boolean isEnabled);

    /**
     * 获取存储插件
     *
     * @param isEnabled 是否启用
     * @return 存储插件
     */
    List<StoragePlugin> getStoragePlugins(boolean isEnabled);


    /**
     * 获取发送短信插件
     *
     * @param isEnabled
     * @return
     */
    List<SendCodePlugin> getSendCodePlugins(boolean isEnabled);


    /**
     * 获取支付插件
     *
     * @param id ID
     * @return 支付插件
     */
    PushPlugin getPushPlugin(String id);

    /**
     * 获取存储插件
     *
     * @param id ID
     * @return 存储插件
     */
    StoragePlugin getStoragePlugin(String id);


    /**
     * 获取发送短信插件
     *
     * @param id
     * @return
     */
    SendCodePlugin getSendCodePlugin(String id);

}