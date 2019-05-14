package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
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


    void getMeals(final MealCallback callback) {

        apiService.getMealList().enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(@NonNull Call<MealResponse> call, @NonNull Response<MealResponse> response) {
                if(response.isSuccessful()) {

                    mealResponse = response.body();
                    callback.onSuccess(mealResponse);

                }
            }

            @Override
            public void onFailure(@NonNull Call<MealResponse> call, @NonNull Throwable t) {

                callback.onError();
            }
        });
    }


    void getMeals(String mealID, final MealCallback mealCallback) {

        // Retrofit call to API, returns the meal details of the selected meal - DB queries meal ID
        apiService.getMeal(mealID).enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(@NonNull Call<MealResponse> call, @NonNull Response<MealResponse> response) {
                if (response.isSuccessful()) {

                    mealResponse = response.body();
                    mealCallback.onSuccess(mealResponse);

                }
            }

            @Override
            public void onFailure(@NonNull Call<MealResponse> call, @NonNull Throwable t) {

                mealCallback.onError();
            }
        });
    }

}


