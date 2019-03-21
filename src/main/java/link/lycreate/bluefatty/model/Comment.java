package link.lycreate.bluefatty.model;

import java.io.Serializable;

/**
 * comment
 * @author 
 */
public class Comment implements Serializable {
    private Integer commentId;

    private Integer star;

    private Integer servantId;

    private Integer dmderId;

    private Integer orderId;

    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getServantId() {
        return servantId;
    }

    public void setServantId(Integer servantId) {
        this.servantId = servantId;
    }

    public Integer getDmderId() {
        return dmderId;
    }

    public void setDmderId(Integer dmderId) {
        this.dmderId = dmderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
        return (this.getCommentId() == null ? other.getCommentId() == null : this.getCommentId().equals(other.getCommentId()))
            && (this.getStar() == null ? other.getStar() == null : this.getStar().equals(other.getStar()))
            && (this.getServantId() == null ? other.getServantId() == null : this.getServantId().equals(other.getServantId()))
            && (this.getDmderId() == null ? other.getDmderId() == null : this.getDmderId().equals(other.getDmderId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCommentId() == null) ? 0 : getCommentId().hashCode());
        result = prime * result + ((getStar() == null) ? 0 : getStar().hashCode());
        result = prime * result + ((getServantId() == null) ? 0 : getServantId().hashCode());
        result = prime * result + ((getDmderId() == null) ? 0 : getDmderId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", commentId=").append(commentId);
        sb.append(", star=").append(star);
        sb.append(", servantId=").append(servantId);
        sb.append(", dmderId=").append(dmderId);
        sb.append(", orderId=").append(orderId);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}