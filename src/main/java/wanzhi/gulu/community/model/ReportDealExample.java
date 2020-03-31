package wanzhi.gulu.community.model;

import java.util.ArrayList;
import java.util.List;

public class ReportDealExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 22:24:18 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 22:24:18 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 22:24:18 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 22:24:18 CST 2020
     */
    public ReportDealExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 22:24:18 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 22:24:18 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 22:24:18 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 22:24:18 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 22:24:18 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 22:24:18 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 22:24:18 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 22:24:18 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 22:24:18 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 22:24:18 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 22:24:18 CST 2020
     */
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

        public Criteria andTargetIdIsNull() {
            addCriterion("target_id is null");
            return (Criteria) this;
        }

        public Criteria andTargetIdIsNotNull() {
            addCriterion("target_id is not null");
            return (Criteria) this;
        }

        public Criteria andTargetIdEqualTo(Long value) {
            addCriterion("target_id =", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotEqualTo(Long value) {
            addCriterion("target_id <>", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdGreaterThan(Long value) {
            addCriterion("target_id >", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdGreaterThanOrEqualTo(Long value) {
            addCriterion("target_id >=", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdLessThan(Long value) {
            addCriterion("target_id <", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdLessThanOrEqualTo(Long value) {
            addCriterion("target_id <=", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdIn(List<Long> values) {
            addCriterion("target_id in", values, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotIn(List<Long> values) {
            addCriterion("target_id not in", values, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdBetween(Long value1, Long value2) {
            addCriterion("target_id between", value1, value2, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotBetween(Long value1, Long value2) {
            addCriterion("target_id not between", value1, value2, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetTypeIsNull() {
            addCriterion("target_type is null");
            return (Criteria) this;
        }

        public Criteria andTargetTypeIsNotNull() {
            addCriterion("target_type is not null");
            return (Criteria) this;
        }

        public Criteria andTargetTypeEqualTo(Integer value) {
            addCriterion("target_type =", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotEqualTo(Integer value) {
            addCriterion("target_type <>", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeGreaterThan(Integer value) {
            addCriterion("target_type >", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("target_type >=", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeLessThan(Integer value) {
            addCriterion("target_type <", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeLessThanOrEqualTo(Integer value) {
            addCriterion("target_type <=", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeIn(List<Integer> values) {
            addCriterion("target_type in", values, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotIn(List<Integer> values) {
            addCriterion("target_type not in", values, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeBetween(Integer value1, Integer value2) {
            addCriterion("target_type between", value1, value2, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("target_type not between", value1, value2, "targetType");
            return (Criteria) this;
        }

        public Criteria andReportCountIsNull() {
            addCriterion("report_count is null");
            return (Criteria) this;
        }

        public Criteria andReportCountIsNotNull() {
            addCriterion("report_count is not null");
            return (Criteria) this;
        }

        public Criteria andReportCountEqualTo(Long value) {
            addCriterion("report_count =", value, "reportCount");
            return (Criteria) this;
        }

        public Criteria andReportCountNotEqualTo(Long value) {
            addCriterion("report_count <>", value, "reportCount");
            return (Criteria) this;
        }

        public Criteria andReportCountGreaterThan(Long value) {
            addCriterion("report_count >", value, "reportCount");
            return (Criteria) this;
        }

        public Criteria andReportCountGreaterThanOrEqualTo(Long value) {
            addCriterion("report_count >=", value, "reportCount");
            return (Criteria) this;
        }

        public Criteria andReportCountLessThan(Long value) {
            addCriterion("report_count <", value, "reportCount");
            return (Criteria) this;
        }

        public Criteria andReportCountLessThanOrEqualTo(Long value) {
            addCriterion("report_count <=", value, "reportCount");
            return (Criteria) this;
        }

        public Criteria andReportCountIn(List<Long> values) {
            addCriterion("report_count in", values, "reportCount");
            return (Criteria) this;
        }

        public Criteria andReportCountNotIn(List<Long> values) {
            addCriterion("report_count not in", values, "reportCount");
            return (Criteria) this;
        }

        public Criteria andReportCountBetween(Long value1, Long value2) {
            addCriterion("report_count between", value1, value2, "reportCount");
            return (Criteria) this;
        }

        public Criteria andReportCountNotBetween(Long value1, Long value2) {
            addCriterion("report_count not between", value1, value2, "reportCount");
            return (Criteria) this;
        }

        public Criteria andLatestCountIsNull() {
            addCriterion("latest_count is null");
            return (Criteria) this;
        }

        public Criteria andLatestCountIsNotNull() {
            addCriterion("latest_count is not null");
            return (Criteria) this;
        }

        public Criteria andLatestCountEqualTo(Long value) {
            addCriterion("latest_count =", value, "latestCount");
            return (Criteria) this;
        }

        public Criteria andLatestCountNotEqualTo(Long value) {
            addCriterion("latest_count <>", value, "latestCount");
            return (Criteria) this;
        }

        public Criteria andLatestCountGreaterThan(Long value) {
            addCriterion("latest_count >", value, "latestCount");
            return (Criteria) this;
        }

        public Criteria andLatestCountGreaterThanOrEqualTo(Long value) {
            addCriterion("latest_count >=", value, "latestCount");
            return (Criteria) this;
        }

        public Criteria andLatestCountLessThan(Long value) {
            addCriterion("latest_count <", value, "latestCount");
            return (Criteria) this;
        }

        public Criteria andLatestCountLessThanOrEqualTo(Long value) {
            addCriterion("latest_count <=", value, "latestCount");
            return (Criteria) this;
        }

        public Criteria andLatestCountIn(List<Long> values) {
            addCriterion("latest_count in", values, "latestCount");
            return (Criteria) this;
        }

        public Criteria andLatestCountNotIn(List<Long> values) {
            addCriterion("latest_count not in", values, "latestCount");
            return (Criteria) this;
        }

        public Criteria andLatestCountBetween(Long value1, Long value2) {
            addCriterion("latest_count between", value1, value2, "latestCount");
            return (Criteria) this;
        }

        public Criteria andLatestCountNotBetween(Long value1, Long value2) {
            addCriterion("latest_count not between", value1, value2, "latestCount");
            return (Criteria) this;
        }

        public Criteria andBanCountIsNull() {
            addCriterion("ban_count is null");
            return (Criteria) this;
        }

        public Criteria andBanCountIsNotNull() {
            addCriterion("ban_count is not null");
            return (Criteria) this;
        }

        public Criteria andBanCountEqualTo(Long value) {
            addCriterion("ban_count =", value, "banCount");
            return (Criteria) this;
        }

        public Criteria andBanCountNotEqualTo(Long value) {
            addCriterion("ban_count <>", value, "banCount");
            return (Criteria) this;
        }

        public Criteria andBanCountGreaterThan(Long value) {
            addCriterion("ban_count >", value, "banCount");
            return (Criteria) this;
        }

        public Criteria andBanCountGreaterThanOrEqualTo(Long value) {
            addCriterion("ban_count >=", value, "banCount");
            return (Criteria) this;
        }

        public Criteria andBanCountLessThan(Long value) {
            addCriterion("ban_count <", value, "banCount");
            return (Criteria) this;
        }

        public Criteria andBanCountLessThanOrEqualTo(Long value) {
            addCriterion("ban_count <=", value, "banCount");
            return (Criteria) this;
        }

        public Criteria andBanCountIn(List<Long> values) {
            addCriterion("ban_count in", values, "banCount");
            return (Criteria) this;
        }

        public Criteria andBanCountNotIn(List<Long> values) {
            addCriterion("ban_count not in", values, "banCount");
            return (Criteria) this;
        }

        public Criteria andBanCountBetween(Long value1, Long value2) {
            addCriterion("ban_count between", value1, value2, "banCount");
            return (Criteria) this;
        }

        public Criteria andBanCountNotBetween(Long value1, Long value2) {
            addCriterion("ban_count not between", value1, value2, "banCount");
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

        public Criteria andGmtDealIsNull() {
            addCriterion("gmt_deal is null");
            return (Criteria) this;
        }

        public Criteria andGmtDealIsNotNull() {
            addCriterion("gmt_deal is not null");
            return (Criteria) this;
        }

        public Criteria andGmtDealEqualTo(Long value) {
            addCriterion("gmt_deal =", value, "gmtDeal");
            return (Criteria) this;
        }

        public Criteria andGmtDealNotEqualTo(Long value) {
            addCriterion("gmt_deal <>", value, "gmtDeal");
            return (Criteria) this;
        }

        public Criteria andGmtDealGreaterThan(Long value) {
            addCriterion("gmt_deal >", value, "gmtDeal");
            return (Criteria) this;
        }

        public Criteria andGmtDealGreaterThanOrEqualTo(Long value) {
            addCriterion("gmt_deal >=", value, "gmtDeal");
            return (Criteria) this;
        }

        public Criteria andGmtDealLessThan(Long value) {
            addCriterion("gmt_deal <", value, "gmtDeal");
            return (Criteria) this;
        }

        public Criteria andGmtDealLessThanOrEqualTo(Long value) {
            addCriterion("gmt_deal <=", value, "gmtDeal");
            return (Criteria) this;
        }

        public Criteria andGmtDealIn(List<Long> values) {
            addCriterion("gmt_deal in", values, "gmtDeal");
            return (Criteria) this;
        }

        public Criteria andGmtDealNotIn(List<Long> values) {
            addCriterion("gmt_deal not in", values, "gmtDeal");
            return (Criteria) this;
        }

        public Criteria andGmtDealBetween(Long value1, Long value2) {
            addCriterion("gmt_deal between", value1, value2, "gmtDeal");
            return (Criteria) this;
        }

        public Criteria andGmtDealNotBetween(Long value1, Long value2) {
            addCriterion("gmt_deal not between", value1, value2, "gmtDeal");
            return (Criteria) this;
        }

        public Criteria andDealResultIsNull() {
            addCriterion("deal_result is null");
            return (Criteria) this;
        }

        public Criteria andDealResultIsNotNull() {
            addCriterion("deal_result is not null");
            return (Criteria) this;
        }

        public Criteria andDealResultEqualTo(String value) {
            addCriterion("deal_result =", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotEqualTo(String value) {
            addCriterion("deal_result <>", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultGreaterThan(String value) {
            addCriterion("deal_result >", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultGreaterThanOrEqualTo(String value) {
            addCriterion("deal_result >=", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultLessThan(String value) {
            addCriterion("deal_result <", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultLessThanOrEqualTo(String value) {
            addCriterion("deal_result <=", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultLike(String value) {
            addCriterion("deal_result like", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotLike(String value) {
            addCriterion("deal_result not like", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultIn(List<String> values) {
            addCriterion("deal_result in", values, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotIn(List<String> values) {
            addCriterion("deal_result not in", values, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultBetween(String value1, String value2) {
            addCriterion("deal_result between", value1, value2, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotBetween(String value1, String value2) {
            addCriterion("deal_result not between", value1, value2, "dealResult");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table report_deal
     *
     * @mbggenerated do_not_delete_during_merge Tue Mar 31 22:24:18 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table report_deal
     *
     * @mbggenerated Tue Mar 31 22:24:18 CST 2020
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