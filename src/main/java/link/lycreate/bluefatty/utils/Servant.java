package link.lycreate.bluefatty.utils;

/**
 * @ClassName Servant
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/4/1 23:00
 */
public class Servant {
    private Integer servantId;
    private String servantName;
    private String servantImg;

    public Servant(Integer servantId, String servantName, String servantImg) {
        this.servantId = servantId;
        this.servantName = servantName;
        this.servantImg = servantImg;
    }

    public Integer getServantId() {
        return servantId;
    }

    public void setServantId(Integer servantId) {
        this.servantId = servantId;
    }

    public String getServantName() {
        return servantName;
    }

    public void setServantName(String servantName) {
        this.servantName = servantName;
    }

    public String getServantImg() {
        return servantImg;
    }

    public void setServantImg(String servantImg) {
        this.servantImg = servantImg;
    }

    @Override
    public String toString() {
        return "Servant{" +
                "servantId=" + servantId +
                ", servantName='" + servantName + '\'' +
                ", servantImg='" + servantImg + '\'' +
                '}';
    }
}
