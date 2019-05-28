package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview;

import java.util.List;

import io.reactivex.Single;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.async.remote.MealAPI;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Meal;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.MealResponse;

public class ListViewManager {

    private MealAPI apiService;


    public ListViewManager(MealAPI apiService) {
        this.apiService = apiService;
    }


    Single<List<Meal>> getMeals() {
        return apiService.getMealList()
                .map(MealResponse::getMeals);
    }


    Single<List<Meal>> getMeals(String mealID) {
        return apiService.getMeal(mealID)
                .map(MealResponse::getMeals);
    }

}


