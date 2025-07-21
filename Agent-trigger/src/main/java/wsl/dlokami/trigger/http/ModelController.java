package wsl.dlokami.trigger.http;


import com.alibaba.cloud.ai.dashscope.api.DashScopeAgentApi;
import com.alibaba.cloud.ai.dashscope.api.DashScopeApi;
import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import wsl.dlokami.api.IAiService;

/**
 * @Author: 机智的赛尔
 * @Description： ****
 * @DateTime： 2025/7/18 14:05
 **/

@RestController()
@CrossOrigin("*")
@RequestMapping("/api/v1/chat")
@Slf4j
public class ModelController implements IAiService {

    private final ChatModel chatModel;

    public ModelController(ChatModel chatModel) {
        this.chatModel = chatModel;
    }


    @RequestMapping(value = "generate",method = RequestMethod.GET)
    @Override
    public ChatResponse generate(@RequestParam String model, @RequestParam String message) {


        DashScopeChatOptions customOptions = DashScopeChatOptions.builder()
                .withTopP(0.7)
                .withTopK(50)
                .withTemperature(0.8)
                .withModel(model)
                .build();

        return chatModel.call(new Prompt(message, customOptions));
    }

    @RequestMapping(value = "generate_stream",method = RequestMethod.GET)
    @Override
    public Flux<ChatResponse> generateStream(@RequestParam String model, @RequestParam String message) {

        DashScopeChatOptions customOptions = DashScopeChatOptions.builder()
                .withTopP(0.7)
                .withTopK(50)
                .withTemperature(0.8)
                .withModel(model)
                .build();

        return chatModel.stream(new Prompt(message,customOptions));
    }
}
