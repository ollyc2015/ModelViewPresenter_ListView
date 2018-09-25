package uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import uk.co.oliverbcurtis.ModelViewPresenter_Listview.R;

import uk.co.oliverbcurtis.ModelViewPresenter_Listview.async.remote.CosmeticAPI;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.model.Cosmetic;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.listview.ListViewContract.View;

//This class relates to all the views/fragments etc used
public class ListViewActivity extends AppCompatActivity implements View {

    //In our activity_main.xml, we have a TextView and a Button, hence they are declared below
     public static CosmeticAPI mApiService;
     private ListViewPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set the content view to the activity_main.xml
        setContentView(R.layout.activity_main);

        presenter = new ListViewPresenter();
        presenter.attachView(this);
        initView();
    }


    @Override
    public void showToast(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_LONG).show();
    }

    @Override
    public void initView() {

        presenter.getCosmetics();

    }

    @Override
    public void populateListView(List<Cosmetic> cosmetic) {

        ArrayList cosmeticList = new ArrayList<>(cosmetic);

        CosmeticAdapter cosmeticAdapter = new CosmeticAdapter(this, cosmeticList);

        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(cosmeticAdapter);

    }

    @Override
    public Cosmetic selectCosmetic() {
        return null;
    }
}