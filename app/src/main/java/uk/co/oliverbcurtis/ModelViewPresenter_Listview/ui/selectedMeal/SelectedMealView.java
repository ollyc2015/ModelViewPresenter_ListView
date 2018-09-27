package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.selectedMeal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import uk.co.oliverbcurtis.ModelViewPresenter_Listview.R;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Meal;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview.ListViewPresenter;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview.MealListAdapter;

public class SelectedMealView extends AppCompatActivity implements SelectedMealContract.View {

    private SelectedMealPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set the content view to the listview_view.xml
        setContentView(R.layout.listview_view);

        presenter = new SelectedMealPresenter();
        //attach the view as this creates a link between this class and the listViewPresenter (without this would cause a null pointer)
        presenter.attachView(this);

        retrieveSelectedMealData();

    }


    @Override
    public void retrieveSelectedMealData() {

        Intent intent = getIntent();

        if (intent != null) {

            Bundle bundle = getIntent().getExtras();
            ArrayList<? extends Meal> arraylist = bundle.getParcelableArrayList("selectedMeal");

            ArrayList arraylists = (ArrayList) arraylist;

            SelectedMealAdapter cosmeticAdapter = new SelectedMealAdapter(this, arraylists);

            final ListView listView = (ListView) findViewById(R.id.list_view);
            listView.setAdapter(cosmeticAdapter);

        }
    }
}
