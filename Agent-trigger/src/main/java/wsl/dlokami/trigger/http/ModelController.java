package wsl.dlokami.trigger.http;

import com.openai.client.OpenAIClient;
import com.openai.core.http.StreamResponse;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionChunk;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;
import com.openai.models.responses.ResponseStreamEvent;
import io.reactivex.rxjava3.core.Flowable;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/api/v1/qwen")
@Slf4j
public class ModelController implements IAiService {

    @Resource(name = "qwenClient")
    private OpenAIClient chatClient;

    @RequestMapping(value = "generate",method = RequestMethod.GET)
    @Override
    public ChatCompletion generate(@RequestParam String model, @RequestParam String message) {

        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)
                .addUserMessage(message)
                .build();

        ChatCompletion chatCompletion = chatClient.chat().completions().create(params);
        log.info(chatCompletion.toString());

        return chatCompletion;
    }

    @RequestMapping(value = "generate_stream",method = RequestMethod.GET)
    @Override
    public Flux<ChatCompletionChunk> generateStream(@RequestParam String model, @RequestParam String message) {

        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)
                .addUserMessage(message)
                .build();

        StreamResponse<ChatCompletionChunk> streaming = chatClient.chat().completions().createStreaming(params);
        return Flux.fromStream(streaming.stream()).doFinally(signalType -> streaming.close());


    }
}
