package android.madar.io.madarsoft.data.network;

import android.madar.io.madarsoft.data.network.model.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MadarApi {

    @GET("daily")
    Call<Weather> getWeather(@Query("lat") String lat,
                             @Query("lon") String lon,
                             @Query("cnt") String cnt,
                             @Query("appid") String appid);

}
