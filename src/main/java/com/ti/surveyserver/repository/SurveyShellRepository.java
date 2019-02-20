package com.ti.surveyserver.repository;

import com.ti.surveyserver.model.SurveyShell;
import org.springframework.data.repository.Repository;

public interface SurveyShellRepository extends Repository<SurveyShell, Long> {
    SurveyShell findOne(Long id);
    SurveyShell save(SurveyShell customer);

}
