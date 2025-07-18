package wsl.dlokami;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 机智的赛尔
 * @Description： 程序启动项
 * @DateTime： 2025/7/17 17:57
 **/

@SpringBootApplication
@Configuration
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
