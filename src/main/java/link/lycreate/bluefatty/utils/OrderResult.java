package link.lycreate.bluefatty.utils;

import java.sql.Timestamp;

/**
 * @ClassName OrderResult
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/4/1 0:27
 */
public class OrderResult {
    private Integer orderId;
    private Timestamp deadline;
    private Integer placeId;
    private Integer typeId;
    private String title;
    private Integer price;
    private Integer posterId;
    private String posterName;
    private Integer posterStar;
    private String posterImg;
    private Integer status;

    public OrderResult(Integer orderId, Timestamp deadline, Integer placeId, Integer typeId, String title, Integer price, Integer posterId, String posterName, Integer posterStar, String posterImg, Integer status) {
        this.orderId = orderId;
        this.deadline = deadline;
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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPosterId() {
        return posterId;
    }

    public void setPosterId(Integer posterId) {
        this.posterId = posterId;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public Integer getPosterStar() {
        return posterStar;
    }

    public void setPosterStar(Integer posterStar) {
        this.posterStar = posterStar;
    }

    public String getPosterImg() {
        return posterImg;
    }

    public void setPosterImg(String posterImg) {
        this.posterImg = posterImg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderResult{" +
                "orderId=" + orderId +
                ", deadline=" + deadline +
                ", placeId=" + placeId +
                ", typeId=" + typeId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", posterId=" + posterId +
                ", posterName='" + posterName + '\'' +
                ", posterStar=" + posterStar +
                ", posterImg='" + posterImg + '\'' +
                ", status=" + status +
                '}';
    }
}
