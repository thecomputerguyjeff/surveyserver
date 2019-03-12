package com.ti.surveyserver.model.shell;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "SurveyShells")
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties("_________________")

public class SurveyShell {

    @Id
    private String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String author;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String title;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Question> questionList;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Recipient> recipientList;

}
