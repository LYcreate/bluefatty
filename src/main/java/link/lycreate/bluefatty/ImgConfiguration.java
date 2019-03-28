package link.lycreate.bluefatty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;

/**
 * @ClassName ImgConfiguration
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/3/27 1:59
 */
@Configuration
public class ImgConfiguration implements WebMvcConfigurer {
    @Value("${img.location}")
    private String location;
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory=new MultipartConfigFactory();
        long size=2*1024*1024;
        DataSize dataSize=DataSize.ofBytes(size);
        factory.setMaxFileSize(dataSize);
        factory.setMaxRequestSize(dataSize);
        return factory.createMultipartConfig();
    }
}
