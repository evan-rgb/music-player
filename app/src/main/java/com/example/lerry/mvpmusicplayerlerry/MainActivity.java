package com.example.lerry.mvpmusicplayerlerry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSeekBar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lerry.mvpmusicplayerlerry.Model.MusicModel;
import com.example.lerry.mvpmusicplayerlerry.Utils.DateUtils;
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
    @Bind(R.id.music_seekbar)
    AppCompatSeekBar mSeekBar;
    @Bind(R.id.timeleft_txt)
    TextView timeLeftTx;
    @Bind(R.id.title_txt)
    TextView titleTx;
    private PlayerInter mPlayerInter;
    private ArrayAdapter<MusicModel> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPlayerInter = new PlayerPresenter(this, this);
        initView();

    }

    private void initView() {
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mPlayerInter.getMusicList());
        mMusicList.setAdapter(mAdapter);
        mSeekBar.setOnSeekBarChangeListener(new SeekBarListener());
    }

    @Override
    public void onClick(View v) {
    }

    @OnClick({R.id.btn_pause, R.id.btn_pre, R.id.btn_next})
    public void mOnClick(View v) {
        switch (v.getId()) {
            case R.id.btn_pause:
                mPlayerInter.pause();
                break;
            case R.id.btn_next:
                mPlayerInter.next();
                break;
            case R.id.btn_pre:
                mPlayerInter.prev();
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
    public void initProgress(int now , int total) {
        mSeekBar.setProgress(now*100/total);
        timeLeftTx.setText(DateUtils.secToMin(total-now));
    }

    @Override
    public void initDetail(MusicModel md) {
        titleTx.setText(md.name);
    }

    class SeekBarListener implements SeekBar.OnSeekBarChangeListener {
        int progress = 0;

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            this.progress = progress;

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            mPlayerInter.seekTo(progress);
        }
    }
}
