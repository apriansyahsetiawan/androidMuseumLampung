package ilkom.unila.ac.id.museum.Adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import ilkom.unila.ac.id.museum.Holders.HolderLantai1;
import ilkom.unila.ac.id.museum.ListObjectMuseum;
import ilkom.unila.ac.id.museum.R;

/**
 * Created by user on 2/13/2018.
 */

public class AdapterLantai1 extends RecyclerView.Adapter<HolderLantai1> {
    public ArrayList<List_Lantai1> listLantai1;

    public AdapterLantai1(ArrayList<List_Lantai1> listLantai1) {
        this.listLantai1 = listLantai1;
    }

    @Override
    public HolderLantai1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View card = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_lantai1, parent, false);
        return new HolderLantai1(card, parent.getContext());
    }

    @Override
    public void onBindViewHolder(final HolderLantai1 holder, int position) {
        final List_Lantai1 data = listLantai1.get(position);
        holder.updateUI(data);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ListObjectMuseum.class);
                intent.putExtra("id_kategori", data.getId_kategori());
//                Toast.makeText(v.getContext(), data.getId_kategori(), Toast.LENGTH_SHORT).show();
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listLantai1.size();
    }
}
