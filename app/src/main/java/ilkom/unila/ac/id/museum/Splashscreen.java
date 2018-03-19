package ilkom.unila.ac.id.museum;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Splashscreen extends AppCompatActivity {
    ProgressBar progressBar;
    ImageView imgSplash;
    TextView txtSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splashscreen);

        imgSplash = (ImageView)findViewById(R.id.imgSplash);
        txtSplash = (TextView) findViewById(R.id.txtSplash);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, 2000);
    }
}
