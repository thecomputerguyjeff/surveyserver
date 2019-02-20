package com.ti.surveyserver.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import com.mongodb.client.jndi.MongoClientFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@Configuration
@ComponentScan
@EnableMongoRepositories
public class ApplicationConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "someDB";
    }
    @Override
    public MongoClient mongoClient() {

        MongoClient mongo =  new MongoClient("mongodb+srv://caih330-jn5ns.mongodb.net/");
        mongo.setWriteConcern(WriteConcern.MAJORITY);

        return mongo;
    }
}
