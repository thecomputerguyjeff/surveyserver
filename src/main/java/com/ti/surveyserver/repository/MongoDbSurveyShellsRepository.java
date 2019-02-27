package com.ti.surveyserver.repository;

import com.ti.surveyserver.model.SurveyShell;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class MongoDbSurveyShellsRepository implements SurveyShellsRepository {

    private final MongoOperations operations;


    public MongoDbSurveyShellsRepository(MongoOperations operations) {
        this.operations = operations;
    }

    @Override
    public SurveyShell findOneById(BigInteger id) {
        Query query = query(where("_id").is(id));
        return operations.findOne(query, SurveyShell.class);
    }

    @Override
    public SurveyShell save(SurveyShell item) {
        return operations.save(item);
    }
}
