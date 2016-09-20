package com.example.lerry.mvpmusicplayerlerry.presenter;

import android.content.Context;

import com.example.lerry.mvpmusicplayerlerry.Model.MusicModel;
import com.example.lerry.mvpmusicplayerlerry.Model.MusicPlayer;
import com.example.lerry.mvpmusicplayerlerry.View.PlayerView;

import java.util.List;

/**
 * Created by ro_ on 2016/9/19.
 */

public class PlayerPresenter implements PlayerInter {
    private PlayerView mPlayerView;
    private MusicPlayer mPlayer;
    private Context ctx;
    private boolean isPause = false;
    private int nowPlaying = 0;

    public PlayerPresenter(PlayerView mPlayerView, Context ctx) {
        this.mPlayerView = mPlayerView;
        this.ctx = ctx;
        mPlayer = new MusicPlayer();
        mPlayer.initData(ctx);
    }

    @Override
    public void play(int position) {
        nowPlaying = position;
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
    public List<MusicModel> getMusicList() {
        return mPlayer.getMusicModelList();
    }

    @Override
    public void prev() {
        nowPlaying--;
        if (nowPlaying == -1) {
            nowPlaying = getMusicList().size() - 1;
        }
        play(nowPlaying);
    }

    @Override
    public void next() {
        nowPlaying++;
        if (nowPlaying == getMusicList().size()) {
            nowPlaying = 0;
        }
        play(nowPlaying);
    }

    @Override
    public void seekTo() {

    }
}
