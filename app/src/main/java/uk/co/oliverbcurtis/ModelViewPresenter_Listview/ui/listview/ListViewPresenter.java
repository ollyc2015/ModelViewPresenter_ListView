package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.async.remote.MealAPI;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.async.remote.ApiUtils;

import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Meal;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.MealResponse;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview.ListViewContract.View;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.selectedMeal.SelectedMealView;

/*
The presenter class holds all of the business logic and acts as a mediator between the view and model
*/
public class ListViewPresenter implements ListViewContract.Presenter {

    private ListViewContract.View view;
    private MealAPI apiService  = ApiUtils.getApiService();
    private MealResponse meals;


    @Override
    public void getMeal() {

        //Call the external DB to load all the latest meals
        apiService.getMealList();

        // Retrofit call to API, returns list of meals
        apiService.getMealList().enqueue(new Callback <MealResponse>() {
            @Override
            public void onResponse(Call <MealResponse> call, Response<MealResponse> response) {
                if(response.isSuccessful()) {

                    meals = response.body();

                    List<Meal> mealResponse = meals.getMeals();

                    view.populateListView(mealResponse);
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {
                view.showToast(t.toString());
            }
        });

    }

    //Below deals with assigning the pointer view to the view
    @Override
    public void attachView(View view) {

        this.view = view;

    }




    @Override
    public void onClick(Meal position) {

        final String mealID = position.getIdMeal().toString();
        //apiService.getMeal();

        // Retrofit call to API, returns the meal details of the selected meal - DB queries meal ID
        apiService.getMeal(mealID).enqueue(new Callback <MealResponse>() {
            @Override
            public void onResponse(Call <MealResponse> call, Response<MealResponse> response) {
                if(response.isSuccessful()) {

                    meals = response.body();

                    List<Meal> mealResponse = meals.getMeals();

                    view.selectedMeal(mealResponse);
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {
                view.showToast(t.toString());
            }
        });


    }
}
