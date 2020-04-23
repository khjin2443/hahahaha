package com.example.ansys.hahahaha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class activity_quiz extends AppCompatActivity {

    private TextView receive_name, quiz_title;
    RadioButton rb1,rb2,rb3,rb4;
    Button next_btn, quit_btn;
    RadioGroup rb_grp;

    String question[] = {
            "Which method can be defined only once in a program?",
            "Which of these is not a bitwise operator?",
            "Which keyword is used by method to refer to the object that invoked it?",
            "Which of these keywords is used to define interfaces in Java?",
            "Which of these access specifiers can be used for an interface?",
            "Which of the following is correct way of importing an entire package ‘pkg’?",
            "What is the return type of Constructors?",
            "Which of the following package stores all the standard java classes?",
            "Which of these method of class String is used to compare two String objects for their equality?",
            "An expression involving byte, int, & literal numbers is promoted to which of these?"
    };

    //정답 리스트
    String answers[] = {"a","<=","this","interface","public","import pkg.*","None of the mentioned","java","equals()","int"};
    //오답 리스트
    String opt[] = {
            "finalize method","a","static method","private method",
            "&","&=","|=","<=",
            "import","this","catch","abstract",
            "Interface","interface","intf","Intf",
            "public","protected","private","All of the mentioned",
            "Import pkg.","import pkg.*","Import pkg.*","import pkg.",
            "int","float","void","None of the mentioned",
            "lang","java","util","java.packages",
            "equals()","Equals()","isequal()","Isequal()",
            "int","long","byte","float"
    };


    int flag = 0; //문제1번부터 연결
    public static int marks=0, correct=0, wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        receive_name = findViewById(R.id.receive_name);

        final TextView score = findViewById(R.id.score);

        //이름불러오기
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        receive_name.setText(name);
        //

        next_btn = findViewById(R.id.next_btn); //다음버튼연결
        quit_btn = findViewById(R.id.quit_btn); //종료버튼연결
        quiz_title = findViewById(R.id.quiz_title); //퀴즈문제 나오는 텍스트연결
        rb_grp = findViewById(R.id.rb_grp); //라디오그룹연결
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        quiz_title.setText(question[flag]);

        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rb_grp.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "하나를 고르세요!", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = findViewById(rb_grp.getCheckedRadioButtonId());
                String ansText = uans.getText().toString(); //사용자가 한 텍스트

                //맞았다면 정답 토스
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "정답!", Toast.LENGTH_SHORT).show();
                }
                //틀리면 틀렸다는 토스
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "오답!", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<question.length)
                {
                    quiz_title.setText(question[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),activity_result.class);
                    startActivity(in);
                }
                rb_grp.clearCheck();
            }
        });
    }
}
