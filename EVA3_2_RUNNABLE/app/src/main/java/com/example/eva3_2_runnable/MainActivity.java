package com.example.eva3_2_runnable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    Thread myHilo;

    Runnable rRun = new Runnable() {
        @Override
        public void run() {
//            for (int i = 0; i<20;i++){
            int i = 0;
            while(true){
                i++;
                try{
                    Log.wtf("HILO",i+"");
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    Log.wtf("QIUBO","HILO INTERRUMPIDO");
                    e.printStackTrace();
                    break;
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myHilo = new Thread(rRun);
        myHilo.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        myHilo.interrupt();
    }
}
