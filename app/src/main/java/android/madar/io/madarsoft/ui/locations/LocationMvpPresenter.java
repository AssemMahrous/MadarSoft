package android.madar.io.madarsoft.ui.locations;

import android.madar.io.madarsoft.data.db.WeatherEntry;
import android.madar.io.madarsoft.data.network.model.Weather;
import android.madar.io.madarsoft.ui.base.MvpPresenter;

import java.util.List;

public interface LocationMvpPresenter<V extends LocationMvpView> extends MvpPresenter<V> {

    List<WeatherEntry> getWeathers();

    void checkData();

    void goToMap();
}
