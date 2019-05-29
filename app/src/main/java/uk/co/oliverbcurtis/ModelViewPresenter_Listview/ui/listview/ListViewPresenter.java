package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview;

import android.annotation.SuppressLint;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Meal;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.BaseActivity;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview.ListViewContract.View;


/*
The presenter class holds all of the business logic and acts as a mediator between the view and model
*/
public class ListViewPresenter extends BaseActivity implements ListViewContract.Presenter {

    //Gets the view of the class that ListViewContract.View is being implemented by
    private ListViewContract.View view;

    @Inject ListViewManager manager;

    public ListViewPresenter(ListViewManager manager) {
        this.manager = manager;
    }

    //Below deals with assigning the pointer view to the view
    @Override
    public void attachView(View view) {
        this.view = view;
    }

    @SuppressLint("CheckResult")
    @Override
    public void requestAllMeals(Scheduler schedulers) {
        manager.getMeals()
                .subscribeOn(Schedulers.io())
                .observeOn(schedulers)
                .subscribe(response -> view.populateListView(response), t -> view.showToast(t.getMessage()));
    }


    @SuppressLint("CheckResult")
    @Override
    public void onClick(Meal position) {
        manager.getMeals(position.getIdMeal())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> view.selectedMeal(response), t -> view.showToast(t.getMessage()));
    }
}
