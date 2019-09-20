package com.example.eva3_16_media_player_servicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent inMulti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inMulti = new Intent(this,MyMusicService.class);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnStart:
                startService(inMulti);
                break;

            case R.id.btnStop:
                stopService(inMulti);
                break;
        }
    }
}
