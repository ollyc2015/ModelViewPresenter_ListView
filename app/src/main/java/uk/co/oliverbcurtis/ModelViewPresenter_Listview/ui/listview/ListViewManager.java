package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.async.remote.MealAPI;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Meal;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.MealResponse;

public class ListViewManager {

    private MealAPI apiService;
    private MealResponse mealResponse;
    private List<Meal> meals;

    public ListViewManager(MealAPI apiService) {
        this.apiService = apiService;
    }

    public void getMeals(final ListViewPresenter listViewPresenter) {
        apiService.getMealList().enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if(response.isSuccessful()) {
                    mealResponse = response.body();

                    if(mealResponse != null) {
                        meals = mealResponse.getMeals();
                        listViewPresenter.populateMeals(meals);
                    }
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {
                meals = null;
            }
        });
    }
}


