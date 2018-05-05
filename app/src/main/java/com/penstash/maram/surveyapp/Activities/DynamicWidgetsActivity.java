package com.penstash.maram.surveyapp.Activities;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.crystal.crystalrangeseekbar.interfaces.OnSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalSeekbar;

import com.penstash.maram.surveyapp.Models.QuestionOptions;
import com.penstash.maram.surveyapp.Models.Questions;
import com.penstash.maram.surveyapp.Models.SurveyResponseValue;
import com.penstash.maram.surveyapp.R;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DynamicWidgetsActivity extends AppCompatActivity {




//    //ResponceLists
    List<EditText> EditTextValue = new ArrayList<>();
    List<CrystalSeekbar> RateValue = new ArrayList<>();

//    List<String> check = new ArrayList<>();
    List<String> checkval =new ArrayList<>();
//    List<String> question =new ArrayList<>();
    HashMap<Integer,String> RadioValue= new HashMap<>();
    HashMap<Integer,String> EtextValue= new HashMap<>();
    HashMap<Integer,List<String>> checkBoxVslue = new HashMap<>();

//    CrystalSeekbar Seekbar;

    LinearLayout dl;
    Button submitBtn;
    android.widget.CheckBox checkBox;
    EditText tb;
    String x;
    RadioGroup r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_widgets);

//        questionList = new ArrayList<>();
         x = Long.toString(getIntent().getLongExtra("id",1));

        dl = (LinearLayout) findViewById(R.id.Dynamicliner);

        Date currentTime = Calendar.getInstance().getTime();
        System.out.println("Time"+currentTime);




        //calling prepareData Function
        prepareData();

//        submitBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                boolean checked = ((android.widget.CheckBox) v).isChecked();
////
////                if (checked){
////                    Toast.makeText(getApplicationContext(), "checked", Toast.LENGTH_SHORT).show();
////                }
//
//                if (EditTextValue.size()>0){
//                    for (int e =0; e<EditTextValue.size();e++){
//                        String text = tb.getText().toString();
//                        responce.add(text);
////                        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
//                    }
//                }
//                if (RadioValue.size()>0){
//                    for (int r =0; r<RadioValue.size();r++){
////                        responce.add();
////                        RadioButton radioButton= (RadioButton) findViewById(checkedId);
//                    }
//                }
//                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                    @Override
//                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                        if (isChecked){
//                            check.add(buttonView.getText().toString());
//                        }
//                        else {
//                            check.remove(buttonView.getText().toString());
//                        }
//                    }
//                });
//
//
//            }
//        });


//        checkBox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                boolean checked = ((android.widget.CheckBox) v).isChecked();
//
////                if (checked){
////                    Toast.makeText(getApplicationContext(), "checked", Toast.LENGTH_SHORT).show();
////                }
////                else {}
//            }
//        });
    }//OnCreateEnd


    void prepareData(){

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);


        final List<Questions> questions = Questions.find(Questions.class,"Survey_Id = ?",x);//.listAll(Questions.class);
        for (int i=0; i< questions.size(); i++){
            Questions ques= questions.get(i);
            String QuesType = ques.getType();
            String quesID = Long.toString( ques.getQuestionId());//.getId());

            if(QuesType  .equals( "textBox")){


                //TextView
                TextView q = new TextView(this);
                q.setTextSize(30);
                q.setText(ques.getQuestionText());
                final int Qid =ques.getQuestionId();
                ll.addView(q);

                //EditText
                tb = new EditText(this);
                tb.layout(50, 300, 30, 100);
                tb.setTextSize(20);
                tb.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
//                        String t = tb.getText().toString();
                        if(s.length()>0) {
                            EtextValue.put(Qid, s.toString());
                        }else {
                            EtextValue.remove(Qid);
                        }
                        EtextValue.size();

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        if(checkBoxVslue.size()+EtextValue.size()+RadioValue.size() == questions.size()){
                            submitBtn.setEnabled(true);
                        }else {
                            submitBtn.setEnabled(false);
                        }

                    }
                });
                ll.addView(tb);

                EditTextValue.add(tb);
            }//EndIftextBox


//                //temp hash map for single survey
//                HashMap<String,String> question = new HashMap<>();
//
//                //adding each child node to HashMap key => value
//                question.put("",Integer.toString(ques.getSurveyId()));//id
//                question.put("questionText",ques.getQuestionText());
//                question.put("Type",ques.getType());
//                question.put("rangeStart",Integer.toString(ques.getRangeStart()));
//                question.put("rangeEnd",Integer.toString(ques.getRangeEnd()));
//
//                questionList.add(question);
//                questions.size();


        else if(QuesType  .equals( "checkBox")){

                //TextView
                TextView q = new TextView(this);
                q.setTextSize(30);
                q.setText(ques.getQuestionText());
                ll.addView(q);
                final int Qid= ques.getQuestionId();

                //CheckBox
                List<QuestionOptions> choices = QuestionOptions.find(QuestionOptions.class, "Question_Id =   ?", quesID  );

//                ArrayList<String> choices = new ArrayList<>();
//
//                choices.add("ch1");
//                choices.add("ch2");
//                choices.add("ch3");
//                choices.add("ch4");
//                choices.add("ch5");
//                android.widget.CheckBox checkBox;


                for (int j = 0; j < choices.size(); j++ ){
                    QuestionOptions option = choices.get(j);

                    checkBox = new android.widget.CheckBox(this);
                    checkBox.setId(j);
                    checkBox.setTextSize(20);
                    checkBox.setText(option.getOptionText());
                    checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                            if (isChecked){

                                if(!checkBoxVslue.containsKey(Qid)){
                                     checkval = new ArrayList<>();
                                    String s= buttonView.getText().toString();
                                    checkval.add(s);
                                    checkBoxVslue.put(Qid,checkval);
                                    checkBoxVslue.size();
                                    if(checkBoxVslue.size()+EtextValue.size()+RadioValue.size() == questions.size()){
                                        submitBtn.setEnabled(true);
                                    }else {
                                        submitBtn.setEnabled(false);
                                    }
                                }else {
                                            String s = buttonView.getText().toString();
                                            checkBoxVslue.get(Qid).add(s);
                                            checkBoxVslue.size();
                                }

                            }else {
                                String s= buttonView.getText().toString();
//                                checkval.remove(s);
                                checkBoxVslue.get(Qid).remove(s);
                                if(checkBoxVslue.get(Qid).isEmpty()){
                                checkBoxVslue.remove(Qid);}
//                                checkBoxVslue.put(Qid,checkval);
                                checkBoxVslue.size();

                                if(checkBoxVslue.size()+EtextValue.size()+RadioValue.size() == questions.size()){
                                    submitBtn.setEnabled(true);
                                }else {
                                    submitBtn.setEnabled(false);
                                }

                            }

                        }
                    });
                    ll.addView(checkBox);
                }

            }//EndIfCheckBox



             else if(QuesType  .equals( "radioButton")){

            //TextView
                TextView q = new TextView(this);
                q.setTextSize(30);
                q.setText(ques.getQuestionText());
                ll.addView(q);
                final int Qid =ques.getQuestionId();

            //RadioButton
                List<QuestionOptions> choices = QuestionOptions.find(QuestionOptions.class, "Question_Id =   ?", quesID  );

                RadioGroup r= new RadioGroup(this);
                r.setOrientation(RadioGroup.VERTICAL);
                RadioGroup.LayoutParams rl2;
                r.getCheckedRadioButtonId();
                for (int x = 0; x < choices.size(); x++){
                    QuestionOptions option = choices.get(x);

                    android.widget.RadioButton rl= new android.widget.RadioButton(this);
                    rl.setText(option.getOptionText());//(choices[x]);
                    rl.setTextSize(20);
                    rl.setId(x);
                    rl.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            java.lang.String s = ((android.widget.RadioButton) v).getText().toString();
                            Toast.makeText(DynamicWidgetsActivity.this, "Hello from 2!" + s,
                                    Toast.LENGTH_LONG).show();
                            RadioValue.put(Qid,s);// add<Qid,s>;
                            RadioValue.size();
                            if(checkBoxVslue.size()+EtextValue.size()+RadioValue.size() == questions.size()){
                                submitBtn.setEnabled(true);
                            }else {
                                submitBtn.setEnabled(false);
                            }
                        }
                    });//(mThisButtonListener);
                    rl2= new RadioGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.MATCH_PARENT);
                    r.addView(rl,rl2);

                    r.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
//                            RadioButton radioButton = (RadioButton) findViewById(checkedId);
//                            RadioValue.add(Qid,rl.isChecked());

//                            Toast.makeText(getApplicationContext(),radioButton.getText(),Toast.LENGTH_LONG).show();
                        }
                    });
                }
                ll.addView(r);
                int selectedId= r.getCheckedRadioButtonId();
//                RadioButton radioButton= (RadioButton) findViewById(selectedId);
                System.out.println("IDD "+selectedId);
//                RadioValue.add(r);

            }//EndIfRadioButton



             else if(QuesType  .equals( "rateBar")){

            //TextView
                TextView q = new TextView(this);
                q.setTextSize(30);
                q.setText(ques.getQuestionText());
                ll.addView(q);

            //RateBar

               CrystalSeekbar Seekbar = new CrystalSeekbar(this);
                int mxV=ques.getRangeEnd();//150;
                int miV=ques.getRangeStart();//10;
              final TextView tvMin = new TextView(this);
              final TextView tvMax = new TextView(this);

                tvMax.setGravity(Gravity.END);
                tvMax.setText(String.valueOf(mxV));
                Seekbar.setMaxValue(mxV);

                tvMin.setText(String.valueOf(miV));
                Seekbar.setMinValue(miV);

//                Seekbar.setMinValue(10);
                Seekbar.setOnSeekbarChangeListener(new OnSeekbarChangeListener() {
                    @Override
                    public void valueChanged(Number minValue) {
                        tvMin.setText(String.valueOf(minValue));
                    }
                });

                Seekbar.setOnSeekbarFinalValueListener(new OnSeekbarFinalValueListener() {
                    @Override
                    public void finalValue(Number value) {
                        Log.d("CRS=>", String.valueOf(value));
                        Toast.makeText(DynamicWidgetsActivity.this, "Rate is " + String.valueOf(value) + "%", Toast.LENGTH_SHORT).show();

                    }
                });
                ll.addView(Seekbar);
                ll.addView(tvMin);
                ll.addView(tvMax);
                RateValue.add(Seekbar);

            }//EndIfRateBar


             if(i == questions.size()  -1 ){

                submitBtn = new Button(this);
                submitBtn.setText("Submit");
                submitBtn.setTextSize(30);
                submitBtn.setOnClickListener(onButtonClick);
                submitBtn.setEnabled(false);

//                 if (questions.size()!= EditTextValue.size()+RadioValue.size()){
//                     submitBtn.setEnabled(false);
//
//                 }
                ll.addView(submitBtn);
            }


        dl.removeAllViews();
        dl.addView(ll);


        }


    }//prepareDataEnd


//    public void onClick(View view) {
//        try {
//            String s = ((android.widget.RadioButton) view).getText().toString();
//            Toast.makeText(DynamicWidgetsActivity.this, "This is: " + s,
//                    Toast.LENGTH_LONG).show();
//        }
//        catch (Exception e1) {
//            e1.printStackTrace();
//        }
//    }

//        //CheckBox OnClickListener
//        View.OnClickListener getOnClickDoSomething(final Button button) {
//                return new View.OnClickListener() {
//                    public void onClick(View v) {
//                        System.out.println("id  " + button.getId());
//                        System.out.println("text  " + button.getText().toString()); } };
//        }



//        //Radio OnClickListener
//        private View.OnClickListener mThisButtonListener = new View.OnClickListener() {
//            public void onClick(View v) {
//                String s = ((android.widget.RadioButton) v).getText().toString();
//                Toast.makeText(DynamicWidgetsActivity.this, "Hello from 2!" + s,
//                        Toast.LENGTH_LONG).show();
//            }
//        };



        //Button OnClickListener
        private View.OnClickListener onButtonClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (RadioValue.size()>0) {
                    for (Map.Entry radioLoop : RadioValue.entrySet()) {

                        SurveyResponseValue Rv = new SurveyResponseValue(1, Integer.valueOf(radioLoop.getKey().toString()), radioLoop.getValue().toString());
                        Rv.save();
                    }
                }

                if (checkBoxVslue.size()>0){
                    for (Map.Entry checkBoxLoop: checkBoxVslue.entrySet()){

                        SurveyResponseValue chV = new SurveyResponseValue(1,Integer.valueOf(checkBoxLoop.getKey().toString()),checkBoxLoop.getValue().toString());
                        chV.save();
                    }
                }

                if (EtextValue.size()>0) {
                    for (Map.Entry eTextLoop : EtextValue.entrySet()) {
                        SurveyResponseValue etV = new SurveyResponseValue(1, Integer.valueOf(eTextLoop.getKey().toString()), eTextLoop.getValue().toString());
                        etV.save();
                    }
                }


//                if (EditTextValue.size()>0){
//                    for (int e =0; e<EditTextValue.size();e++){
//                        String text = tb.getText().toString();
////                        for(int i) {
////                            responce.add(question);
//                            responce.add(text);
////                            for(){
////                                question.add();
////                            }
////    //                        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
////                        }
//                    }
//                }
//
//                if(RateValue.size()>0){
//                    for(int ra =0; ra<RateValue.size();ra++){
//                        r.getCheckedRadioButtonId();
//
////                        Seekbar.setOnSeekbarFinalValueListener(new OnSeekbarFinalValueListener() {
////                            @Override
////                            public void finalValue(Number value) {
////                                Log.d("CRS=>", String.valueOf(value));
////                                Toast.makeText(DynamicWidgetsActivity.this, "Rate is " + String.valueOf(value) + "%", Toast.LENGTH_SHORT).show();
////
////                                String text= String.valueOf(value);
////                                responce.add(text);
////
////                            }
////                        });
//
////                        String text= String.valueOf(value);
////                        responce.add(text);
//                    }
//                }
//                if (RadioValue.size()>0){
//                    for (int r =0; r<RadioValue.size();r++){
////                                responce.add();
////                                RadioButton radioButton= (RadioButton) findViewById(checkedId);
//                    }
//                }
//                int Id= r.getCheckedRadioButtonId();
//                System.out.println(Id);
////                RadioButton selectedRadioButton = new  RadioButton.findViewById(R.id.x);
//
//
//                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                    @Override
//                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                        if (isChecked){
////                            check.add(buttonView.getText().toString());
//                        }
//                        else {
////                            check.remove(buttonView.getText().toString());
//                        }
//                    }
//                });
//                Intent i = new Intent(DynamicWidgetsActivity.this, SurveysListActivity.class);
//                startActivity(i);
            }
        };//EndButton OnClickListener



//    final LocationManager lm = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
//    LocationListener ls= new LocationListener() {
//        @Override
//        public void onLocationChanged(Location location) {
//
//            Double lat=location.getLatitude();
//            String mm = "";
//            Double longitude=location.getLongitude();
//
//            Geocoder geocoder = new Geocoder(DynamicWidgetsActivity.this, Locale.getDefault());
//            try {
//                List<Address> addresses = geocoder.getFromLocation(lat, longitude, 1);
//                Address obj = addresses.get(0);
//                mm = obj.getCountryName();
//                mm=mm+" , "+obj.getSubAdminArea();
//                mm=mm+" , "+obj.getSubLocality();
//                mm=mm+" , "+obj.getFeatureName();
//
//                Log.v("IGA", "Address" + mm);
//                System.out.println("Address "+mm);
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        @Override
//        public void onStatusChanged(String provider, int status, Bundle extras) {
//
//        }
//
//        @Override
//        public void onProviderEnabled(String provider) {
//
//        }
//
//        @Override
//        public void onProviderDisabled(String provider) {
//
//        }
//    };


}//ClassEnd
