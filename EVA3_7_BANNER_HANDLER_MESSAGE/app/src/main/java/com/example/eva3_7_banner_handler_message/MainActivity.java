package com.example.eva3_7_banner_handler_message;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final int HILO_CHAFON = 420;
    ImageView imgVwImg;
    SeekBar seekBar;

    int max = 5000;
    int min = 1000;
    int progress=1;
    int time = 1000;

    int iImg = 0;
    final int[] aiImg = {R.drawable.cake,R.drawable.rickrolled,R.drawable.thor};
    TextView txtVwTitle;

    Handler myHandle = new Handler(){
        @Override
        public void handleMessage(Message msg) {
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
                    Message msg  = myHandle.obtainMessage();
                    myHandle.sendMessage(msg);

                }catch (InterruptedException e){e.printStackTrace();}
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwTitle = findViewById(R.id.txtVwTitle);
        imgVwImg = findViewById(R.id.imgVwImg);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(max - min);
        myThread.start();

    }
}