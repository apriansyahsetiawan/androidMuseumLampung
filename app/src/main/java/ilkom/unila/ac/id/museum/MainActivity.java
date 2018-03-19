package ilkom.unila.ac.id.museum;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import ilkom.unila.ac.id.museum.Adapters.ImageAdapter;
import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {


    Button KoleksiMuseum, SejarahMuseum, Infomuseum;
    ImageView Navigasi, About, Bantuan;
//    ImageButton Bantuan;

    private static ViewPager viewPager;
    private static int currentPage = 0;
    private static final Integer[] flipper = {R.drawable.image_slider_1, R.drawable.image_slider_2, R.drawable.image_slider_3,
            R.drawable.image_slider_4, R.drawable.image_slider_5, R.drawable.image_slider_6};
    private ArrayList<Integer> imageFlipper = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        KoleksiMuseum = (Button) findViewById(R.id.koleksimuseum);
        KoleksiMuseum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ilkom.unila.ac.id.museum.KoleksiMuseum.class);
                startActivity(i);
            }
        });
        SejarahMuseum = (Button) findViewById(R.id.sejarahmuseum);
        SejarahMuseum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SejarahMuseum.class);
                startActivity(i);
            }
        });

        Infomuseum = (Button) findViewById(R.id.infomuseum);
        Infomuseum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Infomuseum.class);
                startActivity(i);

            }
        });

        Navigasi = (ImageView) findViewById(R.id.navigasi);
        Navigasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        About = (ImageView) findViewById(R.id.about);
        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
            }
        });
    }


    private void init() {
        for (int i = 0; i < flipper.length; i++)
            imageFlipper.add(flipper[i]);

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new ImageAdapter(MainActivity.this, imageFlipper));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);

        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage == flipper.length) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 2500, 2500);
    }
}