package link.lycreate.bluefatty.utils;

import java.sql.Timestamp;

/**
 * @ClassName DemandResult
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/3/22 15:18
 */
public class DemandResult {
    private Integer dmdId;
    private Timestamp createTime;
    private Timestamp deadline;
    private Integer placeId;
    private Integer typeId;
    private String title;
    private String content;
    private Integer price;
    private Integer dmderId;
    private String dmderName;
    private Integer dmderStar;
    private String dmderImg;

    public DemandResult(Integer dmdId, Timestamp createTime, Timestamp deadline, Integer placeId, Integer typeId, String title, String content, Integer price, Integer dmderId, String dmderName, Integer dmderStar, String dmderImg) {
        this.dmdId = dmdId;
        this.createTime = createTime;
        this.deadline = deadline;
        this.placeId = placeId;
        this.typeId = typeId;
        this.title = title;
        this.content = content;
        this.price = price;
        this.dmderId = dmderId;
        this.dmderName = dmderName;
        this.dmderStar = dmderStar;
        this.dmderImg = dmderImg;
    }

    public Integer getDmdId() {
        return dmdId;
    }

    public void setDmdId(Integer dmdId) {
        this.dmdId = dmdId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public Integer getDmderStar() {
        return dmderStar;
    }

    public void setDmderStar(Integer dmderStar) {
        this.dmderStar = dmderStar;
    }

    public String getDmderImg() {
        return dmderImg;
    }

    public void setDmderImg(String dmderImg) {
        this.dmderImg = dmderImg;
    }

    @Override
    public String toString() {
        return "DemandResult{" +
                "dmdId=" + dmdId +
                ", createTime=" + createTime +
                ", deadline=" + deadline +
                ", placeId=" + placeId +
                ", typeId=" + typeId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", price=" + price +
                ", dmderId=" + dmderId +
                ", dmderName='" + dmderName + '\'' +
                ", dmderStar=" + dmderStar +
                ", dmderImg='" + dmderImg + '\'' +
                '}';
    }
}
