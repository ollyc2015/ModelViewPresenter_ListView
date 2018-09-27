package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.selectedMeal;

import java.util.List;

import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Meal;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview.ListViewContract;


public interface SelectedMealContract {


    //View defines the rules for the ListView_View Class - the below methods will need to be implemented in ListView_View
    interface View {
        //Method used to set some data
        void retrieveSelectedMealData();

    }

    //The below methods will be defined in the ListViewPresenter class
    interface Presenter {

        void attachView(SelectedMealContract.View view);
    }
}
