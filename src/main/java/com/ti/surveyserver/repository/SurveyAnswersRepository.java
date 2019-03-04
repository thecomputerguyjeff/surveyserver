package com.ti.surveyserver.repository;

import com.ti.surveyserver.model.Answer;
import org.springframework.data.repository.Repository;
import java.math.BigInteger;

public interface SurveyAnswersRepository extends Repository<Answer, BigInteger>{
    Answer save(Answer answer);
}
