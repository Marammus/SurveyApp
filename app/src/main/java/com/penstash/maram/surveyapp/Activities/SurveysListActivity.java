package com.penstash.maram.surveyapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.penstash.maram.surveyapp.Models.Surveys;
import com.penstash.maram.surveyapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SurveysListActivity extends AppCompatActivity {

    private ListView lv;
//    Button btn;
List<Surveys> surveys;

    ArrayList<HashMap<String,String>> surveysList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surveys_list);

        surveysList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.lvSurvey);

        prepareData();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                SimpleAdapter adapter = (SimpleAdapter) parent.getAdapter();

                long x = adapter.getItemId(position);
                Intent i=new Intent(view.getContext(),SyncSurveyActivity.class);

//                List<Surveys> survId= Surveys.findWithQuery(Surveys.class,"Select * from Surveys where id = ?",Long.toString(x));
//                Surveys z= survId.get(0);
//                int y=z.getSurveyId();

                i.putExtra("id",x+1);

                startActivity(i);

            }
        });
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                Questions.deleteAll(Questions.class);
//
//                Surveys s1 = new Surveys("Name", 1, 1, 1, 1, 1, "Tue Nov 01 02:37:18 IST 2016", "StartDate", "EndDate", true, "maram");
//                s1.save();
//
////                Questions Q1 = new Questions(2, "Q1","textBox",1,5);
////                Q1.save();
////                Questions Q2 = new Questions(1,"Q2","checkBox",1,10);
////                Q2.save();
////                Questions Q3 = new Questions(2,"Q3","radioButton",1,10);
////                Q3.save();
////                Questions Q4 = new Questions(2,"Q4","rateBar",1,10);
////                Q4.save();
////                Questions Q5 = new Questions(2,"Q5","radioButton",1,10);
////                Q5.save();
////                Questions Q6 = new Questions(2, "Q6","textBox",1,5);
////                Q6.save();
////                QuestionOptions o1 =new QuestionOptions(2, "op1",1);
////                o1.save();
////                QuestionOptions o2 =new QuestionOptions(2, "op2",2);
////                o2.save();
////                QuestionOptions o3 =new QuestionOptions(3, "op1R",1);
////                o3.save();
////                QuestionOptions o4 =new QuestionOptions(3, "op2R",2);
////                o4.save();
////                QuestionOptions o5 =new QuestionOptions(5, "op1R2",1);
////                o5.save();
////                QuestionOptions o6 =new QuestionOptions(5, "op2R2",2);
////                o6.save();
//
////                startActivity(new Intent(SurveysListActivity.this, DynamicWidgetsActivity.class));
//            }
//        });
    }


    void prepareData(){

         surveys = Surveys.listAll(Surveys.class);
        for (int i=0; i< surveys.size(); i++){
            Surveys surv= surveys.get(i);
//            if(surv.getName() .equals("Name")){

            //temp hash map for single survey
            HashMap<String,String> survey = new HashMap<>();

            //adding each child node to HashMap key => value
            survey.put("SurveyId",Integer.toString(surv.getSurveyId()));//id
            survey.put("Name",surv.getName());
            survey.put("IndustryId",Integer.toString(surv.getIndustryId()));
            survey.put("CompanyId",Integer.toString(surv.getCompanyId()));
            survey.put("DivisionId",Integer.toString(surv.getDivisionId()));
            survey.put("BranchId",Integer.toString(surv.getBranchId()));
            survey.put("DepartmentId",Integer.toString(surv.getDepartmentId()));
            survey.put("CreationDate", surv.getCreationDate());
            survey.put("StartDate",surv.getStartDate());
            survey.put("EndDate",surv.getEndDate());
            survey.put("Active",Boolean.toString(surv.isActive()));
            survey.put("CreatedBy",surv.getCreatedBy());


            surveysList.add(survey);
            surveys.size();
        }
        //}
//    for(int i =0; i < surveysList.size(); i++){
//            if(surveysList[i]["Name"] <= 1){
        ListAdapter listAdapter = new SimpleAdapter(SurveysListActivity.this,
                surveysList,
                R.layout.activity_survey_details,
                new String[]{"Name","CreationDate", "StartDate", "EndDate",  "CreatedBy", "SurveyId"},

                new int[]{R.id.tvSurveyName, R.id.tvCreationDate, R.id.tvStartDate, R.id.tvEndDate, R.id.tvCreatedBy});

        lv.setAdapter(listAdapter);


    }


}//classEnd
