package com.bigcat.app.pojo;

import java.util.ArrayList;
import java.util.List;

public class SettingsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SettingsExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
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

        public Criteria andGameidIsNull() {
            addCriterion("gameId is null");
            return (Criteria) this;
        }

        public Criteria andGameidIsNotNull() {
            addCriterion("gameId is not null");
            return (Criteria) this;
        }

        public Criteria andGameidEqualTo(String value) {
            addCriterion("gameId =", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidNotEqualTo(String value) {
            addCriterion("gameId <>", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidGreaterThan(String value) {
            addCriterion("gameId >", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidGreaterThanOrEqualTo(String value) {
            addCriterion("gameId >=", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidLessThan(String value) {
            addCriterion("gameId <", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidLessThanOrEqualTo(String value) {
            addCriterion("gameId <=", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidLike(String value) {
            addCriterion("gameId like", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidNotLike(String value) {
            addCriterion("gameId not like", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidIn(List<String> values) {
            addCriterion("gameId in", values, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidNotIn(List<String> values) {
            addCriterion("gameId not in", values, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidBetween(String value1, String value2) {
            addCriterion("gameId between", value1, value2, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidNotBetween(String value1, String value2) {
            addCriterion("gameId not between", value1, value2, "gameid");
            return (Criteria) this;
        }

        public Criteria andExecuteIsNull() {
            addCriterion("execute is null");
            return (Criteria) this;
        }

        public Criteria andExecuteIsNotNull() {
            addCriterion("execute is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteEqualTo(Integer value) {
            addCriterion("execute =", value, "execute");
            return (Criteria) this;
        }

        public Criteria andExecuteNotEqualTo(Integer value) {
            addCriterion("execute <>", value, "execute");
            return (Criteria) this;
        }

        public Criteria andExecuteGreaterThan(Integer value) {
            addCriterion("execute >", value, "execute");
            return (Criteria) this;
        }

        public Criteria andExecuteGreaterThanOrEqualTo(Integer value) {
            addCriterion("execute >=", value, "execute");
            return (Criteria) this;
        }

        public Criteria andExecuteLessThan(Integer value) {
            addCriterion("execute <", value, "execute");
            return (Criteria) this;
        }

        public Criteria andExecuteLessThanOrEqualTo(Integer value) {
            addCriterion("execute <=", value, "execute");
            return (Criteria) this;
        }

        public Criteria andExecuteIn(List<Integer> values) {
            addCriterion("execute in", values, "execute");
            return (Criteria) this;
        }

        public Criteria andExecuteNotIn(List<Integer> values) {
            addCriterion("execute not in", values, "execute");
            return (Criteria) this;
        }

        public Criteria andExecuteBetween(Integer value1, Integer value2) {
            addCriterion("execute between", value1, value2, "execute");
            return (Criteria) this;
        }

        public Criteria andExecuteNotBetween(Integer value1, Integer value2) {
            addCriterion("execute not between", value1, value2, "execute");
            return (Criteria) this;
        }

        public Criteria andExecuteDeferIsNull() {
            addCriterion("execute_defer is null");
            return (Criteria) this;
        }

        public Criteria andExecuteDeferIsNotNull() {
            addCriterion("execute_defer is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteDeferEqualTo(Integer value) {
            addCriterion("execute_defer =", value, "executeDefer");
            return (Criteria) this;
        }

        public Criteria andExecuteDeferNotEqualTo(Integer value) {
            addCriterion("execute_defer <>", value, "executeDefer");
            return (Criteria) this;
        }

        public Criteria andExecuteDeferGreaterThan(Integer value) {
            addCriterion("execute_defer >", value, "executeDefer");
            return (Criteria) this;
        }

        public Criteria andExecuteDeferGreaterThanOrEqualTo(Integer value) {
            addCriterion("execute_defer >=", value, "executeDefer");
            return (Criteria) this;
        }

        public Criteria andExecuteDeferLessThan(Integer value) {
            addCriterion("execute_defer <", value, "executeDefer");
            return (Criteria) this;
        }

        public Criteria andExecuteDeferLessThanOrEqualTo(Integer value) {
            addCriterion("execute_defer <=", value, "executeDefer");
            return (Criteria) this;
        }

        public Criteria andExecuteDeferIn(List<Integer> values) {
            addCriterion("execute_defer in", values, "executeDefer");
            return (Criteria) this;
        }

        public Criteria andExecuteDeferNotIn(List<Integer> values) {
            addCriterion("execute_defer not in", values, "executeDefer");
            return (Criteria) this;
        }

        public Criteria andExecuteDeferBetween(Integer value1, Integer value2) {
            addCriterion("execute_defer between", value1, value2, "executeDefer");
            return (Criteria) this;
        }

        public Criteria andExecuteDeferNotBetween(Integer value1, Integer value2) {
            addCriterion("execute_defer not between", value1, value2, "executeDefer");
            return (Criteria) this;
        }

        public Criteria andTemplateImageIsNull() {
            addCriterion("template_image is null");
            return (Criteria) this;
        }

        public Criteria andTemplateImageIsNotNull() {
            addCriterion("template_image is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateImageEqualTo(String value) {
            addCriterion("template_image =", value, "templateImage");
            return (Criteria) this;
        }

        public Criteria andTemplateImageNotEqualTo(String value) {
            addCriterion("template_image <>", value, "templateImage");
            return (Criteria) this;
        }

        public Criteria andTemplateImageGreaterThan(String value) {
            addCriterion("template_image >", value, "templateImage");
            return (Criteria) this;
        }

        public Criteria andTemplateImageGreaterThanOrEqualTo(String value) {
            addCriterion("template_image >=", value, "templateImage");
            return (Criteria) this;
        }

        public Criteria andTemplateImageLessThan(String value) {
            addCriterion("template_image <", value, "templateImage");
            return (Criteria) this;
        }

        public Criteria andTemplateImageLessThanOrEqualTo(String value) {
            addCriterion("template_image <=", value, "templateImage");
            return (Criteria) this;
        }

        public Criteria andTemplateImageLike(String value) {
            addCriterion("template_image like", value, "templateImage");
            return (Criteria) this;
        }

        public Criteria andTemplateImageNotLike(String value) {
            addCriterion("template_image not like", value, "templateImage");
            return (Criteria) this;
        }

        public Criteria andTemplateImageIn(List<String> values) {
            addCriterion("template_image in", values, "templateImage");
            return (Criteria) this;
        }

        public Criteria andTemplateImageNotIn(List<String> values) {
            addCriterion("template_image not in", values, "templateImage");
            return (Criteria) this;
        }

        public Criteria andTemplateImageBetween(String value1, String value2) {
            addCriterion("template_image between", value1, value2, "templateImage");
            return (Criteria) this;
        }

        public Criteria andTemplateImageNotBetween(String value1, String value2) {
            addCriterion("template_image not between", value1, value2, "templateImage");
            return (Criteria) this;
        }

        public Criteria andTemplateTextIsNull() {
            addCriterion("template_text is null");
            return (Criteria) this;
        }

        public Criteria andTemplateTextIsNotNull() {
            addCriterion("template_text is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateTextEqualTo(String value) {
            addCriterion("template_text =", value, "templateText");
            return (Criteria) this;
        }

        public Criteria andTemplateTextNotEqualTo(String value) {
            addCriterion("template_text <>", value, "templateText");
            return (Criteria) this;
        }

        public Criteria andTemplateTextGreaterThan(String value) {
            addCriterion("template_text >", value, "templateText");
            return (Criteria) this;
        }

        public Criteria andTemplateTextGreaterThanOrEqualTo(String value) {
            addCriterion("template_text >=", value, "templateText");
            return (Criteria) this;
        }

        public Criteria andTemplateTextLessThan(String value) {
            addCriterion("template_text <", value, "templateText");
            return (Criteria) this;
        }

        public Criteria andTemplateTextLessThanOrEqualTo(String value) {
            addCriterion("template_text <=", value, "templateText");
            return (Criteria) this;
        }

        public Criteria andTemplateTextLike(String value) {
            addCriterion("template_text like", value, "templateText");
            return (Criteria) this;
        }

        public Criteria andTemplateTextNotLike(String value) {
            addCriterion("template_text not like", value, "templateText");
            return (Criteria) this;
        }

        public Criteria andTemplateTextIn(List<String> values) {
            addCriterion("template_text in", values, "templateText");
            return (Criteria) this;
        }

        public Criteria andTemplateTextNotIn(List<String> values) {
            addCriterion("template_text not in", values, "templateText");
            return (Criteria) this;
        }

        public Criteria andTemplateTextBetween(String value1, String value2) {
            addCriterion("template_text between", value1, value2, "templateText");
            return (Criteria) this;
        }

        public Criteria andTemplateTextNotBetween(String value1, String value2) {
            addCriterion("template_text not between", value1, value2, "templateText");
            return (Criteria) this;
        }

        public Criteria andTemplateStyleIsNull() {
            addCriterion("template_style is null");
            return (Criteria) this;
        }

        public Criteria andTemplateStyleIsNotNull() {
            addCriterion("template_style is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateStyleEqualTo(Integer value) {
            addCriterion("template_style =", value, "templateStyle");
            return (Criteria) this;
        }

        public Criteria andTemplateStyleNotEqualTo(Integer value) {
            addCriterion("template_style <>", value, "templateStyle");
            return (Criteria) this;
        }

        public Criteria andTemplateStyleGreaterThan(Integer value) {
            addCriterion("template_style >", value, "templateStyle");
            return (Criteria) this;
        }

        public Criteria andTemplateStyleGreaterThanOrEqualTo(Integer value) {
            addCriterion("template_style >=", value, "templateStyle");
            return (Criteria) this;
        }

        public Criteria andTemplateStyleLessThan(Integer value) {
            addCriterion("template_style <", value, "templateStyle");
            return (Criteria) this;
        }

        public Criteria andTemplateStyleLessThanOrEqualTo(Integer value) {
            addCriterion("template_style <=", value, "templateStyle");
            return (Criteria) this;
        }

        public Criteria andTemplateStyleIn(List<Integer> values) {
            addCriterion("template_style in", values, "templateStyle");
            return (Criteria) this;
        }

        public Criteria andTemplateStyleNotIn(List<Integer> values) {
            addCriterion("template_style not in", values, "templateStyle");
            return (Criteria) this;
        }

        public Criteria andTemplateStyleBetween(Integer value1, Integer value2) {
            addCriterion("template_style between", value1, value2, "templateStyle");
            return (Criteria) this;
        }

        public Criteria andTemplateStyleNotBetween(Integer value1, Integer value2) {
            addCriterion("template_style not between", value1, value2, "templateStyle");
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