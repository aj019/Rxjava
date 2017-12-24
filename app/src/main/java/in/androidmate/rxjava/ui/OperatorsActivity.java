package in.androidmate.rxjava.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.androidmate.rxjava.R;
import in.androidmate.rxjava.ui.Operators.IntervalExampleActivity;
import in.androidmate.rxjava.ui.Operators.MapExampleActivity;
import in.androidmate.rxjava.ui.Operators.SimpleExampleActivity;
import in.androidmate.rxjava.ui.Operators.TakeExampleActivity;
import in.androidmate.rxjava.ui.Operators.TimerExampleActivity;
import in.androidmate.rxjava.ui.Operators.ZipExampleActivity;

public class OperatorsActivity extends AppCompatActivity {

    @BindView(R.id.btSimpleExample)
    Button btSimpleExample;

    @BindView(R.id.btMapExample)
    Button btMapExample;

    @BindView(R.id.btZipOperator)
    Button btZipExample;

    @BindView(R.id.btTakeExample)
    Button btTakeExample;

    @BindView(R.id.btTimerExample)
    Button btTimerExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operators);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btSimpleExample)
    public void startSimpleExample(){

        startExample(SimpleExampleActivity.class);
    }

    @OnClick(R.id.btMapExample)
    public void startMapExample(){

        startExample(MapExampleActivity.class);
    }

    @OnClick(R.id.btZipOperator)
    public void startZipExample(){

        startExample(ZipExampleActivity.class);
    }

    @OnClick(R.id.btTakeExample)
    public void startTakeExample(){

        startExample(TakeExampleActivity.class);
    }

    @OnClick(R.id.btTimerExample)
    public void startTimerExample(){

        startExample(TimerExampleActivity.class);
    }

    @OnClick(R.id.btIntervalExample)
    public void startIntervalExample(){

        startExample(IntervalExampleActivity.class);
    }

    private void startExample(Class<?> activity){
        Intent i = new Intent(OperatorsActivity.this,activity);
        startActivity(i);
    }

}
