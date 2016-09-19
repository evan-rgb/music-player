package com.example.lerry.mvpmusicplayerlerry.presenter;

import com.example.lerry.mvpmusicplayerlerry.Model.MusicPlayer;
import com.example.lerry.mvpmusicplayerlerry.View.PlayerView;

/**
 * Created by ro_ on 2016/9/19.
 */

public class PlayerPresenter implements PlayerInter {
    private PlayerView mPlayerView;
    private MusicPlayer mPlayer;

    public PlayerPresenter(PlayerView mPlayerView) {
        this.mPlayerView = mPlayerView;
        mPlayer = new MusicPlayer();
    }

    @Override
    public void play(int position) {
        mPlayer.initPlay("");
    }

    @Override
    public void pause() {

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
