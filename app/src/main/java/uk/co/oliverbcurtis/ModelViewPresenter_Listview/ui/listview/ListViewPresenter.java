package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.async.remote.CosmeticAPI;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.async.remote.ApiUtils;

import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Cosmetic;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview.ListViewContract.View;

/*
The presenter class holds all of the business logic and acts as a mediator between the view and model
*/
public class ListViewPresenter implements ListViewContract.Presenter {

    private ListViewContract.View view;
    private CosmeticAPI apiService  = ApiUtils.getApiService();
    private List<Cosmetic> cosmetics;


    @Override
    public void getCosmetics() {

        //Call the external DB to load all the animal cruelty free cosmetics
        apiService.getCosmeticList();

        // Retrofit call to API, returns list of cosmetics
        apiService.getCosmeticList().enqueue(new Callback <List<Cosmetic>>() {
            @Override
            public void onResponse(Call<List<Cosmetic>> call, Response<List<Cosmetic>> response) {
                if(response.isSuccessful()) {

                    cosmetics = response.body();
                    view.populateListView(cosmetics);
                }
            }

            @Override
            public void onFailure(Call<List<Cosmetic>> call, Throwable t) {
                view.showToast(t.toString());
            }
        });

    }

    @Override
    public void attachView(View view) {

        this.view = view;

    }
}
