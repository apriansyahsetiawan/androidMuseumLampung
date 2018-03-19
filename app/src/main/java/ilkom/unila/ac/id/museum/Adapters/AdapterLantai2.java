package ilkom.unila.ac.id.museum.Adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import ilkom.unila.ac.id.museum.Holders.HolderLantai2;
import ilkom.unila.ac.id.museum.ListObjectMuseum;
import ilkom.unila.ac.id.museum.R;

/**
 * Created by user on 2/14/2018.
 */

public class AdapterLantai2 extends RecyclerView.Adapter<HolderLantai2>  {
    public ArrayList<List_Lantai2> listLantai2;

    public AdapterLantai2(ArrayList<List_Lantai2> listLantai2) {
        this.listLantai2 = listLantai2;
    }

    @Override
    public HolderLantai2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View card = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_lantai2, parent, false);
        return new HolderLantai2(card, parent.getContext());
    }

    @Override
    public void onBindViewHolder(HolderLantai2 holder2, int position) {
        final List_Lantai2 data2 = listLantai2.get(position);
        holder2.updateUI2(data2);
        holder2.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ListObjectMuseum.class);
                intent.putExtra("id_kategori", data2.getId_kategori2());
//                Toast.makeText(v.getContext(), data2.getId_kategori2(), Toast.LENGTH_SHORT).show();
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listLantai2.size();
    }
}
