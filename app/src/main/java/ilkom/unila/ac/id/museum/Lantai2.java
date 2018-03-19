package ilkom.unila.ac.id.museum;

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

import ilkom.unila.ac.id.museum.Adapters.AdapterLantai2;
import ilkom.unila.ac.id.museum.Adapters.List_Lantai2;

public class Lantai2 extends AppCompatActivity {
    private ArrayList<List_Lantai2> listLantai2 = new ArrayList<>();
    RecyclerView recyclerView2;
    AdapterLantai2 adapterLantai2;
    String urlLantai2 = "http://192.168.43.241/museum/list_kategori.php?id_lantai=";
    String id_kategori2, nama_kategori2, id_lantai2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lantai2);

        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerLantai2);
        adapterLantai2 = new AdapterLantai2(listLantai2);
        recyclerView2.setAdapter(adapterLantai2);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView2.setLayoutManager(linearLayoutManager);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlLantai2 + 2, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("list_kategori");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        id_kategori2 = jsonObject.getString("id_kategori");
                        id_lantai2 = jsonObject.getString("id_lantai");
                        nama_kategori2 = jsonObject.getString("nama_kategori");

                        List_Lantai2 list_Lantai2 = new List_Lantai2(id_kategori2, id_lantai2, nama_kategori2);
                        listLantai2.add(list_Lantai2);
                    }
                    adapterLantai2.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Lantai2.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(this).add(jsonObjectRequest);

    }

}