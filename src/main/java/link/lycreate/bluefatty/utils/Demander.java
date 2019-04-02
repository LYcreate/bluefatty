package link.lycreate.bluefatty.utils;

/**
 * @ClassName Demander
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/4/1 22:59
 */
public class Demander {
    private Integer dmderId;
    private String dmderName;
    private String dmderImg;

    public Demander(Integer dmderId, String dmderName, String dmderImg) {
        this.dmderId = dmderId;
        this.dmderName = dmderName;
        this.dmderImg = dmderImg;
    }

    public Integer getDmderId() {
        return dmderId;
    }

    public void setDmderId(Integer dmderId) {
        this.dmderId = dmderId;
    }

    public String getDmderName() {
        return dmderName;
    }

    public void setDmderName(String dmderName) {
        this.dmderName = dmderName;
    }

    public String getDmderImg() {
        return dmderImg;
    }

    public void setDmderImg(String dmderImg) {
        this.dmderImg = dmderImg;
    }

    @Override
    public String toString() {
        return "Demander{" +
                "dmderId=" + dmderId +
                ", dmderName='" + dmderName + '\'' +
                ", dmderImg='" + dmderImg + '\'' +
                '}';
    }
}
