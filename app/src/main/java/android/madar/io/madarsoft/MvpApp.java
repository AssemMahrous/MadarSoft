package android.madar.io.madarsoft;

import android.app.Application;
import android.madar.io.madarsoft.data.AppDataManager;
import android.madar.io.madarsoft.data.db.WeatherDataBase;
import android.madar.io.madarsoft.data.network.ApiModule;

public class MvpApp extends Application {

    AppDataManager dataManager;

    @Override
    public void onCreate() {
        super.onCreate();
        WeatherDataBase weatherDataBase = WeatherDataBase.getInstance(getApplicationContext());
        ApiModule apiModule = new ApiModule();
        dataManager = new AppDataManager( weatherDataBase.weatherDao(),
                 apiModule.provideApiService());

    }


    public AppDataManager getDataManager() {
        return dataManager;
    }
}
