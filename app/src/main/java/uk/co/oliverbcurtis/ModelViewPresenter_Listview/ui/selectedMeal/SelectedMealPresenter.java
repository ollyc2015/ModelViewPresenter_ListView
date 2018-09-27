package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.selectedMeal;

import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Meal;

public class SelectedMealPresenter implements SelectedMealContract.Presenter {

    private SelectedMealContract.View view;

    @Override
    public void attachView(SelectedMealContract.View view) {

        this.view = view;

    }


}
