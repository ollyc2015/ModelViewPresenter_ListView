package uk.co.oliverbcurtis.ModelViewPresenter_Listview.async.remote;

/**
 * Created by Jake on 14/05/2018.
 */

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://makeup-api.herokuapp.com/api/v1/";

    public static CosmeticAPI getApiService() {

        return RetrofitClient.getClient(BASE_URL).create(CosmeticAPI.class);
    }

}
