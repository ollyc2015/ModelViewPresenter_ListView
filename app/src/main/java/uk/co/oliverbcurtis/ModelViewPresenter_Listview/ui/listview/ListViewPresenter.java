package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.async.remote.ApiUtils;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.async.remote.MealAPI;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Meal;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.MealResponse;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview.ListViewContract.View;


/*
The presenter class holds all of the business logic and acts as a mediator between the view and model
*/
public class ListViewPresenter implements ListViewContract.Presenter {

    //Gets the view of the class that ListViewContract.View is being implemented by
    private ListViewContract.View view;
    private MealAPI apiService  = ApiUtils.getApiService();
    private MealResponse meals;
    private List<Meal> mealResponse;

    @Inject ListViewManager manager;

    public ListViewPresenter(ListViewManager manager) {
        this.manager = manager;
    }

    @Override
    public void getMeal() {
        final List<Meal> meals = manager.getMeals();
        if (meals != null)
            view.populateListView(meals);
        else
        view.showToast("No Response Received");
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
