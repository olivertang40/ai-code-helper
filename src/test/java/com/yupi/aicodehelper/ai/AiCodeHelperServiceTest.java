package com.yupi.aicodehelper.ai;

import com.yupi.aicodehelper.ai.AiCodeHelperService.Report;
import dev.langchain4j.service.Result;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AiCodeHelperServiceTest {

    @Resource
    private AiCodeHelperService aiCodeHelperService;

    @Test
    void chat() {
        String result = aiCodeHelperService.chat("你好,我是程序员yupi");
        System.out.println(result);
    }

    @Test
    void chatWithMemory() {
        String result = aiCodeHelperService.chat("你好,我是程序员yupi");
        System.out.println(result);
        result = aiCodeHelperService.chat("你好，我是谁？");
        System.out.println(result);
    }

    @Test
    void chatForReport() {
        String userMessage = "你好, 我是程序员yupi,学编程两年半, 请帮我制定学习报告";
        Report report = aiCodeHelperService.chatForReport(userMessage);
        System.out.println(report);
    }

    @Test
    void chatWithRag() {
        Result<String> result = aiCodeHelperService.chatWithRag("怎么学习 Java? 有哪些常见的面试题? ");
        System.out.println(result.sources());
        System.out.println(result.content());
    }

    @Test
    void chatWithTools() {
        Result<String> result = aiCodeHelperService.chatWithRag("有哪些常见的计算机网络面试题?");
        System.out.println(result.sources());
        System.out.println(result.content());
    }

    @Test
    void chatWithMcp() {
        Result<String> result = aiCodeHelperService.chatWithRag("有哪些常见的计算机网络面试题?");
        System.out.println(result.sources());
        System.out.println(result.content());
    }
}