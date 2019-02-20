package com.ti.surveyserver.repository;

import com.ti.surveyserver.model.SurveyShell;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class MongoDbSurveyShellRepository implements SurveyShellRepository {

    private final MongoOperations operations;


    public MongoDbSurveyShellRepository(MongoOperations operations) {
        this.operations = operations;
    }

    @Override
    public SurveyShell findOne(Long id) {
        Query query = query(where("id").is(id));
        return operations.findOne(query, SurveyShell.class);
    }
}
