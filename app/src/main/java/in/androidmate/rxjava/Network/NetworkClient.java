package in.androidmate.rxjava.Network;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anujgupta on 27/07/17.
 */

public class NetworkClient {

    private static Retrofit retrofit;

    public NetworkClient(final Context context) {
        final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);


        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();

        retrofit= new Retrofit.Builder()
                .baseUrl("http://samples.openweathermap.org/data/2.5/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    private Retrofit getRetrofit(){
        return retrofit;
    }

    public static Retrofit getRetrofit(Context context) {
        if(retrofit==null){
            return retrofit=new NetworkClient(context).getRetrofit();
        }else{
            return retrofit;
        }
    }
}
