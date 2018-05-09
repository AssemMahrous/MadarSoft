package android.madar.io.madarsoft.data;

import android.madar.io.madarsoft.data.db.WeatherDao;
import android.madar.io.madarsoft.data.db.WeatherEntry;
import android.madar.io.madarsoft.data.network.MadarApi;
import android.madar.io.madarsoft.data.network.model.Weather;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by assem on 2/7/2018.
 */

public class AppDataManager {

    private final WeatherDao weatherDao;
    private final MadarApi madarApi;

    public AppDataManager(WeatherDao weatherDao,
                          MadarApi madarApi) {
        this.weatherDao = weatherDao;
        this.madarApi = madarApi;
    }

    public MadarApi getApi() {
        return madarApi;
    }

    public List<WeatherEntry> getWeathers() {

        try {
            return new getWeatherAsync(weatherDao).execute().get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null ;
    }

    public static class getWeatherAsync extends AsyncTask<Void, Void, List<WeatherEntry>> {
        private WeatherDao weatherDao;

        getWeatherAsync(WeatherDao weatherDao) {
            this.weatherDao = weatherDao;

        }

        @Override
        protected List<WeatherEntry> doInBackground(Void... voids) {
            return weatherDao.getWeathers();
        }

    }


    public void insertWeather(Weather payloads) {
        new insertWeatherAsync(weatherDao).execute(payloads);
    }

    static class insertWeatherAsync extends AsyncTask<Weather, Void, Void> {

        private WeatherDao mWeatherDao;

        insertWeatherAsync(WeatherDao weatherDao) {
            mWeatherDao = weatherDao;

        }


        @Override
        protected final Void doInBackground(Weather[] lists) {
            WeatherEntry weatherEntry = new WeatherEntry(lists[0]);
            mWeatherDao.bulkInsert(weatherEntry);
            return null;
        }
    }

}
