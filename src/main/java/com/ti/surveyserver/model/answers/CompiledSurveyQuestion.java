package com.ti.surveyserver.model.answers;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CompiledSurveyQuestion {
    String question;
    List<String> allAnswers = new ArrayList<>();
}
