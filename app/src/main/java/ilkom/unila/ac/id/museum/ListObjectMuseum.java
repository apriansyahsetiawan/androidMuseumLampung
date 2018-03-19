package ilkom.unila.ac.id.museum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ilkom.unila.ac.id.museum.Adapters.AdapterObjectMuseum;
import ilkom.unila.ac.id.museum.Adapters.List_Object;

public class ListObjectMuseum extends AppCompatActivity {
    private ArrayList<List_Object> listObjects = new ArrayList<>();
    RecyclerView recyclerView;
    AdapterObjectMuseum adapterObjectMuseum;
    String id_koleksi, nama_koleksi, gambar, nama_jenis_koleksi, asal_koleksi;
    String urllistkoleksi = "http://192.168.43.241/museum/koleksi.php?id_kategori=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_museum);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerObject);
        adapterObjectMuseum = new AdapterObjectMuseum(listObjects);
        recyclerView.setAdapter(adapterObjectMuseum);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        Intent intent = getIntent();
        String id_kategori = intent.getStringExtra("id_kategori");

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urllistkoleksi + id_kategori, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("koleksi");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        id_koleksi = jsonObject.getString("id_koleksi");
                        nama_koleksi = jsonObject.getString("nama_koleksi");
                        nama_jenis_koleksi = jsonObject.getString("nama_jenis_koleksi");
                        asal_koleksi = jsonObject.getString("asal_koleksi");
                        gambar = jsonObject.getString("gambar");

                        List_Object list_object = new List_Object(id_koleksi, nama_jenis_koleksi, gambar, nama_koleksi, asal_koleksi);
                        listObjects.add(list_object);
                    }
                    adapterObjectMuseum.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ListObjectMuseum.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(this).add(jsonObjectRequest);

    }
}