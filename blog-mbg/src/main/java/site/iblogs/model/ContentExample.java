package site.iblogs.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContentExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("Title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("Title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("Title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("Title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("Title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("Title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("Title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("Title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("Title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("Title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("Title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("Title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("Title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("Title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andSlugIsNull() {
            addCriterion("Slug is null");
            return (Criteria) this;
        }

        public Criteria andSlugIsNotNull() {
            addCriterion("Slug is not null");
            return (Criteria) this;
        }

        public Criteria andSlugEqualTo(String value) {
            addCriterion("Slug =", value, "slug");
            return (Criteria) this;
        }

        public Criteria andSlugNotEqualTo(String value) {
            addCriterion("Slug <>", value, "slug");
            return (Criteria) this;
        }

        public Criteria andSlugGreaterThan(String value) {
            addCriterion("Slug >", value, "slug");
            return (Criteria) this;
        }

        public Criteria andSlugGreaterThanOrEqualTo(String value) {
            addCriterion("Slug >=", value, "slug");
            return (Criteria) this;
        }

        public Criteria andSlugLessThan(String value) {
            addCriterion("Slug <", value, "slug");
            return (Criteria) this;
        }

        public Criteria andSlugLessThanOrEqualTo(String value) {
            addCriterion("Slug <=", value, "slug");
            return (Criteria) this;
        }

        public Criteria andSlugLike(String value) {
            addCriterion("Slug like", value, "slug");
            return (Criteria) this;
        }

        public Criteria andSlugNotLike(String value) {
            addCriterion("Slug not like", value, "slug");
            return (Criteria) this;
        }

        public Criteria andSlugIn(List<String> values) {
            addCriterion("Slug in", values, "slug");
            return (Criteria) this;
        }

        public Criteria andSlugNotIn(List<String> values) {
            addCriterion("Slug not in", values, "slug");
            return (Criteria) this;
        }

        public Criteria andSlugBetween(String value1, String value2) {
            addCriterion("Slug between", value1, value2, "slug");
            return (Criteria) this;
        }

        public Criteria andSlugNotBetween(String value1, String value2) {
            addCriterion("Slug not between", value1, value2, "slug");
            return (Criteria) this;
        }

        public Criteria andModifiedIsNull() {
            addCriterion("Modified is null");
            return (Criteria) this;
        }

        public Criteria andModifiedIsNotNull() {
            addCriterion("Modified is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedEqualTo(Date value) {
            addCriterion("Modified =", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotEqualTo(Date value) {
            addCriterion("Modified <>", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedGreaterThan(Date value) {
            addCriterion("Modified >", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("Modified >=", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedLessThan(Date value) {
            addCriterion("Modified <", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedLessThanOrEqualTo(Date value) {
            addCriterion("Modified <=", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedIn(List<Date> values) {
            addCriterion("Modified in", values, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotIn(List<Date> values) {
            addCriterion("Modified not in", values, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedBetween(Date value1, Date value2) {
            addCriterion("Modified between", value1, value2, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotBetween(Date value1, Date value2) {
            addCriterion("Modified not between", value1, value2, "modified");
            return (Criteria) this;
        }

        public Criteria andHitsIsNull() {
            addCriterion("Hits is null");
            return (Criteria) this;
        }

        public Criteria andHitsIsNotNull() {
            addCriterion("Hits is not null");
            return (Criteria) this;
        }

        public Criteria andHitsEqualTo(Integer value) {
            addCriterion("Hits =", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsNotEqualTo(Integer value) {
            addCriterion("Hits <>", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsGreaterThan(Integer value) {
            addCriterion("Hits >", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsGreaterThanOrEqualTo(Integer value) {
            addCriterion("Hits >=", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsLessThan(Integer value) {
            addCriterion("Hits <", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsLessThanOrEqualTo(Integer value) {
            addCriterion("Hits <=", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsIn(List<Integer> values) {
            addCriterion("Hits in", values, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsNotIn(List<Integer> values) {
            addCriterion("Hits not in", values, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsBetween(Integer value1, Integer value2) {
            addCriterion("Hits between", value1, value2, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsNotBetween(Integer value1, Integer value2) {
            addCriterion("Hits not between", value1, value2, "hits");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("Type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("Type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("Type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("Type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("Type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("Type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("Type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("Type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("Type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("Type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("Type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andFmttypeIsNull() {
            addCriterion("FmtType is null");
            return (Criteria) this;
        }

        public Criteria andFmttypeIsNotNull() {
            addCriterion("FmtType is not null");
            return (Criteria) this;
        }

        public Criteria andFmttypeEqualTo(String value) {
            addCriterion("FmtType =", value, "fmttype");
            return (Criteria) this;
        }

        public Criteria andFmttypeNotEqualTo(String value) {
            addCriterion("FmtType <>", value, "fmttype");
            return (Criteria) this;
        }

        public Criteria andFmttypeGreaterThan(String value) {
            addCriterion("FmtType >", value, "fmttype");
            return (Criteria) this;
        }

        public Criteria andFmttypeGreaterThanOrEqualTo(String value) {
            addCriterion("FmtType >=", value, "fmttype");
            return (Criteria) this;
        }

        public Criteria andFmttypeLessThan(String value) {
            addCriterion("FmtType <", value, "fmttype");
            return (Criteria) this;
        }

        public Criteria andFmttypeLessThanOrEqualTo(String value) {
            addCriterion("FmtType <=", value, "fmttype");
            return (Criteria) this;
        }

        public Criteria andFmttypeLike(String value) {
            addCriterion("FmtType like", value, "fmttype");
            return (Criteria) this;
        }

        public Criteria andFmttypeNotLike(String value) {
            addCriterion("FmtType not like", value, "fmttype");
            return (Criteria) this;
        }

        public Criteria andFmttypeIn(List<String> values) {
            addCriterion("FmtType in", values, "fmttype");
            return (Criteria) this;
        }

        public Criteria andFmttypeNotIn(List<String> values) {
            addCriterion("FmtType not in", values, "fmttype");
            return (Criteria) this;
        }

        public Criteria andFmttypeBetween(String value1, String value2) {
            addCriterion("FmtType between", value1, value2, "fmttype");
            return (Criteria) this;
        }

        public Criteria andFmttypeNotBetween(String value1, String value2) {
            addCriterion("FmtType not between", value1, value2, "fmttype");
            return (Criteria) this;
        }

        public Criteria andThumbimgIsNull() {
            addCriterion("ThumbImg is null");
            return (Criteria) this;
        }

        public Criteria andThumbimgIsNotNull() {
            addCriterion("ThumbImg is not null");
            return (Criteria) this;
        }

        public Criteria andThumbimgEqualTo(String value) {
            addCriterion("ThumbImg =", value, "thumbimg");
            return (Criteria) this;
        }

        public Criteria andThumbimgNotEqualTo(String value) {
            addCriterion("ThumbImg <>", value, "thumbimg");
            return (Criteria) this;
        }

        public Criteria andThumbimgGreaterThan(String value) {
            addCriterion("ThumbImg >", value, "thumbimg");
            return (Criteria) this;
        }

        public Criteria andThumbimgGreaterThanOrEqualTo(String value) {
            addCriterion("ThumbImg >=", value, "thumbimg");
            return (Criteria) this;
        }

        public Criteria andThumbimgLessThan(String value) {
            addCriterion("ThumbImg <", value, "thumbimg");
            return (Criteria) this;
        }

        public Criteria andThumbimgLessThanOrEqualTo(String value) {
            addCriterion("ThumbImg <=", value, "thumbimg");
            return (Criteria) this;
        }

        public Criteria andThumbimgLike(String value) {
            addCriterion("ThumbImg like", value, "thumbimg");
            return (Criteria) this;
        }

        public Criteria andThumbimgNotLike(String value) {
            addCriterion("ThumbImg not like", value, "thumbimg");
            return (Criteria) this;
        }

        public Criteria andThumbimgIn(List<String> values) {
            addCriterion("ThumbImg in", values, "thumbimg");
            return (Criteria) this;
        }

        public Criteria andThumbimgNotIn(List<String> values) {
            addCriterion("ThumbImg not in", values, "thumbimg");
            return (Criteria) this;
        }

        public Criteria andThumbimgBetween(String value1, String value2) {
            addCriterion("ThumbImg between", value1, value2, "thumbimg");
            return (Criteria) this;
        }

        public Criteria andThumbimgNotBetween(String value1, String value2) {
            addCriterion("ThumbImg not between", value1, value2, "thumbimg");
            return (Criteria) this;
        }

        public Criteria andTagsIsNull() {
            addCriterion("Tags is null");
            return (Criteria) this;
        }

        public Criteria andTagsIsNotNull() {
            addCriterion("Tags is not null");
            return (Criteria) this;
        }

        public Criteria andTagsEqualTo(String value) {
            addCriterion("Tags =", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotEqualTo(String value) {
            addCriterion("Tags <>", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThan(String value) {
            addCriterion("Tags >", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThanOrEqualTo(String value) {
            addCriterion("Tags >=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThan(String value) {
            addCriterion("Tags <", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThanOrEqualTo(String value) {
            addCriterion("Tags <=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLike(String value) {
            addCriterion("Tags like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotLike(String value) {
            addCriterion("Tags not like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsIn(List<String> values) {
            addCriterion("Tags in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotIn(List<String> values) {
            addCriterion("Tags not in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsBetween(String value1, String value2) {
            addCriterion("Tags between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotBetween(String value1, String value2) {
            addCriterion("Tags not between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("Category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("Category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("Category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("Category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("Category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("Category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("Category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("Category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("Category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("Category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("Category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("Category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("Category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("Category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("Status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("Status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("Status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("Status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("Status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("Status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("Status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("Status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("Status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("Status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("Status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("Status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCommentsnumIsNull() {
            addCriterion("CommentsNum is null");
            return (Criteria) this;
        }

        public Criteria andCommentsnumIsNotNull() {
            addCriterion("CommentsNum is not null");
            return (Criteria) this;
        }

        public Criteria andCommentsnumEqualTo(Integer value) {
            addCriterion("CommentsNum =", value, "commentsnum");
            return (Criteria) this;
        }

        public Criteria andCommentsnumNotEqualTo(Integer value) {
            addCriterion("CommentsNum <>", value, "commentsnum");
            return (Criteria) this;
        }

        public Criteria andCommentsnumGreaterThan(Integer value) {
            addCriterion("CommentsNum >", value, "commentsnum");
            return (Criteria) this;
        }

        public Criteria andCommentsnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("CommentsNum >=", value, "commentsnum");
            return (Criteria) this;
        }

        public Criteria andCommentsnumLessThan(Integer value) {
            addCriterion("CommentsNum <", value, "commentsnum");
            return (Criteria) this;
        }

        public Criteria andCommentsnumLessThanOrEqualTo(Integer value) {
            addCriterion("CommentsNum <=", value, "commentsnum");
            return (Criteria) this;
        }

        public Criteria andCommentsnumIn(List<Integer> values) {
            addCriterion("CommentsNum in", values, "commentsnum");
            return (Criteria) this;
        }

        public Criteria andCommentsnumNotIn(List<Integer> values) {
            addCriterion("CommentsNum not in", values, "commentsnum");
            return (Criteria) this;
        }

        public Criteria andCommentsnumBetween(Integer value1, Integer value2) {
            addCriterion("CommentsNum between", value1, value2, "commentsnum");
            return (Criteria) this;
        }

        public Criteria andCommentsnumNotBetween(Integer value1, Integer value2) {
            addCriterion("CommentsNum not between", value1, value2, "commentsnum");
            return (Criteria) this;
        }

        public Criteria andAllowcommentIsNull() {
            addCriterion("AllowComment is null");
            return (Criteria) this;
        }

        public Criteria andAllowcommentIsNotNull() {
            addCriterion("AllowComment is not null");
            return (Criteria) this;
        }

        public Criteria andAllowcommentEqualTo(Boolean value) {
            addCriterion("AllowComment =", value, "allowcomment");
            return (Criteria) this;
        }

        public Criteria andAllowcommentNotEqualTo(Boolean value) {
            addCriterion("AllowComment <>", value, "allowcomment");
            return (Criteria) this;
        }

        public Criteria andAllowcommentGreaterThan(Boolean value) {
            addCriterion("AllowComment >", value, "allowcomment");
            return (Criteria) this;
        }

        public Criteria andAllowcommentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("AllowComment >=", value, "allowcomment");
            return (Criteria) this;
        }

        public Criteria andAllowcommentLessThan(Boolean value) {
            addCriterion("AllowComment <", value, "allowcomment");
            return (Criteria) this;
        }

        public Criteria andAllowcommentLessThanOrEqualTo(Boolean value) {
            addCriterion("AllowComment <=", value, "allowcomment");
            return (Criteria) this;
        }

        public Criteria andAllowcommentIn(List<Boolean> values) {
            addCriterion("AllowComment in", values, "allowcomment");
            return (Criteria) this;
        }

        public Criteria andAllowcommentNotIn(List<Boolean> values) {
            addCriterion("AllowComment not in", values, "allowcomment");
            return (Criteria) this;
        }

        public Criteria andAllowcommentBetween(Boolean value1, Boolean value2) {
            addCriterion("AllowComment between", value1, value2, "allowcomment");
            return (Criteria) this;
        }

        public Criteria andAllowcommentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("AllowComment not between", value1, value2, "allowcomment");
            return (Criteria) this;
        }

        public Criteria andAllowpingIsNull() {
            addCriterion("AllowPing is null");
            return (Criteria) this;
        }

        public Criteria andAllowpingIsNotNull() {
            addCriterion("AllowPing is not null");
            return (Criteria) this;
        }

        public Criteria andAllowpingEqualTo(Boolean value) {
            addCriterion("AllowPing =", value, "allowping");
            return (Criteria) this;
        }

        public Criteria andAllowpingNotEqualTo(Boolean value) {
            addCriterion("AllowPing <>", value, "allowping");
            return (Criteria) this;
        }

        public Criteria andAllowpingGreaterThan(Boolean value) {
            addCriterion("AllowPing >", value, "allowping");
            return (Criteria) this;
        }

        public Criteria andAllowpingGreaterThanOrEqualTo(Boolean value) {
            addCriterion("AllowPing >=", value, "allowping");
            return (Criteria) this;
        }

        public Criteria andAllowpingLessThan(Boolean value) {
            addCriterion("AllowPing <", value, "allowping");
            return (Criteria) this;
        }

        public Criteria andAllowpingLessThanOrEqualTo(Boolean value) {
            addCriterion("AllowPing <=", value, "allowping");
            return (Criteria) this;
        }

        public Criteria andAllowpingIn(List<Boolean> values) {
            addCriterion("AllowPing in", values, "allowping");
            return (Criteria) this;
        }

        public Criteria andAllowpingNotIn(List<Boolean> values) {
            addCriterion("AllowPing not in", values, "allowping");
            return (Criteria) this;
        }

        public Criteria andAllowpingBetween(Boolean value1, Boolean value2) {
            addCriterion("AllowPing between", value1, value2, "allowping");
            return (Criteria) this;
        }

        public Criteria andAllowpingNotBetween(Boolean value1, Boolean value2) {
            addCriterion("AllowPing not between", value1, value2, "allowping");
            return (Criteria) this;
        }

        public Criteria andAllowfeedIsNull() {
            addCriterion("AllowFeed is null");
            return (Criteria) this;
        }

        public Criteria andAllowfeedIsNotNull() {
            addCriterion("AllowFeed is not null");
            return (Criteria) this;
        }

        public Criteria andAllowfeedEqualTo(Boolean value) {
            addCriterion("AllowFeed =", value, "allowfeed");
            return (Criteria) this;
        }

        public Criteria andAllowfeedNotEqualTo(Boolean value) {
            addCriterion("AllowFeed <>", value, "allowfeed");
            return (Criteria) this;
        }

        public Criteria andAllowfeedGreaterThan(Boolean value) {
            addCriterion("AllowFeed >", value, "allowfeed");
            return (Criteria) this;
        }

        public Criteria andAllowfeedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("AllowFeed >=", value, "allowfeed");
            return (Criteria) this;
        }

        public Criteria andAllowfeedLessThan(Boolean value) {
            addCriterion("AllowFeed <", value, "allowfeed");
            return (Criteria) this;
        }

        public Criteria andAllowfeedLessThanOrEqualTo(Boolean value) {
            addCriterion("AllowFeed <=", value, "allowfeed");
            return (Criteria) this;
        }

        public Criteria andAllowfeedIn(List<Boolean> values) {
            addCriterion("AllowFeed in", values, "allowfeed");
            return (Criteria) this;
        }

        public Criteria andAllowfeedNotIn(List<Boolean> values) {
            addCriterion("AllowFeed not in", values, "allowfeed");
            return (Criteria) this;
        }

        public Criteria andAllowfeedBetween(Boolean value1, Boolean value2) {
            addCriterion("AllowFeed between", value1, value2, "allowfeed");
            return (Criteria) this;
        }

        public Criteria andAllowfeedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("AllowFeed not between", value1, value2, "allowfeed");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("Url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("Url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("Url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("Url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("Url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("Url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("Url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("Url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("Url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("Url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("Url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("Url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("Url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("Url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andAuthoridIsNull() {
            addCriterion("AuthorId is null");
            return (Criteria) this;
        }

        public Criteria andAuthoridIsNotNull() {
            addCriterion("AuthorId is not null");
            return (Criteria) this;
        }

        public Criteria andAuthoridEqualTo(Long value) {
            addCriterion("AuthorId =", value, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridNotEqualTo(Long value) {
            addCriterion("AuthorId <>", value, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridGreaterThan(Long value) {
            addCriterion("AuthorId >", value, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridGreaterThanOrEqualTo(Long value) {
            addCriterion("AuthorId >=", value, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridLessThan(Long value) {
            addCriterion("AuthorId <", value, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridLessThanOrEqualTo(Long value) {
            addCriterion("AuthorId <=", value, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridIn(List<Long> values) {
            addCriterion("AuthorId in", values, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridNotIn(List<Long> values) {
            addCriterion("AuthorId not in", values, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridBetween(Long value1, Long value2) {
            addCriterion("AuthorId between", value1, value2, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridNotBetween(Long value1, Long value2) {
            addCriterion("AuthorId not between", value1, value2, "authorid");
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