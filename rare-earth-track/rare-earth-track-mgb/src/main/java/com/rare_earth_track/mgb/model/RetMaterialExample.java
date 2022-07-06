package com.rare_earth_track.mgb.model;

import java.util.ArrayList;
import java.util.List;

public class RetMaterialExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * RetMaterialExample

     */
    public RetMaterialExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * setOrderByClause
     * @param orderByClause orderByClause

     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * getOrderByClause
     * @return java.lang.String
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * setDistinct
     * @param distinct distinct

     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * isDistinct
     * @return boolean
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * getOredCriteria
     * @return java.util.List<Criteria>
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * or
     * @param criteria criteria

     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * or
     * @return Criteria
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * createCriteria
     * @return Criteria
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * createCriteriaInternal
     * @return Criteria
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * clear

     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * ret_material
     * @author 匡龙 2022-07-06
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMaterialDoubleCategoryIdIsNull() {
            addCriterion("material_double_category_id is null");
            return (Criteria) this;
        }

        public Criteria andMaterialDoubleCategoryIdIsNotNull() {
            addCriterion("material_double_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialDoubleCategoryIdEqualTo(Long value) {
            addCriterion("material_double_category_id =", value, "materialDoubleCategoryId");
            return (Criteria) this;
        }

        public Criteria andMaterialDoubleCategoryIdNotEqualTo(Long value) {
            addCriterion("material_double_category_id <>", value, "materialDoubleCategoryId");
            return (Criteria) this;
        }

        public Criteria andMaterialDoubleCategoryIdGreaterThan(Long value) {
            addCriterion("material_double_category_id >", value, "materialDoubleCategoryId");
            return (Criteria) this;
        }

        public Criteria andMaterialDoubleCategoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("material_double_category_id >=", value, "materialDoubleCategoryId");
            return (Criteria) this;
        }

        public Criteria andMaterialDoubleCategoryIdLessThan(Long value) {
            addCriterion("material_double_category_id <", value, "materialDoubleCategoryId");
            return (Criteria) this;
        }

        public Criteria andMaterialDoubleCategoryIdLessThanOrEqualTo(Long value) {
            addCriterion("material_double_category_id <=", value, "materialDoubleCategoryId");
            return (Criteria) this;
        }

        public Criteria andMaterialDoubleCategoryIdIn(List<Long> values) {
            addCriterion("material_double_category_id in", values, "materialDoubleCategoryId");
            return (Criteria) this;
        }

        public Criteria andMaterialDoubleCategoryIdNotIn(List<Long> values) {
            addCriterion("material_double_category_id not in", values, "materialDoubleCategoryId");
            return (Criteria) this;
        }

        public Criteria andMaterialDoubleCategoryIdBetween(Long value1, Long value2) {
            addCriterion("material_double_category_id between", value1, value2, "materialDoubleCategoryId");
            return (Criteria) this;
        }

        public Criteria andMaterialDoubleCategoryIdNotBetween(Long value1, Long value2) {
            addCriterion("material_double_category_id not between", value1, value2, "materialDoubleCategoryId");
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

        public Criteria andOriginIsNull() {
            addCriterion("origin is null");
            return (Criteria) this;
        }

        public Criteria andOriginIsNotNull() {
            addCriterion("origin is not null");
            return (Criteria) this;
        }

        public Criteria andOriginEqualTo(String value) {
            addCriterion("origin =", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotEqualTo(String value) {
            addCriterion("origin <>", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginGreaterThan(String value) {
            addCriterion("origin >", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginGreaterThanOrEqualTo(String value) {
            addCriterion("origin >=", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLessThan(String value) {
            addCriterion("origin <", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLessThanOrEqualTo(String value) {
            addCriterion("origin <=", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLike(String value) {
            addCriterion("origin like", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotLike(String value) {
            addCriterion("origin not like", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginIn(List<String> values) {
            addCriterion("origin in", values, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotIn(List<String> values) {
            addCriterion("origin not in", values, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginBetween(String value1, String value2) {
            addCriterion("origin between", value1, value2, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotBetween(String value1, String value2) {
            addCriterion("origin not between", value1, value2, "origin");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameIsNull() {
            addCriterion("create_company_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameIsNotNull() {
            addCriterion("create_company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameEqualTo(String value) {
            addCriterion("create_company_name =", value, "createCompanyName");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameNotEqualTo(String value) {
            addCriterion("create_company_name <>", value, "createCompanyName");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameGreaterThan(String value) {
            addCriterion("create_company_name >", value, "createCompanyName");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_company_name >=", value, "createCompanyName");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameLessThan(String value) {
            addCriterion("create_company_name <", value, "createCompanyName");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("create_company_name <=", value, "createCompanyName");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameLike(String value) {
            addCriterion("create_company_name like", value, "createCompanyName");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameNotLike(String value) {
            addCriterion("create_company_name not like", value, "createCompanyName");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameIn(List<String> values) {
            addCriterion("create_company_name in", values, "createCompanyName");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameNotIn(List<String> values) {
            addCriterion("create_company_name not in", values, "createCompanyName");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameBetween(String value1, String value2) {
            addCriterion("create_company_name between", value1, value2, "createCompanyName");
            return (Criteria) this;
        }

        public Criteria andCreateCompanyNameNotBetween(String value1, String value2) {
            addCriterion("create_company_name not between", value1, value2, "createCompanyName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * ret_material
     * @author 匡龙 2022-07-06
     */
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