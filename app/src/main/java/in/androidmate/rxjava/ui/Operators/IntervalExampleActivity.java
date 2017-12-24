package in.androidmate.rxjava.ui.Operators;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.androidmate.rxjava.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class IntervalExampleActivity extends AppCompatActivity {
    @BindView(R.id.btDoSomeWork)
    Button btDoSomeWork;

    @BindView(R.id.tvResult)
    TextView tvResult;

    CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interval_example);
        ButterKnife.bind(this);

        compositeDisposable = new CompositeDisposable();
    }

    @OnClick(R.id.btDoSomeWork)
    public void doSomeWork(){

     Disposable d =   getObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(getObserver());

        compositeDisposable.add(d);

    }

    private Observable<Integer> getObservable(){
        return Observable.zip(getIntervalObservable(), getJustObservable(), new BiFunction<Long, Integer, Integer>() {
            @Override
            public Integer apply(Long aLong, Integer integer) throws Exception {
                return integer;
            }
        });
    }

    private Observable<Integer> getJustObservable(){
        return Observable.just(9,8,7);
    }


    private Observable<Long> getIntervalObservable(){
        return Observable.interval(0,2,TimeUnit.SECONDS);
    }

    private DisposableObserver<Integer> getObserver(){
        return  new DisposableObserver<Integer>() {


            @Override
            public void onNext(Integer value) {
                tvResult.append("Value " + value);
                tvResult.append("\n");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                tvResult.append("Complete ");
                tvResult.append("\n");
            }
        };
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        compositeDisposable.dispose();
    }
}
