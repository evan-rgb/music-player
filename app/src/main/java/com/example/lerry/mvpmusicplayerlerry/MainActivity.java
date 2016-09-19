package com.example.lerry.mvpmusicplayerlerry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.lerry.mvpmusicplayerlerry.View.PlayerView;
import com.example.lerry.mvpmusicplayerlerry.presenter.PlayerInter;
import com.example.lerry.mvpmusicplayerlerry.presenter.PlayerPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,PlayerView {

    @Bind(R.id.btn_pre)ImageView ivPre;
    @Bind(R.id.btn_pause)ImageView ivPause;
    @Bind(R.id.btn_next)ImageView inNext;
    private PlayerInter mPlayerInter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPlayerInter = new PlayerPresenter(this);
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void initProgress() {

    }
}
