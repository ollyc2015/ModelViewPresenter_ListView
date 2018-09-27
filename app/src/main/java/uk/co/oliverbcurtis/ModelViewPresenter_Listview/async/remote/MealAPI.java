package uk.co.oliverbcurtis.ModelViewPresenter_Listview.async.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Meal;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.MealResponse;


public interface MealAPI {

    // Returns list of all the latest meals
    @GET("latest.php")
    Call<MealResponse> getMealList();

    // Returns details of the selected meal by ID
    @GET("lookup.php")
    Call<MealResponse> getMeal(@Query("i") String idMeal);
}
