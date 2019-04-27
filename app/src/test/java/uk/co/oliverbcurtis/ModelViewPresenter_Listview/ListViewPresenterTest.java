package uk.co.oliverbcurtis.ModelViewPresenter_Listview;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.async.remote.MealAPI;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.MealResponse;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview.ListViewPresenter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ListViewPresenterTest {

    ListViewPresenter listViewPresenter;



    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testApiResponse() {

        MealAPI mockedApiInterface = Mockito.mock(MealAPI.class);
        final Call<MealResponse> mockedCall = Mockito.mock(Call.class);

        Mockito.when(mockedApiInterface.getMeal("1")).thenReturn(mockedCall);

        Mockito.doAnswer(new Answer() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                Callback<MealResponse> callback = invocation.getArgument(0);

                callback.onResponse(mockedCall, Response.success(new MealResponse()));
                // or callback.onResponse(mockedCall, Response.error(404. ...);
                // or callback.onFailure(mockedCall, new IOException());

                return null;
            }
        }).when(mockedCall).enqueue(any(Callback.class));

        // inject mocked ApiInterface to your presenter
        // and then mock view and verify calls (and eventually use ArgumentCaptor to access call parameters)
    }
}
