package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import uk.co.oliverbcurtis.ModelViewPresenter_Listview.R;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Meal;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview.ListViewContract.View;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.selectedMeal.SelectedMealView;

//This class relates to all the views/fragments etc used
public class ListView_View extends AppCompatActivity implements View {

    //In our listview_view.xml, we have a TextView and a Button, hence they are declared below
     private ListViewPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set the content view to the listview_view.xml
        setContentView(R.layout.listview_view);

        presenter = new ListViewPresenter();
        //attach the view as this creates a link between this class and the listViewPresenter (without this would cause a null pointer)
        presenter.attachView(this);
        initView();
    }


    @Override
    public void showToast(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_LONG).show();
    }

    @Override
    public void initView() {

        presenter.getMeal();

    }

    @Override
    public void populateListView(final List<Meal> meal) {

        MealListAdapter cosmeticAdapter = new MealListAdapter(this, meal);

        // Attach the adapter to a ListView
        final ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(cosmeticAdapter);

        //Get string value of selected item
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, android.view.View view, int position, long arg3) {

                        //first get the position of the item clicked, then collect the ID (in presenter class)
                        Meal meal1 = meal.get(position);

                        //Then pass it to the presenter class for logic handling
                        presenter.onClick(meal1);


                    }
                }
        );
    }

    @Override
    public void selectedMeal(List<Meal> mealResponse) {

        ArrayList myList = ((ArrayList) mealResponse);

        Intent i =new Intent(this,SelectedMealView.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("selectedMeal", myList);
        i.putExtras(bundle);
        startActivity(i);
    }
}