package in.androidmate.rxjava.ui.Operators;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.androidmate.rxjava.R;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;

public class ReduceExampleActivity extends AppCompatActivity {

    @BindView(R.id.btDoSomeWork)
    Button btDoSomeWork;

    @BindView(R.id.tvResult)
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reduce_example);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btDoSomeWork)
    public void doSomeWork(){

        getObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .reduce(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer i1, Integer i2) throws Exception {
                        return i1+i2+i1;
                    }
                })
                .subscribe(getObserver());

    }


    private Observable<Integer> getObservable(){
        return Observable.just(1,2,3,4,5);

    }

    private MaybeObserver<Integer> getObserver(){
        return new MaybeObserver<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                tvResult.append("Subscribed " );
                tvResult.append("\n");
            }

            @Override
            public void onSuccess(Integer value) {
                tvResult.append("Value "+ value );
                tvResult.append("\n");
            }


            @Override
            public void onError(Throwable e) {
                tvResult.append("Error " );
                tvResult.append("\n");
            }

            @Override
            public void onComplete() {
                tvResult.append("Completed " );
                tvResult.append("\n");
            }
        };
    }

}
