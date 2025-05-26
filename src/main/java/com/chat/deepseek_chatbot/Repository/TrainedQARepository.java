package com.chat.deepseek_chatbot.Repository;

import com.chat.deepseek_chatbot.entity.TrainedQA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrainedQARepository extends JpaRepository<TrainedQA, UUID> {

}
