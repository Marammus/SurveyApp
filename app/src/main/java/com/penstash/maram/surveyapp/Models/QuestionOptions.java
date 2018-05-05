package com.penstash.maram.surveyapp.Models;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by maram on 06/03/2018.
 */
@Table
public class QuestionOptions extends SugarRecord {

    private long id;

    int QuestionId;
    String OptionText;
    int Value;

    public QuestionOptions(){}

    public QuestionOptions( int QuestionId, String OptionText, int Value){
        this.QuestionId= QuestionId;
        this.OptionText= OptionText;
        this.Value= Value;
    }

    public int getQuestionId(){
        return QuestionId;
    }

    public String getOptionText(){
        return OptionText;
    }

    public int getValue(){
        return Value;
    }
}

