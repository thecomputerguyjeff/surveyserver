package com.ti.surveyserver.model.answers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompiledSurveyQuestion {
    private String question;
    private String questionType;
    private List<String> allAnswers;
    private List<String> potentialAnswers;
}