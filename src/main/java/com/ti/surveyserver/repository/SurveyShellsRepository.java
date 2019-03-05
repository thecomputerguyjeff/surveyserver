package com.ti.surveyserver.repository;

import com.ti.surveyserver.model.shell.SurveyShell;
import org.springframework.data.repository.Repository;

import java.math.BigInteger;

public interface SurveyShellsRepository extends Repository<SurveyShell, BigInteger> {
    SurveyShell findOneById(BigInteger id);
    SurveyShell save(SurveyShell customer);

}
