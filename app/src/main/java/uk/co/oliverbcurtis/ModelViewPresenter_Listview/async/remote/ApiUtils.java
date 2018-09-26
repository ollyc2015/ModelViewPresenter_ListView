package uk.co.oliverbcurtis.ModelViewPresenter_Listview.async.remote;


public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";

    public static MealAPI getApiService() {

        return RetrofitClient.getClient(BASE_URL).create(MealAPI.class);
    }

}
