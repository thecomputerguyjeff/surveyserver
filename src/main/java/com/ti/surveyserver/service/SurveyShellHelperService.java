package com.ti.surveyserver.service;

import com.ti.surveyserver.model.shell.SurveyShell;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SurveyShellHelperService{

    public List<SurveyShell> pullOutMatches(List<SurveyShell> fullList,String title){
        List<SurveyShell> matches=new ArrayList<>();
        List<SurveyShell> partials=new ArrayList<>();

        for (SurveyShell surveyShell : fullList) {
            if(surveyShell.getTitle().equalsIgnoreCase(title)) {
                matches.add(surveyShell);
            } else {
                partials.add(surveyShell);
            }
        }
        matches.addAll(partials);
        return matches;
    }
}
