package com.rare_earth_track.mgb.model;

import java.util.ArrayList;
import java.util.List;

public class RetGbReferenceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * RetGbReferenceExample

     */
    public RetGbReferenceExample() {
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
     * ret_gb_reference
     * @author hhoa 2022-07-13
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

        public Criteria andStandardNumberIsNull() {
            addCriterion("standard_number is null");
            return (Criteria) this;
        }

        public Criteria andStandardNumberIsNotNull() {
            addCriterion("standard_number is not null");
            return (Criteria) this;
        }

        public Criteria andStandardNumberEqualTo(String value) {
            addCriterion("standard_number =", value, "standardNumber");
            return (Criteria) this;
        }

        public Criteria andStandardNumberNotEqualTo(String value) {
            addCriterion("standard_number <>", value, "standardNumber");
            return (Criteria) this;
        }

        public Criteria andStandardNumberGreaterThan(String value) {
            addCriterion("standard_number >", value, "standardNumber");
            return (Criteria) this;
        }

        public Criteria andStandardNumberGreaterThanOrEqualTo(String value) {
            addCriterion("standard_number >=", value, "standardNumber");
            return (Criteria) this;
        }

        public Criteria andStandardNumberLessThan(String value) {
            addCriterion("standard_number <", value, "standardNumber");
            return (Criteria) this;
        }

        public Criteria andStandardNumberLessThanOrEqualTo(String value) {
            addCriterion("standard_number <=", value, "standardNumber");
            return (Criteria) this;
        }

        public Criteria andStandardNumberLike(String value) {
            addCriterion("standard_number like", value, "standardNumber");
            return (Criteria) this;
        }

        public Criteria andStandardNumberNotLike(String value) {
            addCriterion("standard_number not like", value, "standardNumber");
            return (Criteria) this;
        }

        public Criteria andStandardNumberIn(List<String> values) {
            addCriterion("standard_number in", values, "standardNumber");
            return (Criteria) this;
        }

        public Criteria andStandardNumberNotIn(List<String> values) {
            addCriterion("standard_number not in", values, "standardNumber");
            return (Criteria) this;
        }

        public Criteria andStandardNumberBetween(String value1, String value2) {
            addCriterion("standard_number between", value1, value2, "standardNumber");
            return (Criteria) this;
        }

        public Criteria andStandardNumberNotBetween(String value1, String value2) {
            addCriterion("standard_number not between", value1, value2, "standardNumber");
            return (Criteria) this;
        }

        public Criteria andNdIsNull() {
            addCriterion("Nd is null");
            return (Criteria) this;
        }

        public Criteria andNdIsNotNull() {
            addCriterion("Nd is not null");
            return (Criteria) this;
        }

        public Criteria andNdEqualTo(String value) {
            addCriterion("Nd =", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotEqualTo(String value) {
            addCriterion("Nd <>", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdGreaterThan(String value) {
            addCriterion("Nd >", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdGreaterThanOrEqualTo(String value) {
            addCriterion("Nd >=", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdLessThan(String value) {
            addCriterion("Nd <", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdLessThanOrEqualTo(String value) {
            addCriterion("Nd <=", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdLike(String value) {
            addCriterion("Nd like", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotLike(String value) {
            addCriterion("Nd not like", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdIn(List<String> values) {
            addCriterion("Nd in", values, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotIn(List<String> values) {
            addCriterion("Nd not in", values, "nd");
            return (Criteria) this;
        }

        public Criteria andNdBetween(String value1, String value2) {
            addCriterion("Nd between", value1, value2, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotBetween(String value1, String value2) {
            addCriterion("Nd not between", value1, value2, "nd");
            return (Criteria) this;
        }

        public Criteria andCoIsNull() {
            addCriterion("Co is null");
            return (Criteria) this;
        }

        public Criteria andCoIsNotNull() {
            addCriterion("Co is not null");
            return (Criteria) this;
        }

        public Criteria andCoEqualTo(String value) {
            addCriterion("Co =", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoNotEqualTo(String value) {
            addCriterion("Co <>", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoGreaterThan(String value) {
            addCriterion("Co >", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoGreaterThanOrEqualTo(String value) {
            addCriterion("Co >=", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoLessThan(String value) {
            addCriterion("Co <", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoLessThanOrEqualTo(String value) {
            addCriterion("Co <=", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoLike(String value) {
            addCriterion("Co like", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoNotLike(String value) {
            addCriterion("Co not like", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoIn(List<String> values) {
            addCriterion("Co in", values, "co");
            return (Criteria) this;
        }

        public Criteria andCoNotIn(List<String> values) {
            addCriterion("Co not in", values, "co");
            return (Criteria) this;
        }

        public Criteria andCoBetween(String value1, String value2) {
            addCriterion("Co between", value1, value2, "co");
            return (Criteria) this;
        }

        public Criteria andCoNotBetween(String value1, String value2) {
            addCriterion("Co not between", value1, value2, "co");
            return (Criteria) this;
        }

        public Criteria andBIsNull() {
            addCriterion("B is null");
            return (Criteria) this;
        }

        public Criteria andBIsNotNull() {
            addCriterion("B is not null");
            return (Criteria) this;
        }

        public Criteria andBEqualTo(String value) {
            addCriterion("B =", value, "b");
            return (Criteria) this;
        }

        public Criteria andBNotEqualTo(String value) {
            addCriterion("B <>", value, "b");
            return (Criteria) this;
        }

        public Criteria andBGreaterThan(String value) {
            addCriterion("B >", value, "b");
            return (Criteria) this;
        }

        public Criteria andBGreaterThanOrEqualTo(String value) {
            addCriterion("B >=", value, "b");
            return (Criteria) this;
        }

        public Criteria andBLessThan(String value) {
            addCriterion("B <", value, "b");
            return (Criteria) this;
        }

        public Criteria andBLessThanOrEqualTo(String value) {
            addCriterion("B <=", value, "b");
            return (Criteria) this;
        }

        public Criteria andBLike(String value) {
            addCriterion("B like", value, "b");
            return (Criteria) this;
        }

        public Criteria andBNotLike(String value) {
            addCriterion("B not like", value, "b");
            return (Criteria) this;
        }

        public Criteria andBIn(List<String> values) {
            addCriterion("B in", values, "b");
            return (Criteria) this;
        }

        public Criteria andBNotIn(List<String> values) {
            addCriterion("B not in", values, "b");
            return (Criteria) this;
        }

        public Criteria andBBetween(String value1, String value2) {
            addCriterion("B between", value1, value2, "b");
            return (Criteria) this;
        }

        public Criteria andBNotBetween(String value1, String value2) {
            addCriterion("B not between", value1, value2, "b");
            return (Criteria) this;
        }

        public Criteria andDyTbPrIsNull() {
            addCriterion("Dy_Tb_Pr is null");
            return (Criteria) this;
        }

        public Criteria andDyTbPrIsNotNull() {
            addCriterion("Dy_Tb_Pr is not null");
            return (Criteria) this;
        }

        public Criteria andDyTbPrEqualTo(String value) {
            addCriterion("Dy_Tb_Pr =", value, "dyTbPr");
            return (Criteria) this;
        }

        public Criteria andDyTbPrNotEqualTo(String value) {
            addCriterion("Dy_Tb_Pr <>", value, "dyTbPr");
            return (Criteria) this;
        }

        public Criteria andDyTbPrGreaterThan(String value) {
            addCriterion("Dy_Tb_Pr >", value, "dyTbPr");
            return (Criteria) this;
        }

        public Criteria andDyTbPrGreaterThanOrEqualTo(String value) {
            addCriterion("Dy_Tb_Pr >=", value, "dyTbPr");
            return (Criteria) this;
        }

        public Criteria andDyTbPrLessThan(String value) {
            addCriterion("Dy_Tb_Pr <", value, "dyTbPr");
            return (Criteria) this;
        }

        public Criteria andDyTbPrLessThanOrEqualTo(String value) {
            addCriterion("Dy_Tb_Pr <=", value, "dyTbPr");
            return (Criteria) this;
        }

        public Criteria andDyTbPrLike(String value) {
            addCriterion("Dy_Tb_Pr like", value, "dyTbPr");
            return (Criteria) this;
        }

        public Criteria andDyTbPrNotLike(String value) {
            addCriterion("Dy_Tb_Pr not like", value, "dyTbPr");
            return (Criteria) this;
        }

        public Criteria andDyTbPrIn(List<String> values) {
            addCriterion("Dy_Tb_Pr in", values, "dyTbPr");
            return (Criteria) this;
        }

        public Criteria andDyTbPrNotIn(List<String> values) {
            addCriterion("Dy_Tb_Pr not in", values, "dyTbPr");
            return (Criteria) this;
        }

        public Criteria andDyTbPrBetween(String value1, String value2) {
            addCriterion("Dy_Tb_Pr between", value1, value2, "dyTbPr");
            return (Criteria) this;
        }

        public Criteria andDyTbPrNotBetween(String value1, String value2) {
            addCriterion("Dy_Tb_Pr not between", value1, value2, "dyTbPr");
            return (Criteria) this;
        }

        public Criteria andOtherIsNull() {
            addCriterion("other is null");
            return (Criteria) this;
        }

        public Criteria andOtherIsNotNull() {
            addCriterion("other is not null");
            return (Criteria) this;
        }

        public Criteria andOtherEqualTo(String value) {
            addCriterion("other =", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotEqualTo(String value) {
            addCriterion("other <>", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThan(String value) {
            addCriterion("other >", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThanOrEqualTo(String value) {
            addCriterion("other >=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThan(String value) {
            addCriterion("other <", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThanOrEqualTo(String value) {
            addCriterion("other <=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLike(String value) {
            addCriterion("other like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotLike(String value) {
            addCriterion("other not like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherIn(List<String> values) {
            addCriterion("other in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotIn(List<String> values) {
            addCriterion("other not in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherBetween(String value1, String value2) {
            addCriterion("other between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotBetween(String value1, String value2) {
            addCriterion("other not between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andReIsNull() {
            addCriterion("RE is null");
            return (Criteria) this;
        }

        public Criteria andReIsNotNull() {
            addCriterion("RE is not null");
            return (Criteria) this;
        }

        public Criteria andReEqualTo(String value) {
            addCriterion("RE =", value, "re");
            return (Criteria) this;
        }

        public Criteria andReNotEqualTo(String value) {
            addCriterion("RE <>", value, "re");
            return (Criteria) this;
        }

        public Criteria andReGreaterThan(String value) {
            addCriterion("RE >", value, "re");
            return (Criteria) this;
        }

        public Criteria andReGreaterThanOrEqualTo(String value) {
            addCriterion("RE >=", value, "re");
            return (Criteria) this;
        }

        public Criteria andReLessThan(String value) {
            addCriterion("RE <", value, "re");
            return (Criteria) this;
        }

        public Criteria andReLessThanOrEqualTo(String value) {
            addCriterion("RE <=", value, "re");
            return (Criteria) this;
        }

        public Criteria andReLike(String value) {
            addCriterion("RE like", value, "re");
            return (Criteria) this;
        }

        public Criteria andReNotLike(String value) {
            addCriterion("RE not like", value, "re");
            return (Criteria) this;
        }

        public Criteria andReIn(List<String> values) {
            addCriterion("RE in", values, "re");
            return (Criteria) this;
        }

        public Criteria andReNotIn(List<String> values) {
            addCriterion("RE not in", values, "re");
            return (Criteria) this;
        }

        public Criteria andReBetween(String value1, String value2) {
            addCriterion("RE between", value1, value2, "re");
            return (Criteria) this;
        }

        public Criteria andReNotBetween(String value1, String value2) {
            addCriterion("RE not between", value1, value2, "re");
            return (Criteria) this;
        }

        public Criteria andNdReIsNull() {
            addCriterion("Nd_RE is null");
            return (Criteria) this;
        }

        public Criteria andNdReIsNotNull() {
            addCriterion("Nd_RE is not null");
            return (Criteria) this;
        }

        public Criteria andNdReEqualTo(String value) {
            addCriterion("Nd_RE =", value, "ndRe");
            return (Criteria) this;
        }

        public Criteria andNdReNotEqualTo(String value) {
            addCriterion("Nd_RE <>", value, "ndRe");
            return (Criteria) this;
        }

        public Criteria andNdReGreaterThan(String value) {
            addCriterion("Nd_RE >", value, "ndRe");
            return (Criteria) this;
        }

        public Criteria andNdReGreaterThanOrEqualTo(String value) {
            addCriterion("Nd_RE >=", value, "ndRe");
            return (Criteria) this;
        }

        public Criteria andNdReLessThan(String value) {
            addCriterion("Nd_RE <", value, "ndRe");
            return (Criteria) this;
        }

        public Criteria andNdReLessThanOrEqualTo(String value) {
            addCriterion("Nd_RE <=", value, "ndRe");
            return (Criteria) this;
        }

        public Criteria andNdReLike(String value) {
            addCriterion("Nd_RE like", value, "ndRe");
            return (Criteria) this;
        }

        public Criteria andNdReNotLike(String value) {
            addCriterion("Nd_RE not like", value, "ndRe");
            return (Criteria) this;
        }

        public Criteria andNdReIn(List<String> values) {
            addCriterion("Nd_RE in", values, "ndRe");
            return (Criteria) this;
        }

        public Criteria andNdReNotIn(List<String> values) {
            addCriterion("Nd_RE not in", values, "ndRe");
            return (Criteria) this;
        }

        public Criteria andNdReBetween(String value1, String value2) {
            addCriterion("Nd_RE between", value1, value2, "ndRe");
            return (Criteria) this;
        }

        public Criteria andNdReNotBetween(String value1, String value2) {
            addCriterion("Nd_RE not between", value1, value2, "ndRe");
            return (Criteria) this;
        }

        public Criteria andDyReIsNull() {
            addCriterion("Dy_RE is null");
            return (Criteria) this;
        }

        public Criteria andDyReIsNotNull() {
            addCriterion("Dy_RE is not null");
            return (Criteria) this;
        }

        public Criteria andDyReEqualTo(String value) {
            addCriterion("Dy_RE =", value, "dyRe");
            return (Criteria) this;
        }

        public Criteria andDyReNotEqualTo(String value) {
            addCriterion("Dy_RE <>", value, "dyRe");
            return (Criteria) this;
        }

        public Criteria andDyReGreaterThan(String value) {
            addCriterion("Dy_RE >", value, "dyRe");
            return (Criteria) this;
        }

        public Criteria andDyReGreaterThanOrEqualTo(String value) {
            addCriterion("Dy_RE >=", value, "dyRe");
            return (Criteria) this;
        }

        public Criteria andDyReLessThan(String value) {
            addCriterion("Dy_RE <", value, "dyRe");
            return (Criteria) this;
        }

        public Criteria andDyReLessThanOrEqualTo(String value) {
            addCriterion("Dy_RE <=", value, "dyRe");
            return (Criteria) this;
        }

        public Criteria andDyReLike(String value) {
            addCriterion("Dy_RE like", value, "dyRe");
            return (Criteria) this;
        }

        public Criteria andDyReNotLike(String value) {
            addCriterion("Dy_RE not like", value, "dyRe");
            return (Criteria) this;
        }

        public Criteria andDyReIn(List<String> values) {
            addCriterion("Dy_RE in", values, "dyRe");
            return (Criteria) this;
        }

        public Criteria andDyReNotIn(List<String> values) {
            addCriterion("Dy_RE not in", values, "dyRe");
            return (Criteria) this;
        }

        public Criteria andDyReBetween(String value1, String value2) {
            addCriterion("Dy_RE between", value1, value2, "dyRe");
            return (Criteria) this;
        }

        public Criteria andDyReNotBetween(String value1, String value2) {
            addCriterion("Dy_RE not between", value1, value2, "dyRe");
            return (Criteria) this;
        }

        public Criteria andReoIsNull() {
            addCriterion("REO is null");
            return (Criteria) this;
        }

        public Criteria andReoIsNotNull() {
            addCriterion("REO is not null");
            return (Criteria) this;
        }

        public Criteria andReoEqualTo(String value) {
            addCriterion("REO =", value, "reo");
            return (Criteria) this;
        }

        public Criteria andReoNotEqualTo(String value) {
            addCriterion("REO <>", value, "reo");
            return (Criteria) this;
        }

        public Criteria andReoGreaterThan(String value) {
            addCriterion("REO >", value, "reo");
            return (Criteria) this;
        }

        public Criteria andReoGreaterThanOrEqualTo(String value) {
            addCriterion("REO >=", value, "reo");
            return (Criteria) this;
        }

        public Criteria andReoLessThan(String value) {
            addCriterion("REO <", value, "reo");
            return (Criteria) this;
        }

        public Criteria andReoLessThanOrEqualTo(String value) {
            addCriterion("REO <=", value, "reo");
            return (Criteria) this;
        }

        public Criteria andReoLike(String value) {
            addCriterion("REO like", value, "reo");
            return (Criteria) this;
        }

        public Criteria andReoNotLike(String value) {
            addCriterion("REO not like", value, "reo");
            return (Criteria) this;
        }

        public Criteria andReoIn(List<String> values) {
            addCriterion("REO in", values, "reo");
            return (Criteria) this;
        }

        public Criteria andReoNotIn(List<String> values) {
            addCriterion("REO not in", values, "reo");
            return (Criteria) this;
        }

        public Criteria andReoBetween(String value1, String value2) {
            addCriterion("REO between", value1, value2, "reo");
            return (Criteria) this;
        }

        public Criteria andReoNotBetween(String value1, String value2) {
            addCriterion("REO not between", value1, value2, "reo");
            return (Criteria) this;
        }

        public Criteria andNd2o3ReoIsNull() {
            addCriterion("Nd2O3_REO is null");
            return (Criteria) this;
        }

        public Criteria andNd2o3ReoIsNotNull() {
            addCriterion("Nd2O3_REO is not null");
            return (Criteria) this;
        }

        public Criteria andNd2o3ReoEqualTo(String value) {
            addCriterion("Nd2O3_REO =", value, "nd2o3Reo");
            return (Criteria) this;
        }

        public Criteria andNd2o3ReoNotEqualTo(String value) {
            addCriterion("Nd2O3_REO <>", value, "nd2o3Reo");
            return (Criteria) this;
        }

        public Criteria andNd2o3ReoGreaterThan(String value) {
            addCriterion("Nd2O3_REO >", value, "nd2o3Reo");
            return (Criteria) this;
        }

        public Criteria andNd2o3ReoGreaterThanOrEqualTo(String value) {
            addCriterion("Nd2O3_REO >=", value, "nd2o3Reo");
            return (Criteria) this;
        }

        public Criteria andNd2o3ReoLessThan(String value) {
            addCriterion("Nd2O3_REO <", value, "nd2o3Reo");
            return (Criteria) this;
        }

        public Criteria andNd2o3ReoLessThanOrEqualTo(String value) {
            addCriterion("Nd2O3_REO <=", value, "nd2o3Reo");
            return (Criteria) this;
        }

        public Criteria andNd2o3ReoLike(String value) {
            addCriterion("Nd2O3_REO like", value, "nd2o3Reo");
            return (Criteria) this;
        }

        public Criteria andNd2o3ReoNotLike(String value) {
            addCriterion("Nd2O3_REO not like", value, "nd2o3Reo");
            return (Criteria) this;
        }

        public Criteria andNd2o3ReoIn(List<String> values) {
            addCriterion("Nd2O3_REO in", values, "nd2o3Reo");
            return (Criteria) this;
        }

        public Criteria andNd2o3ReoNotIn(List<String> values) {
            addCriterion("Nd2O3_REO not in", values, "nd2o3Reo");
            return (Criteria) this;
        }

        public Criteria andNd2o3ReoBetween(String value1, String value2) {
            addCriterion("Nd2O3_REO between", value1, value2, "nd2o3Reo");
            return (Criteria) this;
        }

        public Criteria andNd2o3ReoNotBetween(String value1, String value2) {
            addCriterion("Nd2O3_REO not between", value1, value2, "nd2o3Reo");
            return (Criteria) this;
        }

        public Criteria andNd2o3IsNull() {
            addCriterion("Nd2O3 is null");
            return (Criteria) this;
        }

        public Criteria andNd2o3IsNotNull() {
            addCriterion("Nd2O3 is not null");
            return (Criteria) this;
        }

        public Criteria andNd2o3EqualTo(String value) {
            addCriterion("Nd2O3 =", value, "nd2o3");
            return (Criteria) this;
        }

        public Criteria andNd2o3NotEqualTo(String value) {
            addCriterion("Nd2O3 <>", value, "nd2o3");
            return (Criteria) this;
        }

        public Criteria andNd2o3GreaterThan(String value) {
            addCriterion("Nd2O3 >", value, "nd2o3");
            return (Criteria) this;
        }

        public Criteria andNd2o3GreaterThanOrEqualTo(String value) {
            addCriterion("Nd2O3 >=", value, "nd2o3");
            return (Criteria) this;
        }

        public Criteria andNd2o3LessThan(String value) {
            addCriterion("Nd2O3 <", value, "nd2o3");
            return (Criteria) this;
        }

        public Criteria andNd2o3LessThanOrEqualTo(String value) {
            addCriterion("Nd2O3 <=", value, "nd2o3");
            return (Criteria) this;
        }

        public Criteria andNd2o3Like(String value) {
            addCriterion("Nd2O3 like", value, "nd2o3");
            return (Criteria) this;
        }

        public Criteria andNd2o3NotLike(String value) {
            addCriterion("Nd2O3 not like", value, "nd2o3");
            return (Criteria) this;
        }

        public Criteria andNd2o3In(List<String> values) {
            addCriterion("Nd2O3 in", values, "nd2o3");
            return (Criteria) this;
        }

        public Criteria andNd2o3NotIn(List<String> values) {
            addCriterion("Nd2O3 not in", values, "nd2o3");
            return (Criteria) this;
        }

        public Criteria andNd2o3Between(String value1, String value2) {
            addCriterion("Nd2O3 between", value1, value2, "nd2o3");
            return (Criteria) this;
        }

        public Criteria andNd2o3NotBetween(String value1, String value2) {
            addCriterion("Nd2O3 not between", value1, value2, "nd2o3");
            return (Criteria) this;
        }

        public Criteria andDy2o3ReoIsNull() {
            addCriterion("Dy2O3_REO is null");
            return (Criteria) this;
        }

        public Criteria andDy2o3ReoIsNotNull() {
            addCriterion("Dy2O3_REO is not null");
            return (Criteria) this;
        }

        public Criteria andDy2o3ReoEqualTo(String value) {
            addCriterion("Dy2O3_REO =", value, "dy2o3Reo");
            return (Criteria) this;
        }

        public Criteria andDy2o3ReoNotEqualTo(String value) {
            addCriterion("Dy2O3_REO <>", value, "dy2o3Reo");
            return (Criteria) this;
        }

        public Criteria andDy2o3ReoGreaterThan(String value) {
            addCriterion("Dy2O3_REO >", value, "dy2o3Reo");
            return (Criteria) this;
        }

        public Criteria andDy2o3ReoGreaterThanOrEqualTo(String value) {
            addCriterion("Dy2O3_REO >=", value, "dy2o3Reo");
            return (Criteria) this;
        }

        public Criteria andDy2o3ReoLessThan(String value) {
            addCriterion("Dy2O3_REO <", value, "dy2o3Reo");
            return (Criteria) this;
        }

        public Criteria andDy2o3ReoLessThanOrEqualTo(String value) {
            addCriterion("Dy2O3_REO <=", value, "dy2o3Reo");
            return (Criteria) this;
        }

        public Criteria andDy2o3ReoLike(String value) {
            addCriterion("Dy2O3_REO like", value, "dy2o3Reo");
            return (Criteria) this;
        }

        public Criteria andDy2o3ReoNotLike(String value) {
            addCriterion("Dy2O3_REO not like", value, "dy2o3Reo");
            return (Criteria) this;
        }

        public Criteria andDy2o3ReoIn(List<String> values) {
            addCriterion("Dy2O3_REO in", values, "dy2o3Reo");
            return (Criteria) this;
        }

        public Criteria andDy2o3ReoNotIn(List<String> values) {
            addCriterion("Dy2O3_REO not in", values, "dy2o3Reo");
            return (Criteria) this;
        }

        public Criteria andDy2o3ReoBetween(String value1, String value2) {
            addCriterion("Dy2O3_REO between", value1, value2, "dy2o3Reo");
            return (Criteria) this;
        }

        public Criteria andDy2o3ReoNotBetween(String value1, String value2) {
            addCriterion("Dy2O3_REO not between", value1, value2, "dy2o3Reo");
            return (Criteria) this;
        }

        public Criteria andReImpuritiesIsNull() {
            addCriterion("RE_impurities is null");
            return (Criteria) this;
        }

        public Criteria andReImpuritiesIsNotNull() {
            addCriterion("RE_impurities is not null");
            return (Criteria) this;
        }

        public Criteria andReImpuritiesEqualTo(String value) {
            addCriterion("RE_impurities =", value, "reImpurities");
            return (Criteria) this;
        }

        public Criteria andReImpuritiesNotEqualTo(String value) {
            addCriterion("RE_impurities <>", value, "reImpurities");
            return (Criteria) this;
        }

        public Criteria andReImpuritiesGreaterThan(String value) {
            addCriterion("RE_impurities >", value, "reImpurities");
            return (Criteria) this;
        }

        public Criteria andReImpuritiesGreaterThanOrEqualTo(String value) {
            addCriterion("RE_impurities >=", value, "reImpurities");
            return (Criteria) this;
        }

        public Criteria andReImpuritiesLessThan(String value) {
            addCriterion("RE_impurities <", value, "reImpurities");
            return (Criteria) this;
        }

        public Criteria andReImpuritiesLessThanOrEqualTo(String value) {
            addCriterion("RE_impurities <=", value, "reImpurities");
            return (Criteria) this;
        }

        public Criteria andReImpuritiesLike(String value) {
            addCriterion("RE_impurities like", value, "reImpurities");
            return (Criteria) this;
        }

        public Criteria andReImpuritiesNotLike(String value) {
            addCriterion("RE_impurities not like", value, "reImpurities");
            return (Criteria) this;
        }

        public Criteria andReImpuritiesIn(List<String> values) {
            addCriterion("RE_impurities in", values, "reImpurities");
            return (Criteria) this;
        }

        public Criteria andReImpuritiesNotIn(List<String> values) {
            addCriterion("RE_impurities not in", values, "reImpurities");
            return (Criteria) this;
        }

        public Criteria andReImpuritiesBetween(String value1, String value2) {
            addCriterion("RE_impurities between", value1, value2, "reImpurities");
            return (Criteria) this;
        }

        public Criteria andReImpuritiesNotBetween(String value1, String value2) {
            addCriterion("RE_impurities not between", value1, value2, "reImpurities");
            return (Criteria) this;
        }

        public Criteria andNonReImpuritiesIsNull() {
            addCriterion("non_RE_impurities is null");
            return (Criteria) this;
        }

        public Criteria andNonReImpuritiesIsNotNull() {
            addCriterion("non_RE_impurities is not null");
            return (Criteria) this;
        }

        public Criteria andNonReImpuritiesEqualTo(String value) {
            addCriterion("non_RE_impurities =", value, "nonReImpurities");
            return (Criteria) this;
        }

        public Criteria andNonReImpuritiesNotEqualTo(String value) {
            addCriterion("non_RE_impurities <>", value, "nonReImpurities");
            return (Criteria) this;
        }

        public Criteria andNonReImpuritiesGreaterThan(String value) {
            addCriterion("non_RE_impurities >", value, "nonReImpurities");
            return (Criteria) this;
        }

        public Criteria andNonReImpuritiesGreaterThanOrEqualTo(String value) {
            addCriterion("non_RE_impurities >=", value, "nonReImpurities");
            return (Criteria) this;
        }

        public Criteria andNonReImpuritiesLessThan(String value) {
            addCriterion("non_RE_impurities <", value, "nonReImpurities");
            return (Criteria) this;
        }

        public Criteria andNonReImpuritiesLessThanOrEqualTo(String value) {
            addCriterion("non_RE_impurities <=", value, "nonReImpurities");
            return (Criteria) this;
        }

        public Criteria andNonReImpuritiesLike(String value) {
            addCriterion("non_RE_impurities like", value, "nonReImpurities");
            return (Criteria) this;
        }

        public Criteria andNonReImpuritiesNotLike(String value) {
            addCriterion("non_RE_impurities not like", value, "nonReImpurities");
            return (Criteria) this;
        }

        public Criteria andNonReImpuritiesIn(List<String> values) {
            addCriterion("non_RE_impurities in", values, "nonReImpurities");
            return (Criteria) this;
        }

        public Criteria andNonReImpuritiesNotIn(List<String> values) {
            addCriterion("non_RE_impurities not in", values, "nonReImpurities");
            return (Criteria) this;
        }

        public Criteria andNonReImpuritiesBetween(String value1, String value2) {
            addCriterion("non_RE_impurities between", value1, value2, "nonReImpurities");
            return (Criteria) this;
        }

        public Criteria andNonReImpuritiesNotBetween(String value1, String value2) {
            addCriterion("non_RE_impurities not between", value1, value2, "nonReImpurities");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * ret_gb_reference
     * @author hhoa 2022-07-13
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