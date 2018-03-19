package ilkom.unila.ac.id.museum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class KoleksiMuseum extends AppCompatActivity {

    ImageView lantai1, lantai2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koleksimuseum);

        lantai1 = (ImageView) findViewById(R.id.lantai1);
        lantai2 = (ImageView) findViewById(R.id.lantai2);

        lantai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KoleksiMuseum.this, Lantai1.class);
                startActivity(intent);
            }
        });

        lantai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KoleksiMuseum.this, Lantai2.class);
                startActivity(intent);
            }
        });
    }
}
