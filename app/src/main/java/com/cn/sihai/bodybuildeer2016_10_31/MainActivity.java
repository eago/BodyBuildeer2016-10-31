package com.cn.sihai.bodybuildeer2016_10_31;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.R.layout.*;

import buildWorkOut.PullUp;
import buildWorkOut.Squat;
import buildWorkOut.WorkOut;

public class MainActivity extends AppCompatActivity {
    ListView myListView;
    ArrayAdapter<WorkOut> myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myListView= (ListView)findViewById(R.id.listView);
       // myAdapter = new ArrayAdapter<WorkOut>(this,android.R.layout.simple_list_item_single_choice);
        myAdapter = new WorkoutAdapter(this);
        myAdapter.add(new Squat(100, 4, 12));
        myAdapter.add(new PullUp(70, 4, 8));
        myListView.setAdapter(myAdapter);


       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                       // .setAction("Action", null).show();
                getEditActivity(view);
            }
        });
    }

    public void getEditActivity(View view){
        Intent intentEdit = new Intent(this, EditActivity.class);
        startActivity(intentEdit);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
