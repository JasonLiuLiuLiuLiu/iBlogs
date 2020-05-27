package site.iblogs.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Contents implements Serializable {
    private Integer id;

    private String title;

    private String slug;

    private Date modified;

    private Integer hits;

    private Integer type;

    private String fmttype;

    private String thumbimg;

    private String tags;

    private String categories;

    private Integer status;

    private Integer commentsnum;

    private Boolean allowcomment;

    private Boolean allowping;

    private Boolean allowfeed;

    private String url;

    private Integer authorid;

    private Date created;

    private Boolean deleted;

    private String content;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " [" +
                "Hash = " + hashCode() +
                ", id=" + id +
                ", title=" + title +
                ", slug=" + slug +
                ", modified=" + modified +
                ", hits=" + hits +
                ", type=" + type +
                ", fmttype=" + fmttype +
                ", thumbimg=" + thumbimg +
                ", tags=" + tags +
                ", categories=" + categories +
                ", status=" + status +
                ", commentsnum=" + commentsnum +
                ", allowcomment=" + allowcomment +
                ", allowping=" + allowping +
                ", allowfeed=" + allowfeed +
                ", url=" + url +
                ", authorid=" + authorid +
                ", created=" + created +
                ", deleted=" + deleted +
                ", content=" + content +
                ", serialVersionUID=" + serialVersionUID +
                "]";
    }
}