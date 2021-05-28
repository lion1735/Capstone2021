package com.example.capstone2021;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecieverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciever);

        Intent intent = getIntent();
        String myData = intent.getStringExtra("data");

        TextView textview = findViewById(R.id.textview);
        if (myData != null) {
            //주민 번호 탐지
            String regex = "\\b(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-4][0-9]{6}\\b";
            Matcher matcher = Pattern.compile(regex).matcher(myData);
            if (matcher.find())
                textview.setText("주민 번호 탐지");

            //핸드폰 번호 탐지
            regex = "\\b01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}\\b";
            matcher = Pattern.compile(regex).matcher(myData);
            if (matcher.find())
                textview.setText("핸드폰 번호 탐지");

            //이메일 탐지
            regex = "\\b[a-zA-Z0-9]+@[a-zA-Z0-9]+.[a-zA-Z]+\\b";
            matcher = Pattern.compile(regex).matcher(myData);
            if (matcher.find())
                textview.setText("이메일 탐지");

            //위치정보 탐지
                textview.setText("위치정보가 있습니다.");

        }else
            textview.setText("위치정보가 없습니다.");
    }
}