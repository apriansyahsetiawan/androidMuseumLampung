package ilkom.unila.ac.id.museum.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import ilkom.unila.ac.id.museum.R;

public class ImageAdapter extends PagerAdapter {

    private ArrayList<Integer> images;
    private LayoutInflater inflater;
    private Context context;

    public ImageAdapter(Context context, ArrayList<Integer> images){
        this.context = context;
        this.images = images;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem (ViewGroup container, int position, Object objects) {
        container.removeView((View) objects);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object instantiateItem (ViewGroup view,int position) {
        View myImageLayout = inflater.inflate(R.layout.slide, view, false);
        ImageView imgFlipper = (ImageView) myImageLayout.findViewById(R.id.imgFlipper);
        imgFlipper.setImageResource(images.get(position));
        view.addView(myImageLayout);
        return myImageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
