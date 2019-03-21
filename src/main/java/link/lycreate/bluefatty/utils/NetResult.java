package link.lycreate.bluefatty.utils;

/**
 * @ClassName NetResult
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/3/21 16:35
 */
public class NetResult {
    private int code;
    private String description;

    public NetResult() {
    }

    public NetResult(int code, String description) {
        this.code = code;
        this.description = description;
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

    @Override
    public String toString() {
        return "NetResult{" +
                "code=" + code +
                ", description='" + description + '\'' +
                '}';
    }
}
