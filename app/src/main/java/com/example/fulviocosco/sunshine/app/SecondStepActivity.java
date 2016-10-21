package com.example.fulviocosco.sunshine.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by fulviocosco on 20/10/2016.
 */

public class SecondStepActivity extends AppCompatActivity {

    TextView dataView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_step);

        dataView = (TextView) findViewById(R.id.data);
        Intent intent = getIntent();
        Bundle response = intent.getExtras();

    }
}
