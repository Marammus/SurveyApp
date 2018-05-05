package com.penstash.maram.surveyapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.penstash.maram.surveyapp.Models.Login;
import com.penstash.maram.surveyapp.Models.QuestionOptions;
import com.penstash.maram.surveyapp.Models.Questions;
import com.penstash.maram.surveyapp.Models.Surveys;
import com.penstash.maram.surveyapp.R;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    Button loginBtn, insertBtn;
    EditText teUserName, tePassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = (Button) findViewById(R.id.loginBtn);
        insertBtn = (Button) findViewById(R.id.insertBtn);
        teUserName =(EditText) findViewById(R.id.teUserName);
        tePassword=(EditText) findViewById(R.id.tePassword);

        if(teUserName != null || tePassword != null){
            loginBtn.setEnabled(false);
        }

        teUserName.addTextChangedListener(textWatcher);
        tePassword.addTextChangedListener(textWatcher);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List name = Login.find(Login.class, " User_Name = ? and Password = ? ", teUserName.getText().toString(), tePassword.getText().toString());
                if(name.size()>0) {

                    Intent i = new Intent(LoginActivity.this, SurveysListActivity.class);
                    startActivity(i);
                }else {
                    Toast.makeText(LoginActivity.this, "UserName and password not correct, Please try again" , Toast.LENGTH_LONG).show();
                }
            }
        });


        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Questions.deleteAll(Questions.class);
                QuestionOptions.deleteAll(QuestionOptions.class);
                Surveys.deleteAll(Surveys.class);

                Surveys s1 = new Surveys(1,"Survey No 1", 1, 1, 1, 1, 1, "Tue Nov 01 02:37:18 IST 2016", "1 March 2018", "12 March 2018", true, "Ali");
                s1.save();
                Surveys s2 = new Surveys(2,"Survey No 2", 1, 1, 1, 1, 1, "Wed Nov 02 02:37:18 IST 2016", "2 March 2018", "12 March 2018", true, "Ali");
                s2.save();
                Surveys s3 = new Surveys(3,"Survey No 3", 1, 1, 1, 1, 1, "Wed Nov 02 03:38:19 IST 2016", "3 March 2018", "13 March 2018", true, "Ali");
                s3.save();


                Questions Q1 = new Questions(1,2, "How this product Meets your need","textBox",1,5);
                Q1.save();
                Questions Q2 = new Questions(2,1,"I use","checkBox",1,10);
                Q2.save();
                Questions Q3 = new Questions(3,2,"I enjoy using this product","radioButton",1,10);
                Q3.save();
//                Questions Q4 = new Questions(4,2,"I am satisfied ","rateBar",1,10);
//                Q4.save();
                Questions Q5 = new Questions(5,2,"I wolud purchase from this company again","radioButton",1,10);
                Q5.save();
                Questions Q6 = new Questions(6,2, "Why you using this product","textBox",1,5);
                Q6.save();
                Questions Q2x = new Questions(7,1,"My favorite product","checkBox",1,10);
                Q2x.save();


                QuestionOptions o1 =new QuestionOptions(2, "Product 1",1);
                o1.save();
                QuestionOptions o2 =new QuestionOptions(2, "Product 2",2);
                o2.save();
                QuestionOptions o3 =new QuestionOptions(3, "Agree",1);
                o3.save();
                QuestionOptions o3x =new QuestionOptions(3, "Neutral",2);
                o3x.save();
                QuestionOptions o4 =new QuestionOptions(3, "Disagree",3);
                o4.save();
                QuestionOptions o5 =new QuestionOptions(5, "Agree",1);
                o5.save();
                QuestionOptions o5x =new QuestionOptions(5, "Neutral",2);
                o5x.save();
                QuestionOptions o6 =new QuestionOptions(5, "Disagree",3);
                o6.save();
                QuestionOptions o7 =new QuestionOptions(7, "Product 11",1);
                o7.save();
                QuestionOptions o8 =new QuestionOptions(7, "Product 22",2);
                o8.save();
                QuestionOptions o9 =new QuestionOptions(7, "Product 33",3);
                o9.save();


                Login l1=new Login("Ali","123");
                l1.save();
                Login l2=new Login("Maram","123");
                l2.save();
            }
        });

        checkFieldsValues();
    }//EndOnCreate

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            checkFieldsValues();
        }
    };//EndWatcherFunc

    void checkFieldsValues(){
        if(teUserName.getText().toString().equals("")|| tePassword.getText().toString().equals("")){
            loginBtn.setEnabled(false);
        }else {
            loginBtn.setEnabled(true);
        }

    }//EndCheckFieldsValuesFunc
}
