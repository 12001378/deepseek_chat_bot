package com.chat.deepseek_chatbot.payload;

public class ChatResponse {
    private String answer;

    public ChatResponse() {}

    public ChatResponse(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
