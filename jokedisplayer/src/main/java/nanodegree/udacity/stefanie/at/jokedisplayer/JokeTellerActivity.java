package nanodegree.udacity.stefanie.at.jokedisplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeTellerActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE = "extra-joke";
    private String joke;

    private static final String DEFAULT_JOKE = "Is there a hole in your shoe? No? " +
                                            "Then how did you get your foot into it?";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_teller);

        if(getIntent().hasExtra(EXTRA_JOKE)){
            joke = getIntent().getStringExtra(EXTRA_JOKE);
        } else {
            joke = DEFAULT_JOKE;
        }

        ((TextView) findViewById(R.id.tv_joke)).setText(joke);

    }
}
