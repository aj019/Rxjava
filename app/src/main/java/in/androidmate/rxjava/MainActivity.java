package in.androidmate.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import in.androidmate.rxjava.Network.NetworkCallback;
import in.androidmate.rxjava.Network.NetworkStore;
import in.androidmate.rxjava.Network.NetworkClient;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
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

        Observable<WeatherData> fetchCurrentWeather = NetworkClient.getRetrofit(this)
                .create(NetworkStore.class)
                .fetchCurrentWeather("London,uk","b1b15e88fa797225412429c1c50c122a1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());


        subscription = fetchCurrentWeather.subscribe(new NetworkCallback<WeatherData>() {
            @Override
            public void onSuccess(WeatherData model) {
                Log.d(TAG,"Success");
                tv.setText(model.getName());
            }

            @Override
            public void onFailure(String message) {
                Log.d(TAG,"Failure");
            }

            @Override
            public void onFinish() {
                Log.d(TAG,"Finish");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(subscription != null && !subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }

    }



}
