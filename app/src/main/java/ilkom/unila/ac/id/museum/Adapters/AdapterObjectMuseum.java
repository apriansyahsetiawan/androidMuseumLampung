package ilkom.unila.ac.id.museum.Adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import ilkom.unila.ac.id.museum.DetailObjectMuseum;
import ilkom.unila.ac.id.museum.Holders.HolderObject;
import ilkom.unila.ac.id.museum.R;

/**
 * Created by user on 2/14/2018.
 */

public class AdapterObjectMuseum extends RecyclerView.Adapter<HolderObject> {

    public ArrayList<List_Object> list;

    public AdapterObjectMuseum(ArrayList<List_Object> listObjects) {
        this.list = listObjects;
    }

    @Override
    public HolderObject onCreateViewHolder(ViewGroup parent, int viewType) {
        View card = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_object, parent, false);
        return new HolderObject(card, parent.getContext());
    }

    @Override
    public void onBindViewHolder(final HolderObject holderObject, int position) {
        final List_Object dataObject = list.get(position);
        holderObject.updateUIobject(dataObject);
        holderObject.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailObjectMuseum.class);
                intent.putExtra("id_koleksi", dataObject.getId_koleksi());
//                Toast.makeText(v.getContext(), dataObject.getId_koleksi(), Toast.LENGTH_SHORT).show();
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
