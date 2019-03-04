package com.ti.surveyserver.repository;

import com.ti.surveyserver.model.Answer;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;


@Repository
public class MongoDbSurveyAnswersRepository implements SurveyAnswersRepository{

    private final MongoOperations operations;
    public MongoDbSurveyAnswersRepository(MongoOperations operations ){this.operations=operations;}

    @Override
    public Answer save(Answer answer) {
        return operations.save(answer);
    }
}
