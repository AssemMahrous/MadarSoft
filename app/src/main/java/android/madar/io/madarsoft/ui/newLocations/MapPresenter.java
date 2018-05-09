package android.madar.io.madarsoft.ui.newLocations;

import android.madar.io.madarsoft.data.AppDataManager;
import android.madar.io.madarsoft.data.network.model.Weather;
import android.madar.io.madarsoft.ui.base.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapPresenter<V extends MapMvpView> extends BasePresenter<V> implements MapMvpPresenter<V> {

    public MapPresenter(AppDataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void setData(String lat, String lng) {
        showProgress();
        getDataManager()
                .getApi()
                .getWeather(lat, lng, "10", "b1b15e88fa797225412429c1c50c122a1")
                .enqueue(new Callback<Weather>() {
                    @Override
                    public void onResponse(Call<Weather> call, Response<Weather> response) {
                        try {
                            if (response.isSuccessful()) {
                                AddToDatabase(response.body());
                                getMvpView().incrementPlace();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        hideProgress();
                    }

                    @Override
                    public void onFailure(Call<Weather> call, Throwable t) {
                        hideProgress();
                    }
                });
    }

    @Override
    public void showProgress() {
        getMvpView().showProgress();
    }

    @Override
    public void hideProgress() {
        getMvpView().hideProgress();
    }

    @Override
    public void AddToDatabase(Weather weather) {
        getDataManager().insertWeather(weather);
    }
}
