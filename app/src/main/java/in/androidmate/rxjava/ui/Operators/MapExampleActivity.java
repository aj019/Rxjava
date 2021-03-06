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
import in.androidmate.rxjava.model.ApiUser;
import in.androidmate.rxjava.model.User;
import in.androidmate.rxjava.utils.AppConstant;
import in.androidmate.rxjava.utils.Utils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MapExampleActivity extends AppCompatActivity {

    @BindView(R.id.btDoSomeWork)
    Button btDoSomeWork;

    @BindView(R.id.tvResult)
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_example);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btDoSomeWork)
    public void doSomeWork(){

        getMapObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<List<ApiUser>, List<User>>() {
                    @Override
                    public List<User> apply(List<ApiUser> apiUsers) throws Exception {
                        return Utils.convertApiUserListToUserList(apiUsers);
                    }
                })
                .subscribe(getMapObserver());

    }

    private Observable<List<ApiUser>> getMapObservable(){
        return Observable.create(new ObservableOnSubscribe<List<ApiUser>>() {
            @Override
            public void subscribe(ObservableEmitter<List<ApiUser>> e) throws Exception {
                e.onNext(Utils.getApiUserList());
                e.onComplete();
            }
        });
    }

    private Observer<List<User>> getMapObserver(){
        return new Observer<List<User>>() {
            @Override
            public void onSubscribe(Disposable d) {
                tvResult.append("Subscribed");
            }

            @Override
            public void onNext(List<User> userList) {
                for (User user : userList) {
                    tvResult.append(" firstname : " + user.firstname);
                    tvResult.append(AppConstant.LINE_SEPARATOR);
                    tvResult.append(" lastname : " + user.lastname);
                    tvResult.append(AppConstant.LINE_SEPARATOR);
                }
            }

            @Override
            public void onError(Throwable e) {
               tvResult.append("Error : " + e);
            }

            @Override
            public void onComplete() {
                tvResult.append("Completed");
            }
        };
    }

}
