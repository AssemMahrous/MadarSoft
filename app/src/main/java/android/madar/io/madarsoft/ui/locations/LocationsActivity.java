package android.madar.io.madarsoft.ui.locations;

import android.content.Context;
import android.content.Intent;
import android.madar.io.madarsoft.MvpApp;
import android.madar.io.madarsoft.R;
import android.madar.io.madarsoft.data.AppDataManager;
import android.madar.io.madarsoft.data.db.WeatherEntry;
import android.madar.io.madarsoft.data.network.model.Weather;
import android.madar.io.madarsoft.ui.base.BaseActivity;
import android.madar.io.madarsoft.ui.locations.adapter.ListAdapter;
import android.madar.io.madarsoft.ui.newLocations.MapsActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LocationsActivity extends BaseActivity implements LocationMvpView {
    LocationPresenter presenter;
    ListAdapter adapter;
    List<Weather> weatherList = new ArrayList<>();
    public static Intent getStartIntent(Context context) {
        return new Intent(context, LocationsActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        AppDataManager dataManager = ((MvpApp) getApplication()).getDataManager();
        presenter = new LocationPresenter(dataManager);
        presenter.onAttach(this);

        setViews();
    }


    @Override
    public void setViews() {
        adapter = new ListAdapter(this, weatherList);
        RecyclerView list_recycler = findViewById(R.id.list_recycler);
        list_recycler.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        list_recycler.setAdapter(adapter);
        TextView add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(v -> presenter.goToMap());

        presenter.checkData();
    }

    @Override
    public void setWeather(List<WeatherEntry> weatherLists) {
        for (int i = 0; i < weatherLists.size(); i++) {
            weatherList.add(weatherLists.get(i).getWeather());
        }
        adapter.notifyDataSetChanged();


    }

    @Override
    public void goToMap() {
        Intent intent = MapsActivity.getStartIntent(this);
        startActivity(intent);
    }

    @Override
    public void showEmptyView() {
        findViewById(R.id.empty_view).setVisibility(View.VISIBLE);
        findViewById(R.id.list_recycler).setVisibility(View.GONE);

    }


}
