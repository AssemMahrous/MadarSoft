package android.madar.io.madarsoft.ui.locations;

import android.madar.io.madarsoft.data.db.WeatherEntry;
import android.madar.io.madarsoft.data.network.model.Weather;
import android.madar.io.madarsoft.ui.base.MvpView;

import java.util.List;

public interface LocationMvpView extends MvpView {

    void setViews();

    void setWeather(List<WeatherEntry> weatherList);

    void goToMap();

    void showEmptyView();
}
