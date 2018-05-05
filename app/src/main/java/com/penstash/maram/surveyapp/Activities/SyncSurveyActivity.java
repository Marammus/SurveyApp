package com.penstash.maram.surveyapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.penstash.maram.surveyapp.Models.SurveyResponseValue;
import com.penstash.maram.surveyapp.R;

public class SyncSurveyActivity extends AppCompatActivity {

    Button btn;
    Long x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync_survey);

        long z= SurveyResponseValue.count(SurveyResponseValue.class);
        TextView textView1 =(TextView) findViewById(R.id.textView1);
        textView1.setText(String.valueOf(z));
         x = getIntent().getLongExtra("id",1);
        btn= (Button) findViewById(R.id.startSurveyBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(SyncSurveyActivity.this,DynamicWidgetsActivity.class);
                i.putExtra("id",x);
                startActivity(i);
            }
        });

        long id=getIntent().getLongExtra("id",1);
    }
}
