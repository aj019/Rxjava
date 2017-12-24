package in.androidmate.rxjava.ui.Operators;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.androidmate.rxjava.R;
import in.androidmate.rxjava.model.User;
import in.androidmate.rxjava.utils.Utils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;

public class TakeExampleActivity extends AppCompatActivity {


    @BindView(R.id.btDoSomeWork)
    Button btDoSomeWork;

    @BindView(R.id.tvResult)
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_example);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btDoSomeWork)
    public void doSomeWork(){

      getObservable()
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .take(3)
              .subscribe(getObserver());

    }


    private Observable<Integer> getObservable(){
        return Observable.just(1,2,3,4,5);

    }

    private Observer<Integer> getObserver(){
        return new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

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
                tvResult.append("Completed " );
                tvResult.append("\n");
            }
        };
    }

}
