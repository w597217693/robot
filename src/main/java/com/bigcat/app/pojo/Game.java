package com.bigcat.app.pojo;

public class Game {
    private String id;

    private String name;

    private Integer runtimeStatus;

    private Integer gameStart;

    private Integer type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getRuntimeStatus() {
        return runtimeStatus;
    }

    public void setRuntimeStatus(Integer runtimeStatus) {
        this.runtimeStatus = runtimeStatus;
    }

    public Integer getGameStart() {
        return gameStart;
    }

    public void setGameStart(Integer gameStart) {
        this.gameStart = gameStart;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}