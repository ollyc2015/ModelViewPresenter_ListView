package uk.co.oliverbcurtis.ModelViewPresenter_Listview.async.remote;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.MealResponse;


public interface MealAPI {

    // Returns list of all the latest meals
    @GET("latest.php")
    Single<MealResponse> getMealList();

    // Returns details of the selected meal by ID
    @GET("lookup.php")
    Single<MealResponse> getMeal(@Query("i") String idMeal);
}
