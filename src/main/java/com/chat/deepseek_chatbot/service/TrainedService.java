package com.chat.deepseek_chatbot.service;

import com.chat.deepseek_chatbot.payload.ChatRequest;
import com.chat.deepseek_chatbot.payload.ChatResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TrainedService {
    public ChatResponse preTrainedQuestions(ChatRequest chatRequest){
        Map<String,String> map = new HashMap<String,String>();
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
        ChatResponse response = new ChatResponse();
        if(map.containsKey(chatRequest.getQuestion())){
            response.setAnswer(map.get(chatRequest.getQuestion()));
        }

        return response;

    }
}
