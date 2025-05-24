package com.chat.deepseek_chatbot.payload;

public class ChatRequest {
    private String question;

    public ChatRequest(String question) {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
