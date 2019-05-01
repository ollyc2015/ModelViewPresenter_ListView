package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import uk.co.oliverbcurtis.ModelViewPresenter_Listview.async.remote.MealCallback;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Meal;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ListViewPresenterTest {

    @Mock ListView_View view;
    @Mock ListViewManager manager;
    @Mock MealCallback mealCallback;

    private final List<Meal> MEALS_ONE = createMealList(1);
    private final List<Meal> MEALS_THREE = createMealList(3);
    private ListViewPresenter presenter;

    @Before
    public void setUp() {
        initMocks(this);
        presenter = new ListViewPresenter(manager);
        presenter.attachView(view);
    }

    @Test
    public void givenMealsRequested_whenSuccessfulResponseWithSingleMeas_thenOneMealReturned() {
        when(manager.getMeals(mealCallback)).thenReturn(MEALS_ONE);

        presenter.getMeal();

        ArgumentCaptor<List<Meal>> captor = ArgumentCaptor.forClass(List.class);
        verify(view).populateListView(captor.capture());
        List<Meal> capturedArgument = captor.getValue();
        assertEquals(MEALS_ONE, capturedArgument);
    }

    @Test
    public void givenMealsRequested_whenSuccessfulResponseWithThreeMeals_thenThreeMealsReturned() {
        when(manager.getMeals(mealCallback)).thenReturn(MEALS_THREE);

        presenter.getMeal();

        ArgumentCaptor<List<Meal>> captor = ArgumentCaptor.forClass(List.class);
        verify(view).populateListView(captor.capture());
        List<Meal> capturedArgument = captor.getValue();
        assertEquals(MEALS_THREE, capturedArgument);
    }

    @Test
    public void givenMealsRequested_whenUnsuccessfulResponse_thenNoMealsMessageDisplayed() {
        when(manager.getMeals(mealCallback)).thenReturn(null);

        presenter.getMeal();

        verify(view, times(1)).showToast(anyString());
    }

    private List<Meal> createMealList(Integer count) {
        List<Meal> meals = new ArrayList<>();
        for (int i = 0; i < count; i ++) {
            meals.add(new Meal());
        }
        return meals;
    }

}