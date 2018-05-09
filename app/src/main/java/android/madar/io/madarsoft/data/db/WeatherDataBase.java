package android.madar.io.madarsoft.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.madar.io.madarsoft.data.db.converters.CityConverter;
import android.madar.io.madarsoft.data.db.converters.ListConverter;
import android.madar.io.madarsoft.data.db.converters.TempConverter;
import android.madar.io.madarsoft.data.db.converters.WeatherConverter;
import android.madar.io.madarsoft.data.db.converters.WeatherConverter_;

@Database(entities = {WeatherEntry.class}, version = 3)
@TypeConverters({WeatherConverter.class, WeatherConverter_.class
        , TempConverter.class, ListConverter.class
        , CityConverter.class})
public abstract class WeatherDataBase extends RoomDatabase {

    private static final String DATABASE_NAME = "placesDB";

    // For Singleton instantiation
    private static final Object LOCK = new Object();
    private static volatile WeatherDataBase sInstance;

    public static WeatherDataBase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context.getApplicationContext(),
                            WeatherDataBase.class, WeatherDataBase.DATABASE_NAME)
                            .fallbackToDestructiveMigration().build();
                }
            }
        }
        return sInstance;
    }

    public abstract WeatherDao weatherDao();
}

