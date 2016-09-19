package com.example.lerry.mvpmusicplayerlerry.presenter;

import com.example.lerry.mvpmusicplayerlerry.View.PlayerView;

/**
 * Created by ro_ on 2016/9/19.
 */

public class PlayerPresenter implements  PlayerInter{
    private PlayerView mPlayerView;

    public PlayerPresenter(PlayerView mPlayerView) {
        this.mPlayerView = mPlayerView;
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
