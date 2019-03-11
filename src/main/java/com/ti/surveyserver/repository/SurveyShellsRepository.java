package com.ti.surveyserver.repository;

import com.ti.surveyserver.model.shell.SurveyShell;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SurveyShellsRepository extends Repository<SurveyShell, String> {

    SurveyShell findOneById(String id);
    SurveyShell save(SurveyShell customer);
    @Query(value = "{'title': ?0}", fields = "{'title':1, 'description': 1}")
    List<SurveyShell> findAllByTitle(String title);


    }
