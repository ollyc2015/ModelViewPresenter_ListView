package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import uk.co.oliverbcurtis.ModelViewPresenter_Listview.R;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Cosmetic;

public class CosmeticAdapter extends ArrayAdapter<Cosmetic> {


    public CosmeticAdapter(@NonNull Context context, ArrayList<Cosmetic> cosmeticArrayList) {
        super(context,0, cosmeticArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Get the data item for this position
        Cosmetic cosmetic = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_cosmetic, parent, false);
        }
        // Lookup view for data population
        ImageView iv_cosmetic = (ImageView) convertView.findViewById(R.id.iv_cosmetic);
        TextView tv_cosmetic = (TextView) convertView.findViewById(R.id.tv_cosmetic);
        // Populate the data into the template view using the data object
        Picasso.get().load(cosmetic.getImageLink()).into(iv_cosmetic);
        tv_cosmetic.setText(cosmetic.getName());
        // Return the completed view to render on screen
        return convertView;

    }
}
