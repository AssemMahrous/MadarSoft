package android.madar.io.madarsoft.data.db.converters;

import android.arch.persistence.room.TypeConverter;
import android.madar.io.madarsoft.data.network.model.Weather;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class WeatherConverter {

    @TypeConverter
    public static Weather fromString(String value) {
        Gson gson = new Gson();
        Type listType = new TypeToken<Weather>() {
        }.getType();
        return gson.fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(Weather payloads) {
        Gson gson = new Gson();
        Type type = new TypeToken<Weather>() {
        }.getType();
        return gson.toJson(payloads, type);
    }
}
