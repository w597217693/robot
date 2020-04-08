package com.bigcat.app.pojo;

public class Settings {
    private String id;

    private String title;

    private String description;

    private Integer status;

    private String gameid;

    private Integer execute;

    private Integer executeDefer;

    private String templateImage;

    private String templateText;

    private Integer templateStyle;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getGameid() {
        return gameid;
    }

    public void setGameid(String gameid) {
        this.gameid = gameid == null ? null : gameid.trim();
    }

    public Integer getExecute() {
        return execute;
    }

    public void setExecute(Integer execute) {
        this.execute = execute;
    }

    public Integer getExecuteDefer() {
        return executeDefer;
    }

    public void setExecuteDefer(Integer executeDefer) {
        this.executeDefer = executeDefer;
    }

    public String getTemplateImage() {
        return templateImage;
    }

    public void setTemplateImage(String templateImage) {
        this.templateImage = templateImage == null ? null : templateImage.trim();
    }

    public String getTemplateText() {
        return templateText;
    }

    public void setTemplateText(String templateText) {
        this.templateText = templateText == null ? null : templateText.trim();
    }

    public Integer getTemplateStyle() {
        return templateStyle;
    }

    public void setTemplateStyle(Integer templateStyle) {
        this.templateStyle = templateStyle;
    }
}