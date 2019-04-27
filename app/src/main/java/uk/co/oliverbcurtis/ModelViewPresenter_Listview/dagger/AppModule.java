package uk.co.oliverbcurtis.ModelViewPresenter_Listview.dagger;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.async.remote.ApiUtils;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.async.remote.MealAPI;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Meal;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview.ListViewManager;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview.ListViewPresenter;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview.MealListAdapter;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.selectedMeal.SelectedMealAdapter;


/*
Here is the collection of dependencies
 */
@Module
public class AppModule {

    private final DaggerApplication application;

    //This is where context is being defined, singleton behaviour is specified as we only need once instance to be created
    public AppModule(DaggerApplication app){
        this.application = app;
    }

    @Provides
    @Singleton
    Context providesApplicationContext(){
        return application;
    }

    @Provides static MealAPI mealAPI() {
        return ApiUtils.getApiService();
    }

    @Provides static ListViewManager manager(MealAPI mealAPI) {
        return new ListViewManager(mealAPI);
    }

    //Below creates reference to a new ListViewPresenter object
    @Provides
    public ListViewPresenter providesListViewPresenter(ListViewManager manager) {
        return new ListViewPresenter(manager);
    }

    //Below provides an empty ArrayList so that providesMealListAdapter and providesSelectedMealAdapter can be initialised
    @Provides
    public List<Meal> providesMealList() {
        return new ArrayList<>();
    }

    //This initialises the MealListAdapter, passing the variables needed to the constructor
    @Provides
    public MealListAdapter providesMealListAdapter(List<Meal> meal) {
        return new MealListAdapter(application, meal);
    }

    //This initialises the SelectedMealAdapter, passing the variables needed to the constructor
    @Provides
    public SelectedMealAdapter providesSelectedMealAdapter(List<Meal> selectedMeal) {
        return new SelectedMealAdapter(application, selectedMeal);
    }
}
