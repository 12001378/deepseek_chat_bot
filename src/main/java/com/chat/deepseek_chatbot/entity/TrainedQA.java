package com.chat.deepseek_chatbot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainedQA {
    @Id
    @GeneratedValue
    @JdbcType(VarcharJdbcType.class)
    private UUID t_id;
    private String t_question;
    private String t_answer;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
