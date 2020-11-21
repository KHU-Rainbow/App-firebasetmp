package com.example.rainbow;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class date_study extends AppCompatActivity {
    TextView tx1;
    @Override
    public void onCreate(@Nullable  Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_study_page);

        //툴바 세팅
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        // 날짜 값 전 페이지로부터 넘겨 받기
        Intent intent = getIntent();
        tx1 = (TextView)findViewById(R.id.today_date);
        int year = intent.getExtras().getInt("Year");
        int month = intent.getExtras().getInt("Month")+1;
        int day = intent.getExtras().getInt("Day");
        String date = Integer.toString(year)+"년 " + Integer.toString(month)+"월 " + Integer.toString(day) + "일";
        tx1.setText(date);

        //날짜 색바꾸기
        TextPaint paint1 = tx1.getPaint();
        float width1 = paint1.measureText(date);
        Shader textShader1 = new LinearGradient(0, 0, width1, tx1.getTextSize(),
                new int[]{
                        Color.parseColor("#fa5050"),
                        Color.parseColor("#faa850"),
                        Color.parseColor("#66ed5f"),
                       Color.parseColor("#60b4f0"),
                        Color.parseColor("#c15df0"),
                }, null, Shader.TileMode.MIRROR);
        tx1.getPaint().setShader(textShader1);

        // 데이터베이스 연결
        final DataBaseHelper DBHelper = new DataBaseHelper(this);
        // 1-9일은 Int로 표현했을 때, 01, 09이렇게 표현안되므로 string으로 변경
        String month_s = Integer.toString(month);
        if(month_s.length() == 1)
            month_s = "0" + month;
        String day_s = Integer.toString(day);
        if(day_s.length() == 1)
            day_s = "0" + day;
        int studytime = DBHelper.getStudyTime(year+"-"+month_s+"-"+day_s);
        int goaltime = DBHelper.getStudyGoal(year+"-"+month_s+"-"+day_s);

        int studyhours, studyminutes, goalhours, goalminutes;
        studyhours = studytime/60;
        studyminutes = studytime%60;
        goalhours = goaltime/60;
        goalminutes = goaltime%60;

        TextView tx2 = (TextView)findViewById(R.id.study_time);
        String studytxt = studyhours+ "시간 "+studyminutes+"분 / "+goalhours+"시간 "+goalminutes+ "분";
        tx2.setText(studytxt);

        // 프로그래스바 세
        ProgressBar pb = (ProgressBar)findViewById(R.id.study_progressbar);
        pb.setProgress(studytime*100/goaltime);

        /*
        TextPaint paint2 = tx2.getPaint();
        float width2 = paint2.measureText(studytxt);
        Shader textShader2 = new LinearGradient(0, 0, width2, tx2.getTextSize(),
                new int[]{
                        Color.parseColor("#fa5050"),
                        Color.parseColor("#faa850"),
                        Color.parseColor("#66ed5f"),
                        Color.parseColor("#60b4f0"),
                        Color.parseColor("#c15df0"),
                }, null, Shader.TileMode.MIRROR);
        tx2.getPaint().setShader(textShader2);
*/


        int numofdetect = DBHelper.getDetectNum(year+"-"+month_s+"-"+day_s);

        TextView tx3 = (TextView)findViewById(R.id.phone_time);
        String detecttxt = numofdetect+"회";
        tx3.setText(detecttxt);

        /*
        TextPaint paint3 = tx3.getPaint();
        float width3 = paint3.measureText(detecttxt);

        Shader textShader3 = new LinearGradient(0, 0, width3, tx3.getTextSize(),
                new int[]{
                        Color.parseColor("#fa5050"),
                        Color.parseColor("#faa850"),
                        Color.parseColor("#66ed5f"),
                        Color.parseColor("#60b4f0"),
                        Color.parseColor("#c15df0"),
                }, null, Shader.TileMode.MIRROR);
        tx3.getPaint().setShader(textShader3);
*/
    }

}
