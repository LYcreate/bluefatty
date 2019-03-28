package link.lycreate.bluefatty.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @ClassName ImgUtils
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/3/27 3:00
 */
public class ImgUtils {
    public static String getFilePath(int userId){
        String subPath="user"+userId;
        return subPath;
    }
    public static String saveImg(MultipartFile multipartFile,String path,int userId,String imgType){
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        try{
            FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
            String fileName = imgType+ userId+ ".png";
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + File.separator + fileName));
            byte[] bs = new byte[1024];
            int len;
            while ((len = fileInputStream.read(bs)) != -1) {
                bos.write(bs, 0, len);
            }
            bos.flush();
            bos.close();
            return fileName;} catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
