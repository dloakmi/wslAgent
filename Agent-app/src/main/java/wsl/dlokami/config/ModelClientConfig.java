package wsl.dlokami.config;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import jakarta.annotation.Resource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 机智的赛尔
 * @Description： 模型配置
 * @DateTime： 2025/7/18 11:03
 **/

@Configuration
@EnableConfigurationProperties(ModelClientConfigProperties.class)
public class ModelClientConfig {

    private final ModelClientConfigProperties config;

    public ModelClientConfig(ModelClientConfigProperties config) {
        this.config = config;
    }
    /**
     * @description: Qwen模型实例
     * @author: 超级机智的赛尔
     * @date: 2025/7/18 11:18
     * @Return: Qwen模型实例
     **/
    @Bean("qwenClient")
    public OpenAIClient QwenClient(){
        return OpenAIOkHttpClient.builder()
                .baseUrl(config.getQwen().getBaseUrl())
                .apiKey(config.getQwen().getApiKey())
                .build();
    }
}
