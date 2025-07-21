package wsl.dlokami.test;


import com.alibaba.cloud.ai.dashscope.api.DashScopeApi;
import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatOptions;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

/**
 * @Author: 机智的赛尔
 * @Description： 大模型api调用
 * @DateTime： 2025/7/18 9:44
 **/

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    private static final String DEFAULT_PROMPT = "你好，介绍下你自己吧。";

    @Resource
    private ChatModel chatModel;


    @Test
    public void test_qwen_chat() {

        DashScopeChatOptions customOptions = DashScopeChatOptions.builder()
                .withTopP(0.7)
                .withTopK(50)
                .withTemperature(0.8)
                .withModel(DashScopeApi.ChatModel.QWEN_PLUS.getModel())
                .build();

        String text = chatModel.call(new Prompt(DEFAULT_PROMPT, customOptions)).getResult().getOutput().getText();
        log.info(text);
    }

    @Test
    public void test_qwen_chat_stream() {

        DashScopeChatOptions customOptions = DashScopeChatOptions.builder()
                .withTopP(0.7)
                .withTopK(50)
                .withTemperature(0.8)
                .withModel(DashScopeApi.ChatModel.QWEN_PLUS.getModel())
                .build();

        Flux<ChatResponse> stream = chatModel.stream(new Prompt(DEFAULT_PROMPT,customOptions));
    }



    @Test
    public void test_qwen_embedding() {


    }




}
