package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import javax.inject.Inject;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.dagger.DaggerApplication;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview.ListViewPresenter;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview.MealListAdapter;


public class BaseActivity extends AppCompatActivity {

    @Inject public
    ListViewPresenter presenter;
   // @Inject public
   // MealListAdapter mealListAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        Here we are saying cast the getApplication() from the DaggerApplication, get the app component from it,
        because in this case we already have the appComponent defined in the DaggerApplication class as
        we are first injecting from the DaggerApplication class
         */

        ((DaggerApplication) getApplication()).getAppComponent().inject(this);
    }
}
