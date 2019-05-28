package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Meal;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ListViewPresenterTest {

    @Mock ListViewActivity view;
    @Mock ListViewManager manager;

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
    public void givenMealsRequested_whenSuccessfulResponse_thenMealsReturned() {
        when(manager.getMeals()).thenReturn(Single.just(MEALS_THREE));

        presenter.requestAllMeals();

        ArgumentCaptor<List> listCaptor = ArgumentCaptor.forClass(List.class);
        verify(view, times(1)).populateListView(listCaptor.capture());
        List<Meal> mealList = listCaptor.getValue();

        assertEquals(mealList, MEALS_THREE);
    }

    @Test
    public void givenMealsRequested_whenUnsuccessfulResponse_thenErrorThrownAndMessageDisplayed() {
        when(manager.getMeals()).thenReturn(Single.error(new IOException("Error message")));

        presenter.requestAllMeals();

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