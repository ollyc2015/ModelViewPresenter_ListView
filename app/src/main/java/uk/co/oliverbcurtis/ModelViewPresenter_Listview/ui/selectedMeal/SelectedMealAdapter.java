package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.selectedMeal;

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

public class SelectedMealAdapter  extends ArrayAdapter<Meal> {


    public SelectedMealAdapter(@NonNull Context context, List<Meal> mealArrayList) {
        super(context,0,mealArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Get the data item for this position
        Meal meal = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.selected_meal, parent, false);
        }
        // Lookup view for data population
        ImageView iv_cosmetic = (ImageView) convertView.findViewById(R.id.iv_meal);
        TextView tv_cosmetic = (TextView) convertView.findViewById(R.id.tv_meal);
        TextView tv_cuisineType = (TextView) convertView.findViewById(R.id.tv_cuisineType);
        TextView tv_ingredient1 = (TextView) convertView.findViewById(R.id.tv_ingredient1);
        TextView tv_ingredient2 = (TextView) convertView.findViewById(R.id.tv_ingredient2);
        TextView tv_ingredient3 = (TextView) convertView.findViewById(R.id.tv_ingredient3);
        TextView tv_ingredient4 = (TextView) convertView.findViewById(R.id.tv_ingredient4);
        TextView tv_ingredient5 = (TextView) convertView.findViewById(R.id.tv_ingredient5);
        TextView tv_ingredient6 = (TextView) convertView.findViewById(R.id.tv_ingredient6);
        TextView tv_ingredient7 = (TextView) convertView.findViewById(R.id.tv_ingredient7);
        TextView tv_ingredient8 = (TextView) convertView.findViewById(R.id.tv_ingredient8);
        TextView tv_ingredient9 = (TextView) convertView.findViewById(R.id.tv_ingredient9);
        TextView tv_ingredient10 = (TextView) convertView.findViewById(R.id.tv_ingredient10);
        TextView tv_instructions = (TextView) convertView.findViewById(R.id.tv_instructions);


        // Populate the data into the template view using the data object
        Picasso.get().load(meal.getStrMealThumb()).into(iv_cosmetic);
        tv_cosmetic.setText(meal.getStrMeal());
        tv_cuisineType.setText(meal.getStrArea());
        tv_ingredient1.setText(meal.getStrIngredient1()+" ("+meal.getStrMeasure1()+")");
        tv_ingredient2.setText(meal.getStrIngredient2()+" ("+meal.getStrMeasure2()+")");
        tv_ingredient3.setText(meal.getStrIngredient3()+" ("+meal.getStrMeasure3()+")");
        tv_ingredient4.setText(meal.getStrIngredient4()+" ("+meal.getStrMeasure4()+")");
        tv_ingredient5.setText(meal.getStrIngredient5()+" ("+meal.getStrMeasure5()+")");
        tv_ingredient6.setText(meal.getStrIngredient6()+" ("+meal.getStrMeasure6()+")");
        tv_ingredient7.setText(meal.getStrIngredient7()+" ("+meal.getStrMeasure7()+")");
        tv_ingredient8.setText(meal.getStrIngredient8()+" ("+meal.getStrMeasure8()+")");
        tv_ingredient9.setText(meal.getStrIngredient9()+" ("+meal.getStrMeasure9()+")");
        tv_ingredient10.setText(meal.getStrIngredient10()+" ("+meal.getStrMeasure10()+")");
        tv_instructions.setText(meal.getStrInstructions());

        // Return the completed view to render on screen
        return convertView;

    }
}
