package link.lycreate.bluefatty.utils;

/**
 * @ClassName StuInfo
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/3/27 23:26
 */
public class StuInfo {
    private String stuName;
    private String stuId;
    private Integer universityId;

    public StuInfo(String stuName, String stuId, Integer universityId) {
        this.stuName = stuName;
        this.stuId = stuId;
        this.universityId = universityId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public Integer getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }

    @Override
    public String toString() {
        return "StuInfo{" +
                "stuName='" + stuName + '\'' +
                ", stuId='" + stuId + '\'' +
                ", universityId=" + universityId +
                '}';
    }
}
