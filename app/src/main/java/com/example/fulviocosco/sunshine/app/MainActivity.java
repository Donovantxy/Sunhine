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

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnSystemUiVisibilityChangeListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    private RelativeLayout relativeLayout;
    private Button submitBtn;
    private EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);

        //Button button1 = (Button) findViewById(R.id.submit);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

    }

    @Override
    public void onClick(View v) {
        //this.relativeLayout.setBackgroundColor(Color.GREEN);
        //Log.i(TAG, v.getId() +" - "+ R.id.button1 + " BckgColor: "+Color.GREEN);
    }

    public void onSystemUiVisibilityChange(int visibility){

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

//    public void changeBckgToGhGreen(View view) {
//        this.relativeLayout.setBackgroundColor(0xFF24B5B8);
//    }

    public void submitLogin(View view) {
        Intent secondStep = new Intent(this, SecondStepActivity.class);
        //Intent secondStep = new Intent(Intent.ACTION_VIEW);

        Bundle data = new Bundle();
        data.putString(LoginKeys.USERNAME, username.getText().toString());
        data.putString(LoginKeys.PASSWORD, password.getText().toString());

        secondStep.putExtras(data);
        startActivity(secondStep);
    }
}
