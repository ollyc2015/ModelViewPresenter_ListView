package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.selectedMeal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.R;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Meal;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.BaseActivity;


public class SelectedMealView extends BaseActivity implements SelectedMealContract.View {


    @BindView(R.id.list_view)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set the content view to the listview_view.xml
        setContentView(R.layout.listview_view);
        ButterKnife.bind(this);
        retrieveSelectedMealData();

    }


    @Override
    public void retrieveSelectedMealData() {

        Intent intent = getIntent();

        if (intent != null) {

            Bundle bundle = getIntent().getExtras();
            ArrayList<? extends Meal> arraylist = bundle.getParcelableArrayList("selectedMeal");

            //SelectedMealAdapter selectedMealAdapter = new SelectedMealAdapter(this, (ArrayList) arraylist);

            //final ListView listView = (ListView) findViewById(R.id.list_view);
            listView.setAdapter(selectedMealAdapter);
            selectedMealAdapter.updateList((ArrayList) arraylist);

        }
    }


    public void onBackPressed(){
        super.onBackPressed();
        SelectedMealAdapter.hasRun = false;
    }
}
