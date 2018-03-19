package ilkom.unila.ac.id.museum;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

public class DetailObjectMuseum extends AppCompatActivity {

    String id_koleksi, nama_koleksi, gambar, nama_jenis_koleksi, asal_koleksi, deskripsi;
    String urlDetail = "http://192.168.43.241/museum/detail_koleksi.php?id_koleksi=";
    TextView namakoleksi, jeniskoleksi, asalkoleksi, deskripsikoleksi;
    FloatingActionButton play;
    String ngomong;
    TextToSpeech speech;
    boolean stop = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_object_museum);

        namakoleksi = (TextView) findViewById(R.id.nama_detail_koleksi);
        jeniskoleksi = (TextView) findViewById(R.id.jenis_detail_koleksi);
        asalkoleksi = (TextView) findViewById(R.id.asal_detail_koleksi);
        deskripsikoleksi = (TextView) findViewById(R.id.deskripsi_detail_koleksi);
        play = (FloatingActionButton) findViewById(R.id.fab_play);

        speech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
//                    speech.setLanguage(Locale.US);
//                    speech.setSpeechRate(1);
                    Locale indo = new Locale("in", "IN");
                    speech.setLanguage(indo);

                }
            }
        });
        play.setImageResource(R.drawable.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stop) {
                    Speak();
                    stop = false;
                    play.setImageResource(R.drawable.stop);
                } else {
                    if (speech.isSpeaking()) {
                        Stopped();
                        stop = true;
                        play.setImageResource(R.drawable.play);
                    }
                }
            }
        });

        Intent intent = getIntent();
        String idKoleksi = intent.getStringExtra("id_koleksi");

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlDetail + idKoleksi, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("detail_koleksi");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        id_koleksi = jsonObject.getString("id_koleksi");
                        nama_koleksi = jsonObject.getString("nama_koleksi");
                        nama_jenis_koleksi = jsonObject.getString("nama_jenis_koleksi");
                        asal_koleksi = jsonObject.getString("asal_koleksi");
                        gambar = jsonObject.getString("gambar");
                        deskripsi = jsonObject.getString("deskripsi");

                        namakoleksi.setText(nama_koleksi);
                        jeniskoleksi.setText(nama_jenis_koleksi);
                        asalkoleksi.setText(asal_koleksi);
                        deskripsikoleksi.setText(deskripsi);
                        ngomong = deskripsikoleksi.getText().toString();

                    }
//                    Toast.makeText(DetailObjectMuseum.this, nama_koleksi + " " + nama_jenis_koleksi + " " + asal_koleksi, Toast.LENGTH_SHORT).show();
//                    adapterObjectMuseum.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DetailObjectMuseum.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(this).add(jsonObjectRequest);

    }

    private void Stopped() {
        speech.stop();
    }

    private void Speak() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            speech.speak(ngomong, TextToSpeech.QUEUE_FLUSH, null, null);
        } else {
            speech.speak(ngomong, TextToSpeech.QUEUE_FLUSH, null);
        }
    }


}
