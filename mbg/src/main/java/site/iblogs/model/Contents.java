package site.iblogs.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Contents implements Serializable {
    private Integer id;

    private String slug;

    private Date modified;

    private Integer hits;

    private Integer type;

    private Integer status;

    private Integer commentsnum;

    private Boolean allowcomment;

    private Boolean allowping;

    private Boolean allowfeed;

    private Integer authorid;

    private Date created;

    private Boolean deleted;

    private String title;

    private String content;

    private String fmttype;

    private String thumbimg;

    private String tags;

    private String categories;

    private String url;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCommentsnum() {
        return commentsnum;
    }

    public void setCommentsnum(Integer commentsnum) {
        this.commentsnum = commentsnum;
    }

    public Boolean getAllowcomment() {
        return allowcomment;
    }

    public void setAllowcomment(Boolean allowcomment) {
        this.allowcomment = allowcomment;
    }

    public Boolean getAllowping() {
        return allowping;
    }

    public void setAllowping(Boolean allowping) {
        this.allowping = allowping;
    }

    public Boolean getAllowfeed() {
        return allowfeed;
    }

    public void setAllowfeed(Boolean allowfeed) {
        this.allowfeed = allowfeed;
    }

    public Integer getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFmttype() {
        return fmttype;
    }

    public void setFmttype(String fmttype) {
        this.fmttype = fmttype;
    }

    public String getThumbimg() {
        return thumbimg;
    }

    public void setThumbimg(String thumbimg) {
        this.thumbimg = thumbimg;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", slug=").append(slug);
        sb.append(", modified=").append(modified);
        sb.append(", hits=").append(hits);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", commentsnum=").append(commentsnum);
        sb.append(", allowcomment=").append(allowcomment);
        sb.append(", allowping=").append(allowping);
        sb.append(", allowfeed=").append(allowfeed);
        sb.append(", authorid=").append(authorid);
        sb.append(", created=").append(created);
        sb.append(", deleted=").append(deleted);
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", fmttype=").append(fmttype);
        sb.append(", thumbimg=").append(thumbimg);
        sb.append(", tags=").append(tags);
        sb.append(", categories=").append(categories);
        sb.append(", url=").append(url);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}