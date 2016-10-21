package com.example.fulviocosco.sunshine.app;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    private RelativeLayout relativeLayout;
    private Button submitBtn;
    private EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);

        //Button button1 = (Button) findViewById(R.id.button1);
        //Button button2 = (Button) findViewById(R.id.button2);
        //button1.setOnClickListener(this);
        //button2.setOnClickListener(this);
        //button2.setOnClickListener(this.sendEmail());

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        submitBtn = (Button) findViewById(R.id.submit);
    }

    @Override
    public void onClick(View v) {
        //this.relativeLayout.setBackgroundColor(Color.GREEN);
        //Log.i(TAG, v.getId() +" - "+ R.id.button1 + " BckgColor: "+Color.GREEN);
    }

    private View.OnClickListener sendEmail(){
        return (new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               //relativeLayout.setBackgroundColor(0);
               //Log.i(TAG, "Email sent! "+ R.id.button2 +" - "+ v.getId());
            }
        });
    }


    public void changeBckgToGhGreen(View view) {
        this.relativeLayout.setBackgroundColor(0xFF24B5B8);
    }

    public void submitLogin(View view) {
        Intent goToSecondStep = new Intent(this, SecondStepActivity.class);

        Bundle data = new Bundle();
        data.putString("user", username.getText().toString());
        data.putString("password", password.getText().toString());

        startActivity(goToSecondStep);
    }
}
