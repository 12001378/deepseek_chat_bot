package com.chat.deepseek_chatbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DeepseekChatBotApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DeepseekChatBotApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DeepseekChatBotApplication.class);
    }
}
