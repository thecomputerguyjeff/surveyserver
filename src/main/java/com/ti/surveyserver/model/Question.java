package com.ti.surveyserver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Question {
    private Integer questionId;
    private String question;
    private String responseType;
    private List<String> responseChoices;


}
