package in.androidmate.rxjava.Api;

import in.androidmate.rxjava.WeatherData;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by anujgupta on 27/07/17.
 */

public interface ApiInterface {

    @GET("weather")
    Observable<WeatherData> fetchCurrentWeather(@Query("q") String q,
                                                @Query("appid") String appid);

}
