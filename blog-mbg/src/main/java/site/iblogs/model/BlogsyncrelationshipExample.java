package site.iblogs.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogsyncrelationshipExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogsyncrelationshipExample() {
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
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("Created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("Created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("Created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("Created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("Created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("Created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("Created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("Created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("Created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("Created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("Created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("Created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("Deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("Deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Boolean value) {
            addCriterion("Deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Boolean value) {
            addCriterion("Deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Boolean value) {
            addCriterion("Deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("Deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Boolean value) {
            addCriterion("Deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("Deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Boolean> values) {
            addCriterion("Deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Boolean> values) {
            addCriterion("Deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("Deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("Deleted not between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andContentidIsNull() {
            addCriterion("ContentId is null");
            return (Criteria) this;
        }

        public Criteria andContentidIsNotNull() {
            addCriterion("ContentId is not null");
            return (Criteria) this;
        }

        public Criteria andContentidEqualTo(Long value) {
            addCriterion("ContentId =", value, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidNotEqualTo(Long value) {
            addCriterion("ContentId <>", value, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidGreaterThan(Long value) {
            addCriterion("ContentId >", value, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidGreaterThanOrEqualTo(Long value) {
            addCriterion("ContentId >=", value, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidLessThan(Long value) {
            addCriterion("ContentId <", value, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidLessThanOrEqualTo(Long value) {
            addCriterion("ContentId <=", value, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidIn(List<Long> values) {
            addCriterion("ContentId in", values, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidNotIn(List<Long> values) {
            addCriterion("ContentId not in", values, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidBetween(Long value1, Long value2) {
            addCriterion("ContentId between", value1, value2, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidNotBetween(Long value1, Long value2) {
            addCriterion("ContentId not between", value1, value2, "contentid");
            return (Criteria) this;
        }

        public Criteria andTargetIsNull() {
            addCriterion("Target is null");
            return (Criteria) this;
        }

        public Criteria andTargetIsNotNull() {
            addCriterion("Target is not null");
            return (Criteria) this;
        }

        public Criteria andTargetEqualTo(Integer value) {
            addCriterion("Target =", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotEqualTo(Integer value) {
            addCriterion("Target <>", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetGreaterThan(Integer value) {
            addCriterion("Target >", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetGreaterThanOrEqualTo(Integer value) {
            addCriterion("Target >=", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLessThan(Integer value) {
            addCriterion("Target <", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLessThanOrEqualTo(Integer value) {
            addCriterion("Target <=", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetIn(List<Integer> values) {
            addCriterion("Target in", values, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotIn(List<Integer> values) {
            addCriterion("Target not in", values, "target");
            return (Criteria) this;
        }

        public Criteria andTargetBetween(Integer value1, Integer value2) {
            addCriterion("Target between", value1, value2, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotBetween(Integer value1, Integer value2) {
            addCriterion("Target not between", value1, value2, "target");
            return (Criteria) this;
        }

        public Criteria andTargetpostidIsNull() {
            addCriterion("TargetPostId is null");
            return (Criteria) this;
        }

        public Criteria andTargetpostidIsNotNull() {
            addCriterion("TargetPostId is not null");
            return (Criteria) this;
        }

        public Criteria andTargetpostidEqualTo(Integer value) {
            addCriterion("TargetPostId =", value, "targetpostid");
            return (Criteria) this;
        }

        public Criteria andTargetpostidNotEqualTo(Integer value) {
            addCriterion("TargetPostId <>", value, "targetpostid");
            return (Criteria) this;
        }

        public Criteria andTargetpostidGreaterThan(Integer value) {
            addCriterion("TargetPostId >", value, "targetpostid");
            return (Criteria) this;
        }

        public Criteria andTargetpostidGreaterThanOrEqualTo(Integer value) {
            addCriterion("TargetPostId >=", value, "targetpostid");
            return (Criteria) this;
        }

        public Criteria andTargetpostidLessThan(Integer value) {
            addCriterion("TargetPostId <", value, "targetpostid");
            return (Criteria) this;
        }

        public Criteria andTargetpostidLessThanOrEqualTo(Integer value) {
            addCriterion("TargetPostId <=", value, "targetpostid");
            return (Criteria) this;
        }

        public Criteria andTargetpostidIn(List<Integer> values) {
            addCriterion("TargetPostId in", values, "targetpostid");
            return (Criteria) this;
        }

        public Criteria andTargetpostidNotIn(List<Integer> values) {
            addCriterion("TargetPostId not in", values, "targetpostid");
            return (Criteria) this;
        }

        public Criteria andTargetpostidBetween(Integer value1, Integer value2) {
            addCriterion("TargetPostId between", value1, value2, "targetpostid");
            return (Criteria) this;
        }

        public Criteria andTargetpostidNotBetween(Integer value1, Integer value2) {
            addCriterion("TargetPostId not between", value1, value2, "targetpostid");
            return (Criteria) this;
        }

        public Criteria andSyncdataIsNull() {
            addCriterion("SyncData is null");
            return (Criteria) this;
        }

        public Criteria andSyncdataIsNotNull() {
            addCriterion("SyncData is not null");
            return (Criteria) this;
        }

        public Criteria andSyncdataEqualTo(Date value) {
            addCriterion("SyncData =", value, "syncdata");
            return (Criteria) this;
        }

        public Criteria andSyncdataNotEqualTo(Date value) {
            addCriterion("SyncData <>", value, "syncdata");
            return (Criteria) this;
        }

        public Criteria andSyncdataGreaterThan(Date value) {
            addCriterion("SyncData >", value, "syncdata");
            return (Criteria) this;
        }

        public Criteria andSyncdataGreaterThanOrEqualTo(Date value) {
            addCriterion("SyncData >=", value, "syncdata");
            return (Criteria) this;
        }

        public Criteria andSyncdataLessThan(Date value) {
            addCriterion("SyncData <", value, "syncdata");
            return (Criteria) this;
        }

        public Criteria andSyncdataLessThanOrEqualTo(Date value) {
            addCriterion("SyncData <=", value, "syncdata");
            return (Criteria) this;
        }

        public Criteria andSyncdataIn(List<Date> values) {
            addCriterion("SyncData in", values, "syncdata");
            return (Criteria) this;
        }

        public Criteria andSyncdataNotIn(List<Date> values) {
            addCriterion("SyncData not in", values, "syncdata");
            return (Criteria) this;
        }

        public Criteria andSyncdataBetween(Date value1, Date value2) {
            addCriterion("SyncData between", value1, value2, "syncdata");
            return (Criteria) this;
        }

        public Criteria andSyncdataNotBetween(Date value1, Date value2) {
            addCriterion("SyncData not between", value1, value2, "syncdata");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("Message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("Message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("Message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("Message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("Message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("Message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("Message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("Message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("Message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("Message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("Message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("Message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("Message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("Message not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andExtensionpropertyIsNull() {
            addCriterion("ExtensionProperty is null");
            return (Criteria) this;
        }

        public Criteria andExtensionpropertyIsNotNull() {
            addCriterion("ExtensionProperty is not null");
            return (Criteria) this;
        }

        public Criteria andExtensionpropertyEqualTo(String value) {
            addCriterion("ExtensionProperty =", value, "extensionproperty");
            return (Criteria) this;
        }

        public Criteria andExtensionpropertyNotEqualTo(String value) {
            addCriterion("ExtensionProperty <>", value, "extensionproperty");
            return (Criteria) this;
        }

        public Criteria andExtensionpropertyGreaterThan(String value) {
            addCriterion("ExtensionProperty >", value, "extensionproperty");
            return (Criteria) this;
        }

        public Criteria andExtensionpropertyGreaterThanOrEqualTo(String value) {
            addCriterion("ExtensionProperty >=", value, "extensionproperty");
            return (Criteria) this;
        }

        public Criteria andExtensionpropertyLessThan(String value) {
            addCriterion("ExtensionProperty <", value, "extensionproperty");
            return (Criteria) this;
        }

        public Criteria andExtensionpropertyLessThanOrEqualTo(String value) {
            addCriterion("ExtensionProperty <=", value, "extensionproperty");
            return (Criteria) this;
        }

        public Criteria andExtensionpropertyLike(String value) {
            addCriterion("ExtensionProperty like", value, "extensionproperty");
            return (Criteria) this;
        }

        public Criteria andExtensionpropertyNotLike(String value) {
            addCriterion("ExtensionProperty not like", value, "extensionproperty");
            return (Criteria) this;
        }

        public Criteria andExtensionpropertyIn(List<String> values) {
            addCriterion("ExtensionProperty in", values, "extensionproperty");
            return (Criteria) this;
        }

        public Criteria andExtensionpropertyNotIn(List<String> values) {
            addCriterion("ExtensionProperty not in", values, "extensionproperty");
            return (Criteria) this;
        }

        public Criteria andExtensionpropertyBetween(String value1, String value2) {
            addCriterion("ExtensionProperty between", value1, value2, "extensionproperty");
            return (Criteria) this;
        }

        public Criteria andExtensionpropertyNotBetween(String value1, String value2) {
            addCriterion("ExtensionProperty not between", value1, value2, "extensionproperty");
            return (Criteria) this;
        }

        public Criteria andSuccessfulIsNull() {
            addCriterion("Successful is null");
            return (Criteria) this;
        }

        public Criteria andSuccessfulIsNotNull() {
            addCriterion("Successful is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessfulEqualTo(Boolean value) {
            addCriterion("Successful =", value, "successful");
            return (Criteria) this;
        }

        public Criteria andSuccessfulNotEqualTo(Boolean value) {
            addCriterion("Successful <>", value, "successful");
            return (Criteria) this;
        }

        public Criteria andSuccessfulGreaterThan(Boolean value) {
            addCriterion("Successful >", value, "successful");
            return (Criteria) this;
        }

        public Criteria andSuccessfulGreaterThanOrEqualTo(Boolean value) {
            addCriterion("Successful >=", value, "successful");
            return (Criteria) this;
        }

        public Criteria andSuccessfulLessThan(Boolean value) {
            addCriterion("Successful <", value, "successful");
            return (Criteria) this;
        }

        public Criteria andSuccessfulLessThanOrEqualTo(Boolean value) {
            addCriterion("Successful <=", value, "successful");
            return (Criteria) this;
        }

        public Criteria andSuccessfulIn(List<Boolean> values) {
            addCriterion("Successful in", values, "successful");
            return (Criteria) this;
        }

        public Criteria andSuccessfulNotIn(List<Boolean> values) {
            addCriterion("Successful not in", values, "successful");
            return (Criteria) this;
        }

        public Criteria andSuccessfulBetween(Boolean value1, Boolean value2) {
            addCriterion("Successful between", value1, value2, "successful");
            return (Criteria) this;
        }

        public Criteria andSuccessfulNotBetween(Boolean value1, Boolean value2) {
            addCriterion("Successful not between", value1, value2, "successful");
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