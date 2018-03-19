package ilkom.unila.ac.id.museum.Holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ilkom.unila.ac.id.museum.Adapters.List_Lantai2;
import ilkom.unila.ac.id.museum.R;

/**
 * Created by user on 2/14/2018.
 */

public class HolderLantai2 extends RecyclerView.ViewHolder  {
    ImageView img_kategori2;
    TextView nama_kategori2;
    String id_kategori2;
    private Context context;

    public HolderLantai2(View itemView, final Context context) {
        super(itemView);
        this.context = context;

        img_kategori2 = (ImageView) itemView.findViewById(R.id.imgKategori2);
        nama_kategori2 = (TextView) itemView.findViewById(R.id.nama_kategori2);
    }

    public void updateUI2(List_Lantai2 data2) {
        id_kategori2 = data2.getId_kategori2();
        nama_kategori2.setText(data2.getNama_kategori2());
    }
}
