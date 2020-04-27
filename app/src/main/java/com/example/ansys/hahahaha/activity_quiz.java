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

    TextView count_quiz;
    int count = 1;


    //문제
    String question[] = {
            "프로그램에서 한 번만 정의 할 수있는 것은 무엇일까요?",
            "비트 연산자가 아닌 것은 무엇일까요?",
            "메소드에서 키워드를 호출 한 오브젝트를 참조하기 위해 사용하는 키워드는 무엇일까요?",
            "Java에서 인터페이스를 정의하는 데 사용되는 키워드는 무엇일까요?",
            "인터페이스에 사용할 수있는 액세스 지정자는 무엇일까요?",
            "다음 중 전체 패키지 'pkg'를 가져 오는 올바른 방법은 무엇일까요?",
            "생성자의 반환 유형은 무엇일까요?",
            "다음 중 표준 Java 클래스를 모두 저장하는 패키지는 무엇일까요?",
            "두 String 객체가 동일한지 비교하기 위해 String 클래스의 다음 중 어떤 방법을 사용할까요?",
            "바이트, 정수 및 리터럴 숫자를 포함하는 표현식이 다음 중 어느 것으로 오를까요?"
    };

    //정답 리스트
    String answers[] = {"main method","<=","this","interface","public","import pkg.*","None of the mentioned","java","equals()","int"};
    //오답 리스트
    String opt[] = {
            "finalize method","main method","static method","private method",
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

        //수 증가
        count_quiz = findViewById(R.id.count_quiz);

        //이름불러오기
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        receive_name.setText(name);


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

                count++;
                count_quiz.setText(count+"/"+question.length);

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

        quit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),activity_result.class);
                startActivity(intent);
            }
        });
    }
}
