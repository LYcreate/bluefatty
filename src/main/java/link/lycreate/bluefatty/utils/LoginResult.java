package link.lycreate.bluefatty.utils;


import java.util.Map;

/**
 * @ClassName LoginResult
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/3/27 19:52
 */
public class LoginResult {
    private int code;
    private String description;
    private int userStatus;
    private int userId;
    private int universityId;
    private UserInfo userInfo;
    private Map<String,Object> place;
    private Map<String,Object>type;
    private Map<String,Object> university;

    public LoginResult(int code, String description, int userStatus) {
        this.code = code;
        this.description = description;
        this.userStatus = userStatus;
    }

    public LoginResult(int code, String description, int userStatus, int userId) {
        this.code = code;
        this.description = description;
        this.userStatus = userStatus;
        this.userId = userId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Map<String, Object> getPlace() {
        return place;
    }

    public void setPlace(Map<String, Object> place) {
        this.place = place;
    }

    public Map<String, Object> getType() {
        return type;
    }

    public void setType(Map<String, Object> type) {
        this.type = type;
    }

    public Map<String, Object> getUniversity() {
        return university;
    }

    public void setUniversity(Map<String, Object> university) {
        this.university = university;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "LoginResult{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", userStatus=" + userStatus +
                ", userId=" + userId +
                ", userInfo=" + userInfo +
                ", place=" + place +
                ", type=" + type +
                ", university=" + university +
                '}';
    }
}
