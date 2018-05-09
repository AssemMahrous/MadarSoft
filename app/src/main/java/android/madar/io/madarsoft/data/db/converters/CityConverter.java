package android.madar.io.madarsoft.data.db.converters;

import android.arch.persistence.room.TypeConverter;
import android.madar.io.madarsoft.data.network.model.City;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class CityConverter {
    @TypeConverter
    public static City fromString(String value) {
        Gson gson = new Gson();
        Type listType = new TypeToken<City>() {
        }.getType();
        return gson.fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(City payloads) {
        Gson gson = new Gson();
        Type type = new TypeToken<City>() {
        }.getType();
        return gson.toJson(payloads, type);
    }
}
