package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import uk.co.oliverbcurtis.ModelViewPresenter_Listview.async.remote.MealCallback;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Meal;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.MealResponse;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class ListViewPresenterTest {

    @Mock ListView_View view;
    @Mock ListViewManager manager;
    @Mock MealCallback mealCallback;

    private final List<Meal> MEALS_ONE = createMealList(1);
   // private final List<Meal> MEALS_THREE = createMealList(3);
    private ListViewPresenter presenter;


    @Before
    public void setUp() {
        initMocks(this);
        presenter = new ListViewPresenter(manager);
        presenter.attachView(view);
    }

    @Test
    public void givenMealsRequested_whenSuccessfulResponseWithSingleMeals_thenOneMealReturned() {

        //I have tried to rewrite these tests to check the expected callback is being received
        manager.getMeals(mealCallback);

        ArgumentCaptor<MealCallback> mealCaptor = ArgumentCaptor.forClass(MealCallback.class);

        verify(manager).getMeals(mealCaptor.capture());

        mealCaptor.getValue().testSuccess(true);

        verify(mealCallback).testSuccess(true);

        presenter.requestAllMeals();

    }

/*
    @Test
    public void givenMealsRequested_whenSuccessfulResponseWithThreeMeals_thenThreeMealsReturned() {

        //BELOW IS WHERE I AM STUCK TRYING TO HANDLE THE CALLBACK
        manager.getMeals(mealCallback);

        presenter.requestAllMeals();

        ArgumentCaptor<List<Meal>> captor = ArgumentCaptor.forClass(List.class);
        verify(view).populateListView(captor.capture());
        List<Meal> capturedArgument = captor.getValue();
        assertEquals(MEALS_THREE, capturedArgument);
    }

    @Test
    public void givenMealsRequested_whenUnsuccessfulResponse_thenNoMealsMessageDisplayed() {

        //BELOW IS WHERE I AM STUCK TRYING TO HANDLE THE CALLBACK
       // when(manager.getMeals(mealCallback)).thenReturn(null);

        presenter.requestAllMeals();

        verify(view, times(1)).showToast(anyString());
    }
    */

    private List<Meal> createMealList(Integer count) {

        List<Meal> meals = new ArrayList<>();
        for (int i = 0; i < count; i ++) {
            meals.add(new Meal());
        }
        return meals;
    }

}