package wsl.dlokami.api;

import com.openai.client.OpenAIClient;
import com.openai.core.http.StreamResponse;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionChunk;
import jakarta.annotation.Resource;
import com.openai.models.responses.Response;
import reactor.core.publisher.Flux;

/**
 * @Author: 机智的赛尔
 * @Description： 文本生成接口
 * @DateTime： 2025/7/18 13:26
 **/

public interface IAiService {

    /**
     * @description: 非流式输出
     * @author: 超级机智的赛尔
     * @date: 2025/7/18 13:37
     * @param model 模型名称
     * @param message 消息
     * @Return: 生成文本
     **/
    ChatCompletion generate(String model, String message);

    /**
     * @description: 流式输出
     * @author: 超级机智的赛尔
     * @date: 2025/7/18 13:37
     * @param model 模型名称
     * @param message 消息
     * @Return: 流式文本
     **/
    Flux<ChatCompletionChunk> generateStream(String model, String message);

}
