package com.example.rainbow;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/* textView id : week_1, week_2...  ImageView id : week_pic_1, week_pic_2....
무지개 : rb_pic7
반무지개 : half_rb_pic4
비 : rain_pic5
기본값 : rb_pic8
변수명 week_rbpic1,...
*/
public class weekofRainbow extends AppCompatActivity {
    private ImageView week_rbpic1, week_rbpic2, week_rbpic3, week_rbpic4;
    private TextView week1, week2, week3, week4;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weekofrainbow_page);

        week_rbpic1 = (ImageView)findViewById(R.id.week_pic_1);
        week_rbpic2 = (ImageView)findViewById(R.id.week_pic_2);
        week_rbpic3 = (ImageView)findViewById(R.id.week_pic_3);
        week_rbpic4 = (ImageView)findViewById(R.id.week_pic_4);


        week_rbpic1.setImageResource(0);
        week_rbpic2.setImageResource(0);
        week_rbpic3.setImageResource(0);
        week_rbpic4.setImageResource(0);

        week1 = (TextView) findViewById(R.id.week_1);
        week2 = (TextView) findViewById(R.id.week_2);
        week3 = (TextView) findViewById(R.id.week_3);
        week4 = (TextView) findViewById(R.id.week_4);

        final DataBaseHelper DBHelper = new DataBaseHelper(this);
        int result[] = DBHelper.getWeekAchieve();
        for(int i = 0; i < result.length ; i++)
        {
            //첫째 주
            if(i == 0) {
                week1.setText("첫째 주");
                if (result[0] == 2)
                    week_rbpic1.setImageResource(R.drawable.rb_pic7);
                else if(result[0] == 1)
                    week_rbpic1.setImageResource(R.drawable.half_rb_pic4);
                else
                    week_rbpic1.setImageResource(R.drawable.rain_pic5);
            }
            else if(i == 1) {
                week2.setText("둘째 주");
                if (result[1] == 2)
                    week_rbpic2.setImageResource(R.drawable.rb_pic7);
                else if(result[1] == 1)
                    week_rbpic2.setImageResource(R.drawable.half_rb_pic4);
                else
                    week_rbpic2.setImageResource(R.drawable.rain_pic5);
            }
            else if(i ==2) {
                week3.setText("셋째 주");
                if (result[2] == 2)
                    week_rbpic3.setImageResource(R.drawable.rb_pic7);
                else if(result[2] == 1)
                    week_rbpic3.setImageResource(R.drawable.half_rb_pic4);
                else
                    week_rbpic3.setImageResource(R.drawable.rain_pic5);
            }
            else if(i == 3) {
                week4.setText("넷째 주");
                if (result[3] == 2)
                    week_rbpic4.setImageResource(R.drawable.rb_pic7);
                else if(result[3] == 1)
                    week_rbpic4.setImageResource(R.drawable.half_rb_pic4);
                else
                    week_rbpic4.setImageResource(R.drawable.rain_pic5);
            }

        }

        // 빨 - 주 - 초 - 파 - 보
        week1.setTextColor(Color.parseColor("#eb4934"));
        week2.setTextColor(Color.parseColor("#eba834"));
        week3.setTextColor(Color.parseColor("#3bba14"));
        week4.setTextColor(Color.parseColor("#1288cc"));
        //week5까지 안나와서 색 수정 필요
        //week5.setTextColor(Color.parseColor("#a753f5"));

        // 툴바 지정
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

    }

}
