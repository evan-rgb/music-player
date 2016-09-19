package com.example.lerry.mvpmusicplayerlerry.presenter;

import android.content.Context;

import com.example.lerry.mvpmusicplayerlerry.Model.MusicPlayer;
import com.example.lerry.mvpmusicplayerlerry.View.PlayerView;

/**
 * Created by ro_ on 2016/9/19.
 */

public class PlayerPresenter implements PlayerInter {
    private PlayerView mPlayerView;
    private MusicPlayer mPlayer;
    private Context ctx;
    private boolean isPause = false;

    public PlayerPresenter(PlayerView mPlayerView, Context ctx) {
        this.mPlayerView = mPlayerView;
        this.ctx = ctx;
        mPlayer = new MusicPlayer();
        mPlayer.initData(ctx);
    }

    @Override
    public void play(int position) {
        mPlayer.initPlay(position);
    }

    @Override
    public void pause() {
        if (isPause) {
            mPlayer.start();
            isPause = false;
        } else {
            mPlayer.pause();
            isPause = true;
        }
    }

    @Override
    public void prev() {

    }

    @Override
    public void next() {

    }

    @Override
    public void seekTo() {

    }
}
