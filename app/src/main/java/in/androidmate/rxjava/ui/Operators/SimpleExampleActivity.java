package in.androidmate.rxjava.Operators;

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
import io.reactivex.schedulers.Schedulers;

public class SimpleExampleActivity extends AppCompatActivity {


    @BindView(R.id.btDoSomeWork)
    Button btDoWork;

    @BindView(R.id.tvResult)
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_example);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btDoSomeWork)
    public void doSomeWork(){

        getObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver());

    }

    private Observable<String> getObservable(){
        return Observable.just("Cricket","Soccer");

    }


    private Observer<String> getObserver(){
        return  new Observer<String>(){
            @Override
            public void onSubscribe(Disposable d) {
                tvResult.append("Subscribed \n");
            }

            @Override
            public void onNext(String value) {
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
