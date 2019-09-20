package com.example.eva3_15_media_player;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MediaPlayer myMusic = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myMusic = MediaPlayer.create(this,R.raw.puto);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(myMusic != null){
            myMusic.start();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(myMusic != null){
            myMusic.stop();
            myMusic.release();
        }
    }
}
