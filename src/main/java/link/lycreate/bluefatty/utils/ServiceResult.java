package link.lycreate.bluefatty.utils;

import java.sql.Timestamp;

/**
 * @ClassName ServiceResult
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/3/24 9:20
 */
public class ServiceResult {
    private Integer ServiceId;
    private Timestamp lowDeadline;
    private Timestamp highDeadline;
    private Integer placeId;
    private Integer typeId;
    private String title;
    private String content;
    private Integer price;
    private Integer servantId;
    private String servantName;
    private Integer servantStar;
    private String servantImg;
    private Integer posterId;
    private String posterName;
    private Integer posterStar;
    private String posterImg;
    private Integer status;
    public ServiceResult(Integer serviceId, Timestamp lowDeadline, Timestamp highDeadline, Integer placeId, Integer typeId, String title, Integer price, Integer servantId, String servantName, Integer servantStar, String servantImg) {
        ServiceId = serviceId;
        this.lowDeadline = lowDeadline;
        this.highDeadline = highDeadline;
        this.placeId = placeId;
        this.typeId = typeId;
        this.title = title;
        this.price = price;
        this.servantId = servantId;
        this.servantName = servantName;
        this.servantStar = servantStar;
        this.servantImg = servantImg;
    }

    public ServiceResult(Integer serviceId, Timestamp highDeadline, Integer placeId, Integer typeId, String title, Integer price, Integer posterId, String posterName, Integer posterStar, String posterImg, Integer status) {
        ServiceId = serviceId;
        this.highDeadline = highDeadline;
        this.placeId = placeId;
        this.typeId = typeId;
        this.title = title;
        this.price = price;
        this.posterId = posterId;
        this.posterName = posterName;
        this.posterStar = posterStar;
        this.posterImg = posterImg;
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getServiceId() {
        return ServiceId;
    }

    public void setServiceId(Integer serviceId) {
        ServiceId = serviceId;
    }

    public Timestamp getLowDeadline() {
        return lowDeadline;
    }

    public void setLowDeadline(Timestamp lowDeadline) {
        this.lowDeadline = lowDeadline;
    }

    public Timestamp getHighDeadline() {
        return highDeadline;
    }

    public void setHighDeadline(Timestamp highDeadline) {
        this.highDeadline = highDeadline;
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

    public Integer getServantStar() {
        return servantStar;
    }

    public void setServantStar(Integer servantStar) {
        this.servantStar = servantStar;
    }

    public String getServantImg() {
        return servantImg;
    }

    public void setServantImg(String servantImg) {
        this.servantImg = servantImg;
    }

    @Override
    public String toString() {
        return "ServiceResult{" +
                "ServiceId=" + ServiceId +
                ", lowDeadline=" + lowDeadline +
                ", highDeadline=" + highDeadline +
                ", placeId=" + placeId +
                ", typeId=" + typeId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", price=" + price +
                ", servantId=" + servantId +
                ", servantName='" + servantName + '\'' +
                ", servantStar=" + servantStar +
                ", servantImg='" + servantImg + '\'' +
                '}';
    }
}
