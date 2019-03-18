package com.ti.surveyserver.model.answers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties("_________________")

public class SurveyAnswer {
    @Id
    private String id;
    private String shellId;
    private String surveySender;
    private Recipient surveyTaker;
    private List<Answer> userAnswers;
}
