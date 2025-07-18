package wsl.dlokami.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 机智的赛尔
 * @Description： 模型配置必要参数
 * @DateTime： 2025/7/18 11:03
 **/

@Data
@ConfigurationProperties(prefix = "model", ignoreInvalidFields = true)
public class ModelClientConfigProperties {

    private Qwen qwen;

    @Data
    public static class Qwen {
        /** qwen的apikey */
        String apiKey;
        /** qwen官方给定的baseUrl */
        String baseUrl;
    }

}
