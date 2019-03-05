package com.ti.surveyserver.model.shell;

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
@Document(collection = "SurveyShells")
public class SurveyShell {

    @Id
    private String id;
    private String author;
    private String title;
    private String description;

    private List<Question> questionList;
    private List<Recipient> recipientList;

}
