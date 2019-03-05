package com.ti.surveyserver.repository;

import com.ti.surveyserver.model.answers.SurveyAnswer;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class MongoDbSurveyAnswersRepository implements SurveyAnswersRepository {

    private final MongoOperations operations;

    public MongoDbSurveyAnswersRepository(MongoOperations operations){
        this.operations = operations;
    }

    @Override
    public SurveyAnswer findOneById(BigInteger id) {
        Query query = query(where("_id").is(id));
        return operations.findOne(query, SurveyAnswer.class);
    }

    @Override
    public SurveyAnswer save(SurveyAnswer item) {
        return operations.save(item);
    }
}
