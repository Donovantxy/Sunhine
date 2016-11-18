package com.example.fulviocosco.sunshine.app;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.fulviocosco.sunshine.app.rest.RestClient;
import com.example.fulviocosco.sunshine.app.rest.model.MovieResults;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnSystemUiVisibilityChangeListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RelativeLayout relativeLayout;
    private Button submitBtn;
    private EditText username, password;
    private MyUser mu;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client2;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);

        //Button button1 = (Button) findViewById(R.id.submit);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        getPopularMovies();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2 = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onClick(View v) {
        //this.relativeLayout.setBackgroundColor(Color.GREEN);
        //Log.i(TAG, v.getId() +" - "+ R.id.button1 + " BckgColor: "+Color.GREEN);
    }

    public void onSystemUiVisibilityChange(int visibility) {

    }

    private View.OnClickListener sendEmail() {
        return (new View.OnClickListener() {
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


    @RequiresApi(api = Build.VERSION_CODES.N)
    void getPopularMovies() {

        RestClient client = new RestClient();
        //Observable<MovieResults> topRated = client.getApiMovie().getTopRated()
        Observable<ArrayList<Movie>> topRated = client.getApiMovie().getTopRated()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map( (data) -> {
                    Log.i( "INFO MAP",  data.getResults().toString() );
                    return data.getResults();
                });


        topRated.flatMapIterable((movie) ->{
                    Log.i( "INFO Movie",  movie.toString() );
                    return movie;
                })
                .subscribe( (movie) -> {
                    Character.UnicodeBlock block = Character.UnicodeBlock.of(movie.getTitle().charAt(1));
                    System.out.println( "OUT: " + block );
                    boolean isChinese = Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS.equals(block) ||
                                        Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS.equals(block) ||
                                        Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A.equals(block);
                    if( isChinese ){
                        Log.i("SINGLE MOVIE: ", movie.getId() +" - "+ movie.getTitle() );
                    }
                    else{
                        Log.i("SINGLE MOVIE: ", movie.getId() +" - "+ movie.getOriginal_title() );
                    }
                });
//                .subscribe( (data) -> {
//                    Log.d("DATA:", data.toString() );
//                    Log.d("DATA:", data.toString() );
//                    ArrayList<Movie> results = data.getResults();
//
////                    results.forEach(movie -> {
////                        Log.d("MOVIE", movie.getOriginal_title());
////                    });
//
//                    for(Movie movie : results){
//                        Log.d("MOVIE: ", movie.getId() +" - "+ movie.getOriginal_title());
//                    }
//
//                    Log.d("DATA:", data.getResults().toString() );
//            Log.d("END", "end of debug");
//        });



    }

    public void submitLogin(View view) {
        //Intent secondStep = new Intent(Intent.ACTION_VIEW);

        //Bundle data = new Bundle();
        //data.putString(LoginKeys.USERNAME, username.getText().toString());
        //data.putString(LoginKeys.PASSWORD, password.getText().toString());
        //seconßdStep.putExtra(LoginKeys.PASSWORD, password.getText().toString() + "__");

        Intent secondStep = new Intent(this, SecondStepActivity.class);
        mu = new MyUser(
                username.getText().toString(),
                password.getText().toString()
        );

        secondStep.putExtra("MyUser", mu);
        //secondStep.putExtras(data);
        Log.i(100 + ": " + mu.getUserName(), mu.getPassword());
        startActivity(secondStep);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
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
        client2.connect();
        AppIndex.AppIndexApi.start(client2, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client2, getIndexApiAction());
        client2.disconnect();
    }
}
