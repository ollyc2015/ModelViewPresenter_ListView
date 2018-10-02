package uk.co.oliverbcurtis.ModelViewPresenter_Listview.dagger;


import android.content.Context;

import java.util.List;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Meal;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview.ListViewPresenter;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview.MealListAdapter;


/*
Here is our collection of dependencies
 */
@Module
public class AppModule {

    private final DaggerApplication application;

    //This is where context is being defined
    public AppModule(DaggerApplication app){
        this.application = app;
    }

    @Provides
    @Singleton
    Context providesApplicationContext(){

        return application;
    }

    @Provides
    public ListViewPresenter providesListviewPresenter() {
        return new ListViewPresenter();
    }


/*
    @Provides
    public MealListAdapter providesMealListAdapter() {
        return new MealListAdapter(application, );
    }
*/

}
