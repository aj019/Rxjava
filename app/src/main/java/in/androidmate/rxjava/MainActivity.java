package in.androidmate.rxjava;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";
    @BindView(R.id.btOperators) Button btOperators;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

//        Observable<Integer> getObservable =  Observable.just(1,2);
//        Flowable<Integer> flowObservable = Flowable.just(3,4);
//        Single<Integer> singleObservable = Single.just(5);
//        Maybe<Integer> maybeObservable = Maybe.just(6);
////        Completable completable = Completable.amb();
//
//
//         Observer<Integer> getObserver  = new Observer<Integer>() {
//
//             @Override
//             public void onSubscribe(Disposable d) {
//
//             }
//
//             @Override
//                public void onNext(Integer value) {
//                    Log.d(TAG,String.valueOf(value));
//                }
//
//                @Override
//                public void onError(Throwable e) {
//
//                }
//
//                @Override
//                public void onComplete() {
//                    Log.d(TAG,"onCompleted");
//                }
//            };
//
//           Subscriber<Integer> flowableObserver = new Subscriber<Integer>() {
//
//               @Override
//               public void onSubscribe(Subscription s) {
//                   Log.d(TAG,"Flow Subscriber subscribed");
//               }
//
//               @Override
//               public void onNext(Integer integer) {
//                   Log.d(TAG,String.valueOf(integer));
//               }
//
//               @Override
//               public void onError(Throwable t) {
//                   Log.d(TAG,t.toString());
//               }
//
//               @Override
//               public void onComplete() {
//                   Log.d(TAG,"Flow Subscriber Completed");
//
//               }
//           };
//
//           Consumer<Integer> singleObserver = new Consumer<Integer>() {
//
//               @Override
//               public void accept(Integer integer) throws Exception {
//                   if(integer != null){
//                       Log.d(TAG,"Single Observer "+integer);
//                   }
//               }
//           };
//
//            Consumer<Integer> maybeObserver  = new Consumer<Integer>() {
//
//
//                @Override
//                public void accept(Integer integer) throws Exception {
//                    Log.d(TAG,"Maybe Observer "+integer);
//                }
//            };
//
//
//        getObservable
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(getObserver);
//
//
//        flowObservable
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(flowableObserver);
//
//        singleObservable
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(singleObserver);
//
//        maybeObservable
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(maybeObserver);
//
//        CompositeDisposable cd = new CompositeDisposable();

    }

    @OnClick(R.id.btOperators)
        public void operatorsClicked(){
            Intent i = new Intent(MainActivity.this,OperatorsActivity.class);
            startActivity(i);
        }



    @Override
    protected void onDestroy() {
        super.onDestroy();


    }



}
