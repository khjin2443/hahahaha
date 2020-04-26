package com.example.ansys.hahahaha;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    EditText edit_name;
    Button start_btn, other_btn;
    String name;
    //음악버튼
    ImageButton sound_btn, sound_btn_start;
    MediaPlayer mediaPlayer;

    //액티비티가 종료될때 실행되는거
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_name = findViewById(R.id.edit_name);
        start_btn = findViewById(R.id.start_btn);
        other_btn = findViewById(R.id.other_btn);
        //음악
        sound_btn = findViewById(R.id.sound_btn);
        sound_btn_start=findViewById(R.id.sound_btn_start);
        sound_btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.jorgesys_song);
                mediaPlayer.start();
            }
        });

        sound_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                }
            }
        });


        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edit_name.getText().toString();
                Intent intent = new Intent(MainActivity.this, activity_quiz.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });

        other_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, activity_other.class);
                startActivity(intent);
            }
        });

    }
}
