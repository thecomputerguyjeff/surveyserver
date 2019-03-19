package com.ti.surveyserver.repository;

import com.ti.surveyserver.model.answers.SurveyAnswer;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SurveyAnswersRepository extends Repository<SurveyAnswer, String> {
    SurveyAnswer save(SurveyAnswer item);
    SurveyAnswer findOneById(String id);
    List<SurveyAnswer> findAllByShellId(String id);
}
