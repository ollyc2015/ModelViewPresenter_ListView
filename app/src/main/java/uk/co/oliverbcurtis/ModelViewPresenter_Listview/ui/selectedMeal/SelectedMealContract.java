package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.selectedMeal;


public interface SelectedMealContract {


    //View defines the rules for the ListView_View Class - the below methods will need to be implemented in ListView_View
    interface View {
        //Method used to set some data
        void retrieveSelectedMealData();

    }


}
