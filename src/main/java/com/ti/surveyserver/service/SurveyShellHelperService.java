package com.ti.surveyserver.service;

import com.ti.surveyserver.model.shell.SurveyShell;

import java.util.ArrayList;
import java.util.List;

public class SurveyShellHelperService{
    public List<SurveyShell>pullOutMatches(List<SurveyShell> fullList,String title){
        List<SurveyShell>matches=new ArrayList<>();
        Integer size=fullList.size();
        for (int i=0;i<size;i++) {
            SurveyShell thisOne=fullList.get(i);
            if(thisOne.getTitle().equals(title)){
                matches.add(thisOne);
            }
        }
        for (SurveyShell survey:fullList) {
            if(!(survey.getTitle().equals(title))){
                matches.add(survey);
            }
        }
        return matches;
    }
}
