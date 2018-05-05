package com.penstash.maram.surveyapp.Models;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by maram on 31/03/2018.
 */

@Table
public class SurveyResponseValue extends SugarRecord{

    private long id;

    int SurveyResponceId;
    int QuestionId;
    String Value;


//Constructor
    public SurveyResponseValue(){}


//Method
    public SurveyResponseValue(int SurveyResponceId, int questionId, String value){
        this.SurveyResponceId = SurveyResponceId;
        this.QuestionId = questionId;
        this.Value = value;
    }


//Return Value
    public int getSurveyResponceId(){
        return SurveyResponceId;
    }

    public int getQuestionId(){
        return QuestionId;
    }

    public String getValue(){
        return Value;
    }

}
