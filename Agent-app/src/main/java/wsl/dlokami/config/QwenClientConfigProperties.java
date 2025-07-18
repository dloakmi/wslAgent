package wsl.dlokami.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: 机智的赛尔
 * @Description： qwen模型参数
 * @DateTime： 2025/7/18 10:44
 **/

@Data
@ConfigurationProperties(prefix = "model.qwen", ignoreInvalidFields = true)
public class QwenClientConfigProperties {
    String apiKey;
    String baseUrl;
}
