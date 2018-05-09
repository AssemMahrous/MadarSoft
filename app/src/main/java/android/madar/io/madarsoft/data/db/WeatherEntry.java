package android.madar.io.madarsoft.data.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.madar.io.madarsoft.data.db.converters.WeatherConverter;
import android.madar.io.madarsoft.data.network.model.Weather;

@Entity(tableName = "weather")
public class WeatherEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @TypeConverters(WeatherConverter.class)
    private Weather weather;

    @TypeConverters(WeatherConverter.class)
    public Weather getWeather() {
        return weather;
    }

    public WeatherEntry(int id, Weather weather) {
        this.id = id;
        this.weather = weather;
    }

    @Ignore
    public WeatherEntry(Weather weather) {
        this.weather = weather;
    }

    public int getId() {
        return id;
    }
}
