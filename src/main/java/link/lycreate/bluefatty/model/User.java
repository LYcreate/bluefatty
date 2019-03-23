package link.lycreate.bluefatty.model;

import java.io.Serializable;

/**
 * user
 * @author 
 */
public class User implements Serializable {
    private Integer userId;

    private String userName;

    private String token;

    private Integer studentId;

    private String tel;

    private String gender;

    private String stuname;

    private Integer credit;

    private String openId;

    private String userImg;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (token != null ? !token.equals(user.token) : user.token != null) return false;
        if (studentId != null ? !studentId.equals(user.studentId) : user.studentId != null) return false;
        if (tel != null ? !tel.equals(user.tel) : user.tel != null) return false;
        if (gender != null ? !gender.equals(user.gender) : user.gender != null) return false;
        if (stuname != null ? !stuname.equals(user.stuname) : user.stuname != null) return false;
        if (credit != null ? !credit.equals(user.credit) : user.credit != null) return false;
        if (openId != null ? !openId.equals(user.openId) : user.openId != null) return false;
        return userImg != null ? userImg.equals(user.userImg) : user.userImg == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (studentId != null ? studentId.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (stuname != null ? stuname.hashCode() : 0);
        result = 31 * result + (credit != null ? credit.hashCode() : 0);
        result = 31 * result + (openId != null ? openId.hashCode() : 0);
        result = 31 * result + (userImg != null ? userImg.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", token='" + token + '\'' +
                ", studentId=" + studentId +
                ", tel='" + tel + '\'' +
                ", gender='" + gender + '\'' +
                ", stuname='" + stuname + '\'' +
                ", credit=" + credit +
                ", openId='" + openId + '\'' +
                ", userImg='" + userImg + '\'' +
                '}';
    }
}