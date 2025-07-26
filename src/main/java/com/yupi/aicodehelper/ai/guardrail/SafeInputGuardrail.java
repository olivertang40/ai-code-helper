package com.yupi.aicodehelper.ai.guardrail;

import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.guardrail.InputGuardrail;
import dev.langchain4j.guardrail.InputGuardrailResult;

import java.util.Set;

public class SafeInputGuardrail implements InputGuardrail {

    //敏感词集合
    private static final Set<String> sensitiveWords = Set.of("kill", "evil");

    /**
     * 检测用户输入是否安全
     */
    @Override
    public InputGuardrailResult validate(UserMessage userMessage) {
        //获取用户输入并转化小写
        String inputText = userMessage.singleText().toLowerCase();
        // 正则表达式分割输入文本为单词
        String[] words = inputText.split("\\W+");
        for (String word : words) {
            if(sensitiveWords.contains(word)) { // 检查敏感词
                return fatal("Sensitive word detected: " + word);
            }
        }
        return success();
    }
}
