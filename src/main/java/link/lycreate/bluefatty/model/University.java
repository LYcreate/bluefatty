package link.lycreate.bluefatty.model;

import java.io.Serializable;

/**
 * university
 * @author 
 */
public class University implements Serializable {
    private Integer universityId;

    private String universityName;

    private static final long serialVersionUID = 1L;

    public Integer getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
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
        University other = (University) that;
        return (this.getUniversityId() == null ? other.getUniversityId() == null : this.getUniversityId().equals(other.getUniversityId()))
            && (this.getUniversityName() == null ? other.getUniversityName() == null : this.getUniversityName().equals(other.getUniversityName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUniversityId() == null) ? 0 : getUniversityId().hashCode());
        result = prime * result + ((getUniversityName() == null) ? 0 : getUniversityName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", universityId=").append(universityId);
        sb.append(", universityName=").append(universityName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}