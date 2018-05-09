package android.madar.io.madarsoft.data.db.converters;

import android.arch.persistence.room.TypeConverter;
import android.madar.io.madarsoft.data.network.model.Weather_;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class WeatherConverter_ {

    @TypeConverter
    public static List<Weather_> fromString(String value) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Weather_>>() {
        }.getType();
        List<Weather_> payloads = gson.fromJson(value, listType);
        return payloads;
    }

    @TypeConverter
    public static String fromArrayList(List<Weather_> payloads) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Weather_>>() {
        }.getType();
        String json = gson.toJson(payloads, type);
        return json;
    }
}
