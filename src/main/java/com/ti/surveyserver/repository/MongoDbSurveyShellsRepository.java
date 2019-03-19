package com.ti.surveyserver.repository;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mongodb.BasicDBObject;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.ti.surveyserver.model.answers.SurveyAnswer;
import com.mongodb.BasicDBObject;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.ti.surveyserver.model.answers.SurveyAnswer;
import com.ti.surveyserver.model.shell.SurveyShell;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.query.*;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class MongoDbSurveyShellsRepository implements SurveyShellsRepository {


    private final MongoOperations operations;

    public MongoDbSurveyShellsRepository(MongoOperations operations) {
        this.operations = operations;
    }

    @Override
    public SurveyShell findOneById(String id) {
        Query query = query(where("_id").is(id));
        return operations.findOne(query, SurveyShell.class);
    }

    //We want this to find all
    //@org.springframework.data.mongodb.repository.Query(value = "{'title': ?0}", fields = "{'title':1, 'description': 1}")

    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<SurveyShell> findAllByTitle(String title) {
//        List<Bson> queryFilters = new ArrayList<>();
//        queryFilters.add(Filters.eq("title", 1));
//        queryFilters.add(Filters.eq("description", 1));

        Query querySpecific = query(where("title").regex(title,"i"));//it finds all that have those exact letters in the answer
        querySpecific.with(new Sort(Sort.Direction.ASC, "title"));//then it sorts the not exact ones by title

        querySpecific.fields().include("title").include("description");


        //Projections.include("title", "description");
        return operations.find(querySpecific, SurveyShell.class);

    }

    @Override
    public List<SurveyShell> findAllByAuthor(String author) {
//        List<Bson> queryFilters = new ArrayList<>();
//        queryFilters.add(Filters.eq("title", 1));
//        queryFilters.add(Filters.eq("description", 1));

        Query querySpecific = new Query();
        querySpecific = query(where("author").is(author));
        querySpecific.fields().include("title").include("description");

        //Projections.include("title", "description");
        return operations.find(querySpecific, SurveyShell.class);
    }

    @Override
    public SurveyShell save(SurveyShell item) {
        return operations.save(item);
    }
}
