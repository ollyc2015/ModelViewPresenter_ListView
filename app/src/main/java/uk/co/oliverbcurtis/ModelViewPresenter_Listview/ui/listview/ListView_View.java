package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import uk.co.oliverbcurtis.ModelViewPresenter_Listview.R;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Meal;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview.ListViewContract.View;

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

        MealAdapter cosmeticAdapter = new MealAdapter(this, meal);

        // Attach the adapter to a ListView
        final ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(cosmeticAdapter);

        //Get string value of selected item
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, android.view.View view, int position, long arg3) {

                        //first get the position of the item clicked, then collect the ID (in presenter class)
                        //Object meal1 = cosmeticList.get(position);

                        //Then pass it to the presenter class for logic handling
                        //presenter.onClick(meal1);


                    }
                }
        );
    }

    @Override
    public Meal selectMeal() {
        return null;
    }
}