package uk.co.oliverbcurtis.ModelViewPresenter_Listview.async.remote;

import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.MealResponse;

public interface MealCallback {

    void onSuccess(MealResponse value);
    void onError();

    void onSuccess(boolean b);
}
