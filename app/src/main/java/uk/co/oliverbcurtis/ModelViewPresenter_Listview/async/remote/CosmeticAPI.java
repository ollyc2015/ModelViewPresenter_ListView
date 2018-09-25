package uk.co.oliverbcurtis.ModelViewPresenter_Listview.async.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Cosmetic;


public interface CosmeticAPI {

    // Returns list of all cosmetics that are cruelty free
    @GET("products.json?product_tags=cruelty%20free")
    Call<List<Cosmetic>> getCosmeticList();


}
