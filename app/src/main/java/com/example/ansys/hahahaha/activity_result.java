package com.example.ansys.hahahaha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_result extends AppCompatActivity {
    TextView correct_btn, wrong_btn;
    Button re_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //텍스트, 버튼 xml과 java 연결
        correct_btn = findViewById(R.id.correct_btn);
        wrong_btn = findViewById(R.id.wrong_btn);
        re_btn = findViewById(R.id.re_btn);

        //값을 변경할 수 있고, 추가 가능하게 buffer
        StringBuffer sb = new StringBuffer();
        sb.append("맞힌 갯수 : "+ activity_quiz.correct+"\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("틀린 갯수 : "+activity_quiz.wrong+"\n");

        correct_btn.setText(sb);
        wrong_btn.setText(sb2);

        //문제 초기화
        activity_quiz.correct = 0;
        activity_quiz.wrong = 0;


        re_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
        });
    }
}
