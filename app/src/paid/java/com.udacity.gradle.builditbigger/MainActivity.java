package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import nanodegree.udacity.stefanie.at.jokedisplayer.JokeTellerActivity;


public class MainActivity extends AppCompatActivity implements AsyncJokeRetrieverTask.Callback {

    private static final String TAG = MainActivity.class.getSimpleName();
    private View progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressbar);
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

    public void tellJoke(View view) {
        //Toast.makeText(this, JokeProvider.getJoke(), Toast.LENGTH_SHORT).show();
        AsyncJokeRetrieverTask asyncJokeRetrieverTask = new AsyncJokeRetrieverTask(this, this);
        asyncJokeRetrieverTask.execute();

    }


    @Override
    public void onPreExecute() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPostExecute(String joke) {

        if(joke == null){
            //  probably no connection to server
            Log.e(TAG, "no joke received");
            Toast.makeText(this, getString(R.string.no_connection), Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, JokeTellerActivity.class);
            intent.putExtra(JokeTellerActivity.EXTRA_JOKE, joke);
            startActivity(intent);
        }
        progressBar.setVisibility(View.GONE);

    }
}
