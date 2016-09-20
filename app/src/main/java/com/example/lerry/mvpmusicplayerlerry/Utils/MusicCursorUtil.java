package com.example.lerry.mvpmusicplayerlerry.Utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.widget.Toast;

import com.example.lerry.mvpmusicplayerlerry.Model.MusicModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ro_ on 2016/9/19.
 */

public class MusicCursorUtil {
    public static List<MusicModel> getMusicList(Context ctx) {
        List<MusicModel> musicModelList = new ArrayList<>();
        ContentResolver musicResolver = null;
        Cursor cursor = null;
        try {
            musicResolver = ctx.getContentResolver();
            cursor = musicResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    null, null, null, null);
        } catch (RuntimeException e) {
            if(e instanceof  SecurityException){
                Toast.makeText(ctx,"请打开文件读写权限",Toast.LENGTH_SHORT).show();
            }
            return musicModelList;
        }
        if (cursor == null || !cursor.moveToFirst()) {
            return musicModelList;
        }
        do {
            MusicModel musicModel = new MusicModel();
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID));
            //歌曲的名称 ：MediaStore.Audio.Media.TITLE

            String tilte = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));

            //歌曲的专辑名：MediaStore.Audio.Media.ALBUM

            String album = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM));
            //歌曲的歌手名： MediaStore.Audio.Media.ARTIST

            String artist = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
            //歌曲文件的路径 ：MediaStore.Audio.Media.DATA

            String url = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
            //歌曲的总播放时长 ：MediaStore.Audio.Media.DURATION

            int duration = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));
            if (duration < 120000)
                continue;
            //歌曲文件的大小 ：MediaStore.Audio.Media.SIZE
            musicModel.name = tilte;
            musicModel.path = url;
            musicModel.artist = artist;
            musicModel.album = album;
            musicModelList.add(musicModel);

        } while (cursor.moveToNext());
        return musicModelList;
    }
}
