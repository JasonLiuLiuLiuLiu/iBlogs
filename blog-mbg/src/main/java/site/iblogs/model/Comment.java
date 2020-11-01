package site.iblogs.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    private Long id;

    private Boolean isauthor;

    private Date created;

    private Boolean deleted;

    private Long cid;

    private String author;

    private Long ownerid;

    private Integer status;

    private Long parent;

    private String mail;

    private String url;

    private String ip;

    private String agent;

    private String content;

    private String type;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsauthor() {
        return isauthor;
    }

    public void setIsauthor(Boolean isauthor) {
        this.isauthor = isauthor;
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

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Long ownerid) {
        this.ownerid = ownerid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", isauthor=").append(isauthor);
        sb.append(", created=").append(created);
        sb.append(", deleted=").append(deleted);
        sb.append(", cid=").append(cid);
        sb.append(", author=").append(author);
        sb.append(", ownerid=").append(ownerid);
        sb.append(", status=").append(status);
        sb.append(", parent=").append(parent);
        sb.append(", mail=").append(mail);
        sb.append(", url=").append(url);
        sb.append(", ip=").append(ip);
        sb.append(", agent=").append(agent);
        sb.append(", content=").append(content);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}