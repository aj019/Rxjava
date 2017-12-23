package in.androidmate.rxjava;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.androidmate.rxjava.Operators.SimpleExampleActivity;

public class OperatorsActivity extends AppCompatActivity {

    @BindView(R.id.btSimpleExample)
    Button btSimpleExample;

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

    private void startExample(Class<?> activity){
        Intent i = new Intent(OperatorsActivity.this,activity);
        startActivity(i);
    }

}
