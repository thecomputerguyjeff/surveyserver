package com.ti.surveyserver.repository;

import com.ti.surveyserver.model.SurveyShell;
import org.springframework.data.repository.Repository;

import java.math.BigInteger;

public interface SurveyShellRepository extends Repository<SurveyShell, Long> {
    SurveyShell findOneById(BigInteger id);
//    SurveyShell save(SurveyShell customer);

}
