package com.ti.surveyserver.repository;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.mongodb.BasicDBObject;
import com.ti.surveyserver.model.shell.SurveyShell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import java.util.List;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.util.ClassTypeInformation.COLLECTION;

@Repository
public class MongoDbSurveyShellsRepository implements SurveyShellsRepository {

    @Autowired
    MongoConverter mongoConverter;

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

        Query querySpecific = new Query();
        querySpecific = query(where("title").is("*"+title+"*"));
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

        if(operations.find(query(where("id").is(item.getId())).limit(1), SurveyShell.class)!= null) {
            Query query = new Query(new Criteria("id").is(item.getId()));
            Update update = new Update();
            if (item.getAuthor()!=null){
                update.set("author", item.getAuthor());
            }
            if (item.getTitle()!=null){
                update.set("title", item.getTitle());
            }
            if (item.getDescription()!=null){
                update.set("description", item.getDescription());
            }
            if (item.getQuestionList()!=null){
                update.set("questionList", item.getQuestionList());
            }
            if (item.getRecipientList()!=null){
                update.set("recipientList", item.getRecipientList());
            }
            operations.updateFirst(query, update, SurveyShell.class);
            return item;
        }
//        BasicDBObject basicDBObject = new BasicDBObject();
//        mongoConverter.write(item, basicDBObject);


        return operations.save(item);
    }

    public SurveyShell updateShell(SurveyShell surveyShell) {
        return null;
    }
}