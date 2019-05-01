package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.async.remote.MealAPI;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.async.remote.MealCallback;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Meal;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.MealResponse;

public class ListViewManager {

    private MealAPI apiService;
    private MealResponse mealResponse;

    public ListViewManager(MealAPI apiService) {
        this.apiService = apiService;
    }

    public void getMeals(final MealCallback callback) {
        apiService.getMealList().enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if(response.isSuccessful()) {

                    mealResponse = response.body();
                    callback.onSuccess(mealResponse);

                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {

                callback.onError();
            }
        });
    }


    public void getMeals(String mealID, final MealCallback mealCallback) {

        // Retrofit call to API, returns the meal details of the selected meal - DB queries meal ID
        apiService.getMeal(mealID).enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if (response.isSuccessful()) {

                    mealResponse = response.body();
                    mealCallback.onSuccess(mealResponse);

                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {

                mealCallback.onError();
            }
        });
    }
}


