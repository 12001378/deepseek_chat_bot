package com.chat.deepseek_chatbot.Mapper;

import com.chat.deepseek_chatbot.entity.TrainedQA;
import com.chat.deepseek_chatbot.payload.TraningDTO;

public class TrainedQAMapper {

    public static TraningDTO mapToDTO(TrainedQA trainedQA) {
        TraningDTO dto = new TraningDTO();
            dto.setQuestion(trainedQA.getT_question());
            dto.setAnswer(trainedQA.getT_answer());
            return dto;
    }
}
