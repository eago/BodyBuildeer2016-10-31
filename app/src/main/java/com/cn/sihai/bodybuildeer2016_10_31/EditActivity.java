package com.cn.sihai.bodybuildeer2016_10_31;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import buildWorkOut.WorkOut;
import buildWorkOut.WorkoutFactory;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView, textView2, textView3, textView4, textView5;
    EditText editText, editText2, editText3;
    Spinner spinner, spinner2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView4 = (TextView)findViewById(R.id.textView4);
        textView5 = (TextView)findViewById(R.id.textView5);

        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);

        spinner = (Spinner)findViewById(R.id.spinner);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        String[] arrayPosition, arrayWorkout;
        arrayPosition = new String[] {"Shoulder", "Leg"};
        arrayWorkout = new String[] {"PullUp", "Squat"};
        ArrayAdapter<String> positionAdapter, workoutAdapter;
        positionAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayPosition);
        workoutAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayWorkout);
        spinner.setAdapter(positionAdapter);
        spinner2.setAdapter(workoutAdapter);


        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String position = spinner.getSelectedItem().toString();
        String workout = spinner2.getSelectedItem().toString();
        int group = Integer.parseInt(editText.getText().toString());
        int weight = Integer.parseInt(editText2.getText().toString());
        int repeat = Integer.parseInt(editText3.getText().toString());

        WorkoutFactory workoutFactory = new WorkoutFactory();
        WorkOut workoutObject = workoutFactory.getWorkout(position,workout,group,weight,repeat);

        if (group == 0 | editText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Group must not be 0 or empty",Toast.LENGTH_SHORT).show();
            return;
        }
        if (weight == 0 | editText2.getText().toString().isEmpty()) {
            Toast.makeText(this, "Weight must not be 0 or empty",Toast.LENGTH_SHORT).show();
            return;
        }
        if (repeat == 0 | editText3.getText().toString().isEmpty()) {
            Toast.makeText(this, "Number of repeat must not be 0 or empty",Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent();
        intent.putExtra(WorkOut.WO_DATA_KRY, workoutObject);
        setResult(RESULT_OK,intent);
        finish();


    }
}
