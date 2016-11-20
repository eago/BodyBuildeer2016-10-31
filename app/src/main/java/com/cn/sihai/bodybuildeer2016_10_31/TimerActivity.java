package com.cn.sihai.bodybuildeer2016_10_31;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.media.ToneGenerator;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Toast;
import android.media.Ringtone;
import android.os.Vibrator;

import java.io.IOException;

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
            if(minutes == 1 && seconds == 30) {
                Vibrator vibrator = (Vibrator) getBaseContext().getSystemService(Context.VIBRATOR_SERVICE);
                long[] pattern = {500, 500};
                try {
                    Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                    r.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                vibrator.vibrate(pattern, 1);

            }

            timerTextView.setText(String.format("%d:%02d", minutes, seconds));

            timerHandler.postDelayed(this, 500);
        }
    };

    public void playSound(Context context) throws IllegalArgumentException,
            SecurityException,
            IllegalStateException,
            IOException {

        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        MediaPlayer mMediaPlayer = new MediaPlayer();
        mMediaPlayer.setDataSource(context, soundUri);
        final AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        if (audioManager.getStreamVolume(AudioManager.STREAM_ALARM) != 0) {
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_ALARM);
            mMediaPlayer.setLooping(true);
            mMediaPlayer.prepare();
            mMediaPlayer.start();
        }
    }

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
            textView24.setText(workOut.getPosition());
            textView25.setText(workOut.getName());
            textView26.setText(R.string.ticket_weight);
            textView27.setText(Integer.toString(workOut.getWeight()));
            textView28.setText(R.string.ticket_repeat);
            textView29.setText(Integer.toString(workOut.getRepeat()));
            textView30.setText(R.string.ticket_group);
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
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                button2.setText(R.string.ticket_ok);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                button3.setText(R.string.ticket_ok);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                button4.setText(R.string.ticket_ok);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                button5.setText(R.string.ticket_ok);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                button6.setText(R.string.ticket_ok);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                button7.setText(R.string.ticket_ok);
            }
        });

        stopButton = (Button) findViewById(R.id.stopButton);
        stopButton.setText(R.string.action_start);
        stopButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                if (b.getText().equals(R.string.action_stop)) {
                    timerHandler.removeCallbacks(timerRunnable);
                    b.setText(R.string.action_start);
                } else {
                    startTime = System.currentTimeMillis();
                    timerHandler.postDelayed(timerRunnable, 0);
                    b.setText(R.string.action_stop);
                }
            }
        });
    }

        //backButton = (Button) findViewById(R.id.backButton);

}
