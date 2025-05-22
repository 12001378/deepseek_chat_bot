package com.chat.deepseek_chatbot.service;

import com.chat.deepseek_chatbot.payload.ChatResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@Service
public class DeepSeekService {

    private static final String API_KEY = "sk-d0b754bf463242aea98924c7e5ff9b46";
    private static final String ENDPOINT = "https://api.deepseek.com/v1/chat/completions";

    private final ObjectMapper objectMapper = new ObjectMapper();

    public ChatResponse askDeepSeek(String userQuestion) {
        try {
            String requestJson = """
                {
                  "model": "deepseek-chat",
                  "messages": [
                    { "role": "system", "content": "You are a helpful assistant." },
                    { "role": "user", "content": "%s" }
                  ]
                }
            """.formatted(userQuestion);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(ENDPOINT))
                    .header("Authorization", "Bearer " + API_KEY)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestJson, StandardCharsets.UTF_8))
                    .build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("DeepSeek response: " + response.body());

            JsonNode root = objectMapper.readTree(response.body());

            JsonNode choicesNode = root.path("choices");
            if (choicesNode.isArray() && choicesNode.size() > 0) {
                JsonNode messageNode = choicesNode.get(0).path("message").path("content");
                if (!messageNode.isMissingNode()) {
                    return new ChatResponse(messageNode.asText().trim());
                }
            }
            return new ChatResponse("No valid response received from DeepSeek.");

        } catch (Exception e) {
            e.printStackTrace();
            return new ChatResponse("Error communicating with DeepSeek API: " + e.getMessage());
        }
    }
}
