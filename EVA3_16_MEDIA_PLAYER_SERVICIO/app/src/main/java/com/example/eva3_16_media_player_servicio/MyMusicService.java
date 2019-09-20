package com.example.eva3_16_media_player_servicio;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyMusicService extends Service {
    MediaPlayer mMulti=null;
    public MyMusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mMulti = MediaPlayer.create(getApplicationContext(),R.raw.puto);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if(mMulti != null){
            mMulti.start();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mMulti != null){
            mMulti.stop();
            mMulti.release();
        }
    }
}
