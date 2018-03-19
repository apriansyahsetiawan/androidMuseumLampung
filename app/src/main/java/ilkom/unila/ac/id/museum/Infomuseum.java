package ilkom.unila.ac.id.museum;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import ilkom.unila.ac.id.museum.Adapters.Adapterinfo;
import me.relex.circleindicator.CircleIndicator;

public class Infomuseum extends AppCompatActivity {

    ImageView telp, mail;
    private static ViewPager viewPager;
    private static int currentPage1 = 0;
    private static final Integer[] flipper1 = {R.drawable.p1, R.drawable.p2, R.drawable.p3,};
    private ArrayList<Integer> imageFlipper1 = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infomuseum);
        init();
        telp = (ImageView) findViewById(R.id.telp);
        mail = (ImageView) findViewById(R.id.mail);

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent send = new Intent(Intent.ACTION_SENDTO);
                String uriText = "mailto:" + Uri.encode("museumlampunglpg@gmail.com") + "?subject="
                        + Uri.encode("") + "&body=" + Uri.encode("");
                Uri uri = Uri.parse(uriText);

                send.setData(uri);
                startActivity(Intent.createChooser(send, "send mail..."));
            }
        });

        telp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomor = "0721783688";
                String dial = "tel:" + nomor;
                Intent call = new Intent(Intent.ACTION_CALL, Uri.parse(dial));
                if (ActivityCompat.checkSelfPermission(Infomuseum.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(call);


            }
        });

    }

    private void init() {
        for (int i = 0; i < flipper1.length; i++)
            imageFlipper1.add(flipper1[i]);

        viewPager = (ViewPager) findViewById(R.id.pagerinfo);
        viewPager.setAdapter(new Adapterinfo(Infomuseum.this, imageFlipper1));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicatorinfo);
        indicator.setViewPager(viewPager);

        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage1 == flipper1.length) {
                    currentPage1 = 0;
                }
                viewPager.setCurrentItem(currentPage1++, true);
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
