package link.lycreate.bluefatty.utils;

/**
 * @ClassName UserInfo
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/3/27 23:25
 */
public class UserInfo {
    private String userName;
    private String userImg;

    public UserInfo(String userName, String userImg) {
        this.userName = userName;
        this.userImg = userImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", userImg='" + userImg + '\'' +
                '}';
    }
}
