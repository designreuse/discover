package com.ada.plug.data.plugs;

import com.ada.plug.api.StoragePlugin;
import com.ada.plug.data.vo.FileInfo;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component("noneFilePlug")
public class NoneFilePlug extends StoragePlugin {
    @Override
    public String getName() {
        return "文件上传例子插件";
    }

    @Override
    public String getVersion() {
        return "1.01";
    }

    @Override
    public String getAuthor() {
        return "ada.young";
    }

    public boolean getIsInstalled() {
        return false;
    }


    @Override
    public String getSiteUrl() {
        return null;
    }

    @Override
    public String getInstallUrl() {
        return null;
    }

    @Override
    public String getUninstallUrl() {
        return null;
    }

    @Override
    public String getSettingUrl() {
        return null;
    }

    @Override
    public void upload(String path, File file, String contentType) {

    }

    @Override
    public String getUrl(String path) {
        return null;
    }

    @Override
    public List<FileInfo> browser(String path) {
        return null;
    }
}
