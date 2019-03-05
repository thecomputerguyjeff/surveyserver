package com.ti.surveyserver.model.answers;

import com.ti.surveyserver.model.shell.Recipient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "SurveyAnswers")

public class SurveyAnswer {
    @Id
    private BigInteger id;
    private BigInteger shellId;
    private String surveySender;
    private Recipient surveyTaker;
    private List<Answer> userAnswers;
}
