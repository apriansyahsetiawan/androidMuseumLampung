package ilkom.unila.ac.id.museum;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ilkom.unila.ac.id.museum.Adapters.AdapterLantai1;
import ilkom.unila.ac.id.museum.Adapters.List_Lantai1;
import ilkom.unila.ac.id.museum.Adapters.List_Object;

public class Lantai1 extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private ArrayList<List_Lantai1> listLantai1 = new ArrayList<>();
    private ArrayList<List_Object> listObjects = new ArrayList<>();
    RecyclerView recyclerView1;
    AdapterLantai1 adapterLantai1;
    SearchView cari1;
    String urlLantai1 = "http://192.168.43.241/museum/list_kategori.php?id_lantai=";
    String url_cari = "http://192.168.43.241/museum/carikoleksi.php";
    String id_kategori, nama_kategori, id_lantai;
    String id_koleksi, nama_jenis_koleksi, gambar, nama_koleksi, asal_koleksi;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lantai1);

        recyclerView1 = (RecyclerView) findViewById(R.id.recyclerLantai1);
        adapterLantai1 = new AdapterLantai1(listLantai1);
        cari1 = (SearchView) findViewById(R.id.carilantai1);
        recyclerView1.setAdapter(adapterLantai1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(linearLayoutManager);

        cari1.setQueryHint("cari objek wisata");
        cari1.setIconified(true);
        cari1.setOnQueryTextListener(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlLantai1 + 1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("list_kategori");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        id_kategori = jsonObject.getString("id_kategori");
                        id_lantai = jsonObject.getString("id_lantai");
                        nama_kategori = jsonObject.getString("nama_kategori");

                        List_Lantai1 list_Lantai1 = new List_Lantai1(id_kategori, id_lantai, nama_kategori);
                        listLantai1.add(list_Lantai1);
                    }
                    adapterLantai1.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Lantai1.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(this).add(jsonObjectRequest);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        cariData(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    private void cariData(final String keyword) {
        StringRequest request = new StringRequest(Request.Method.POST, url_cari, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Response : ", response.toString());
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    int value = jsonObject.getInt("value");
                    if (value == 1) {
                        listLantai1.clear();
                        adapterLantai1.notifyDataSetChanged();

                        String getKoleksi = jsonObject.getString("result");
                        JSONArray jsonArray = new JSONArray(getKoleksi);

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
//                           List_Lantai1 carilist = new List_Lantai1(id_kategoric, id_lantaic, nama_kategoric);

                            List_Object carilist = new List_Object(id_koleksi, nama_jenis_koleksi, gambar, nama_koleksi, asal_koleksi);
                            carilist.setId_koleksi(object.getString("id_koleksi"));
                            carilist.setNama_jenis_koleksi(object.getString("nama_jenis_koleksi"));
                            carilist.setGambar(object.getString("gambar"));
                            carilist.setNama_koleksi(object.getString("nama_koleksi"));
                            carilist.setAsal_koleksi(object.getString("asal_koleksi"));

                            listObjects.add(carilist);
                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                adapterLantai1.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("tag", "Error : " + error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("keyword", keyword);

                return params;
            }
        };
        Volley.newRequestQueue(this).add(request);
    }

}

