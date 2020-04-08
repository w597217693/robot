package com.bigcat.app.pojo;

import java.util.ArrayList;
import java.util.List;

public class WayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WayExample() {
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

        public Criteria andInstructIsNull() {
            addCriterion("instruct is null");
            return (Criteria) this;
        }

        public Criteria andInstructIsNotNull() {
            addCriterion("instruct is not null");
            return (Criteria) this;
        }

        public Criteria andInstructEqualTo(String value) {
            addCriterion("instruct =", value, "instruct");
            return (Criteria) this;
        }

        public Criteria andInstructNotEqualTo(String value) {
            addCriterion("instruct <>", value, "instruct");
            return (Criteria) this;
        }

        public Criteria andInstructGreaterThan(String value) {
            addCriterion("instruct >", value, "instruct");
            return (Criteria) this;
        }

        public Criteria andInstructGreaterThanOrEqualTo(String value) {
            addCriterion("instruct >=", value, "instruct");
            return (Criteria) this;
        }

        public Criteria andInstructLessThan(String value) {
            addCriterion("instruct <", value, "instruct");
            return (Criteria) this;
        }

        public Criteria andInstructLessThanOrEqualTo(String value) {
            addCriterion("instruct <=", value, "instruct");
            return (Criteria) this;
        }

        public Criteria andInstructLike(String value) {
            addCriterion("instruct like", value, "instruct");
            return (Criteria) this;
        }

        public Criteria andInstructNotLike(String value) {
            addCriterion("instruct not like", value, "instruct");
            return (Criteria) this;
        }

        public Criteria andInstructIn(List<String> values) {
            addCriterion("instruct in", values, "instruct");
            return (Criteria) this;
        }

        public Criteria andInstructNotIn(List<String> values) {
            addCriterion("instruct not in", values, "instruct");
            return (Criteria) this;
        }

        public Criteria andInstructBetween(String value1, String value2) {
            addCriterion("instruct between", value1, value2, "instruct");
            return (Criteria) this;
        }

        public Criteria andInstructNotBetween(String value1, String value2) {
            addCriterion("instruct not between", value1, value2, "instruct");
            return (Criteria) this;
        }

        public Criteria andOddsIsNull() {
            addCriterion("odds is null");
            return (Criteria) this;
        }

        public Criteria andOddsIsNotNull() {
            addCriterion("odds is not null");
            return (Criteria) this;
        }

        public Criteria andOddsEqualTo(String value) {
            addCriterion("odds =", value, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsNotEqualTo(String value) {
            addCriterion("odds <>", value, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsGreaterThan(String value) {
            addCriterion("odds >", value, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsGreaterThanOrEqualTo(String value) {
            addCriterion("odds >=", value, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsLessThan(String value) {
            addCriterion("odds <", value, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsLessThanOrEqualTo(String value) {
            addCriterion("odds <=", value, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsLike(String value) {
            addCriterion("odds like", value, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsNotLike(String value) {
            addCriterion("odds not like", value, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsIn(List<String> values) {
            addCriterion("odds in", values, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsNotIn(List<String> values) {
            addCriterion("odds not in", values, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsBetween(String value1, String value2) {
            addCriterion("odds between", value1, value2, "odds");
            return (Criteria) this;
        }

        public Criteria andOddsNotBetween(String value1, String value2) {
            addCriterion("odds not between", value1, value2, "odds");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andParseNameIsNull() {
            addCriterion("parse_name is null");
            return (Criteria) this;
        }

        public Criteria andParseNameIsNotNull() {
            addCriterion("parse_name is not null");
            return (Criteria) this;
        }

        public Criteria andParseNameEqualTo(String value) {
            addCriterion("parse_name =", value, "parseName");
            return (Criteria) this;
        }

        public Criteria andParseNameNotEqualTo(String value) {
            addCriterion("parse_name <>", value, "parseName");
            return (Criteria) this;
        }

        public Criteria andParseNameGreaterThan(String value) {
            addCriterion("parse_name >", value, "parseName");
            return (Criteria) this;
        }

        public Criteria andParseNameGreaterThanOrEqualTo(String value) {
            addCriterion("parse_name >=", value, "parseName");
            return (Criteria) this;
        }

        public Criteria andParseNameLessThan(String value) {
            addCriterion("parse_name <", value, "parseName");
            return (Criteria) this;
        }

        public Criteria andParseNameLessThanOrEqualTo(String value) {
            addCriterion("parse_name <=", value, "parseName");
            return (Criteria) this;
        }

        public Criteria andParseNameLike(String value) {
            addCriterion("parse_name like", value, "parseName");
            return (Criteria) this;
        }

        public Criteria andParseNameNotLike(String value) {
            addCriterion("parse_name not like", value, "parseName");
            return (Criteria) this;
        }

        public Criteria andParseNameIn(List<String> values) {
            addCriterion("parse_name in", values, "parseName");
            return (Criteria) this;
        }

        public Criteria andParseNameNotIn(List<String> values) {
            addCriterion("parse_name not in", values, "parseName");
            return (Criteria) this;
        }

        public Criteria andParseNameBetween(String value1, String value2) {
            addCriterion("parse_name between", value1, value2, "parseName");
            return (Criteria) this;
        }

        public Criteria andParseNameNotBetween(String value1, String value2) {
            addCriterion("parse_name not between", value1, value2, "parseName");
            return (Criteria) this;
        }

        public Criteria andOdds22IsNull() {
            addCriterion("odds_22 is null");
            return (Criteria) this;
        }

        public Criteria andOdds22IsNotNull() {
            addCriterion("odds_22 is not null");
            return (Criteria) this;
        }

        public Criteria andOdds22EqualTo(String value) {
            addCriterion("odds_22 =", value, "odds22");
            return (Criteria) this;
        }

        public Criteria andOdds22NotEqualTo(String value) {
            addCriterion("odds_22 <>", value, "odds22");
            return (Criteria) this;
        }

        public Criteria andOdds22GreaterThan(String value) {
            addCriterion("odds_22 >", value, "odds22");
            return (Criteria) this;
        }

        public Criteria andOdds22GreaterThanOrEqualTo(String value) {
            addCriterion("odds_22 >=", value, "odds22");
            return (Criteria) this;
        }

        public Criteria andOdds22LessThan(String value) {
            addCriterion("odds_22 <", value, "odds22");
            return (Criteria) this;
        }

        public Criteria andOdds22LessThanOrEqualTo(String value) {
            addCriterion("odds_22 <=", value, "odds22");
            return (Criteria) this;
        }

        public Criteria andOdds22Like(String value) {
            addCriterion("odds_22 like", value, "odds22");
            return (Criteria) this;
        }

        public Criteria andOdds22NotLike(String value) {
            addCriterion("odds_22 not like", value, "odds22");
            return (Criteria) this;
        }

        public Criteria andOdds22In(List<String> values) {
            addCriterion("odds_22 in", values, "odds22");
            return (Criteria) this;
        }

        public Criteria andOdds22NotIn(List<String> values) {
            addCriterion("odds_22 not in", values, "odds22");
            return (Criteria) this;
        }

        public Criteria andOdds22Between(String value1, String value2) {
            addCriterion("odds_22 between", value1, value2, "odds22");
            return (Criteria) this;
        }

        public Criteria andOdds22NotBetween(String value1, String value2) {
            addCriterion("odds_22 not between", value1, value2, "odds22");
            return (Criteria) this;
        }

        public Criteria andOdds23IsNull() {
            addCriterion("odds_23 is null");
            return (Criteria) this;
        }

        public Criteria andOdds23IsNotNull() {
            addCriterion("odds_23 is not null");
            return (Criteria) this;
        }

        public Criteria andOdds23EqualTo(String value) {
            addCriterion("odds_23 =", value, "odds23");
            return (Criteria) this;
        }

        public Criteria andOdds23NotEqualTo(String value) {
            addCriterion("odds_23 <>", value, "odds23");
            return (Criteria) this;
        }

        public Criteria andOdds23GreaterThan(String value) {
            addCriterion("odds_23 >", value, "odds23");
            return (Criteria) this;
        }

        public Criteria andOdds23GreaterThanOrEqualTo(String value) {
            addCriterion("odds_23 >=", value, "odds23");
            return (Criteria) this;
        }

        public Criteria andOdds23LessThan(String value) {
            addCriterion("odds_23 <", value, "odds23");
            return (Criteria) this;
        }

        public Criteria andOdds23LessThanOrEqualTo(String value) {
            addCriterion("odds_23 <=", value, "odds23");
            return (Criteria) this;
        }

        public Criteria andOdds23Like(String value) {
            addCriterion("odds_23 like", value, "odds23");
            return (Criteria) this;
        }

        public Criteria andOdds23NotLike(String value) {
            addCriterion("odds_23 not like", value, "odds23");
            return (Criteria) this;
        }

        public Criteria andOdds23In(List<String> values) {
            addCriterion("odds_23 in", values, "odds23");
            return (Criteria) this;
        }

        public Criteria andOdds23NotIn(List<String> values) {
            addCriterion("odds_23 not in", values, "odds23");
            return (Criteria) this;
        }

        public Criteria andOdds23Between(String value1, String value2) {
            addCriterion("odds_23 between", value1, value2, "odds23");
            return (Criteria) this;
        }

        public Criteria andOdds23NotBetween(String value1, String value2) {
            addCriterion("odds_23 not between", value1, value2, "odds23");
            return (Criteria) this;
        }

        public Criteria andBetsMinIsNull() {
            addCriterion("bets_min is null");
            return (Criteria) this;
        }

        public Criteria andBetsMinIsNotNull() {
            addCriterion("bets_min is not null");
            return (Criteria) this;
        }

        public Criteria andBetsMinEqualTo(Long value) {
            addCriterion("bets_min =", value, "betsMin");
            return (Criteria) this;
        }

        public Criteria andBetsMinNotEqualTo(Long value) {
            addCriterion("bets_min <>", value, "betsMin");
            return (Criteria) this;
        }

        public Criteria andBetsMinGreaterThan(Long value) {
            addCriterion("bets_min >", value, "betsMin");
            return (Criteria) this;
        }

        public Criteria andBetsMinGreaterThanOrEqualTo(Long value) {
            addCriterion("bets_min >=", value, "betsMin");
            return (Criteria) this;
        }

        public Criteria andBetsMinLessThan(Long value) {
            addCriterion("bets_min <", value, "betsMin");
            return (Criteria) this;
        }

        public Criteria andBetsMinLessThanOrEqualTo(Long value) {
            addCriterion("bets_min <=", value, "betsMin");
            return (Criteria) this;
        }

        public Criteria andBetsMinIn(List<Long> values) {
            addCriterion("bets_min in", values, "betsMin");
            return (Criteria) this;
        }

        public Criteria andBetsMinNotIn(List<Long> values) {
            addCriterion("bets_min not in", values, "betsMin");
            return (Criteria) this;
        }

        public Criteria andBetsMinBetween(Long value1, Long value2) {
            addCriterion("bets_min between", value1, value2, "betsMin");
            return (Criteria) this;
        }

        public Criteria andBetsMinNotBetween(Long value1, Long value2) {
            addCriterion("bets_min not between", value1, value2, "betsMin");
            return (Criteria) this;
        }

        public Criteria andBetsMaxIsNull() {
            addCriterion("bets_max is null");
            return (Criteria) this;
        }

        public Criteria andBetsMaxIsNotNull() {
            addCriterion("bets_max is not null");
            return (Criteria) this;
        }

        public Criteria andBetsMaxEqualTo(Long value) {
            addCriterion("bets_max =", value, "betsMax");
            return (Criteria) this;
        }

        public Criteria andBetsMaxNotEqualTo(Long value) {
            addCriterion("bets_max <>", value, "betsMax");
            return (Criteria) this;
        }

        public Criteria andBetsMaxGreaterThan(Long value) {
            addCriterion("bets_max >", value, "betsMax");
            return (Criteria) this;
        }

        public Criteria andBetsMaxGreaterThanOrEqualTo(Long value) {
            addCriterion("bets_max >=", value, "betsMax");
            return (Criteria) this;
        }

        public Criteria andBetsMaxLessThan(Long value) {
            addCriterion("bets_max <", value, "betsMax");
            return (Criteria) this;
        }

        public Criteria andBetsMaxLessThanOrEqualTo(Long value) {
            addCriterion("bets_max <=", value, "betsMax");
            return (Criteria) this;
        }

        public Criteria andBetsMaxIn(List<Long> values) {
            addCriterion("bets_max in", values, "betsMax");
            return (Criteria) this;
        }

        public Criteria andBetsMaxNotIn(List<Long> values) {
            addCriterion("bets_max not in", values, "betsMax");
            return (Criteria) this;
        }

        public Criteria andBetsMaxBetween(Long value1, Long value2) {
            addCriterion("bets_max between", value1, value2, "betsMax");
            return (Criteria) this;
        }

        public Criteria andBetsMaxNotBetween(Long value1, Long value2) {
            addCriterion("bets_max not between", value1, value2, "betsMax");
            return (Criteria) this;
        }

        public Criteria andSigleMaxIsNull() {
            addCriterion("sigle_max is null");
            return (Criteria) this;
        }

        public Criteria andSigleMaxIsNotNull() {
            addCriterion("sigle_max is not null");
            return (Criteria) this;
        }

        public Criteria andSigleMaxEqualTo(Long value) {
            addCriterion("sigle_max =", value, "sigleMax");
            return (Criteria) this;
        }

        public Criteria andSigleMaxNotEqualTo(Long value) {
            addCriterion("sigle_max <>", value, "sigleMax");
            return (Criteria) this;
        }

        public Criteria andSigleMaxGreaterThan(Long value) {
            addCriterion("sigle_max >", value, "sigleMax");
            return (Criteria) this;
        }

        public Criteria andSigleMaxGreaterThanOrEqualTo(Long value) {
            addCriterion("sigle_max >=", value, "sigleMax");
            return (Criteria) this;
        }

        public Criteria andSigleMaxLessThan(Long value) {
            addCriterion("sigle_max <", value, "sigleMax");
            return (Criteria) this;
        }

        public Criteria andSigleMaxLessThanOrEqualTo(Long value) {
            addCriterion("sigle_max <=", value, "sigleMax");
            return (Criteria) this;
        }

        public Criteria andSigleMaxIn(List<Long> values) {
            addCriterion("sigle_max in", values, "sigleMax");
            return (Criteria) this;
        }

        public Criteria andSigleMaxNotIn(List<Long> values) {
            addCriterion("sigle_max not in", values, "sigleMax");
            return (Criteria) this;
        }

        public Criteria andSigleMaxBetween(Long value1, Long value2) {
            addCriterion("sigle_max between", value1, value2, "sigleMax");
            return (Criteria) this;
        }

        public Criteria andSigleMaxNotBetween(Long value1, Long value2) {
            addCriterion("sigle_max not between", value1, value2, "sigleMax");
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

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
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