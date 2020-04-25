package com.example.ansys.hahahaha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edit_name;
    Button start_btn, other_btn;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_name = findViewById(R.id.edit_name);
        start_btn = findViewById(R.id.start_btn);
        other_btn = findViewById(R.id.other_btn);

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
