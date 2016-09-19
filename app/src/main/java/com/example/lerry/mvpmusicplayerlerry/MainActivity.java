package com.example.lerry.mvpmusicplayerlerry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lerry.mvpmusicplayerlerry.View.PlayerView;
import com.example.lerry.mvpmusicplayerlerry.presenter.PlayerInter;
import com.example.lerry.mvpmusicplayerlerry.presenter.PlayerPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, PlayerView {

    @Bind(R.id.btn_pre)
    ImageView ivPre;
    @Bind(R.id.btn_pause)
    ImageView ivPause;
    @Bind(R.id.btn_next)
    ImageView inNext;
    @Bind(R.id.music_list)
    ListView mMusicList;
    private PlayerInter mPlayerInter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPlayerInter = new PlayerPresenter(this, this);
        initView();

    }

    private void initView() {
        String content[] = {"1", "2", "3"};
        ArrayAdapter mAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, content);
        mMusicList.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {
    }

    @OnClick({R.id.btn_pause, R.id.btn_pre, R.id.btn_next})
    public void mOnClick(View v) {
        switch (v.getId()) {
            case R.id.btn_pause:
                Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
                mPlayerInter.pause();
                break;
            case R.id.btn_next:
                Toast.makeText(this, "Next", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @OnItemClick(R.id.music_list)
    public void mOnItemClick(int position) {
        mPlayerInter.play(position);
    }


    @Override
    public void initProgress() {

    }
}
