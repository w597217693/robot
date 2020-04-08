package com.bigcat.app.pojo;

public class Way {
    private String id;

    private String instruct;

    private String odds;

    private String name;

    private String parseName;

    private String odds22;

    private String odds23;

    private Long betsMin;

    private Long betsMax;

    private Long sigleMax;

    private String gameId;

    private Integer sort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getInstruct() {
        return instruct;
    }

    public void setInstruct(String instruct) {
        this.instruct = instruct == null ? null : instruct.trim();
    }

    public String getOdds() {
        return odds;
    }

    public void setOdds(String odds) {
        this.odds = odds == null ? null : odds.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getParseName() {
        return parseName;
    }

    public void setParseName(String parseName) {
        this.parseName = parseName == null ? null : parseName.trim();
    }

    public String getOdds22() {
        return odds22;
    }

    public void setOdds22(String odds22) {
        this.odds22 = odds22 == null ? null : odds22.trim();
    }

    public String getOdds23() {
        return odds23;
    }

    public void setOdds23(String odds23) {
        this.odds23 = odds23 == null ? null : odds23.trim();
    }

    public Long getBetsMin() {
        return betsMin;
    }

    public void setBetsMin(Long betsMin) {
        this.betsMin = betsMin;
    }

    public Long getBetsMax() {
        return betsMax;
    }

    public void setBetsMax(Long betsMax) {
        this.betsMax = betsMax;
    }

    public Long getSigleMax() {
        return sigleMax;
    }

    public void setSigleMax(Long sigleMax) {
        this.sigleMax = sigleMax;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId == null ? null : gameId.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}