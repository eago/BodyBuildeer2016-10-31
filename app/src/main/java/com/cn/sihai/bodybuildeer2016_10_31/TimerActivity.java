package com.cn.sihai.bodybuildeer2016_10_31;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Toast;

import buildWorkOut.WorkOut;
import buildWorkOut.WorkoutFactory;

public class TimerActivity extends AppCompatActivity {

    TextView timerTextView;
    TextView textView24, textView25, textView26, textView27, textView28, textView29, textView30, textView31;
    Button button2, button3,button4,button5,button6,button7,stopButton, backButton;

    long startTime = 0;

    //runs without a timer by reposting this handler at the end of the runnable
    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;

            timerTextView.setText(String.format("%d:%02d", minutes, seconds));

            timerHandler.postDelayed(this, 500);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        Intent intent =getIntent();
        WorkOut workOut = (WorkOut) intent.getExtras().get(MainActivity.EXTRA_timer);

        textView24 = (TextView)findViewById(R.id.TextView24);
        textView25 = (TextView)findViewById(R.id.TextView25);
        textView26 = (TextView)findViewById(R.id.TextView26);
        textView27 = (TextView)findViewById(R.id.TextView27);
        textView28 = (TextView)findViewById(R.id.TextView28);
        textView29 = (TextView)findViewById(R.id.TextView29);
        textView30 = (TextView)findViewById(R.id.TextView30);
        textView31 = (TextView)findViewById(R.id.TextView31);
        if (workOut != null) {
            textView24.setText("Postion");
            textView25.setText(workOut.getPosition());
            textView26.setText("Weight");
            textView27.setText(Integer.toString(workOut.getWeight()));
            textView28.setText("RM");
            textView29.setText(Integer.toString(workOut.getRepeat()));
            textView30.setText("Group");
            textView31.setText(Integer.toString(workOut.getGroup()));
        } else {
            Toast.makeText(this, "Workout is null",Toast.LENGTH_SHORT).show();
        }

        timerTextView = (TextView) findViewById(R.id.timerTextView);

        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);

        stopButton = (Button) findViewById(R.id.stopButton);
        backButton = (Button) findViewById(R.id.backButton);


    }
}
