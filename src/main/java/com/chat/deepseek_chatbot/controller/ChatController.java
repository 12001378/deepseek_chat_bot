package com.chat.deepseek_chatbot.controller;

import com.chat.deepseek_chatbot.Repository.TrainedQARepository;
import com.chat.deepseek_chatbot.payload.ChatRequest;
import com.chat.deepseek_chatbot.payload.ChatResponse;
import com.chat.deepseek_chatbot.payload.TraningDTO;
import com.chat.deepseek_chatbot.service.DeepSeekService;
import com.chat.deepseek_chatbot.service.TrainedQAService;
import com.chat.deepseek_chatbot.service.TrainedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ChatController {

    @Autowired
    private DeepSeekService deepSeekService;
    @Autowired
    private TrainedService trainedService;
    @Autowired
    private TrainedQARepository trainedQARepository;
    @Autowired
    private TrainedQAService trainedQAService;

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

    @GetMapping("/questions")
    public ResponseEntity<List<ChatRequest>> questions() throws Exception {
        List<ChatRequest> requests = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("what is a class?", "A class is a blueprint for creating objects in Java.");
        map.put("what is an object?", "An object is an instance of a class that contains both data and methods.");
        map.put("what is inheritance?", "Inheritance is a mechanism where one class acquires the properties of another class.");
        map.put("what is polymorphism?", "Polymorphism allows objects to take many forms, typically through method overloading and overriding.");
        map.put("what is encapsulation?", "Encapsulation is the practice of keeping fields private and providing access via public methods.");
        map.put("what is abstraction?", "Abstraction is the process of hiding implementation details and showing only functionality.");
        map.put("what is JVM?", "JVM stands for Java Virtual Machine, which runs Java bytecode.");
        map.put("what is JDK?", "JDK stands for Java Development Kit, which includes tools for developing Java applications.");
        map.put("what is JRE?", "JRE stands for Java Runtime Environment, which provides libraries and JVM to run Java programs.");
        map.put("what is method overloading?", "Method overloading is defining multiple methods with the same name but different parameters.");
        map.put("what is method overriding?", "Method overriding is redefining a superclass method in a subclass.");
        map.put("what is constructor?", "A constructor is a special method used to initialize objects.");
        map.put("what is the difference between == and equals()?", "== compares object references, while equals() compares values.");
        map.put("what is an interface?", "An interface is a reference type with abstract methods that classes can implement.");
        map.put("what is an abstract class?", "An abstract class cannot be instantiated and may contain abstract methods.");

        // Add only questions to the requests list
        for (String question : map.keySet()) {
            requests.add(new ChatRequest(question));
        }
        return ResponseEntity.ok(requests);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody  TraningDTO traningDTO) throws Exception {
        if(!traningDTO.getQuestion().trim().equals("") && !traningDTO.getAnswer().trim().equals("")) {
            trainedQAService.trainQA(traningDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/list")
    public ResponseEntity<List<TraningDTO>> getAllTraningDTO() throws Exception {
        return ResponseEntity.ok(trainedQAService.trainQAList());
    }

}