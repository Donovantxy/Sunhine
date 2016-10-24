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

    TextView b_username;
    TextView b_password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_step);

        b_username = (TextView) findViewById(R.id.b_username);
        b_password = (TextView) findViewById(R.id.b_password);

        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        b_username.setText(data.getString(LoginKeys.USERNAME, "No username"));
        b_password.setText(data.getString(LoginKeys.PASSWORD, ""));

    }
}
