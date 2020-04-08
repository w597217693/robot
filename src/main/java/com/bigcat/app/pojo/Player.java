package com.bigcat.app.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Player {
    private String id;

    private String nickname;

    private String aliQrcode;

    private String wxQrcode;

    private String holderCard;

    private String bankName;

    private String cardNum;

    private Date createTime;

    private Integer type;

    private Integer status;

    private String bindPlayerId;

    private BigDecimal balance;

    private Integer source;

    private String account;

    private String registSource;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getAliQrcode() {
        return aliQrcode;
    }

    public void setAliQrcode(String aliQrcode) {
        this.aliQrcode = aliQrcode == null ? null : aliQrcode.trim();
    }

    public String getWxQrcode() {
        return wxQrcode;
    }

    public void setWxQrcode(String wxQrcode) {
        this.wxQrcode = wxQrcode == null ? null : wxQrcode.trim();
    }

    public String getHolderCard() {
        return holderCard;
    }

    public void setHolderCard(String holderCard) {
        this.holderCard = holderCard == null ? null : holderCard.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum == null ? null : cardNum.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBindPlayerId() {
        return bindPlayerId;
    }

    public void setBindPlayerId(String bindPlayerId) {
        this.bindPlayerId = bindPlayerId == null ? null : bindPlayerId.trim();
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getRegistSource() {
        return registSource;
    }

    public void setRegistSource(String registSource) {
        this.registSource = registSource == null ? null : registSource.trim();
    }
}