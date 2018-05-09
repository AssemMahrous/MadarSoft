package android.madar.io.madarsoft.ui.newLocations;

import android.madar.io.madarsoft.data.network.model.Weather;
import android.madar.io.madarsoft.ui.base.MvpPresenter;

public interface MapMvpPresenter<V extends MapMvpView> extends MvpPresenter<V> {

    void setData(String lat, String lng);

    void showProgress();

    void hideProgress();

    void AddToDatabase(Weather weather);
}
