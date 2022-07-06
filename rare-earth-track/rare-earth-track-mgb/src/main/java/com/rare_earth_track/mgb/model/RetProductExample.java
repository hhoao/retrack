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

        public Criteria andFactoryIdIsNull() {
            addCriterion("factory_id is null");
            return (Criteria) this;
        }

        public Criteria andFactoryIdIsNotNull() {
            addCriterion("factory_id is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryIdEqualTo(Long value) {
            addCriterion("factory_id =", value, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdNotEqualTo(Long value) {
            addCriterion("factory_id <>", value, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdGreaterThan(Long value) {
            addCriterion("factory_id >", value, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("factory_id >=", value, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdLessThan(Long value) {
            addCriterion("factory_id <", value, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdLessThanOrEqualTo(Long value) {
            addCriterion("factory_id <=", value, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdIn(List<Long> values) {
            addCriterion("factory_id in", values, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdNotIn(List<Long> values) {
            addCriterion("factory_id not in", values, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdBetween(Long value1, Long value2) {
            addCriterion("factory_id between", value1, value2, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdNotBetween(Long value1, Long value2) {
            addCriterion("factory_id not between", value1, value2, "factoryId");
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

        public Criteria andFactoryIsNull() {
            addCriterion("factory is null");
            return (Criteria) this;
        }

        public Criteria andFactoryIsNotNull() {
            addCriterion("factory is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryEqualTo(String value) {
            addCriterion("factory =", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryNotEqualTo(String value) {
            addCriterion("factory <>", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryGreaterThan(String value) {
            addCriterion("factory >", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryGreaterThanOrEqualTo(String value) {
            addCriterion("factory >=", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryLessThan(String value) {
            addCriterion("factory <", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryLessThanOrEqualTo(String value) {
            addCriterion("factory <=", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryLike(String value) {
            addCriterion("factory like", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryNotLike(String value) {
            addCriterion("factory not like", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryIn(List<String> values) {
            addCriterion("factory in", values, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryNotIn(List<String> values) {
            addCriterion("factory not in", values, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryBetween(String value1, String value2) {
            addCriterion("factory between", value1, value2, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryNotBetween(String value1, String value2) {
            addCriterion("factory not between", value1, value2, "factory");
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

        public Criteria andQualityCertificateIsNull() {
            addCriterion("quality_certificate is null");
            return (Criteria) this;
        }

        public Criteria andQualityCertificateIsNotNull() {
            addCriterion("quality_certificate is not null");
            return (Criteria) this;
        }

        public Criteria andQualityCertificateEqualTo(String value) {
            addCriterion("quality_certificate =", value, "qualityCertificate");
            return (Criteria) this;
        }

        public Criteria andQualityCertificateNotEqualTo(String value) {
            addCriterion("quality_certificate <>", value, "qualityCertificate");
            return (Criteria) this;
        }

        public Criteria andQualityCertificateGreaterThan(String value) {
            addCriterion("quality_certificate >", value, "qualityCertificate");
            return (Criteria) this;
        }

        public Criteria andQualityCertificateGreaterThanOrEqualTo(String value) {
            addCriterion("quality_certificate >=", value, "qualityCertificate");
            return (Criteria) this;
        }

        public Criteria andQualityCertificateLessThan(String value) {
            addCriterion("quality_certificate <", value, "qualityCertificate");
            return (Criteria) this;
        }

        public Criteria andQualityCertificateLessThanOrEqualTo(String value) {
            addCriterion("quality_certificate <=", value, "qualityCertificate");
            return (Criteria) this;
        }

        public Criteria andQualityCertificateLike(String value) {
            addCriterion("quality_certificate like", value, "qualityCertificate");
            return (Criteria) this;
        }

        public Criteria andQualityCertificateNotLike(String value) {
            addCriterion("quality_certificate not like", value, "qualityCertificate");
            return (Criteria) this;
        }

        public Criteria andQualityCertificateIn(List<String> values) {
            addCriterion("quality_certificate in", values, "qualityCertificate");
            return (Criteria) this;
        }

        public Criteria andQualityCertificateNotIn(List<String> values) {
            addCriterion("quality_certificate not in", values, "qualityCertificate");
            return (Criteria) this;
        }

        public Criteria andQualityCertificateBetween(String value1, String value2) {
            addCriterion("quality_certificate between", value1, value2, "qualityCertificate");
            return (Criteria) this;
        }

        public Criteria andQualityCertificateNotBetween(String value1, String value2) {
            addCriterion("quality_certificate not between", value1, value2, "qualityCertificate");
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

        public Criteria andMiningTechnologyIsNull() {
            addCriterion("mining_technology is null");
            return (Criteria) this;
        }

        public Criteria andMiningTechnologyIsNotNull() {
            addCriterion("mining_technology is not null");
            return (Criteria) this;
        }

        public Criteria andMiningTechnologyEqualTo(String value) {
            addCriterion("mining_technology =", value, "miningTechnology");
            return (Criteria) this;
        }

        public Criteria andMiningTechnologyNotEqualTo(String value) {
            addCriterion("mining_technology <>", value, "miningTechnology");
            return (Criteria) this;
        }

        public Criteria andMiningTechnologyGreaterThan(String value) {
            addCriterion("mining_technology >", value, "miningTechnology");
            return (Criteria) this;
        }

        public Criteria andMiningTechnologyGreaterThanOrEqualTo(String value) {
            addCriterion("mining_technology >=", value, "miningTechnology");
            return (Criteria) this;
        }

        public Criteria andMiningTechnologyLessThan(String value) {
            addCriterion("mining_technology <", value, "miningTechnology");
            return (Criteria) this;
        }

        public Criteria andMiningTechnologyLessThanOrEqualTo(String value) {
            addCriterion("mining_technology <=", value, "miningTechnology");
            return (Criteria) this;
        }

        public Criteria andMiningTechnologyLike(String value) {
            addCriterion("mining_technology like", value, "miningTechnology");
            return (Criteria) this;
        }

        public Criteria andMiningTechnologyNotLike(String value) {
            addCriterion("mining_technology not like", value, "miningTechnology");
            return (Criteria) this;
        }

        public Criteria andMiningTechnologyIn(List<String> values) {
            addCriterion("mining_technology in", values, "miningTechnology");
            return (Criteria) this;
        }

        public Criteria andMiningTechnologyNotIn(List<String> values) {
            addCriterion("mining_technology not in", values, "miningTechnology");
            return (Criteria) this;
        }

        public Criteria andMiningTechnologyBetween(String value1, String value2) {
            addCriterion("mining_technology between", value1, value2, "miningTechnology");
            return (Criteria) this;
        }

        public Criteria andMiningTechnologyNotBetween(String value1, String value2) {
            addCriterion("mining_technology not between", value1, value2, "miningTechnology");
            return (Criteria) this;
        }

        public Criteria andMineIsNull() {
            addCriterion("mine is null");
            return (Criteria) this;
        }

        public Criteria andMineIsNotNull() {
            addCriterion("mine is not null");
            return (Criteria) this;
        }

        public Criteria andMineEqualTo(String value) {
            addCriterion("mine =", value, "mine");
            return (Criteria) this;
        }

        public Criteria andMineNotEqualTo(String value) {
            addCriterion("mine <>", value, "mine");
            return (Criteria) this;
        }

        public Criteria andMineGreaterThan(String value) {
            addCriterion("mine >", value, "mine");
            return (Criteria) this;
        }

        public Criteria andMineGreaterThanOrEqualTo(String value) {
            addCriterion("mine >=", value, "mine");
            return (Criteria) this;
        }

        public Criteria andMineLessThan(String value) {
            addCriterion("mine <", value, "mine");
            return (Criteria) this;
        }

        public Criteria andMineLessThanOrEqualTo(String value) {
            addCriterion("mine <=", value, "mine");
            return (Criteria) this;
        }

        public Criteria andMineLike(String value) {
            addCriterion("mine like", value, "mine");
            return (Criteria) this;
        }

        public Criteria andMineNotLike(String value) {
            addCriterion("mine not like", value, "mine");
            return (Criteria) this;
        }

        public Criteria andMineIn(List<String> values) {
            addCriterion("mine in", values, "mine");
            return (Criteria) this;
        }

        public Criteria andMineNotIn(List<String> values) {
            addCriterion("mine not in", values, "mine");
            return (Criteria) this;
        }

        public Criteria andMineBetween(String value1, String value2) {
            addCriterion("mine between", value1, value2, "mine");
            return (Criteria) this;
        }

        public Criteria andMineNotBetween(String value1, String value2) {
            addCriterion("mine not between", value1, value2, "mine");
            return (Criteria) this;
        }

        public Criteria andSeparateIsNull() {
            addCriterion("separate is null");
            return (Criteria) this;
        }

        public Criteria andSeparateIsNotNull() {
            addCriterion("separate is not null");
            return (Criteria) this;
        }

        public Criteria andSeparateEqualTo(String value) {
            addCriterion("separate =", value, "separate");
            return (Criteria) this;
        }

        public Criteria andSeparateNotEqualTo(String value) {
            addCriterion("separate <>", value, "separate");
            return (Criteria) this;
        }

        public Criteria andSeparateGreaterThan(String value) {
            addCriterion("separate >", value, "separate");
            return (Criteria) this;
        }

        public Criteria andSeparateGreaterThanOrEqualTo(String value) {
            addCriterion("separate >=", value, "separate");
            return (Criteria) this;
        }

        public Criteria andSeparateLessThan(String value) {
            addCriterion("separate <", value, "separate");
            return (Criteria) this;
        }

        public Criteria andSeparateLessThanOrEqualTo(String value) {
            addCriterion("separate <=", value, "separate");
            return (Criteria) this;
        }

        public Criteria andSeparateLike(String value) {
            addCriterion("separate like", value, "separate");
            return (Criteria) this;
        }

        public Criteria andSeparateNotLike(String value) {
            addCriterion("separate not like", value, "separate");
            return (Criteria) this;
        }

        public Criteria andSeparateIn(List<String> values) {
            addCriterion("separate in", values, "separate");
            return (Criteria) this;
        }

        public Criteria andSeparateNotIn(List<String> values) {
            addCriterion("separate not in", values, "separate");
            return (Criteria) this;
        }

        public Criteria andSeparateBetween(String value1, String value2) {
            addCriterion("separate between", value1, value2, "separate");
            return (Criteria) this;
        }

        public Criteria andSeparateNotBetween(String value1, String value2) {
            addCriterion("separate not between", value1, value2, "separate");
            return (Criteria) this;
        }

        public Criteria andOxygenLevelsIsNull() {
            addCriterion("oxygen_levels is null");
            return (Criteria) this;
        }

        public Criteria andOxygenLevelsIsNotNull() {
            addCriterion("oxygen_levels is not null");
            return (Criteria) this;
        }

        public Criteria andOxygenLevelsEqualTo(String value) {
            addCriterion("oxygen_levels =", value, "oxygenLevels");
            return (Criteria) this;
        }

        public Criteria andOxygenLevelsNotEqualTo(String value) {
            addCriterion("oxygen_levels <>", value, "oxygenLevels");
            return (Criteria) this;
        }

        public Criteria andOxygenLevelsGreaterThan(String value) {
            addCriterion("oxygen_levels >", value, "oxygenLevels");
            return (Criteria) this;
        }

        public Criteria andOxygenLevelsGreaterThanOrEqualTo(String value) {
            addCriterion("oxygen_levels >=", value, "oxygenLevels");
            return (Criteria) this;
        }

        public Criteria andOxygenLevelsLessThan(String value) {
            addCriterion("oxygen_levels <", value, "oxygenLevels");
            return (Criteria) this;
        }

        public Criteria andOxygenLevelsLessThanOrEqualTo(String value) {
            addCriterion("oxygen_levels <=", value, "oxygenLevels");
            return (Criteria) this;
        }

        public Criteria andOxygenLevelsLike(String value) {
            addCriterion("oxygen_levels like", value, "oxygenLevels");
            return (Criteria) this;
        }

        public Criteria andOxygenLevelsNotLike(String value) {
            addCriterion("oxygen_levels not like", value, "oxygenLevels");
            return (Criteria) this;
        }

        public Criteria andOxygenLevelsIn(List<String> values) {
            addCriterion("oxygen_levels in", values, "oxygenLevels");
            return (Criteria) this;
        }

        public Criteria andOxygenLevelsNotIn(List<String> values) {
            addCriterion("oxygen_levels not in", values, "oxygenLevels");
            return (Criteria) this;
        }

        public Criteria andOxygenLevelsBetween(String value1, String value2) {
            addCriterion("oxygen_levels between", value1, value2, "oxygenLevels");
            return (Criteria) this;
        }

        public Criteria andOxygenLevelsNotBetween(String value1, String value2) {
            addCriterion("oxygen_levels not between", value1, value2, "oxygenLevels");
            return (Criteria) this;
        }

        public Criteria andPressureIsNull() {
            addCriterion("pressure is null");
            return (Criteria) this;
        }

        public Criteria andPressureIsNotNull() {
            addCriterion("pressure is not null");
            return (Criteria) this;
        }

        public Criteria andPressureEqualTo(String value) {
            addCriterion("pressure =", value, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureNotEqualTo(String value) {
            addCriterion("pressure <>", value, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureGreaterThan(String value) {
            addCriterion("pressure >", value, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureGreaterThanOrEqualTo(String value) {
            addCriterion("pressure >=", value, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureLessThan(String value) {
            addCriterion("pressure <", value, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureLessThanOrEqualTo(String value) {
            addCriterion("pressure <=", value, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureLike(String value) {
            addCriterion("pressure like", value, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureNotLike(String value) {
            addCriterion("pressure not like", value, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureIn(List<String> values) {
            addCriterion("pressure in", values, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureNotIn(List<String> values) {
            addCriterion("pressure not in", values, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureBetween(String value1, String value2) {
            addCriterion("pressure between", value1, value2, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureNotBetween(String value1, String value2) {
            addCriterion("pressure not between", value1, value2, "pressure");
            return (Criteria) this;
        }

        public Criteria andMagneticFieldIsNull() {
            addCriterion("magnetic_field is null");
            return (Criteria) this;
        }

        public Criteria andMagneticFieldIsNotNull() {
            addCriterion("magnetic_field is not null");
            return (Criteria) this;
        }

        public Criteria andMagneticFieldEqualTo(String value) {
            addCriterion("magnetic_field =", value, "magneticField");
            return (Criteria) this;
        }

        public Criteria andMagneticFieldNotEqualTo(String value) {
            addCriterion("magnetic_field <>", value, "magneticField");
            return (Criteria) this;
        }

        public Criteria andMagneticFieldGreaterThan(String value) {
            addCriterion("magnetic_field >", value, "magneticField");
            return (Criteria) this;
        }

        public Criteria andMagneticFieldGreaterThanOrEqualTo(String value) {
            addCriterion("magnetic_field >=", value, "magneticField");
            return (Criteria) this;
        }

        public Criteria andMagneticFieldLessThan(String value) {
            addCriterion("magnetic_field <", value, "magneticField");
            return (Criteria) this;
        }

        public Criteria andMagneticFieldLessThanOrEqualTo(String value) {
            addCriterion("magnetic_field <=", value, "magneticField");
            return (Criteria) this;
        }

        public Criteria andMagneticFieldLike(String value) {
            addCriterion("magnetic_field like", value, "magneticField");
            return (Criteria) this;
        }

        public Criteria andMagneticFieldNotLike(String value) {
            addCriterion("magnetic_field not like", value, "magneticField");
            return (Criteria) this;
        }

        public Criteria andMagneticFieldIn(List<String> values) {
            addCriterion("magnetic_field in", values, "magneticField");
            return (Criteria) this;
        }

        public Criteria andMagneticFieldNotIn(List<String> values) {
            addCriterion("magnetic_field not in", values, "magneticField");
            return (Criteria) this;
        }

        public Criteria andMagneticFieldBetween(String value1, String value2) {
            addCriterion("magnetic_field between", value1, value2, "magneticField");
            return (Criteria) this;
        }

        public Criteria andMagneticFieldNotBetween(String value1, String value2) {
            addCriterion("magnetic_field not between", value1, value2, "magneticField");
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
     * ret_product
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