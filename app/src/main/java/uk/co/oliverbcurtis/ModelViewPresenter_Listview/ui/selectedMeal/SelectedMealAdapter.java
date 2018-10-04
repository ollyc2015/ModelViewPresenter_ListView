package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.selectedMeal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.R;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Meal;


public class SelectedMealAdapter  extends ArrayAdapter<Meal> {

    public static boolean hasRun = false;


    public SelectedMealAdapter(@NonNull Context context, List<Meal> mealArrayList) {
        super(context,0,mealArrayList);
    }

    public void updateList(List<Meal> meal) {
        this.addAll(meal);
        notifyDataSetChanged();
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
        ImageView iv_meal = convertView.findViewById(R.id.iv_meal);
        TextView tv_meal = convertView.findViewById(R.id.tv_meal);
        TextView tv_cuisineType =  convertView.findViewById(R.id.tv_cuisineType);
        TextView tv_instructions =  convertView.findViewById(R.id.tv_instructions);
        LinearLayout dynamicSelectedMealLayout = convertView.findViewById(R.id.dynamicSelectedMealLayout);

        /*
        Due to the API returning individual strings for each ingredient, we first add them to an array.
        The API will not return a recipe with more than 20 ingredients.
        */
        ArrayList<String> mealIngredient = new ArrayList<>();
        mealIngredient.add(meal.getStrIngredient1());
        mealIngredient.add(meal.getStrIngredient2());
        mealIngredient.add(meal.getStrIngredient3());
        mealIngredient.add(meal.getStrIngredient4());
        mealIngredient.add(meal.getStrIngredient5());
        mealIngredient.add(meal.getStrIngredient6());
        mealIngredient.add(meal.getStrIngredient7());
        mealIngredient.add(meal.getStrIngredient8());
        mealIngredient.add(meal.getStrIngredient9());
        mealIngredient.add(meal.getStrIngredient10());
        mealIngredient.add(meal.getStrIngredient11());
        mealIngredient.add(meal.getStrIngredient12());
        mealIngredient.add(meal.getStrIngredient13());
        mealIngredient.add(meal.getStrIngredient14());
        mealIngredient.add(meal.getStrIngredient15());
        mealIngredient.add(meal.getStrIngredient16());
        mealIngredient.add(meal.getStrIngredient17());
        mealIngredient.add(meal.getStrIngredient18());
        mealIngredient.add(meal.getStrIngredient19());
        mealIngredient.add(meal.getStrIngredient20());

        //Then do the same for the measurements of each ingredient needed
        ArrayList<String> mealMeasure = new ArrayList<>();
        mealMeasure.add(meal.getStrMeasure1());
        mealMeasure.add(meal.getStrMeasure2());
        mealMeasure.add(meal.getStrMeasure3());
        mealMeasure.add(meal.getStrMeasure4());
        mealMeasure.add(meal.getStrMeasure5());
        mealMeasure.add(meal.getStrMeasure6());
        mealMeasure.add(meal.getStrMeasure7());
        mealMeasure.add(meal.getStrMeasure8());
        mealMeasure.add(meal.getStrMeasure9());
        mealMeasure.add(meal.getStrMeasure10());
        mealMeasure.add(meal.getStrMeasure11());
        mealMeasure.add(meal.getStrMeasure12());
        mealMeasure.add(meal.getStrMeasure13());
        mealMeasure.add(meal.getStrMeasure14());
        mealMeasure.add(meal.getStrMeasure15());
        mealMeasure.add(meal.getStrMeasure16());
        mealMeasure.add(meal.getStrMeasure17());
        mealMeasure.add(meal.getStrMeasure18());
        mealMeasure.add(meal.getStrMeasure19());
        mealMeasure.add(meal.getStrMeasure20());

        /*
        Then we will loop through the ingredients/measurements, adding them to the screen as long as
        the ingredient section is not null
        */
        int measureCount = 0;

        if(!hasRun) {
            hasRun = true;
            for (Object value : mealIngredient) {
                if (!value.equals("")) {

                    Log.i("Ingredient: ", mealIngredient.toString());

                    final TextView tv_ingredient = new TextView(getContext());

                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
                    tv_ingredient.setText((value) + " (" + mealMeasure.get(measureCount) + ")");
                    tv_ingredient.setLayoutParams(params);
                    tv_ingredient.setTextSize(18);
                    tv_ingredient.setGravity(Gravity.CENTER);
                    dynamicSelectedMealLayout.addView(tv_ingredient);

                    measureCount++;
                }
            }
        }


        //Finally, populate the remaining data (like meal image etc) into the template view using the data object
        Picasso.get().load(meal.getStrMealThumb()).into(iv_meal);
        tv_meal.setText(meal.getStrMeal());
        tv_cuisineType.setText(meal.getStrArea());
        tv_instructions.setText(meal.getStrInstructions());

        // Return the completed view to render on screen
        return convertView;

    }
}
