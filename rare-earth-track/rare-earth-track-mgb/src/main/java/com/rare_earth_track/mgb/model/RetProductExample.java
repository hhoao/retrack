package com.rare_earth_track.mgb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RetProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * RetProductExample

     */
    public RetProductExample() {
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
     * ret_product
     * @author hhoa 2022-05-27
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

        public Criteria andBatchIdIsNull() {
            addCriterion("batch_id is null");
            return (Criteria) this;
        }

        public Criteria andBatchIdIsNotNull() {
            addCriterion("batch_id is not null");
            return (Criteria) this;
        }

        public Criteria andBatchIdEqualTo(String value) {
            addCriterion("batch_id =", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotEqualTo(String value) {
            addCriterion("batch_id <>", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdGreaterThan(String value) {
            addCriterion("batch_id >", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdGreaterThanOrEqualTo(String value) {
            addCriterion("batch_id >=", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLessThan(String value) {
            addCriterion("batch_id <", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLessThanOrEqualTo(String value) {
            addCriterion("batch_id <=", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLike(String value) {
            addCriterion("batch_id like", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotLike(String value) {
            addCriterion("batch_id not like", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdIn(List<String> values) {
            addCriterion("batch_id in", values, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotIn(List<String> values) {
            addCriterion("batch_id not in", values, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdBetween(String value1, String value2) {
            addCriterion("batch_id between", value1, value2, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotBetween(String value1, String value2) {
            addCriterion("batch_id not between", value1, value2, "batchId");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeIsNull() {
            addCriterion("dispatch_time is null");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeIsNotNull() {
            addCriterion("dispatch_time is not null");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeEqualTo(Date value) {
            addCriterion("dispatch_time =", value, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeNotEqualTo(Date value) {
            addCriterion("dispatch_time <>", value, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeGreaterThan(Date value) {
            addCriterion("dispatch_time >", value, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("dispatch_time >=", value, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeLessThan(Date value) {
            addCriterion("dispatch_time <", value, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeLessThanOrEqualTo(Date value) {
            addCriterion("dispatch_time <=", value, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeIn(List<Date> values) {
            addCriterion("dispatch_time in", values, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeNotIn(List<Date> values) {
            addCriterion("dispatch_time not in", values, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeBetween(Date value1, Date value2) {
            addCriterion("dispatch_time between", value1, value2, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeNotBetween(Date value1, Date value2) {
            addCriterion("dispatch_time not between", value1, value2, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andMoistureProofLogoIsNull() {
            addCriterion("moisture_proof_logo is null");
            return (Criteria) this;
        }

        public Criteria andMoistureProofLogoIsNotNull() {
            addCriterion("moisture_proof_logo is not null");
            return (Criteria) this;
        }

        public Criteria andMoistureProofLogoEqualTo(String value) {
            addCriterion("moisture_proof_logo =", value, "moistureProofLogo");
            return (Criteria) this;
        }

        public Criteria andMoistureProofLogoNotEqualTo(String value) {
            addCriterion("moisture_proof_logo <>", value, "moistureProofLogo");
            return (Criteria) this;
        }

        public Criteria andMoistureProofLogoGreaterThan(String value) {
            addCriterion("moisture_proof_logo >", value, "moistureProofLogo");
            return (Criteria) this;
        }

        public Criteria andMoistureProofLogoGreaterThanOrEqualTo(String value) {
            addCriterion("moisture_proof_logo >=", value, "moistureProofLogo");
            return (Criteria) this;
        }

        public Criteria andMoistureProofLogoLessThan(String value) {
            addCriterion("moisture_proof_logo <", value, "moistureProofLogo");
            return (Criteria) this;
        }

        public Criteria andMoistureProofLogoLessThanOrEqualTo(String value) {
            addCriterion("moisture_proof_logo <=", value, "moistureProofLogo");
            return (Criteria) this;
        }

        public Criteria andMoistureProofLogoLike(String value) {
            addCriterion("moisture_proof_logo like", value, "moistureProofLogo");
            return (Criteria) this;
        }

        public Criteria andMoistureProofLogoNotLike(String value) {
            addCriterion("moisture_proof_logo not like", value, "moistureProofLogo");
            return (Criteria) this;
        }

        public Criteria andMoistureProofLogoIn(List<String> values) {
            addCriterion("moisture_proof_logo in", values, "moistureProofLogo");
            return (Criteria) this;
        }

        public Criteria andMoistureProofLogoNotIn(List<String> values) {
            addCriterion("moisture_proof_logo not in", values, "moistureProofLogo");
            return (Criteria) this;
        }

        public Criteria andMoistureProofLogoBetween(String value1, String value2) {
            addCriterion("moisture_proof_logo between", value1, value2, "moistureProofLogo");
            return (Criteria) this;
        }

        public Criteria andMoistureProofLogoNotBetween(String value1, String value2) {
            addCriterion("moisture_proof_logo not between", value1, value2, "moistureProofLogo");
            return (Criteria) this;
        }

        public Criteria andSpecificationIsNull() {
            addCriterion("specification is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationIsNotNull() {
            addCriterion("specification is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationEqualTo(String value) {
            addCriterion("specification =", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotEqualTo(String value) {
            addCriterion("specification <>", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationGreaterThan(String value) {
            addCriterion("specification >", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationGreaterThanOrEqualTo(String value) {
            addCriterion("specification >=", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLessThan(String value) {
            addCriterion("specification <", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLessThanOrEqualTo(String value) {
            addCriterion("specification <=", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLike(String value) {
            addCriterion("specification like", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotLike(String value) {
            addCriterion("specification not like", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationIn(List<String> values) {
            addCriterion("specification in", values, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotIn(List<String> values) {
            addCriterion("specification not in", values, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationBetween(String value1, String value2) {
            addCriterion("specification between", value1, value2, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotBetween(String value1, String value2) {
            addCriterion("specification not between", value1, value2, "specification");
            return (Criteria) this;
        }

        public Criteria andPackingTypeIsNull() {
            addCriterion("packing_type is null");
            return (Criteria) this;
        }

        public Criteria andPackingTypeIsNotNull() {
            addCriterion("packing_type is not null");
            return (Criteria) this;
        }

        public Criteria andPackingTypeEqualTo(String value) {
            addCriterion("packing_type =", value, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeNotEqualTo(String value) {
            addCriterion("packing_type <>", value, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeGreaterThan(String value) {
            addCriterion("packing_type >", value, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("packing_type >=", value, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeLessThan(String value) {
            addCriterion("packing_type <", value, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeLessThanOrEqualTo(String value) {
            addCriterion("packing_type <=", value, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeLike(String value) {
            addCriterion("packing_type like", value, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeNotLike(String value) {
            addCriterion("packing_type not like", value, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeIn(List<String> values) {
            addCriterion("packing_type in", values, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeNotIn(List<String> values) {
            addCriterion("packing_type not in", values, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeBetween(String value1, String value2) {
            addCriterion("packing_type between", value1, value2, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeNotBetween(String value1, String value2) {
            addCriterion("packing_type not between", value1, value2, "packingType");
            return (Criteria) this;
        }

        public Criteria andNetWeightIsNull() {
            addCriterion("net_weight is null");
            return (Criteria) this;
        }

        public Criteria andNetWeightIsNotNull() {
            addCriterion("net_weight is not null");
            return (Criteria) this;
        }

        public Criteria andNetWeightEqualTo(String value) {
            addCriterion("net_weight =", value, "netWeight");
            return (Criteria) this;
        }

        public Criteria andNetWeightNotEqualTo(String value) {
            addCriterion("net_weight <>", value, "netWeight");
            return (Criteria) this;
        }

        public Criteria andNetWeightGreaterThan(String value) {
            addCriterion("net_weight >", value, "netWeight");
            return (Criteria) this;
        }

        public Criteria andNetWeightGreaterThanOrEqualTo(String value) {
            addCriterion("net_weight >=", value, "netWeight");
            return (Criteria) this;
        }

        public Criteria andNetWeightLessThan(String value) {
            addCriterion("net_weight <", value, "netWeight");
            return (Criteria) this;
        }

        public Criteria andNetWeightLessThanOrEqualTo(String value) {
            addCriterion("net_weight <=", value, "netWeight");
            return (Criteria) this;
        }

        public Criteria andNetWeightLike(String value) {
            addCriterion("net_weight like", value, "netWeight");
            return (Criteria) this;
        }

        public Criteria andNetWeightNotLike(String value) {
            addCriterion("net_weight not like", value, "netWeight");
            return (Criteria) this;
        }

        public Criteria andNetWeightIn(List<String> values) {
            addCriterion("net_weight in", values, "netWeight");
            return (Criteria) this;
        }

        public Criteria andNetWeightNotIn(List<String> values) {
            addCriterion("net_weight not in", values, "netWeight");
            return (Criteria) this;
        }

        public Criteria andNetWeightBetween(String value1, String value2) {
            addCriterion("net_weight between", value1, value2, "netWeight");
            return (Criteria) this;
        }

        public Criteria andNetWeightNotBetween(String value1, String value2) {
            addCriterion("net_weight not between", value1, value2, "netWeight");
            return (Criteria) this;
        }

        public Criteria andTransportLogIsNull() {
            addCriterion("transport_log is null");
            return (Criteria) this;
        }

        public Criteria andTransportLogIsNotNull() {
            addCriterion("transport_log is not null");
            return (Criteria) this;
        }

        public Criteria andTransportLogEqualTo(String value) {
            addCriterion("transport_log =", value, "transportLog");
            return (Criteria) this;
        }

        public Criteria andTransportLogNotEqualTo(String value) {
            addCriterion("transport_log <>", value, "transportLog");
            return (Criteria) this;
        }

        public Criteria andTransportLogGreaterThan(String value) {
            addCriterion("transport_log >", value, "transportLog");
            return (Criteria) this;
        }

        public Criteria andTransportLogGreaterThanOrEqualTo(String value) {
            addCriterion("transport_log >=", value, "transportLog");
            return (Criteria) this;
        }

        public Criteria andTransportLogLessThan(String value) {
            addCriterion("transport_log <", value, "transportLog");
            return (Criteria) this;
        }

        public Criteria andTransportLogLessThanOrEqualTo(String value) {
            addCriterion("transport_log <=", value, "transportLog");
            return (Criteria) this;
        }

        public Criteria andTransportLogLike(String value) {
            addCriterion("transport_log like", value, "transportLog");
            return (Criteria) this;
        }

        public Criteria andTransportLogNotLike(String value) {
            addCriterion("transport_log not like", value, "transportLog");
            return (Criteria) this;
        }

        public Criteria andTransportLogIn(List<String> values) {
            addCriterion("transport_log in", values, "transportLog");
            return (Criteria) this;
        }

        public Criteria andTransportLogNotIn(List<String> values) {
            addCriterion("transport_log not in", values, "transportLog");
            return (Criteria) this;
        }

        public Criteria andTransportLogBetween(String value1, String value2) {
            addCriterion("transport_log between", value1, value2, "transportLog");
            return (Criteria) this;
        }

        public Criteria andTransportLogNotBetween(String value1, String value2) {
            addCriterion("transport_log not between", value1, value2, "transportLog");
            return (Criteria) this;
        }

        public Criteria andPicIsNull() {
            addCriterion("pic is null");
            return (Criteria) this;
        }

        public Criteria andPicIsNotNull() {
            addCriterion("pic is not null");
            return (Criteria) this;
        }

        public Criteria andPicEqualTo(String value) {
            addCriterion("pic =", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotEqualTo(String value) {
            addCriterion("pic <>", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThan(String value) {
            addCriterion("pic >", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThanOrEqualTo(String value) {
            addCriterion("pic >=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThan(String value) {
            addCriterion("pic <", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThanOrEqualTo(String value) {
            addCriterion("pic <=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLike(String value) {
            addCriterion("pic like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotLike(String value) {
            addCriterion("pic not like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicIn(List<String> values) {
            addCriterion("pic in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotIn(List<String> values) {
            addCriterion("pic not in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicBetween(String value1, String value2) {
            addCriterion("pic between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotBetween(String value1, String value2) {
            addCriterion("pic not between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andPurityIsNull() {
            addCriterion("purity is null");
            return (Criteria) this;
        }

        public Criteria andPurityIsNotNull() {
            addCriterion("purity is not null");
            return (Criteria) this;
        }

        public Criteria andPurityEqualTo(String value) {
            addCriterion("purity =", value, "purity");
            return (Criteria) this;
        }

        public Criteria andPurityNotEqualTo(String value) {
            addCriterion("purity <>", value, "purity");
            return (Criteria) this;
        }

        public Criteria andPurityGreaterThan(String value) {
            addCriterion("purity >", value, "purity");
            return (Criteria) this;
        }

        public Criteria andPurityGreaterThanOrEqualTo(String value) {
            addCriterion("purity >=", value, "purity");
            return (Criteria) this;
        }

        public Criteria andPurityLessThan(String value) {
            addCriterion("purity <", value, "purity");
            return (Criteria) this;
        }

        public Criteria andPurityLessThanOrEqualTo(String value) {
            addCriterion("purity <=", value, "purity");
            return (Criteria) this;
        }

        public Criteria andPurityLike(String value) {
            addCriterion("purity like", value, "purity");
            return (Criteria) this;
        }

        public Criteria andPurityNotLike(String value) {
            addCriterion("purity not like", value, "purity");
            return (Criteria) this;
        }

        public Criteria andPurityIn(List<String> values) {
            addCriterion("purity in", values, "purity");
            return (Criteria) this;
        }

        public Criteria andPurityNotIn(List<String> values) {
            addCriterion("purity not in", values, "purity");
            return (Criteria) this;
        }

        public Criteria andPurityBetween(String value1, String value2) {
            addCriterion("purity between", value1, value2, "purity");
            return (Criteria) this;
        }

        public Criteria andPurityNotBetween(String value1, String value2) {
            addCriterion("purity not between", value1, value2, "purity");
            return (Criteria) this;
        }

        public Criteria andProductionEquipmentIsNull() {
            addCriterion("production_equipment is null");
            return (Criteria) this;
        }

        public Criteria andProductionEquipmentIsNotNull() {
            addCriterion("production_equipment is not null");
            return (Criteria) this;
        }

        public Criteria andProductionEquipmentEqualTo(String value) {
            addCriterion("production_equipment =", value, "productionEquipment");
            return (Criteria) this;
        }

        public Criteria andProductionEquipmentNotEqualTo(String value) {
            addCriterion("production_equipment <>", value, "productionEquipment");
            return (Criteria) this;
        }

        public Criteria andProductionEquipmentGreaterThan(String value) {
            addCriterion("production_equipment >", value, "productionEquipment");
            return (Criteria) this;
        }

        public Criteria andProductionEquipmentGreaterThanOrEqualTo(String value) {
            addCriterion("production_equipment >=", value, "productionEquipment");
            return (Criteria) this;
        }

        public Criteria andProductionEquipmentLessThan(String value) {
            addCriterion("production_equipment <", value, "productionEquipment");
            return (Criteria) this;
        }

        public Criteria andProductionEquipmentLessThanOrEqualTo(String value) {
            addCriterion("production_equipment <=", value, "productionEquipment");
            return (Criteria) this;
        }

        public Criteria andProductionEquipmentLike(String value) {
            addCriterion("production_equipment like", value, "productionEquipment");
            return (Criteria) this;
        }

        public Criteria andProductionEquipmentNotLike(String value) {
            addCriterion("production_equipment not like", value, "productionEquipment");
            return (Criteria) this;
        }

        public Criteria andProductionEquipmentIn(List<String> values) {
            addCriterion("production_equipment in", values, "productionEquipment");
            return (Criteria) this;
        }

        public Criteria andProductionEquipmentNotIn(List<String> values) {
            addCriterion("production_equipment not in", values, "productionEquipment");
            return (Criteria) this;
        }

        public Criteria andProductionEquipmentBetween(String value1, String value2) {
            addCriterion("production_equipment between", value1, value2, "productionEquipment");
            return (Criteria) this;
        }

        public Criteria andProductionEquipmentNotBetween(String value1, String value2) {
            addCriterion("production_equipment not between", value1, value2, "productionEquipment");
            return (Criteria) this;
        }

        public Criteria andMaterialRatioIsNull() {
            addCriterion("material_ratio is null");
            return (Criteria) this;
        }

        public Criteria andMaterialRatioIsNotNull() {
            addCriterion("material_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialRatioEqualTo(String value) {
            addCriterion("material_ratio =", value, "materialRatio");
            return (Criteria) this;
        }

        public Criteria andMaterialRatioNotEqualTo(String value) {
            addCriterion("material_ratio <>", value, "materialRatio");
            return (Criteria) this;
        }

        public Criteria andMaterialRatioGreaterThan(String value) {
            addCriterion("material_ratio >", value, "materialRatio");
            return (Criteria) this;
        }

        public Criteria andMaterialRatioGreaterThanOrEqualTo(String value) {
            addCriterion("material_ratio >=", value, "materialRatio");
            return (Criteria) this;
        }

        public Criteria andMaterialRatioLessThan(String value) {
            addCriterion("material_ratio <", value, "materialRatio");
            return (Criteria) this;
        }

        public Criteria andMaterialRatioLessThanOrEqualTo(String value) {
            addCriterion("material_ratio <=", value, "materialRatio");
            return (Criteria) this;
        }

        public Criteria andMaterialRatioLike(String value) {
            addCriterion("material_ratio like", value, "materialRatio");
            return (Criteria) this;
        }

        public Criteria andMaterialRatioNotLike(String value) {
            addCriterion("material_ratio not like", value, "materialRatio");
            return (Criteria) this;
        }

        public Criteria andMaterialRatioIn(List<String> values) {
            addCriterion("material_ratio in", values, "materialRatio");
            return (Criteria) this;
        }

        public Criteria andMaterialRatioNotIn(List<String> values) {
            addCriterion("material_ratio not in", values, "materialRatio");
            return (Criteria) this;
        }

        public Criteria andMaterialRatioBetween(String value1, String value2) {
            addCriterion("material_ratio between", value1, value2, "materialRatio");
            return (Criteria) this;
        }

        public Criteria andMaterialRatioNotBetween(String value1, String value2) {
            addCriterion("material_ratio not between", value1, value2, "materialRatio");
            return (Criteria) this;
        }

        public Criteria andExtractionUnitIsNull() {
            addCriterion("extraction_unit is null");
            return (Criteria) this;
        }

        public Criteria andExtractionUnitIsNotNull() {
            addCriterion("extraction_unit is not null");
            return (Criteria) this;
        }

        public Criteria andExtractionUnitEqualTo(String value) {
            addCriterion("extraction_unit =", value, "extractionUnit");
            return (Criteria) this;
        }

        public Criteria andExtractionUnitNotEqualTo(String value) {
            addCriterion("extraction_unit <>", value, "extractionUnit");
            return (Criteria) this;
        }

        public Criteria andExtractionUnitGreaterThan(String value) {
            addCriterion("extraction_unit >", value, "extractionUnit");
            return (Criteria) this;
        }

        public Criteria andExtractionUnitGreaterThanOrEqualTo(String value) {
            addCriterion("extraction_unit >=", value, "extractionUnit");
            return (Criteria) this;
        }

        public Criteria andExtractionUnitLessThan(String value) {
            addCriterion("extraction_unit <", value, "extractionUnit");
            return (Criteria) this;
        }

        public Criteria andExtractionUnitLessThanOrEqualTo(String value) {
            addCriterion("extraction_unit <=", value, "extractionUnit");
            return (Criteria) this;
        }

        public Criteria andExtractionUnitLike(String value) {
            addCriterion("extraction_unit like", value, "extractionUnit");
            return (Criteria) this;
        }

        public Criteria andExtractionUnitNotLike(String value) {
            addCriterion("extraction_unit not like", value, "extractionUnit");
            return (Criteria) this;
        }

        public Criteria andExtractionUnitIn(List<String> values) {
            addCriterion("extraction_unit in", values, "extractionUnit");
            return (Criteria) this;
        }

        public Criteria andExtractionUnitNotIn(List<String> values) {
            addCriterion("extraction_unit not in", values, "extractionUnit");
            return (Criteria) this;
        }

        public Criteria andExtractionUnitBetween(String value1, String value2) {
            addCriterion("extraction_unit between", value1, value2, "extractionUnit");
            return (Criteria) this;
        }

        public Criteria andExtractionUnitNotBetween(String value1, String value2) {
            addCriterion("extraction_unit not between", value1, value2, "extractionUnit");
            return (Criteria) this;
        }

        public Criteria andAlbumPicsIsNull() {
            addCriterion("album_pics is null");
            return (Criteria) this;
        }

        public Criteria andAlbumPicsIsNotNull() {
            addCriterion("album_pics is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumPicsEqualTo(String value) {
            addCriterion("album_pics =", value, "albumPics");
            return (Criteria) this;
        }

        public Criteria andAlbumPicsNotEqualTo(String value) {
            addCriterion("album_pics <>", value, "albumPics");
            return (Criteria) this;
        }

        public Criteria andAlbumPicsGreaterThan(String value) {
            addCriterion("album_pics >", value, "albumPics");
            return (Criteria) this;
        }

        public Criteria andAlbumPicsGreaterThanOrEqualTo(String value) {
            addCriterion("album_pics >=", value, "albumPics");
            return (Criteria) this;
        }

        public Criteria andAlbumPicsLessThan(String value) {
            addCriterion("album_pics <", value, "albumPics");
            return (Criteria) this;
        }

        public Criteria andAlbumPicsLessThanOrEqualTo(String value) {
            addCriterion("album_pics <=", value, "albumPics");
            return (Criteria) this;
        }

        public Criteria andAlbumPicsLike(String value) {
            addCriterion("album_pics like", value, "albumPics");
            return (Criteria) this;
        }

        public Criteria andAlbumPicsNotLike(String value) {
            addCriterion("album_pics not like", value, "albumPics");
            return (Criteria) this;
        }

        public Criteria andAlbumPicsIn(List<String> values) {
            addCriterion("album_pics in", values, "albumPics");
            return (Criteria) this;
        }

        public Criteria andAlbumPicsNotIn(List<String> values) {
            addCriterion("album_pics not in", values, "albumPics");
            return (Criteria) this;
        }

        public Criteria andAlbumPicsBetween(String value1, String value2) {
            addCriterion("album_pics between", value1, value2, "albumPics");
            return (Criteria) this;
        }

        public Criteria andAlbumPicsNotBetween(String value1, String value2) {
            addCriterion("album_pics not between", value1, value2, "albumPics");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * ret_product
     * @author hhoa 2022-05-27
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