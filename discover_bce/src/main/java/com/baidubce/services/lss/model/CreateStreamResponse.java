package com.baidubce.services.lss.model;

import com.baidubce.model.AbstractBceResponse;

import java.util.List;
import java.util.Map;

/**
 * Created by wuyafei on 16/10/14.
 */
public class CreateStreamResponse extends AbstractBceResponse {

    private String sessionId = null;

    private String playDomain = null;

    private String app = null;

    private String description = null;

    private String preset = null;

    private Map<String, String> presets = null;

    private String createTime = null;

    private String status = null;

    private String notification = null;

    private String securityPolicy = null;

    private String recording = null;

    private String thumbnail = null;

    private List<String> thumbnails = null;

    private String scene = null;

    private Watermarks watermarks = null;

    private LivePublish publish = null;

    private LivePlay play = null;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getPlayDomain() {
        return playDomain;
    }

    public void setPlayDomain(String playDomain) {
        this.playDomain = playDomain;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getScene() {
        return scene;
    }

    public void setScene() {
        this.scene = scene;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreset() {
        return preset;
    }

    public void setPreset(String preset) {
        this.preset = preset;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public String getSecurityPolicy() {
        return securityPolicy;
    }

    public void setSecurityPolicy(String securityPolicy) {
        this.securityPolicy = securityPolicy;
    }

    public String getRecording() {
        return recording;
    }

    public void setRecording(String recording) {
        this.recording = recording;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<String> getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(List<String> thumbnails) {
        this.thumbnails = thumbnails;
    }

    public Watermarks getWatermarks() {
        return watermarks;
    }

    public void setWatermarks(Watermarks watermarks) {
        this.watermarks = watermarks;
    }

    public LivePublish getPublish() {
        return publish;
    }

    public void setPublish(LivePublish publish) {
        this.publish = publish;
    }

    public LivePlay getPlay() {
        return play;
    }

    public void setPlay(LivePlay play) {
        this.play = play;
    }

    public Map<String, String> getPresets() {
        return presets;
    }

    public void setPresets(Map<String, String> presets) {
        this.presets = presets;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("class CreateSessionResponse {\n");
        sb.append("    sessionId: ").append(sessionId).append("\n");
        sb.append("    playDomain: ").append(playDomain).append("\n");
        sb.append("    app: ").append(app).append("\n");
        sb.append("    description: ").append(description).append("\n");
        sb.append("    preset: ").append(preset).append("\n");
        sb.append("    presets: ").append(presets).append("\n");
        sb.append("    createTime: ").append(createTime).append("\n");
        sb.append("    status: ").append(status).append("\n");
        sb.append("    notification: ").append(notification).append("\n");
        sb.append("    securityPolicy: ").append(securityPolicy).append("\n");
        sb.append("    recording: ").append(recording).append("\n");
        sb.append("    thumbnail: ").append(thumbnail).append("\n");
        sb.append("    thumbnails: ").append(thumbnails).append("\n");
        sb.append("    watermarks: ").append(watermarks).append("\n");
        sb.append("    scene: ").append(scene).append("\n");
        sb.append("    publish: ").append(publish).append("\n");
        sb.append("    play: ").append(play).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
