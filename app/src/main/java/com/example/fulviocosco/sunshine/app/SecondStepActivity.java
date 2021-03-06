package com.example.fulviocosco.sunshine.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by fulviocosco on 20/10/2016.
 */

public class SecondStepActivity extends AppCompatActivity {

    TextView b_username;
    TextView b_password;
    MyUser mu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_step);

        b_username = (TextView) findViewById(R.id.b_username);
        b_password = (TextView) findViewById(R.id.b_password);

        Intent intent = getIntent();
        MyUser mu = intent.getExtras().getParcelable("MyUser");
        Log.i("Second Activity", ": "+mu.getUserName());

        b_username.setText(mu.getUserName());
        b_password.setText(mu.getPassword());

        //mu = intent.getParcelableExtra("MyUser");
        //Log.i(200 +": "+intent.getStringExtra("usernNme"), intent.getStringExtra("password"));
        //Log.i("Second Activity", ": "+intent.getParcelableExtra("MyUser").toString());
        //Log.i("Second Activity", ": "+intent.getParcelableExtra("MyUser"));

        //Bundle data = intent.getExtras();
        //b_username.setText(data.getString(LoginKeys.USERNAME, "No username"));
        //b_password.setText(data.getString(LoginKeys.PASSWORD, ""));

        //b_username.setText(mu.getUserName());
        //b_password.setText(mu.getPassword());

        // api_key=c4637c00d2d0a9d2d183af069b0c7c21

        Retrofit apiClient = ApiClient.getClient();

        MoviesAPI movieApi = apiClient.create(MoviesAPI.class);

        Call<MovieResults> call = movieApi.getTopRated(ApiClient.KEY_API);
        call.enqueue(new Callback<MovieResults>() {
            @Override
            public void onResponse(Call<MovieResults> call, Response<MovieResults> response) {
                System.out.println("RESPONSE: "+ response.body().toString());
                //Log.d("Response", response.body().getTotal_result());
            }

            @Override
            public void onFailure(Call<MovieResults> call, Throwable t) {
                Log.e("Error", t.toString());
            }
        });


    }
}
