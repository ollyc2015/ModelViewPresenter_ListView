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
import java.util.List;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.R;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Meal;

public class MealListAdapter extends ArrayAdapter<Meal> {


    public MealListAdapter(@NonNull Context context, List<Meal> mealArrayList) {
        super(context,0,mealArrayList);
    }

    /*
    public void updateList(List<Meal> meal) {
        this.meal = meal;
        notifyDataSetChanged();
    }
    */

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Get the data item for this position
        Meal meal = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.meal_list_layout, parent, false);
        }
        // Lookup view for data population
        ImageView iv_cosmetic = (ImageView) convertView.findViewById(R.id.iv_meal);
        TextView tv_cosmetic = (TextView) convertView.findViewById(R.id.tv_meal);

        // Populate the data into the template view using the data object
        Picasso.get().load(meal.getStrMealThumb()).into(iv_cosmetic);
        tv_cosmetic.setText(meal.getStrMeal());

        // Return the completed view to render on screen
        return convertView;

    }
}
