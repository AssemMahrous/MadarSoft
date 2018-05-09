package android.madar.io.madarsoft.data.db.converters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class ListConverter {

    @TypeConverter
    public static java.util.List<android.madar.io.madarsoft.data.network.model.List>
    fromString(String value) {
        Gson gson = new Gson();
        Type listType = new TypeToken<
                java.util.List<android.madar.io.madarsoft.data.network.model.List>>() {
        }.getType();
        return gson.fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(
            java.util.List<android.madar.io.madarsoft.data.network.model.List> payloads) {
        Gson gson = new Gson();
        Type type = new TypeToken<java.util.List<android.madar.io.madarsoft.data.network.model.List>>() {
        }.getType();
        return gson.toJson(payloads, type);
    }
}
