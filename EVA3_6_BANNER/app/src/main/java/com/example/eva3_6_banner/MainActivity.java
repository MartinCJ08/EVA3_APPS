package com.example.eva3_6_banner;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imgVwImg;
    SeekBar seekBar;

    int max = 5000;
    int min = 1000;
    int progress=1;
    int time = 1000;

    int iImg = 0;
    final int[] aiImg = {R.drawable.cake,R.drawable.rickrolled,R.drawable.thor};

    Handler myHandler = new Handler();
    Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            imgVwImg.setImageResource(aiImg[iImg]);
            if(iImg == 2){
                iImg = 0;
            }else{
                iImg++;
            }
        }
    };

    Thread myThread = new Thread(){
        @Override
        public void run() {
            super.run();
            while (true){
                try{
                    progress = seekBar.getProgress();
                    time = max - progress;
                    Log.wtf("PROGRESS","tiempo: "+time);
                    Thread.sleep(time);
                    myHandler.post(myRunnable);

                }catch (InterruptedException e){e.printStackTrace();}
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwImg = findViewById(R.id.imgVwImg);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(max - min);
        myThread.start();
    }
}
