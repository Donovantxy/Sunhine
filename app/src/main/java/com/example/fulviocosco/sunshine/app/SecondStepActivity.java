package com.example.fulviocosco.sunshine.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.fulviocosco.sunshine.app.rest.model.MovieResults;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.JsonObject;

import java.util.ArrayList;

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
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_step);

        b_username = (TextView) findViewById(R.id.b_username);
        b_password = (TextView) findViewById(R.id.b_password);

        Intent intent = getIntent();
        MyUser mu = intent.getExtras().getParcelable("MyUser");
        Log.i("Second Activity", ": " + mu.getUserName());

        b_username.setText(mu.getUserName());
        b_password.setText(mu.getPassword());

        //mu = intent.getParcelableExtra("MyUser");
        //Log.i(200 +": "+intent.getStringExtra("usernNme"), intent.getStringExtra("password"));
        //Log.i("Second Activity", ": "+intent.getParcelableExtra("MyUser").toString());
        //Log.i("Second Activity", ": "+intent.getParc
        // elableExtra("MyUser"));

        //Bundle data = intent.getExtras();
        //b_username.setText(data.getString(LoginKeys.USERNAME, "No username"));
        //b_password.setText(data.getString(LoginKeys.PASSWORD, ""));

        //b_username.setText(mu.getUserName());
        //b_password.setText(mu.getPassword());

        // api_key=c4637c00d2d0a9d2d183af069b0c7c21

        Retrofit apiClient = ApiClient.getClient();

        MoviesAPI movieApi = apiClient.create(MoviesAPI.class);

        Call<MovieResults> call = movieApi.getTopRated(ApiClient.KEY_API);
        Call<JsonObject> callJson = movieApi.getTopRatedJson(ApiClient.KEY_API);

        call.enqueue(new Callback<MovieResults>() {
            @Override
            public void onResponse(Call<MovieResults> call, Response<MovieResults> response) {
                MovieResults movieResult = response.body();
                ArrayList<Movie> arrMovie = response.body().getResults();
                Movie movie = arrMovie.get(0);
                //System.out.println("RESPONSE: "+ response.body());
                Log.d("Response", arrMovie.get(0).getTitle());
            }

            @Override
            public void onFailure(Call<MovieResults> call, Throwable t) {
                Log.e("Error", t.toString());
            }
        });

        callJson.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                JsonObject body = response.body();
                // JsonElement members = body.get("results");
                //Log.d("callJson", response.body().toString());
                //JsonArray results = body.get("results").getAsJsonArray();
                //JsonElement firstPopularMovie = results.get(0);
                //Log.d("First movie", results.toString() );
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("SecondStep Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
