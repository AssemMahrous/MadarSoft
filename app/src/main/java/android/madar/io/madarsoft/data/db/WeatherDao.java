package android.madar.io.madarsoft.data.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.madar.io.madarsoft.data.network.model.Weather;

import java.util.List;

@Dao
public interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void bulkInsert(WeatherEntry... places);

    @Query("SELECT * FROM weather")
    List<WeatherEntry> getWeathers();

}
