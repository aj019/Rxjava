package in.androidmate.rxjava.ui.Operators;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.androidmate.rxjava.R;
import in.androidmate.rxjava.utils.AppConstant;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class BufferExampleActivity extends AppCompatActivity {

    @BindView(R.id.btDoSomeWork)
    Button btDoWork;

    @BindView(R.id.tvResult)
    TextView textView;

    private String TAG = "BufferExample";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buffer_example);
        ButterKnife.bind(this);

    }

    // buffer(3,1) which means the buffer will hold max three items at a time and in the next iteration it will move by one
    @OnClick(R.id.btDoSomeWork)
    public void doSomeWork(){

        getObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .buffer(3,1)
                .subscribe(getObserver());

    }

    private Observable<String> getObservable(){
        return Observable.just("one","two","three","four","five");

    }


    private Observer<List<String>> getObserver() {
        return new Observer<List<String>>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(List<String> stringList) {
                textView.append(" onNext size : " + stringList.size());
                textView.append(AppConstant.LINE_SEPARATOR);
                Log.d(TAG, " onNext : size :" + stringList.size());
                for (String value : stringList) {
                    textView.append(" value : " + value);
                    textView.append(AppConstant.LINE_SEPARATOR);
                    Log.d(TAG, " : value :" + value);
                }

            }

            @Override
            public void onError(Throwable e) {
                textView.append(" onError : " + e.getMessage());
                textView.append(AppConstant.LINE_SEPARATOR);
                Log.d(TAG, " onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                textView.append(" onComplete");
                textView.append(AppConstant.LINE_SEPARATOR);
                Log.d(TAG, " onComplete");
            }
        };
    }
}
