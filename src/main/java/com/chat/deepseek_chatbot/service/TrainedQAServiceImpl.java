package com.chat.deepseek_chatbot.service;

import com.chat.deepseek_chatbot.Mapper.TrainedQAMapper;
import com.chat.deepseek_chatbot.Repository.TrainedQARepository;
import com.chat.deepseek_chatbot.entity.TrainedQA;
import com.chat.deepseek_chatbot.payload.TraningDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrainedQAServiceImpl implements TrainedQAService {

    private final TrainedQARepository trainedQARepository;

    @Override
    public TraningDTO trainQA(TraningDTO traningDTO) throws Exception {
        TrainedQA trainedQA = new TrainedQA();
        trainedQA.setT_question(traningDTO.getQuestion());
        trainedQA.setT_answer(traningDTO.getAnswer());
        trainedQA.setCreated_at(LocalDateTime.now());
        trainedQA.setUpdated_at(LocalDateTime.now());

        trainedQARepository.save(trainedQA);

        return TrainedQAMapper.mapToDTO(trainedQA);
    }

    @Override
    public List<TraningDTO> trainQAList() throws Exception {

        List<TrainedQA> trainedQA = trainedQARepository.findAll();
        List<TraningDTO> dto_list = trainedQA.stream().map(trainedQA1 -> {
            return TrainedQAMapper.mapToDTO(trainedQA1);
        }).collect(Collectors.toList());

        return dto_list;
    }
}
