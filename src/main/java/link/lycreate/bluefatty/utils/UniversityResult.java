package link.lycreate.bluefatty.utils;

/**
 * @ClassName UniversityResult
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/3/26 0:22
 */
public class UniversityResult {
    Integer universityId;
    String unsersityName;

    public UniversityResult(Integer universityId, String unsersityName) {
        this.universityId = universityId;
        this.unsersityName = unsersityName;
    }

    public Integer getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }

    public String getUnsersityName() {
        return unsersityName;
    }

    public void setUnsersityName(String unsersityName) {
        this.unsersityName = unsersityName;
    }

    @Override
    public String toString() {
        return "UniversityResult{" +
                "universityId=" + universityId +
                ", unsersityName='" + unsersityName + '\'' +
                '}';
    }
}
