package com.ti.surveyserver.repository;

import com.ti.surveyserver.model.shell.SurveyShell;
import org.springframework.data.repository.Repository;

public interface SurveyShellsRepository extends Repository<SurveyShell, String> {
    SurveyShell findOneById(String id);
    SurveyShell save(SurveyShell customer);

}
