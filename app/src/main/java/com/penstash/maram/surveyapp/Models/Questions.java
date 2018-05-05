package com.penstash.maram.surveyapp.Models;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by maram on 05/03/2018.
 */

@Table
public class Questions extends SugarRecord {

//Variables
    private long id;

    int QuestionId;
    int SurveyId ;
    String QuestionText;
    String Type;
    int RangeStart;
    int RangeEnd;



//Constructor
    public Questions(){}




//Methods
    public Questions(int questionId, int surveyId, String questionText,String type,int rangeStart,int rangeEnd){
        this.QuestionId = questionId;
        this.SurveyId = surveyId;
        this.QuestionText= questionText;
        this.Type= type;
        this.RangeStart= rangeStart;
        this.RangeEnd= rangeEnd;
    }




//Return Values

    public int getQuestionId(){
        return QuestionId;
    }

    public int getSurveyId(){
        return SurveyId;
    }

    public String getQuestionText(){
        return QuestionText;
    }

    public String getType(){
        return Type;
    }

    public int getRangeStart(){
        return RangeStart;
    }

    public int getRangeEnd(){
        return RangeEnd;
    }



}
