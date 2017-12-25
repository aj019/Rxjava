package in.androidmate.rxjava.ui.Operators;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.androidmate.rxjava.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class FilterExampleActivity extends AppCompatActivity {
    @BindView(R.id.btDoSomeWork)
    Button btDoWork;

    @BindView(R.id.tvResult)
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_example);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btDoSomeWork)
    public void doSomeWork(){

        getObservable()
                .subscribeOn(Schedulers.io())
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer i) throws Exception {
                        return i%2 == 0;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver());

    }

    private Observable<Integer> getObservable(){
        return Observable.just(1,2,3,4,5,6);

    }


    private Observer<Integer> getObserver(){
        return  new Observer<Integer>(){
            @Override
            public void onSubscribe(Disposable d) {
                tvResult.append("Subscribed \n");
            }

            @Override
            public void onNext(Integer value) {
                tvResult.append("Value : "+ value +"\n");
            }

            @Override
            public void onError(Throwable e) {
                tvResult.append("Error : " + e +"\n");
            }

            @Override
            public void onComplete() {
                tvResult.append("Completed");
            }
        };
    }

}
