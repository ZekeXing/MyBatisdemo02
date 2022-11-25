package com.example.mybatisdemo01.entity;

import java.io.Serializable;
import java.util.List;

/**
 * comment
 * @author 
 */
public class Comment implements Serializable {
    /**
     * 评论id
     */
    private Integer cid;

    /**
     * 评论作者
     */
    private String author;

    /**
     * 关联的文章id
     */
    private Integer aid;

    /**
     * 评论内容
     */
    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Comment other = (Comment) that;
        return (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
            && (this.getAid() == null ? other.getAid() == null : this.getAid().equals(other.getAid()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getAid() == null) ? 0 : getAid().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cid=").append(cid);
        sb.append(", author=").append(author);
        sb.append(", aid=").append(aid);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}