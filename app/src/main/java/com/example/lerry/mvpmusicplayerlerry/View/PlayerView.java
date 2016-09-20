package com.example.lerry.mvpmusicplayerlerry.View;

import com.example.lerry.mvpmusicplayerlerry.Model.MusicModel;

/**
 * Created by ro_ on 2016/9/19.
 */

public interface PlayerView {
    public void initProgress(int now, int total);
    public void initDetail(MusicModel md);

}
