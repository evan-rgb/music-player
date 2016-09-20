package com.example.lerry.mvpmusicplayerlerry.presenter;

import com.example.lerry.mvpmusicplayerlerry.Model.MusicModel;

import java.util.List;

/**
 * Created by ro_ on 2016/9/19.
 */

public interface PlayerInter {
    public void play(int posi);
    public void pause();
    List<MusicModel> getMusicList();

    public void prev();

    public void next();

    public void seekTo(int progress);
}
