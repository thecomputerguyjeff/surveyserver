package com.ti.surveyserver.repository;

import com.ti.surveyserver.SurveyserverApplication;
import com.ti.surveyserver.model.shell.SurveyShell;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SurveyserverApplication.class)
public class MongoDbSurveyShellsRepositoryTest {
    @Autowired
    private MongoDbSurveyShellsRepository surveyShellRepository;
    @Test
    public void firstMongoTest(){
        SurveyShell testSurveyShell=surveyShellRepository.findOneById(BigInteger.ONE);

    }


}