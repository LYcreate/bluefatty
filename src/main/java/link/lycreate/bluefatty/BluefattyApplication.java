package link.lycreate.bluefatty;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BluefattyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BluefattyApplication.class, args);
    }

}
