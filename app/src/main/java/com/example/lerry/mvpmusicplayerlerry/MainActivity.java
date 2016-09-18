package com.example.lerry.mvpmusicplayerlerry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Bind(R.id.btn_pre)ImageView ivPre;
    @Bind(R.id.btn_pause)ImageView ivPause;
    @Bind(R.id.btn_next)ImageView inNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View v) {
    }
}
