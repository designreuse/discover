/*
 * Copyright 2014 Baidu, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.baidubce.services.vod.model;

import com.baidubce.auth.BceCredentials;
import com.baidubce.model.AbstractBceRequest;

public class GenerateMediaPlayerCodeRequest extends AbstractBceRequest {

    /*
     * Unique Id of media resource
     */
    private String mediaId;

    /*
     * The width of player view
     */
    private int width;

    /*
     * The height of player view
     */
    private int height;

    /*
     * Indicate whether to start automatically
     */
    private Boolean autoStart;

    /*
     * Indicate ak
     */
    private String ak;

    private String transcodingPresetName;

    public Boolean getAutoStart() {
        return autoStart;
    }

    public String getTranscodingPresetName() {
        return transcodingPresetName;
    }

    public void setTranscodingPresetName(String transcodingPresetName) {
        this.transcodingPresetName = transcodingPresetName;
    }

    public GenerateMediaPlayerCodeRequest withTranscodingPresetName(String transcodingPresetName) {
        this.transcodingPresetName = transcodingPresetName;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GetPlayerCodeRequest { \n");
        sb.append("  mediaId = ").append(mediaId).append("\n");
        sb.append("  width = ").append(width).append("\n");
        sb.append("  height = ").append(height).append("\n");
        sb.append("  autoStart = ").append(autoStart).append("\n");
        sb.append("  ak = ").append(ak).append("\n");
        sb.append("  transcodingPresetName = ").append(transcodingPresetName).append("\n");
        sb.append("}\n");
        return sb.toString();
    }

    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public GenerateMediaPlayerCodeRequest withAk(String ak) {
        this.ak = ak;
        return this;
    }

    /**
     * Gets the media ID value for the media resource.
     *
     * @return The ETag value for the new object.
     */
    public String getMediaId() {
        return mediaId;
    }

    /**
     * Sets the ETag value for the new object that was created from the associated <code>putObject</code> request.
     *
     * @param mediaId The ETag value for the new object.
     */
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public GenerateMediaPlayerCodeRequest withMediaId(String mediaId) {
        this.mediaId = mediaId;
        return this;
    }

    /**
     * Gets the ETag value for the newly created object.
     *
     * @return The ETag value for the new object.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the ETag value for the new object that was created from the associated <code>putObject</code> request.
     *
     * @param width The ETag value for the new object.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    public GenerateMediaPlayerCodeRequest withWidth(int width) {
        this.width = width;
        return this;
    }

    /**
     * Gets the ETag value for the newly created object.
     *
     * @return The ETag value for the new object.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the ETag value for the new object that was created from the associated <code>putObject</code> request.
     *
     * @param height The ETag value for the new object.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    public GenerateMediaPlayerCodeRequest withHeight(int height) {
        this.height = height;
        return this;
    }

    /**
     * Gets the ETag value for the newly created object.
     *
     * @return The ETag value for the new object.
     */
    public Boolean isAutoStart() {
        return autoStart;
    }

    /**
     * Sets the ETag value for the new object that was created from the associated <code>putObject</code> request.
     *
     * @param autoStart The ETag value for the new object.
     */
    public void setAutoStart(Boolean autoStart) {
        this.autoStart = autoStart;
    }

    public GenerateMediaPlayerCodeRequest withAutoStart(boolean autoStart) {
        this.autoStart = autoStart;
        return this;
    }

    @Override
    public AbstractBceRequest withRequestCredentials(BceCredentials credentials) {
        this.setRequestCredentials(credentials);
        return this;
    }

}
