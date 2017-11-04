package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.steffy.myapplication.backend.jokeApi.JokeApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by steffy on 15/10/2017.
 */

public class AsyncJokeRetrieverTask extends AsyncTask<Void, Void, String> {

    private static final String TAG = AsyncJokeRetrieverTask.class.getSimpleName();
    private final Context context;

    public interface Callback {
        void onPreExecute();
        void onPostExecute(String joke);

    }
    private static JokeApi jokeApi;
    private final Callback callback;
    private final static String JOKE_API_URL = "http://10.0.2.2:8080/_ah/api/";


    public AsyncJokeRetrieverTask(Context context, Callback callback){
        this.callback = callback;
        this.context = context;

    }

    @Override
    protected void onPreExecute() {
        if(callback != null) callback.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... params) {
        if(jokeApi == null){
            jokeApi = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl(JOKE_API_URL)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    })
                    .setApplicationName("My Joke Api")
                    .build();

        }
        String joke = null;
        try {
            joke = jokeApi.getJoke().execute().getJoke();
        } catch (IOException e) {
            Log.e(TAG, "error while retrieving joke: " + e.getMessage());
        }

        return joke;
    }

    @Override
    protected void onPostExecute(String joke) {
        if(callback != null) callback.onPostExecute(joke);
    }
}
