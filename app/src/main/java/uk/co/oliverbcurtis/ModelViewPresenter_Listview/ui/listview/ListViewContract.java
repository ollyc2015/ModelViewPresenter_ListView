package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview;

import java.util.List;

import io.reactivex.Scheduler;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Meal;

//Contract holds the well defined methods for all of the 3 classes
public interface ListViewContract {

    //View defines the rules for the ListView_View Class - the below methods will need to be implemented in ListView_View
        interface View {
        //Method used to set some data

        void initView();
        void populateListView(List<Meal> meal);
        void selectedMeal(List<Meal> mealResponse);
        void showToast(String toast);

    }

    //The below methods will be defined in the ListViewPresenter class
    interface Presenter {

       void requestAllMeals(Scheduler schedulers);
       void attachView(ListViewContract.View view);
       void onClick(Meal position);

    }

}
