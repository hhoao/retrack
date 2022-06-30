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
     * @author 匡龙 2022-06-30
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

        public Criteria andMaterialIsNull() {
            addCriterion("material is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIsNotNull() {
            addCriterion("material is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialEqualTo(String value) {
            addCriterion("material =", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotEqualTo(String value) {
            addCriterion("material <>", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThan(String value) {
            addCriterion("material >", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThanOrEqualTo(String value) {
            addCriterion("material >=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThan(String value) {
            addCriterion("material <", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThanOrEqualTo(String value) {
            addCriterion("material <=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLike(String value) {
            addCriterion("material like", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotLike(String value) {
            addCriterion("material not like", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialIn(List<String> values) {
            addCriterion("material in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotIn(List<String> values) {
            addCriterion("material not in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialBetween(String value1, String value2) {
            addCriterion("material between", value1, value2, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotBetween(String value1, String value2) {
            addCriterion("material not between", value1, value2, "material");
            return (Criteria) this;
        }

        public Criteria andMarkIsNull() {
            addCriterion("mark is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("mark is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(String value) {
            addCriterion("mark =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(String value) {
            addCriterion("mark <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(String value) {
            addCriterion("mark >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(String value) {
            addCriterion("mark >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(String value) {
            addCriterion("mark <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(String value) {
            addCriterion("mark <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLike(String value) {
            addCriterion("mark like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotLike(String value) {
            addCriterion("mark not like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<String> values) {
            addCriterion("mark in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<String> values) {
            addCriterion("mark not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(String value1, String value2) {
            addCriterion("mark between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(String value1, String value2) {
            addCriterion("mark not between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andComponent1IsNull() {
            addCriterion("component1 is null");
            return (Criteria) this;
        }

        public Criteria andComponent1IsNotNull() {
            addCriterion("component1 is not null");
            return (Criteria) this;
        }

        public Criteria andComponent1EqualTo(String value) {
            addCriterion("component1 =", value, "component1");
            return (Criteria) this;
        }

        public Criteria andComponent1NotEqualTo(String value) {
            addCriterion("component1 <>", value, "component1");
            return (Criteria) this;
        }

        public Criteria andComponent1GreaterThan(String value) {
            addCriterion("component1 >", value, "component1");
            return (Criteria) this;
        }

        public Criteria andComponent1GreaterThanOrEqualTo(String value) {
            addCriterion("component1 >=", value, "component1");
            return (Criteria) this;
        }

        public Criteria andComponent1LessThan(String value) {
            addCriterion("component1 <", value, "component1");
            return (Criteria) this;
        }

        public Criteria andComponent1LessThanOrEqualTo(String value) {
            addCriterion("component1 <=", value, "component1");
            return (Criteria) this;
        }

        public Criteria andComponent1Like(String value) {
            addCriterion("component1 like", value, "component1");
            return (Criteria) this;
        }

        public Criteria andComponent1NotLike(String value) {
            addCriterion("component1 not like", value, "component1");
            return (Criteria) this;
        }

        public Criteria andComponent1In(List<String> values) {
            addCriterion("component1 in", values, "component1");
            return (Criteria) this;
        }

        public Criteria andComponent1NotIn(List<String> values) {
            addCriterion("component1 not in", values, "component1");
            return (Criteria) this;
        }

        public Criteria andComponent1Between(String value1, String value2) {
            addCriterion("component1 between", value1, value2, "component1");
            return (Criteria) this;
        }

        public Criteria andComponent1NotBetween(String value1, String value2) {
            addCriterion("component1 not between", value1, value2, "component1");
            return (Criteria) this;
        }

        public Criteria andContent1IsNull() {
            addCriterion("content1 is null");
            return (Criteria) this;
        }

        public Criteria andContent1IsNotNull() {
            addCriterion("content1 is not null");
            return (Criteria) this;
        }

        public Criteria andContent1EqualTo(String value) {
            addCriterion("content1 =", value, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1NotEqualTo(String value) {
            addCriterion("content1 <>", value, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1GreaterThan(String value) {
            addCriterion("content1 >", value, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1GreaterThanOrEqualTo(String value) {
            addCriterion("content1 >=", value, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1LessThan(String value) {
            addCriterion("content1 <", value, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1LessThanOrEqualTo(String value) {
            addCriterion("content1 <=", value, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1Like(String value) {
            addCriterion("content1 like", value, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1NotLike(String value) {
            addCriterion("content1 not like", value, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1In(List<String> values) {
            addCriterion("content1 in", values, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1NotIn(List<String> values) {
            addCriterion("content1 not in", values, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1Between(String value1, String value2) {
            addCriterion("content1 between", value1, value2, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1NotBetween(String value1, String value2) {
            addCriterion("content1 not between", value1, value2, "content1");
            return (Criteria) this;
        }

        public Criteria andComponent2IsNull() {
            addCriterion("component2 is null");
            return (Criteria) this;
        }

        public Criteria andComponent2IsNotNull() {
            addCriterion("component2 is not null");
            return (Criteria) this;
        }

        public Criteria andComponent2EqualTo(String value) {
            addCriterion("component2 =", value, "component2");
            return (Criteria) this;
        }

        public Criteria andComponent2NotEqualTo(String value) {
            addCriterion("component2 <>", value, "component2");
            return (Criteria) this;
        }

        public Criteria andComponent2GreaterThan(String value) {
            addCriterion("component2 >", value, "component2");
            return (Criteria) this;
        }

        public Criteria andComponent2GreaterThanOrEqualTo(String value) {
            addCriterion("component2 >=", value, "component2");
            return (Criteria) this;
        }

        public Criteria andComponent2LessThan(String value) {
            addCriterion("component2 <", value, "component2");
            return (Criteria) this;
        }

        public Criteria andComponent2LessThanOrEqualTo(String value) {
            addCriterion("component2 <=", value, "component2");
            return (Criteria) this;
        }

        public Criteria andComponent2Like(String value) {
            addCriterion("component2 like", value, "component2");
            return (Criteria) this;
        }

        public Criteria andComponent2NotLike(String value) {
            addCriterion("component2 not like", value, "component2");
            return (Criteria) this;
        }

        public Criteria andComponent2In(List<String> values) {
            addCriterion("component2 in", values, "component2");
            return (Criteria) this;
        }

        public Criteria andComponent2NotIn(List<String> values) {
            addCriterion("component2 not in", values, "component2");
            return (Criteria) this;
        }

        public Criteria andComponent2Between(String value1, String value2) {
            addCriterion("component2 between", value1, value2, "component2");
            return (Criteria) this;
        }

        public Criteria andComponent2NotBetween(String value1, String value2) {
            addCriterion("component2 not between", value1, value2, "component2");
            return (Criteria) this;
        }

        public Criteria andContent2IsNull() {
            addCriterion("content2 is null");
            return (Criteria) this;
        }

        public Criteria andContent2IsNotNull() {
            addCriterion("content2 is not null");
            return (Criteria) this;
        }

        public Criteria andContent2EqualTo(String value) {
            addCriterion("content2 =", value, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2NotEqualTo(String value) {
            addCriterion("content2 <>", value, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2GreaterThan(String value) {
            addCriterion("content2 >", value, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2GreaterThanOrEqualTo(String value) {
            addCriterion("content2 >=", value, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2LessThan(String value) {
            addCriterion("content2 <", value, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2LessThanOrEqualTo(String value) {
            addCriterion("content2 <=", value, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2Like(String value) {
            addCriterion("content2 like", value, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2NotLike(String value) {
            addCriterion("content2 not like", value, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2In(List<String> values) {
            addCriterion("content2 in", values, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2NotIn(List<String> values) {
            addCriterion("content2 not in", values, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2Between(String value1, String value2) {
            addCriterion("content2 between", value1, value2, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2NotBetween(String value1, String value2) {
            addCriterion("content2 not between", value1, value2, "content2");
            return (Criteria) this;
        }

        public Criteria andComponent3IsNull() {
            addCriterion("component3 is null");
            return (Criteria) this;
        }

        public Criteria andComponent3IsNotNull() {
            addCriterion("component3 is not null");
            return (Criteria) this;
        }

        public Criteria andComponent3EqualTo(String value) {
            addCriterion("component3 =", value, "component3");
            return (Criteria) this;
        }

        public Criteria andComponent3NotEqualTo(String value) {
            addCriterion("component3 <>", value, "component3");
            return (Criteria) this;
        }

        public Criteria andComponent3GreaterThan(String value) {
            addCriterion("component3 >", value, "component3");
            return (Criteria) this;
        }

        public Criteria andComponent3GreaterThanOrEqualTo(String value) {
            addCriterion("component3 >=", value, "component3");
            return (Criteria) this;
        }

        public Criteria andComponent3LessThan(String value) {
            addCriterion("component3 <", value, "component3");
            return (Criteria) this;
        }

        public Criteria andComponent3LessThanOrEqualTo(String value) {
            addCriterion("component3 <=", value, "component3");
            return (Criteria) this;
        }

        public Criteria andComponent3Like(String value) {
            addCriterion("component3 like", value, "component3");
            return (Criteria) this;
        }

        public Criteria andComponent3NotLike(String value) {
            addCriterion("component3 not like", value, "component3");
            return (Criteria) this;
        }

        public Criteria andComponent3In(List<String> values) {
            addCriterion("component3 in", values, "component3");
            return (Criteria) this;
        }

        public Criteria andComponent3NotIn(List<String> values) {
            addCriterion("component3 not in", values, "component3");
            return (Criteria) this;
        }

        public Criteria andComponent3Between(String value1, String value2) {
            addCriterion("component3 between", value1, value2, "component3");
            return (Criteria) this;
        }

        public Criteria andComponent3NotBetween(String value1, String value2) {
            addCriterion("component3 not between", value1, value2, "component3");
            return (Criteria) this;
        }

        public Criteria andContent3IsNull() {
            addCriterion("content3 is null");
            return (Criteria) this;
        }

        public Criteria andContent3IsNotNull() {
            addCriterion("content3 is not null");
            return (Criteria) this;
        }

        public Criteria andContent3EqualTo(String value) {
            addCriterion("content3 =", value, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3NotEqualTo(String value) {
            addCriterion("content3 <>", value, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3GreaterThan(String value) {
            addCriterion("content3 >", value, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3GreaterThanOrEqualTo(String value) {
            addCriterion("content3 >=", value, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3LessThan(String value) {
            addCriterion("content3 <", value, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3LessThanOrEqualTo(String value) {
            addCriterion("content3 <=", value, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3Like(String value) {
            addCriterion("content3 like", value, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3NotLike(String value) {
            addCriterion("content3 not like", value, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3In(List<String> values) {
            addCriterion("content3 in", values, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3NotIn(List<String> values) {
            addCriterion("content3 not in", values, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3Between(String value1, String value2) {
            addCriterion("content3 between", value1, value2, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3NotBetween(String value1, String value2) {
            addCriterion("content3 not between", value1, value2, "content3");
            return (Criteria) this;
        }

        public Criteria andComponent4IsNull() {
            addCriterion("component4 is null");
            return (Criteria) this;
        }

        public Criteria andComponent4IsNotNull() {
            addCriterion("component4 is not null");
            return (Criteria) this;
        }

        public Criteria andComponent4EqualTo(String value) {
            addCriterion("component4 =", value, "component4");
            return (Criteria) this;
        }

        public Criteria andComponent4NotEqualTo(String value) {
            addCriterion("component4 <>", value, "component4");
            return (Criteria) this;
        }

        public Criteria andComponent4GreaterThan(String value) {
            addCriterion("component4 >", value, "component4");
            return (Criteria) this;
        }

        public Criteria andComponent4GreaterThanOrEqualTo(String value) {
            addCriterion("component4 >=", value, "component4");
            return (Criteria) this;
        }

        public Criteria andComponent4LessThan(String value) {
            addCriterion("component4 <", value, "component4");
            return (Criteria) this;
        }

        public Criteria andComponent4LessThanOrEqualTo(String value) {
            addCriterion("component4 <=", value, "component4");
            return (Criteria) this;
        }

        public Criteria andComponent4Like(String value) {
            addCriterion("component4 like", value, "component4");
            return (Criteria) this;
        }

        public Criteria andComponent4NotLike(String value) {
            addCriterion("component4 not like", value, "component4");
            return (Criteria) this;
        }

        public Criteria andComponent4In(List<String> values) {
            addCriterion("component4 in", values, "component4");
            return (Criteria) this;
        }

        public Criteria andComponent4NotIn(List<String> values) {
            addCriterion("component4 not in", values, "component4");
            return (Criteria) this;
        }

        public Criteria andComponent4Between(String value1, String value2) {
            addCriterion("component4 between", value1, value2, "component4");
            return (Criteria) this;
        }

        public Criteria andComponent4NotBetween(String value1, String value2) {
            addCriterion("component4 not between", value1, value2, "component4");
            return (Criteria) this;
        }

        public Criteria andContent4IsNull() {
            addCriterion("content4 is null");
            return (Criteria) this;
        }

        public Criteria andContent4IsNotNull() {
            addCriterion("content4 is not null");
            return (Criteria) this;
        }

        public Criteria andContent4EqualTo(String value) {
            addCriterion("content4 =", value, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4NotEqualTo(String value) {
            addCriterion("content4 <>", value, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4GreaterThan(String value) {
            addCriterion("content4 >", value, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4GreaterThanOrEqualTo(String value) {
            addCriterion("content4 >=", value, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4LessThan(String value) {
            addCriterion("content4 <", value, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4LessThanOrEqualTo(String value) {
            addCriterion("content4 <=", value, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4Like(String value) {
            addCriterion("content4 like", value, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4NotLike(String value) {
            addCriterion("content4 not like", value, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4In(List<String> values) {
            addCriterion("content4 in", values, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4NotIn(List<String> values) {
            addCriterion("content4 not in", values, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4Between(String value1, String value2) {
            addCriterion("content4 between", value1, value2, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4NotBetween(String value1, String value2) {
            addCriterion("content4 not between", value1, value2, "content4");
            return (Criteria) this;
        }

        public Criteria andComponent5IsNull() {
            addCriterion("component5 is null");
            return (Criteria) this;
        }

        public Criteria andComponent5IsNotNull() {
            addCriterion("component5 is not null");
            return (Criteria) this;
        }

        public Criteria andComponent5EqualTo(String value) {
            addCriterion("component5 =", value, "component5");
            return (Criteria) this;
        }

        public Criteria andComponent5NotEqualTo(String value) {
            addCriterion("component5 <>", value, "component5");
            return (Criteria) this;
        }

        public Criteria andComponent5GreaterThan(String value) {
            addCriterion("component5 >", value, "component5");
            return (Criteria) this;
        }

        public Criteria andComponent5GreaterThanOrEqualTo(String value) {
            addCriterion("component5 >=", value, "component5");
            return (Criteria) this;
        }

        public Criteria andComponent5LessThan(String value) {
            addCriterion("component5 <", value, "component5");
            return (Criteria) this;
        }

        public Criteria andComponent5LessThanOrEqualTo(String value) {
            addCriterion("component5 <=", value, "component5");
            return (Criteria) this;
        }

        public Criteria andComponent5Like(String value) {
            addCriterion("component5 like", value, "component5");
            return (Criteria) this;
        }

        public Criteria andComponent5NotLike(String value) {
            addCriterion("component5 not like", value, "component5");
            return (Criteria) this;
        }

        public Criteria andComponent5In(List<String> values) {
            addCriterion("component5 in", values, "component5");
            return (Criteria) this;
        }

        public Criteria andComponent5NotIn(List<String> values) {
            addCriterion("component5 not in", values, "component5");
            return (Criteria) this;
        }

        public Criteria andComponent5Between(String value1, String value2) {
            addCriterion("component5 between", value1, value2, "component5");
            return (Criteria) this;
        }

        public Criteria andComponent5NotBetween(String value1, String value2) {
            addCriterion("component5 not between", value1, value2, "component5");
            return (Criteria) this;
        }

        public Criteria andContent5IsNull() {
            addCriterion("content5 is null");
            return (Criteria) this;
        }

        public Criteria andContent5IsNotNull() {
            addCriterion("content5 is not null");
            return (Criteria) this;
        }

        public Criteria andContent5EqualTo(String value) {
            addCriterion("content5 =", value, "content5");
            return (Criteria) this;
        }

        public Criteria andContent5NotEqualTo(String value) {
            addCriterion("content5 <>", value, "content5");
            return (Criteria) this;
        }

        public Criteria andContent5GreaterThan(String value) {
            addCriterion("content5 >", value, "content5");
            return (Criteria) this;
        }

        public Criteria andContent5GreaterThanOrEqualTo(String value) {
            addCriterion("content5 >=", value, "content5");
            return (Criteria) this;
        }

        public Criteria andContent5LessThan(String value) {
            addCriterion("content5 <", value, "content5");
            return (Criteria) this;
        }

        public Criteria andContent5LessThanOrEqualTo(String value) {
            addCriterion("content5 <=", value, "content5");
            return (Criteria) this;
        }

        public Criteria andContent5Like(String value) {
            addCriterion("content5 like", value, "content5");
            return (Criteria) this;
        }

        public Criteria andContent5NotLike(String value) {
            addCriterion("content5 not like", value, "content5");
            return (Criteria) this;
        }

        public Criteria andContent5In(List<String> values) {
            addCriterion("content5 in", values, "content5");
            return (Criteria) this;
        }

        public Criteria andContent5NotIn(List<String> values) {
            addCriterion("content5 not in", values, "content5");
            return (Criteria) this;
        }

        public Criteria andContent5Between(String value1, String value2) {
            addCriterion("content5 between", value1, value2, "content5");
            return (Criteria) this;
        }

        public Criteria andContent5NotBetween(String value1, String value2) {
            addCriterion("content5 not between", value1, value2, "content5");
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
     * @author 匡龙 2022-06-30
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