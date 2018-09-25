package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview;

import java.util.List;

import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Cosmetic;

//Contract holds the well defined methods for all of the 3 classes
public interface ListViewContract {

    //View defines the rules for the ListView_View Class - the below methods will need to be implemented in ListView_View
        interface View {
        //Method used to set some data

        void initView();
        void populateListView(List<Cosmetic> cosmetics);
        Cosmetic selectCosmetic();
        void showToast(String toast);
    }

    //The below methods will be defined in the ListViewPresenter class
    interface Presenter {

       void getCosmetics();
       void attachView(ListViewContract.View view);
    }

}
