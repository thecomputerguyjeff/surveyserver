package com.ti.surveyserver;

import com.ti.surveyserver.model.answers.SurveyAnswer;
import com.ti.surveyserver.model.shell.SurveyShell;
import com.ti.surveyserver.repository.MongoDbSurveyAnswersRepository;
import com.ti.surveyserver.repository.MongoDbSurveyShellsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SurveyserverApplicationTests {

	@Autowired
	private MongoDbSurveyShellsRepository mongoDbSurveyShellsRepository;

	@Test
	public void contextLoads() {
		SurveyShell surveyShell = SurveyShell.builder().title("Hi").build();


		SurveyShell saved = mongoDbSurveyShellsRepository.save(surveyShell);
//		SurveyShell retrieved = mongoDbSurveyShellsRepository.findOneByTitle(saved.getTitle());
//		System.out.println(retrieved);



	}

	@Autowired
	private MongoDbSurveyAnswersRepository mongoDbSurveyAnswersRepository;

	@Test
	public void hardcodedAnswersWillSaveToDatabase() {
		SurveyAnswer surveyAnswer = SurveyAnswer.builder().surveySender("Sally").build();
		SurveyAnswer saved = mongoDbSurveyAnswersRepository.save(surveyAnswer);
		SurveyAnswer retrieved = mongoDbSurveyAnswersRepository.findOneById(saved.getId());
		System.out.println(retrieved);

	}

}
