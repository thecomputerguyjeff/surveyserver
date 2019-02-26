package com.ti.surveyserver.config;

import com.mongodb.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
import java.util.stream.Collectors;

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
        MongoCredential credential = MongoCredential.createCredential("CAIH330", getDatabaseName(), "h8dZHqG7bEqXragz".toCharArray());
        ServerAddress serverAddress = new ServerAddress("mongodb+srv://caih330-jn5ns.mongodb.net");
//        MongoClientOptions options = MongoClientOptions.builder()
//                .socketTimeout(socketTimeout)
//                .serverSelectionTimeout(serverSelectTimeout)
//                .connectTimeout(connectTimeout)
//                .requiredReplicaSetName(replicaSet)
//                .writeConcern(WriteConcern.MAJORITY)
//                .build();
        return new MongoClient(serverAddress, credential, null);
    }
}
