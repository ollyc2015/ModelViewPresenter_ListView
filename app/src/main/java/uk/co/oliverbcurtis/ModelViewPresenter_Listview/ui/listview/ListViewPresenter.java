package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.async.remote.ApiUtils;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.async.remote.MealAPI;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.async.remote.MealCallback;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Meal;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.MealResponse;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.BaseActivity;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview.ListViewContract.View;


/*
The presenter class holds all of the business logic and acts as a mediator between the view and model
*/
public class ListViewPresenter extends BaseActivity implements ListViewContract.Presenter {

    //Gets the view of the class that ListViewContract.View is being implemented by
    private ListViewContract.View view;
    private List<Meal> returnedMeals;

    @Inject ListViewManager manager;

    public ListViewPresenter(ListViewManager manager) {
        this.manager = manager;
    }

    //Below deals with assigning the pointer view to the view
    @Override
    public void attachView(View view) {
        this.view = view;
    }

    @Override
    public void requestAllMeals() {

         manager.getMeals(new MealCallback() {
             @Override
             public void onSuccess(MealResponse mealResponse) {

                 if(mealResponse != null) {
                     returnedMeals = mealResponse.getMeals();
                     view.populateListView(returnedMeals);
                 }
             }
             @Override
             public void onError() {

                 view.showToast("No Response Received");
             }

             @Override
             public void onSuccess(boolean b) {

                 Log.d("RequestMealsTest", "Test Passed");

             }
         });
    }


    @Override
    public void onClick(Meal position) {

        final String mealID = position.getIdMeal().toString();
        //apiService.requestAllMeals();

        manager.getMeals(mealID, new MealCallback() {
            @Override
            public void onSuccess(MealResponse mealResponse) {


                if(mealResponse != null) {
                    returnedMeals = mealResponse.getMeals();
                    view.selectedMeal(returnedMeals);
                }
            }

            @Override
            public void onError() {

                view.showToast("No Response Received");

            }

            @Override
            public void onSuccess(boolean b) {

                Log.d("RequestMealTest", "Test Passed");
            }
        });
    }
}
