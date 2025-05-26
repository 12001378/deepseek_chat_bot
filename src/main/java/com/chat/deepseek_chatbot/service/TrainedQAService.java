package com.chat.deepseek_chatbot.service;

import com.chat.deepseek_chatbot.payload.TraningDTO;

import java.util.List;

public interface TrainedQAService {

    public TraningDTO trainQA(TraningDTO traningDTO) throws Exception;

    public List<TraningDTO> trainQAList() throws Exception;
}
