package com.example.lerry.mvpmusicplayerlerry.Model;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;


import com.example.lerry.mvpmusicplayerlerry.Utils.MusicCursorUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ro_ on 2016/9/19.
 */

public class MusicPlayer {
    private MediaPlayer mPlayer;
    private final int MSG_INITPROGRESS = 0x0;
    private List<MusicModel>  musicModelList;
    private SeekBarCallback mSeekCallback;
    public MusicPlayer(){
        this.mPlayer = new MediaPlayer();
        musicModelList = new ArrayList<>();
        mHandler.sendEmptyMessage(MSG_INITPROGRESS);
    }
    public void initData(Context ctx){
        musicModelList = MusicCursorUtil.getMusicList(ctx);
        Toast.makeText(ctx,musicModelList.size()+"",Toast.LENGTH_SHORT).show();
    }
    public List<MusicModel> getMusicModelList(){
        return  musicModelList;
    }
    public MusicModel getMusic(int position){
        return musicModelList.get(position);
    }
    public void initPlay(int position){
        try {
            mSeekCallback.onDetail(getMusic(position));
            mPlayer.reset();
            mPlayer.setDataSource(getMusic(position).path);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MSG_INITPROGRESS:
                    int now = mPlayer.getCurrentPosition();
                    int total = mPlayer.getDuration();
                    if (mSeekCallback != null && total != 0) {
                        mSeekCallback.onSeek(now,total);
                    }
                    removeMessages(MSG_INITPROGRESS);
                    sendEmptyMessageDelayed(MSG_INITPROGRESS,1000);
                    break;
                default:
                    break;
            }
        }
    };
    public void setmSeekCallback(SeekBarCallback cbk){
        mSeekCallback = cbk;
    }

    public void seekTo(int progress) {
        int position = progress * mPlayer.getDuration() / 100;
        mPlayer.seekTo(position);
    }
    public void stop(){
        mPlayer.stop();
        mPlayer.release();
    }
    public void pause(){
        mPlayer.pause();
    }
    public void start(){
        mPlayer.start();
    }
    public static interface  SeekBarCallback{
        void onSeek(int now, int total);
        void onDetail(MusicModel md);
    }
}
