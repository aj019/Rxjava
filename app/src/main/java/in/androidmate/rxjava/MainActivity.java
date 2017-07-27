package in.androidmate.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import in.androidmate.rxjava.Api.ApiInterface;
import in.androidmate.rxjava.Api.RestAdapter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func0;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";
    private Subscription subscription;
    private TextView tv;
    CompositeSubscription compositeSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);

        Observable<WeatherData> fetchCurrentWeather = RestAdapter.getRetrofit(this)
                .create(ApiInterface.class)
                .fetchCurrentWeather("London,uk","b1b15e88fa797225412429c1c50c122a1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Subscriber<WeatherData> subscriber = new Subscriber<WeatherData>() {
            @Override
            public void onCompleted() {
                Log.d(TAG,"Completed");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,"Error");
            }

            @Override
            public void onNext(WeatherData weatherData) {
                Log.d(TAG,"Next");
                tv.setText(weatherData.getName());
            }
        };

        subscription = fetchCurrentWeather.subscribe(subscriber);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(subscription != null && !subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }

    }



}
