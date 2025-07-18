package wsl.dlokami.config;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author: 机智的赛尔
 * @Description： Qwen模型
 * @DateTime： 2025/7/18 9:25
 **/

@Configuration
@EnableConfigurationProperties(QwenClientConfigProperties.class)
public class QwenClientConfig {

    @Bean("qwenClient")
    public OpenAIClient QwenClient(ConfigurableApplicationContext applicationContext, QwenClientConfigProperties properties) {
        return OpenAIOkHttpClient.builder()
                .apiKey(properties.getApiKey())
                .baseUrl(properties.getBaseUrl())
                .build();
    }

}
