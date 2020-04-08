package com.bigcat.app.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BetsOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BetsOrderExample() {
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

        public Criteria andBetsMoneyIsNull() {
            addCriterion("bets_money is null");
            return (Criteria) this;
        }

        public Criteria andBetsMoneyIsNotNull() {
            addCriterion("bets_money is not null");
            return (Criteria) this;
        }

        public Criteria andBetsMoneyEqualTo(BigDecimal value) {
            addCriterion("bets_money =", value, "betsMoney");
            return (Criteria) this;
        }

        public Criteria andBetsMoneyNotEqualTo(BigDecimal value) {
            addCriterion("bets_money <>", value, "betsMoney");
            return (Criteria) this;
        }

        public Criteria andBetsMoneyGreaterThan(BigDecimal value) {
            addCriterion("bets_money >", value, "betsMoney");
            return (Criteria) this;
        }

        public Criteria andBetsMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bets_money >=", value, "betsMoney");
            return (Criteria) this;
        }

        public Criteria andBetsMoneyLessThan(BigDecimal value) {
            addCriterion("bets_money <", value, "betsMoney");
            return (Criteria) this;
        }

        public Criteria andBetsMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bets_money <=", value, "betsMoney");
            return (Criteria) this;
        }

        public Criteria andBetsMoneyIn(List<BigDecimal> values) {
            addCriterion("bets_money in", values, "betsMoney");
            return (Criteria) this;
        }

        public Criteria andBetsMoneyNotIn(List<BigDecimal> values) {
            addCriterion("bets_money not in", values, "betsMoney");
            return (Criteria) this;
        }

        public Criteria andBetsMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bets_money between", value1, value2, "betsMoney");
            return (Criteria) this;
        }

        public Criteria andBetsMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bets_money not between", value1, value2, "betsMoney");
            return (Criteria) this;
        }

        public Criteria andTargetWayIsNull() {
            addCriterion("target_way is null");
            return (Criteria) this;
        }

        public Criteria andTargetWayIsNotNull() {
            addCriterion("target_way is not null");
            return (Criteria) this;
        }

        public Criteria andTargetWayEqualTo(String value) {
            addCriterion("target_way =", value, "targetWay");
            return (Criteria) this;
        }

        public Criteria andTargetWayNotEqualTo(String value) {
            addCriterion("target_way <>", value, "targetWay");
            return (Criteria) this;
        }

        public Criteria andTargetWayGreaterThan(String value) {
            addCriterion("target_way >", value, "targetWay");
            return (Criteria) this;
        }

        public Criteria andTargetWayGreaterThanOrEqualTo(String value) {
            addCriterion("target_way >=", value, "targetWay");
            return (Criteria) this;
        }

        public Criteria andTargetWayLessThan(String value) {
            addCriterion("target_way <", value, "targetWay");
            return (Criteria) this;
        }

        public Criteria andTargetWayLessThanOrEqualTo(String value) {
            addCriterion("target_way <=", value, "targetWay");
            return (Criteria) this;
        }

        public Criteria andTargetWayLike(String value) {
            addCriterion("target_way like", value, "targetWay");
            return (Criteria) this;
        }

        public Criteria andTargetWayNotLike(String value) {
            addCriterion("target_way not like", value, "targetWay");
            return (Criteria) this;
        }

        public Criteria andTargetWayIn(List<String> values) {
            addCriterion("target_way in", values, "targetWay");
            return (Criteria) this;
        }

        public Criteria andTargetWayNotIn(List<String> values) {
            addCriterion("target_way not in", values, "targetWay");
            return (Criteria) this;
        }

        public Criteria andTargetWayBetween(String value1, String value2) {
            addCriterion("target_way between", value1, value2, "targetWay");
            return (Criteria) this;
        }

        public Criteria andTargetWayNotBetween(String value1, String value2) {
            addCriterion("target_way not between", value1, value2, "targetWay");
            return (Criteria) this;
        }

        public Criteria andPlayerIdIsNull() {
            addCriterion("player_id is null");
            return (Criteria) this;
        }

        public Criteria andPlayerIdIsNotNull() {
            addCriterion("player_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlayerIdEqualTo(String value) {
            addCriterion("player_id =", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdNotEqualTo(String value) {
            addCriterion("player_id <>", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdGreaterThan(String value) {
            addCriterion("player_id >", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdGreaterThanOrEqualTo(String value) {
            addCriterion("player_id >=", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdLessThan(String value) {
            addCriterion("player_id <", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdLessThanOrEqualTo(String value) {
            addCriterion("player_id <=", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdLike(String value) {
            addCriterion("player_id like", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdNotLike(String value) {
            addCriterion("player_id not like", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdIn(List<String> values) {
            addCriterion("player_id in", values, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdNotIn(List<String> values) {
            addCriterion("player_id not in", values, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdBetween(String value1, String value2) {
            addCriterion("player_id between", value1, value2, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdNotBetween(String value1, String value2) {
            addCriterion("player_id not between", value1, value2, "playerId");
            return (Criteria) this;
        }

        public Criteria andGameIdIsNull() {
            addCriterion("game_id is null");
            return (Criteria) this;
        }

        public Criteria andGameIdIsNotNull() {
            addCriterion("game_id is not null");
            return (Criteria) this;
        }

        public Criteria andGameIdEqualTo(String value) {
            addCriterion("game_id =", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotEqualTo(String value) {
            addCriterion("game_id <>", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThan(String value) {
            addCriterion("game_id >", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThanOrEqualTo(String value) {
            addCriterion("game_id >=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThan(String value) {
            addCriterion("game_id <", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThanOrEqualTo(String value) {
            addCriterion("game_id <=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLike(String value) {
            addCriterion("game_id like", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotLike(String value) {
            addCriterion("game_id not like", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdIn(List<String> values) {
            addCriterion("game_id in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotIn(List<String> values) {
            addCriterion("game_id not in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdBetween(String value1, String value2) {
            addCriterion("game_id between", value1, value2, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotBetween(String value1, String value2) {
            addCriterion("game_id not between", value1, value2, "gameId");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNull() {
            addCriterion("period is null");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNotNull() {
            addCriterion("period is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodEqualTo(Long value) {
            addCriterion("period =", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotEqualTo(Long value) {
            addCriterion("period <>", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThan(Long value) {
            addCriterion("period >", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThanOrEqualTo(Long value) {
            addCriterion("period >=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThan(Long value) {
            addCriterion("period <", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThanOrEqualTo(Long value) {
            addCriterion("period <=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodIn(List<Long> values) {
            addCriterion("period in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotIn(List<Long> values) {
            addCriterion("period not in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodBetween(Long value1, Long value2) {
            addCriterion("period between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotBetween(Long value1, Long value2) {
            addCriterion("period not between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andPlayerInIsNull() {
            addCriterion("player_in is null");
            return (Criteria) this;
        }

        public Criteria andPlayerInIsNotNull() {
            addCriterion("player_in is not null");
            return (Criteria) this;
        }

        public Criteria andPlayerInEqualTo(String value) {
            addCriterion("player_in =", value, "playerIn");
            return (Criteria) this;
        }

        public Criteria andPlayerInNotEqualTo(String value) {
            addCriterion("player_in <>", value, "playerIn");
            return (Criteria) this;
        }

        public Criteria andPlayerInGreaterThan(String value) {
            addCriterion("player_in >", value, "playerIn");
            return (Criteria) this;
        }

        public Criteria andPlayerInGreaterThanOrEqualTo(String value) {
            addCriterion("player_in >=", value, "playerIn");
            return (Criteria) this;
        }

        public Criteria andPlayerInLessThan(String value) {
            addCriterion("player_in <", value, "playerIn");
            return (Criteria) this;
        }

        public Criteria andPlayerInLessThanOrEqualTo(String value) {
            addCriterion("player_in <=", value, "playerIn");
            return (Criteria) this;
        }

        public Criteria andPlayerInLike(String value) {
            addCriterion("player_in like", value, "playerIn");
            return (Criteria) this;
        }

        public Criteria andPlayerInNotLike(String value) {
            addCriterion("player_in not like", value, "playerIn");
            return (Criteria) this;
        }

        public Criteria andPlayerInIn(List<String> values) {
            addCriterion("player_in in", values, "playerIn");
            return (Criteria) this;
        }

        public Criteria andPlayerInNotIn(List<String> values) {
            addCriterion("player_in not in", values, "playerIn");
            return (Criteria) this;
        }

        public Criteria andPlayerInBetween(String value1, String value2) {
            addCriterion("player_in between", value1, value2, "playerIn");
            return (Criteria) this;
        }

        public Criteria andPlayerInNotBetween(String value1, String value2) {
            addCriterion("player_in not between", value1, value2, "playerIn");
            return (Criteria) this;
        }

        public Criteria andFinanceIdIsNull() {
            addCriterion("finance_id is null");
            return (Criteria) this;
        }

        public Criteria andFinanceIdIsNotNull() {
            addCriterion("finance_id is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceIdEqualTo(String value) {
            addCriterion("finance_id =", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotEqualTo(String value) {
            addCriterion("finance_id <>", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdGreaterThan(String value) {
            addCriterion("finance_id >", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdGreaterThanOrEqualTo(String value) {
            addCriterion("finance_id >=", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdLessThan(String value) {
            addCriterion("finance_id <", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdLessThanOrEqualTo(String value) {
            addCriterion("finance_id <=", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdLike(String value) {
            addCriterion("finance_id like", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotLike(String value) {
            addCriterion("finance_id not like", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdIn(List<String> values) {
            addCriterion("finance_id in", values, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotIn(List<String> values) {
            addCriterion("finance_id not in", values, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdBetween(String value1, String value2) {
            addCriterion("finance_id between", value1, value2, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotBetween(String value1, String value2) {
            addCriterion("finance_id not between", value1, value2, "financeId");
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

        public Criteria andResultFinanceIdIsNull() {
            addCriterion("result_finance_id is null");
            return (Criteria) this;
        }

        public Criteria andResultFinanceIdIsNotNull() {
            addCriterion("result_finance_id is not null");
            return (Criteria) this;
        }

        public Criteria andResultFinanceIdEqualTo(String value) {
            addCriterion("result_finance_id =", value, "resultFinanceId");
            return (Criteria) this;
        }

        public Criteria andResultFinanceIdNotEqualTo(String value) {
            addCriterion("result_finance_id <>", value, "resultFinanceId");
            return (Criteria) this;
        }

        public Criteria andResultFinanceIdGreaterThan(String value) {
            addCriterion("result_finance_id >", value, "resultFinanceId");
            return (Criteria) this;
        }

        public Criteria andResultFinanceIdGreaterThanOrEqualTo(String value) {
            addCriterion("result_finance_id >=", value, "resultFinanceId");
            return (Criteria) this;
        }

        public Criteria andResultFinanceIdLessThan(String value) {
            addCriterion("result_finance_id <", value, "resultFinanceId");
            return (Criteria) this;
        }

        public Criteria andResultFinanceIdLessThanOrEqualTo(String value) {
            addCriterion("result_finance_id <=", value, "resultFinanceId");
            return (Criteria) this;
        }

        public Criteria andResultFinanceIdLike(String value) {
            addCriterion("result_finance_id like", value, "resultFinanceId");
            return (Criteria) this;
        }

        public Criteria andResultFinanceIdNotLike(String value) {
            addCriterion("result_finance_id not like", value, "resultFinanceId");
            return (Criteria) this;
        }

        public Criteria andResultFinanceIdIn(List<String> values) {
            addCriterion("result_finance_id in", values, "resultFinanceId");
            return (Criteria) this;
        }

        public Criteria andResultFinanceIdNotIn(List<String> values) {
            addCriterion("result_finance_id not in", values, "resultFinanceId");
            return (Criteria) this;
        }

        public Criteria andResultFinanceIdBetween(String value1, String value2) {
            addCriterion("result_finance_id between", value1, value2, "resultFinanceId");
            return (Criteria) this;
        }

        public Criteria andResultFinanceIdNotBetween(String value1, String value2) {
            addCriterion("result_finance_id not between", value1, value2, "resultFinanceId");
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