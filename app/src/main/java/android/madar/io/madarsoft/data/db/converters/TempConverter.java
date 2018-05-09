package android.madar.io.madarsoft.data.db.converters;

import android.arch.persistence.room.TypeConverter;
import android.madar.io.madarsoft.data.network.model.Temp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class TempConverter {

    @TypeConverter
    public static Temp fromString(String value) {
        Gson gson = new Gson();
        Type listType = new TypeToken<Temp>() {
        }.getType();
        return gson.fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(Temp payloads) {
        Gson gson = new Gson();
        Type type = new TypeToken<Temp>() {
        }.getType();
        return gson.toJson(payloads, type);
    }
}
