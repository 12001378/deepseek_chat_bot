package com.chat.deepseek_chatbot.controller;

import com.chat.deepseek_chatbot.payload.ChatRequest;
import com.chat.deepseek_chatbot.payload.ChatResponse;
import com.chat.deepseek_chatbot.service.DeepSeekService;
import com.chat.deepseek_chatbot.service.TrainedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ChatController {

    @Autowired
    private DeepSeekService deepSeekService;
    @Autowired
    private TrainedService trainedService;

    @GetMapping("/")
    public String resp() {
        return "chat Home";
    }

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest chatRequest) throws Exception {

        ChatResponse response = trainedService.preTrainedQuestions(chatRequest);

        if(response.getAnswer() != null){
            return response;
        }
        return deepSeekService.askDeepSeek(chatRequest.getQuestion()+" in google");
    }
}