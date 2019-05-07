package com.example.eva3_11_asynk_tasks_banner;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    ImageView imgVwImg;
    SeekBar seekBar;

    private int max = 5000;
    private int min = 1000;

    final int[] aiImg = {R.drawable.cake,R.drawable.rickrolled,R.drawable.thor};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwImg = findViewById(R.id.imgVwImg);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(max - min);

        MyClassAsynk myAsynk = new MyClassAsynk();
        myAsynk.execute();
    }

    class MyClassAsynk extends AsyncTask<Void,Void,Void> {
        private int progress=1;
        private int time = 1000;

        private int iImg = 0;

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            imgVwImg.setImageResource(aiImg[iImg]);
            if(iImg == 2){
                iImg = 0;
            }else{
                iImg++;
            }
        }

        @Override
        protected Void doInBackground(Void... integers) {
            while (true){
                try{
                    progress = seekBar.getProgress();
                    time = max - progress;
                    publishProgress();

                    Thread.sleep(time);


                }catch (InterruptedException e){e.printStackTrace();}
            }
//            return null;
        }
    }
}
