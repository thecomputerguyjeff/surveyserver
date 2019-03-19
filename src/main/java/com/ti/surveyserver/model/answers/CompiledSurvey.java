package com.ti.surveyserver.model.answers;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class CompiledSurvey {
    List<CompiledSurveyQuestion> questions = new ArrayList<>();
}
