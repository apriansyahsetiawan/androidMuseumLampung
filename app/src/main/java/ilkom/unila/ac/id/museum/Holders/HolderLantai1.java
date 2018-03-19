package ilkom.unila.ac.id.museum.Holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ilkom.unila.ac.id.museum.Adapters.List_Lantai1;
import ilkom.unila.ac.id.museum.R;

/**
 * Created by user on 2/13/2018.
 */

public class HolderLantai1 extends RecyclerView.ViewHolder {
    ImageView img_kategori;
    TextView nama_kategori;
    String id_kategori;
    private Context context;

    public HolderLantai1(View itemView, final Context context) {
        super(itemView);
        this.context = context;

        img_kategori = (ImageView) itemView.findViewById(R.id.imgKategori);
        nama_kategori = (TextView) itemView.findViewById(R.id.nama_kategori);
    }

    public void updateUI(List_Lantai1 data) {
        id_kategori = data.getId_kategori();
        nama_kategori.setText(data.getNama_kategori());
    }
}
