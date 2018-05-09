package android.madar.io.madarsoft.ui.locations;

import android.madar.io.madarsoft.data.AppDataManager;
import android.madar.io.madarsoft.data.db.WeatherEntry;
import android.madar.io.madarsoft.ui.base.BasePresenter;
import android.util.Log;

import java.util.List;

public class LocationPresenter<V extends LocationMvpView> extends BasePresenter<V> implements LocationMvpPresenter<V> {

    public LocationPresenter(AppDataManager dataManager) {
        super(dataManager);
    }

    @Override
    public List<WeatherEntry> getWeathers() {

        return getDataManager().getWeathers();
    }

    @Override
    public void checkData() {
        List<WeatherEntry> data = getWeathers();
        Log.v("data","data"+data);
        if (data.size()==0) {
            getMvpView().showEmptyView();
        } else {
            getMvpView().setWeather(data);

        }
    }

    @Override
    public void goToMap() {
        getMvpView().goToMap();
    }
}
