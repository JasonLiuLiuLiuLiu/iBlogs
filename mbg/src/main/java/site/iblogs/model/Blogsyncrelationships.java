package site.iblogs.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Blogsyncrelationships implements Serializable {
    private Integer id;

    private Date created;

    private Boolean deleted;

    private Integer contentid;

    private Integer target;

    private Integer targetpostid;

    private Date syncdata;

    private String message;

    private String extensionproperty;

    private Boolean successful;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getContentid() {
        return contentid;
    }

    public void setContentid(Integer contentid) {
        this.contentid = contentid;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public Integer getTargetpostid() {
        return targetpostid;
    }

    public void setTargetpostid(Integer targetpostid) {
        this.targetpostid = targetpostid;
    }

    public Date getSyncdata() {
        return syncdata;
    }

    public void setSyncdata(Date syncdata) {
        this.syncdata = syncdata;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExtensionproperty() {
        return extensionproperty;
    }

    public void setExtensionproperty(String extensionproperty) {
        this.extensionproperty = extensionproperty;
    }

    public Boolean getSuccessful() {
        return successful;
    }

    public void setSuccessful(Boolean successful) {
        this.successful = successful;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", created=").append(created);
        sb.append(", deleted=").append(deleted);
        sb.append(", contentid=").append(contentid);
        sb.append(", target=").append(target);
        sb.append(", targetpostid=").append(targetpostid);
        sb.append(", syncdata=").append(syncdata);
        sb.append(", message=").append(message);
        sb.append(", extensionproperty=").append(extensionproperty);
        sb.append(", successful=").append(successful);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}