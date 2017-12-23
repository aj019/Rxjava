package in.androidmate.rxjava.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.androidmate.rxjava.R;
import in.androidmate.rxjava.ui.Operators.MapExampleActivity;
import in.androidmate.rxjava.ui.Operators.SimpleExampleActivity;

public class OperatorsActivity extends AppCompatActivity {

    @BindView(R.id.btSimpleExample)
    Button btSimpleExample;

    @BindView(R.id.btMapExample)
    Button btMapExample;

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

    private void startExample(Class<?> activity){
        Intent i = new Intent(OperatorsActivity.this,activity);
        startActivity(i);
    }

}
