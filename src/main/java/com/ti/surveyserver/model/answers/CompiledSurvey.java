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
public class CompiledSurvey {
    private List<CompiledSurveyQuestion> questions = new ArrayList<>();
}