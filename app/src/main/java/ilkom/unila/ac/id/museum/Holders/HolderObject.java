package ilkom.unila.ac.id.museum.Holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ilkom.unila.ac.id.museum.Adapters.List_Object;
import ilkom.unila.ac.id.museum.R;

/**
 * Created by user on 2/14/2018.
 */

public class HolderObject extends RecyclerView.ViewHolder  {
    ImageView imgObject;
    TextView nama_koleksi, jenis_koleksi, asal_koleksi;
    String id_koleksi, id_kategori, id_jenis;
    private Context context;

    public HolderObject(View itemView, final Context context) {
        super(itemView);
        this.context = context;

        imgObject = (ImageView) itemView.findViewById(R.id.imgObject);
        nama_koleksi = (TextView) itemView.findViewById(R.id.nama_koleksi);
        jenis_koleksi = (TextView) itemView.findViewById(R.id.jenis_koleksi);
        asal_koleksi = (TextView) itemView.findViewById(R.id.asal_koleksi);
    }

    public void updateUIobject(List_Object data) {
        id_koleksi = data.getId_koleksi();
        nama_koleksi.setText(data.getNama_koleksi());
        jenis_koleksi.setText(data.getNama_jenis_koleksi());
        asal_koleksi.setText(data.getAsal_koleksi());
    }
}
