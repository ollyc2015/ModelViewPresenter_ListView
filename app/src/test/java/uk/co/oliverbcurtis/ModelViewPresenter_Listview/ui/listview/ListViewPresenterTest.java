package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Meal;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ListViewPresenterTest {

    // Mock the dependencies; mock object simulates the data source and ensures that the test conditions are always the same.
    @Mock ListViewActivity view;
    @Mock ListViewManager manager;

    // The below is a rule set for how the RX Java Scheduler is handled during testing
    @Rule
    public TrampolineSchedulerRule rule = new TrampolineSchedulerRule();

    // Create a list of 3 meals
    private final List<Meal> MEALS_THREE = createMealList(3);
    private ListViewPresenter presenter;


    // Do something before @Test method starts
    @Before
    public void setUp() {
        initMocks(this);
        presenter = new ListViewPresenter(manager);
        presenter.attachView(view);

    }

    // @Test tells Android to test the below methods
    @Test
    public void givenMealsRequested_whenSuccessfulResponse_thenMealsReturned() {
        /*
        Mocks can return different values depending on arguments passed into a method.
        The when(…​.).thenReturn(…​.) method chain is used to specify a a return value
        for a method call with pre-defined parameters.
         */
        when(manager.getMeals()).thenReturn(Single.just(MEALS_THREE));

        presenter.requestAllMeals();
        /*
        The ArgumentCaptor class allows us to access the arguments of method calls during the verification.
        This allows us to capture these arguments of method calls and to use them for tests.
         */
        ArgumentCaptor<List> listCaptor = ArgumentCaptor.forClass(List.class);

        /*
        Mockito keeps track of all the method calls and their parameters to the mock object.
        You can use the verify() method on the mock object to verify that the specified conditions are met.
         */
        verify(view, times(1)).populateListView(listCaptor.capture());
        List<Meal> mealList = listCaptor.getValue();
        // The below confirms that expected value is the same as actual value
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