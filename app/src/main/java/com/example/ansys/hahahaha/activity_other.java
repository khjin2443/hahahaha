package com.example.ansys.hahahaha;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class activity_other extends AppCompatActivity {

    //힌트
    public static int a = 0;
    //
    Button title_other_btn, easy_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);


        title_other_btn = (Button)findViewById(R.id.title_other_btn);
        easy_btn = (Button)findViewById(R.id.easy_btn);

        title_other_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_other.this, activity_open_quiz.class);
                startActivity(intent);
                a = 0;
            }
        });

        easy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_other.this, activity_open_quiz.class);
                a = 1;
                startActivity(intent);
            }
        });
    }

}
