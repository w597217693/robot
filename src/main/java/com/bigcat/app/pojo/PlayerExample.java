package com.bigcat.app.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlayerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlayerExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andAliQrcodeIsNull() {
            addCriterion("ali_qrcode is null");
            return (Criteria) this;
        }

        public Criteria andAliQrcodeIsNotNull() {
            addCriterion("ali_qrcode is not null");
            return (Criteria) this;
        }

        public Criteria andAliQrcodeEqualTo(String value) {
            addCriterion("ali_qrcode =", value, "aliQrcode");
            return (Criteria) this;
        }

        public Criteria andAliQrcodeNotEqualTo(String value) {
            addCriterion("ali_qrcode <>", value, "aliQrcode");
            return (Criteria) this;
        }

        public Criteria andAliQrcodeGreaterThan(String value) {
            addCriterion("ali_qrcode >", value, "aliQrcode");
            return (Criteria) this;
        }

        public Criteria andAliQrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("ali_qrcode >=", value, "aliQrcode");
            return (Criteria) this;
        }

        public Criteria andAliQrcodeLessThan(String value) {
            addCriterion("ali_qrcode <", value, "aliQrcode");
            return (Criteria) this;
        }

        public Criteria andAliQrcodeLessThanOrEqualTo(String value) {
            addCriterion("ali_qrcode <=", value, "aliQrcode");
            return (Criteria) this;
        }

        public Criteria andAliQrcodeLike(String value) {
            addCriterion("ali_qrcode like", value, "aliQrcode");
            return (Criteria) this;
        }

        public Criteria andAliQrcodeNotLike(String value) {
            addCriterion("ali_qrcode not like", value, "aliQrcode");
            return (Criteria) this;
        }

        public Criteria andAliQrcodeIn(List<String> values) {
            addCriterion("ali_qrcode in", values, "aliQrcode");
            return (Criteria) this;
        }

        public Criteria andAliQrcodeNotIn(List<String> values) {
            addCriterion("ali_qrcode not in", values, "aliQrcode");
            return (Criteria) this;
        }

        public Criteria andAliQrcodeBetween(String value1, String value2) {
            addCriterion("ali_qrcode between", value1, value2, "aliQrcode");
            return (Criteria) this;
        }

        public Criteria andAliQrcodeNotBetween(String value1, String value2) {
            addCriterion("ali_qrcode not between", value1, value2, "aliQrcode");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeIsNull() {
            addCriterion("wx_qrcode is null");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeIsNotNull() {
            addCriterion("wx_qrcode is not null");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeEqualTo(String value) {
            addCriterion("wx_qrcode =", value, "wxQrcode");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeNotEqualTo(String value) {
            addCriterion("wx_qrcode <>", value, "wxQrcode");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeGreaterThan(String value) {
            addCriterion("wx_qrcode >", value, "wxQrcode");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("wx_qrcode >=", value, "wxQrcode");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeLessThan(String value) {
            addCriterion("wx_qrcode <", value, "wxQrcode");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeLessThanOrEqualTo(String value) {
            addCriterion("wx_qrcode <=", value, "wxQrcode");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeLike(String value) {
            addCriterion("wx_qrcode like", value, "wxQrcode");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeNotLike(String value) {
            addCriterion("wx_qrcode not like", value, "wxQrcode");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeIn(List<String> values) {
            addCriterion("wx_qrcode in", values, "wxQrcode");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeNotIn(List<String> values) {
            addCriterion("wx_qrcode not in", values, "wxQrcode");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeBetween(String value1, String value2) {
            addCriterion("wx_qrcode between", value1, value2, "wxQrcode");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeNotBetween(String value1, String value2) {
            addCriterion("wx_qrcode not between", value1, value2, "wxQrcode");
            return (Criteria) this;
        }

        public Criteria andHolderCardIsNull() {
            addCriterion("holder_card is null");
            return (Criteria) this;
        }

        public Criteria andHolderCardIsNotNull() {
            addCriterion("holder_card is not null");
            return (Criteria) this;
        }

        public Criteria andHolderCardEqualTo(String value) {
            addCriterion("holder_card =", value, "holderCard");
            return (Criteria) this;
        }

        public Criteria andHolderCardNotEqualTo(String value) {
            addCriterion("holder_card <>", value, "holderCard");
            return (Criteria) this;
        }

        public Criteria andHolderCardGreaterThan(String value) {
            addCriterion("holder_card >", value, "holderCard");
            return (Criteria) this;
        }

        public Criteria andHolderCardGreaterThanOrEqualTo(String value) {
            addCriterion("holder_card >=", value, "holderCard");
            return (Criteria) this;
        }

        public Criteria andHolderCardLessThan(String value) {
            addCriterion("holder_card <", value, "holderCard");
            return (Criteria) this;
        }

        public Criteria andHolderCardLessThanOrEqualTo(String value) {
            addCriterion("holder_card <=", value, "holderCard");
            return (Criteria) this;
        }

        public Criteria andHolderCardLike(String value) {
            addCriterion("holder_card like", value, "holderCard");
            return (Criteria) this;
        }

        public Criteria andHolderCardNotLike(String value) {
            addCriterion("holder_card not like", value, "holderCard");
            return (Criteria) this;
        }

        public Criteria andHolderCardIn(List<String> values) {
            addCriterion("holder_card in", values, "holderCard");
            return (Criteria) this;
        }

        public Criteria andHolderCardNotIn(List<String> values) {
            addCriterion("holder_card not in", values, "holderCard");
            return (Criteria) this;
        }

        public Criteria andHolderCardBetween(String value1, String value2) {
            addCriterion("holder_card between", value1, value2, "holderCard");
            return (Criteria) this;
        }

        public Criteria andHolderCardNotBetween(String value1, String value2) {
            addCriterion("holder_card not between", value1, value2, "holderCard");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("bank_name is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("bank_name =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("bank_name <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("bank_name >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_name >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("bank_name <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("bank_name <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("bank_name like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("bank_name not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("bank_name in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("bank_name not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("bank_name between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("bank_name not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andCardNumIsNull() {
            addCriterion("card_num is null");
            return (Criteria) this;
        }

        public Criteria andCardNumIsNotNull() {
            addCriterion("card_num is not null");
            return (Criteria) this;
        }

        public Criteria andCardNumEqualTo(String value) {
            addCriterion("card_num =", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumNotEqualTo(String value) {
            addCriterion("card_num <>", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumGreaterThan(String value) {
            addCriterion("card_num >", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumGreaterThanOrEqualTo(String value) {
            addCriterion("card_num >=", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumLessThan(String value) {
            addCriterion("card_num <", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumLessThanOrEqualTo(String value) {
            addCriterion("card_num <=", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumLike(String value) {
            addCriterion("card_num like", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumNotLike(String value) {
            addCriterion("card_num not like", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumIn(List<String> values) {
            addCriterion("card_num in", values, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumNotIn(List<String> values) {
            addCriterion("card_num not in", values, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumBetween(String value1, String value2) {
            addCriterion("card_num between", value1, value2, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumNotBetween(String value1, String value2) {
            addCriterion("card_num not between", value1, value2, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andBindPlayerIdIsNull() {
            addCriterion("bind_player_id is null");
            return (Criteria) this;
        }

        public Criteria andBindPlayerIdIsNotNull() {
            addCriterion("bind_player_id is not null");
            return (Criteria) this;
        }

        public Criteria andBindPlayerIdEqualTo(String value) {
            addCriterion("bind_player_id =", value, "bindPlayerId");
            return (Criteria) this;
        }

        public Criteria andBindPlayerIdNotEqualTo(String value) {
            addCriterion("bind_player_id <>", value, "bindPlayerId");
            return (Criteria) this;
        }

        public Criteria andBindPlayerIdGreaterThan(String value) {
            addCriterion("bind_player_id >", value, "bindPlayerId");
            return (Criteria) this;
        }

        public Criteria andBindPlayerIdGreaterThanOrEqualTo(String value) {
            addCriterion("bind_player_id >=", value, "bindPlayerId");
            return (Criteria) this;
        }

        public Criteria andBindPlayerIdLessThan(String value) {
            addCriterion("bind_player_id <", value, "bindPlayerId");
            return (Criteria) this;
        }

        public Criteria andBindPlayerIdLessThanOrEqualTo(String value) {
            addCriterion("bind_player_id <=", value, "bindPlayerId");
            return (Criteria) this;
        }

        public Criteria andBindPlayerIdLike(String value) {
            addCriterion("bind_player_id like", value, "bindPlayerId");
            return (Criteria) this;
        }

        public Criteria andBindPlayerIdNotLike(String value) {
            addCriterion("bind_player_id not like", value, "bindPlayerId");
            return (Criteria) this;
        }

        public Criteria andBindPlayerIdIn(List<String> values) {
            addCriterion("bind_player_id in", values, "bindPlayerId");
            return (Criteria) this;
        }

        public Criteria andBindPlayerIdNotIn(List<String> values) {
            addCriterion("bind_player_id not in", values, "bindPlayerId");
            return (Criteria) this;
        }

        public Criteria andBindPlayerIdBetween(String value1, String value2) {
            addCriterion("bind_player_id between", value1, value2, "bindPlayerId");
            return (Criteria) this;
        }

        public Criteria andBindPlayerIdNotBetween(String value1, String value2) {
            addCriterion("bind_player_id not between", value1, value2, "bindPlayerId");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(BigDecimal value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(BigDecimal value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(BigDecimal value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(BigDecimal value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<BigDecimal> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<BigDecimal> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(Integer value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(Integer value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(Integer value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(Integer value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(Integer value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<Integer> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<Integer> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(Integer value1, Integer value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andRegistSourceIsNull() {
            addCriterion("regist_source is null");
            return (Criteria) this;
        }

        public Criteria andRegistSourceIsNotNull() {
            addCriterion("regist_source is not null");
            return (Criteria) this;
        }

        public Criteria andRegistSourceEqualTo(String value) {
            addCriterion("regist_source =", value, "registSource");
            return (Criteria) this;
        }

        public Criteria andRegistSourceNotEqualTo(String value) {
            addCriterion("regist_source <>", value, "registSource");
            return (Criteria) this;
        }

        public Criteria andRegistSourceGreaterThan(String value) {
            addCriterion("regist_source >", value, "registSource");
            return (Criteria) this;
        }

        public Criteria andRegistSourceGreaterThanOrEqualTo(String value) {
            addCriterion("regist_source >=", value, "registSource");
            return (Criteria) this;
        }

        public Criteria andRegistSourceLessThan(String value) {
            addCriterion("regist_source <", value, "registSource");
            return (Criteria) this;
        }

        public Criteria andRegistSourceLessThanOrEqualTo(String value) {
            addCriterion("regist_source <=", value, "registSource");
            return (Criteria) this;
        }

        public Criteria andRegistSourceLike(String value) {
            addCriterion("regist_source like", value, "registSource");
            return (Criteria) this;
        }

        public Criteria andRegistSourceNotLike(String value) {
            addCriterion("regist_source not like", value, "registSource");
            return (Criteria) this;
        }

        public Criteria andRegistSourceIn(List<String> values) {
            addCriterion("regist_source in", values, "registSource");
            return (Criteria) this;
        }

        public Criteria andRegistSourceNotIn(List<String> values) {
            addCriterion("regist_source not in", values, "registSource");
            return (Criteria) this;
        }

        public Criteria andRegistSourceBetween(String value1, String value2) {
            addCriterion("regist_source between", value1, value2, "registSource");
            return (Criteria) this;
        }

        public Criteria andRegistSourceNotBetween(String value1, String value2) {
            addCriterion("regist_source not between", value1, value2, "registSource");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}